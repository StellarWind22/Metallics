package com.github.stellarwind22.metallics.object;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.InsideBlockEffectApplier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.crafting.CampfireCookingRecipe;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipePropertySet;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.CampfireBlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("deprecation")
public class MCampfireBlock extends BaseEntityBlock implements SimpleWaterloggedBlock {

    public static final MapCodec<MCampfireBlock> CODEC = RecordCodecBuilder.mapCodec((instance) -> instance.group(Codec.BOOL.fieldOf("spawn_particles").forGetter((campfireBlock) -> campfireBlock.spawnParticles), Codec.intRange(0, 1000).fieldOf("fire_damage").forGetter((campfireBlock) -> campfireBlock.fireDamage), propertiesCodec()).apply(instance, MCampfireBlock::new));
    public static final BooleanProperty LIT;
    public static final BooleanProperty SIGNAL_FIRE;
    public static final BooleanProperty WATERLOGGED;
    public static final EnumProperty<Direction> FACING;
    private static final VoxelShape SHAPE;
    private static final VoxelShape SHAPE_VIRTUAL_POST;
    private final boolean spawnParticles;
    private final int fireDamage;

    public @NotNull MapCodec<MCampfireBlock> codec() {
        return CODEC;
    }

    public MCampfireBlock(boolean bl, int i, BlockBehaviour.Properties properties) {
        super(properties);
        this.spawnParticles = bl;
        this.fireDamage = i;
        this.registerDefaultState(this.stateDefinition.any().setValue(LIT, true).setValue(SIGNAL_FIRE, false).setValue(WATERLOGGED, false).setValue(FACING, Direction.NORTH));
    }

    protected @NotNull InteractionResult useItemOn(ItemStack itemStack, BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        BlockEntity blockEntity = level.getBlockEntity(blockPos);
        if (blockEntity instanceof CampfireBlockEntity campfireBlockEntity) {
            ItemStack itemStack2 = player.getItemInHand(interactionHand);
            if (level.recipeAccess().propertySet(RecipePropertySet.CAMPFIRE_INPUT).test(itemStack2)) {
                if (level instanceof ServerLevel serverLevel) {
                    if (campfireBlockEntity.placeFood(serverLevel, player, itemStack2)) {
                        player.awardStat(Stats.INTERACT_WITH_CAMPFIRE);
                        return InteractionResult.SUCCESS_SERVER;
                    }
                }

                return InteractionResult.CONSUME;
            }
        }

        return InteractionResult.TRY_WITH_EMPTY_HAND;
    }

    protected void entityInside(BlockState blockState, Level level, BlockPos blockPos, Entity entity, InsideBlockEffectApplier insideBlockEffectApplier, boolean bl) {
        if (blockState.getValue(LIT) && entity instanceof LivingEntity) {
            entity.hurt(level.damageSources().campfire(), (float)this.fireDamage);
        }

        super.entityInside(blockState, level, blockPos, entity, insideBlockEffectApplier, bl);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        LevelAccessor levelAccessor = blockPlaceContext.getLevel();
        BlockPos blockPos = blockPlaceContext.getClickedPos();
        boolean bl = levelAccessor.getFluidState(blockPos).getType() == Fluids.WATER;
        return this.defaultBlockState().setValue(WATERLOGGED, bl).setValue(SIGNAL_FIRE, this.isSmokeSource(levelAccessor.getBlockState(blockPos.below()))).setValue(LIT, !bl).setValue(FACING, blockPlaceContext.getHorizontalDirection());
    }

    protected @NotNull BlockState updateShape(BlockState blockState, LevelReader levelReader, ScheduledTickAccess scheduledTickAccess, BlockPos blockPos, Direction direction, BlockPos blockPos2, BlockState blockState2, RandomSource randomSource) {
        if (blockState.getValue(WATERLOGGED)) {
            scheduledTickAccess.scheduleTick(blockPos, Fluids.WATER, Fluids.WATER.getTickDelay(levelReader));
        }

        return direction == Direction.DOWN ? blockState.setValue(SIGNAL_FIRE, this.isSmokeSource(blockState2)) : super.updateShape(blockState, levelReader, scheduledTickAccess, blockPos, direction, blockPos2, blockState2, randomSource);
    }

