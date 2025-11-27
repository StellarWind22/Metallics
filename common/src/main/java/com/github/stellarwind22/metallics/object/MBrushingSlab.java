package com.github.stellarwind22.metallics.object;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class MBrushingSlab extends BaseEntityBlock implements MBrushable, SimpleWaterloggedBlock {

    public static final MapCodec<MBrushingSlab> CODEC = RecordCodecBuilder.mapCodec((instance) -> instance.group(
            ExtraCodecs.POSITIVE_INT.fieldOf("tick_delay").forGetter(MBrushingSlab::tickDelay),
            ExtraCodecs.POSITIVE_INT.fieldOf("brushes_to_complete").forGetter(MBrushingSlab::brushesToComplete),
            ResourceLocation.CODEC.fieldOf("turns_into").forGetter(MBrushingSlab::getTurnsInto),
            BuiltInRegistries.SOUND_EVENT.byNameCodec().fieldOf("brush_sound").forGetter(MBrushingSlab::brushSound),
            BuiltInRegistries.SOUND_EVENT.byNameCodec().fieldOf("brush_completed_sound").forGetter(MBrushingSlab::brushCompletedSound),
            propertiesCodec()).apply(instance, MBrushingSlab::new));

    private final int tickDelay;
    private final int brushesToComplete;
    private final ResourceLocation turnsInto;
    private final SoundEvent brushSound;
    private final SoundEvent brushCompletedSound;

    public static final EnumProperty<SlabType> TYPE;
    public static final BooleanProperty WATERLOGGED;
    private static final VoxelShape SHAPE_BOTTOM;
    private static final VoxelShape SHAPE_TOP;

    private static final IntegerProperty DUSTED;

    public MBrushingSlab(int tickDelay, int brushesToComplete, ResourceLocation turnsInto, SoundEvent brushSound, SoundEvent brushCompletedSound, Properties properties) {
        super(properties);
        this.tickDelay = tickDelay;
        this.brushesToComplete = brushesToComplete;
        this.turnsInto = turnsInto;
        this.brushSound = brushSound;
        this.brushCompletedSound = brushCompletedSound;
        this.registerDefaultState(this.stateDefinition.any().setValue(DUSTED, 0));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(TYPE, WATERLOGGED, DUSTED);
    }

    @Override
    public int tickDelay() {
        return this.tickDelay;
    }

    @Override
    public int brushesToComplete() {
        return this.brushesToComplete;
    }

    @Override
    public Block getBrushableBlock() {
        return this;
    }

    @Override
    public ResourceLocation getTurnsInto() {
        return this.turnsInto;
    }

    @Override
    public SoundEvent brushSound() {
        return this.brushSound;
    }

    @Override
    public SoundEvent brushCompletedSound() {
        return this.brushCompletedSound;
    }

    @Override
    public Holder<Block> arch$holder() {
        return super.arch$holder();
    }

    @Override
    public void animateTick(BlockState blockState, Level level, BlockPos blockPos, RandomSource randomSource) {
        this.animateTickBrushable(blockState, level, blockPos, randomSource);
    }

    @Override
    public void onPlace(BlockState blockState, Level level, BlockPos blockPos, BlockState blockState2, boolean bl) {
        this.onPlaceBrushable(level, blockPos);
    }

    @Override
    public @NotNull MapCodec<MBrushingSlab> codec() {
        return CODEC;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new MBrushingBlockEntity(blockPos, blockState);
    }

    @Override
    public void tick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
        this.tickBrushable(serverLevel, blockPos);
    }

    protected boolean useShapeForLightOcclusion(BlockState blockState) {
        return blockState.getValue(TYPE) != SlabType.DOUBLE;
    }

    protected @NotNull VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        VoxelShape var10000;
        switch (blockState.getValue(TYPE)) {
            case TOP -> var10000 = SHAPE_TOP;
            case BOTTOM -> var10000 = SHAPE_BOTTOM;
            case DOUBLE -> var10000 = Shapes.block();
            default -> throw new MatchException(null, null);
        }

        return var10000;
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        BlockPos blockPos = blockPlaceContext.getClickedPos();
        BlockState blockState = blockPlaceContext.getLevel().getBlockState(blockPos);
        if (blockState.is(this)) {
            return blockState.setValue(TYPE, SlabType.DOUBLE).setValue(WATERLOGGED, false);
        } else {
            FluidState fluidState = blockPlaceContext.getLevel().getFluidState(blockPos);
            BlockState blockState2 = this.defaultBlockState().setValue(TYPE, SlabType.BOTTOM).setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER);
            Direction direction = blockPlaceContext.getClickedFace();
            return direction != Direction.DOWN && (direction == Direction.UP || !(blockPlaceContext.getClickLocation().y - (double)blockPos.getY() > (double)0.5F)) ? blockState2 : blockState2.setValue(TYPE, SlabType.TOP);
        }
    }

    protected boolean canBeReplaced(BlockState blockState, BlockPlaceContext blockPlaceContext) {
        ItemStack itemStack = blockPlaceContext.getItemInHand();
        SlabType slabType = blockState.getValue(TYPE);
        if (slabType != SlabType.DOUBLE && itemStack.is(this.asItem())) {
            if (blockPlaceContext.replacingClickedOnBlock()) {
                boolean bl = blockPlaceContext.getClickLocation().y - (double)blockPlaceContext.getClickedPos().getY() > (double)0.5F;
                Direction direction = blockPlaceContext.getClickedFace();
                if (slabType == SlabType.BOTTOM) {
                    return direction == Direction.UP || bl && direction.getAxis().isHorizontal();
                } else {
                    return direction == Direction.DOWN || !bl && direction.getAxis().isHorizontal();
                }
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    protected @NotNull FluidState getFluidState(BlockState blockState) {
        return blockState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(blockState);
    }

    @Override
    public boolean placeLiquid(LevelAccessor levelAccessor, BlockPos blockPos, BlockState blockState, FluidState fluidState) {
        return blockState.getValue(TYPE) != SlabType.DOUBLE && SimpleWaterloggedBlock.super.placeLiquid(levelAccessor, blockPos, blockState, fluidState);
    }

    public boolean canPlaceLiquid(@Nullable LivingEntity livingEntity, BlockGetter blockGetter, BlockPos blockPos, BlockState blockState, Fluid fluid) {
        return blockState.getValue(TYPE) != SlabType.DOUBLE && SimpleWaterloggedBlock.super.canPlaceLiquid(livingEntity, blockGetter, blockPos, blockState, fluid);
    }

    protected @NotNull BlockState updateShape(BlockState blockState, LevelReader levelReader, ScheduledTickAccess scheduledTickAccess, BlockPos blockPos, Direction direction, BlockPos blockPos2, BlockState blockState2, RandomSource randomSource) {
        if (blockState.getValue(WATERLOGGED)) {
            scheduledTickAccess.scheduleTick(blockPos, Fluids.WATER, Fluids.WATER.getTickDelay(levelReader));
        }

        return super.updateShape(blockState, levelReader, scheduledTickAccess, blockPos, direction, blockPos2, blockState2, randomSource);
    }

    protected boolean isPathfindable(BlockState blockState, PathComputationType pathComputationType) {
        if (Objects.requireNonNull(pathComputationType) == PathComputationType.WATER) {
            return blockState.getFluidState().is(FluidTags.WATER);
        }
        return false;
    }

    static {
        TYPE = BlockStateProperties.SLAB_TYPE;
        WATERLOGGED = BlockStateProperties.WATERLOGGED;
        SHAPE_BOTTOM = Block.column(16.0F, 0.0F, 8.0F);
        SHAPE_TOP = Block.column(16.0F, 8.0F, 16.0F);
        DUSTED = BlockStateProperties.DUSTED;
    }
}