    private boolean isSmokeSource(BlockState blockState) {
        return blockState.is(Blocks.HAY_BLOCK);
    }

    protected @NotNull VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return SHAPE;
    }

    public void animateTick(BlockState blockState, Level level, BlockPos blockPos, RandomSource randomSource) {
        if (blockState.getValue(LIT)) {
            if (randomSource.nextInt(10) == 0) {
                level.playLocalSound((double)blockPos.getX() + (double)0.5F, (double)blockPos.getY() + (double)0.5F, (double)blockPos.getZ() + (double)0.5F, SoundEvents.CAMPFIRE_CRACKLE, SoundSource.BLOCKS, 0.5F + randomSource.nextFloat(), randomSource.nextFloat() * 0.7F + 0.6F, false);
            }

            if (this.spawnParticles && randomSource.nextInt(5) == 0) {
                for(int i = 0; i < randomSource.nextInt(1) + 1; ++i) {
                    level.addParticle(ParticleTypes.LAVA, (double)blockPos.getX() + (double)0.5F, (double)blockPos.getY() + (double)0.5F, (double)blockPos.getZ() + (double)0.5F, randomSource.nextFloat() / 2.0F, 5.0E-5, randomSource.nextFloat() / 2.0F);
                }
            }

        }
    }

    public static void dowse(@Nullable Entity entity, LevelAccessor levelAccessor, BlockPos blockPos, BlockState blockState) {
        if (levelAccessor.isClientSide()) {
            for(int i = 0; i < 20; ++i) {
                makeParticles((Level)levelAccessor, blockPos, blockState.getValue(SIGNAL_FIRE), true);
            }
        }

        levelAccessor.gameEvent(entity, GameEvent.BLOCK_CHANGE, blockPos);
    }

    public boolean placeLiquid(LevelAccessor levelAccessor, BlockPos blockPos, BlockState blockState, FluidState fluidState) {
        if (!(Boolean)blockState.getValue(BlockStateProperties.WATERLOGGED) && fluidState.getType() == Fluids.WATER) {
            boolean bl = blockState.getValue(LIT);
            if (bl) {
                if (!levelAccessor.isClientSide()) {
                    levelAccessor.playSound(null, blockPos, SoundEvents.GENERIC_EXTINGUISH_FIRE, SoundSource.BLOCKS, 1.0F, 1.0F);
                }

                dowse(null, levelAccessor, blockPos, blockState);
            }

            levelAccessor.setBlock(blockPos, blockState.setValue(WATERLOGGED, true).setValue(LIT, false), 3);
            levelAccessor.scheduleTick(blockPos, fluidState.getType(), fluidState.getType().getTickDelay(levelAccessor));
            return true;
        } else {
            return false;
        }
    }

    protected void onProjectileHit(Level level, BlockState blockState, BlockHitResult blockHitResult, Projectile projectile) {
        BlockPos blockPos = blockHitResult.getBlockPos();
        if (level instanceof ServerLevel serverLevel) {
            if (projectile.isOnFire() && projectile.mayInteract(serverLevel, blockPos) && !(Boolean)blockState.getValue(LIT) && !(Boolean)blockState.getValue(WATERLOGGED)) {
                level.setBlock(blockPos, blockState.setValue(BlockStateProperties.LIT, true), 11);
            }
        }

    }

    public static void makeParticles(Level level, BlockPos blockPos, boolean bl, boolean bl2) {
        RandomSource randomSource = level.getRandom();
        SimpleParticleType simpleParticleType = bl ? ParticleTypes.CAMPFIRE_SIGNAL_SMOKE : ParticleTypes.CAMPFIRE_COSY_SMOKE;
        level.addAlwaysVisibleParticle(simpleParticleType, true, (double)blockPos.getX() + (double)0.5F + randomSource.nextDouble() / (double)3.0F * (double)(randomSource.nextBoolean() ? 1 : -1), (double)blockPos.getY() + randomSource.nextDouble() + randomSource.nextDouble(), (double)blockPos.getZ() + (double)0.5F + randomSource.nextDouble() / (double)3.0F * (double)(randomSource.nextBoolean() ? 1 : -1), 0.0F, 0.07, 0.0F);
        if (bl2) {
            level.addParticle(ParticleTypes.SMOKE, (double)blockPos.getX() + (double)0.5F + randomSource.nextDouble() / (double)4.0F * (double)(randomSource.nextBoolean() ? 1 : -1), (double)blockPos.getY() + 0.4, (double)blockPos.getZ() + (double)0.5F + randomSource.nextDouble() / (double)4.0F * (double)(randomSource.nextBoolean() ? 1 : -1), 0.0F, 0.005, 0.0F);
        }

    }

    public static boolean isSmokeyPos(Level level, BlockPos blockPos) {
        for(int i = 1; i <= 5; ++i) {
            BlockPos blockPos2 = blockPos.below(i);
            BlockState blockState = level.getBlockState(blockPos2);
            if (isLitCampfire(blockState)) {
                return true;
            }

            boolean bl = Shapes.joinIsNotEmpty(SHAPE_VIRTUAL_POST, blockState.getCollisionShape(level, blockPos, CollisionContext.empty()), BooleanOp.AND);
            if (bl) {
                BlockState blockState2 = level.getBlockState(blockPos2.below());
                return isLitCampfire(blockState2);
            }
        }

        return false;
    }

    public static boolean isLitCampfire(BlockState blockState) {
        return blockState.hasProperty(LIT) && blockState.is(BlockTags.CAMPFIRES) && blockState.getValue(LIT);
    }

    protected @NotNull FluidState getFluidState(BlockState blockState) {
        return blockState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(blockState);
    }

    protected @NotNull BlockState rotate(BlockState blockState, Rotation rotation) {
        return blockState.setValue(FACING, rotation.rotate(blockState.getValue(FACING)));
    }

    protected @NotNull BlockState mirror(BlockState blockState, Mirror mirror) {        return blockState.rotate(mirror.getRotation(blockState.getValue(FACING)));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(LIT, SIGNAL_FIRE, WATERLOGGED, FACING);
    }

    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new MCampfireBlockEntity(blockPos, blockState);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState blockState, BlockEntityType<T> blockEntityType) {
        if (level instanceof ServerLevel serverLevel) {
            if (blockState.getValue(LIT)) {
                RecipeManager.CachedCheck<SingleRecipeInput, CampfireCookingRecipe> cachedCheck = RecipeManager.createCheck(RecipeType.CAMPFIRE_COOKING);
                return createTickerHelper(blockEntityType, BlockEntityType.CAMPFIRE, (levelx, blockPos, blockStatex, mCampfireBlockEntity) -> MCampfireBlockEntity.cookTick(serverLevel, blockPos, blockStatex, mCampfireBlockEntity, cachedCheck));
            } else {
                return createTickerHelper(blockEntityType, BlockEntityType.CAMPFIRE, CampfireBlockEntity::cooldownTick);
            }
        } else {
            return blockState.getValue(LIT) ? createTickerHelper(blockEntityType, BlockEntityType.CAMPFIRE, CampfireBlockEntity::particleTick) : null;
        }
    }

    protected boolean isPathfindable(BlockState blockState, PathComputationType pathComputationType) {
        return false;
    }

    public static boolean canLight(BlockState blockState) {
        return blockState.is(BlockTags.CAMPFIRES, (blockStateBase) -> blockStateBase.hasProperty(WATERLOGGED) && blockStateBase.hasProperty(LIT)) && !(Boolean)blockState.getValue(WATERLOGGED) && !(Boolean)blockState.getValue(LIT);
    }

    static {
        LIT = BlockStateProperties.LIT;
        SIGNAL_FIRE = BlockStateProperties.SIGNAL_FIRE;
        WATERLOGGED = BlockStateProperties.WATERLOGGED;
        FACING = BlockStateProperties.HORIZONTAL_FACING;
        SHAPE = Block.column(16.0F, 0.0F, 7.0F);
        SHAPE_VIRTUAL_POST = Block.column(4.0F, 0.0F, 16.0F);
    }
}
