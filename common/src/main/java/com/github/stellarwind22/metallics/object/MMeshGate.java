package com.github.stellarwind22.metallics.object;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import java.util.function.BiConsumer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.gameevent.GameEvent.Context;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class MMeshGate extends HorizontalDirectionalBlock {

    public static final MapCodec<MMeshGate> CODEC = RecordCodecBuilder.mapCodec((instance) -> instance.group(
            BlockSetType.CODEC.fieldOf("block_set_type").forGetter(MMeshGate::getBlockSetType),
            propertiesCodec()
    ).apply(instance, MMeshGate::new));
    public static final BooleanProperty OPEN;
    public static final BooleanProperty POWERED;
    public static final BooleanProperty IN_WALL;
    protected static final VoxelShape Z_SHAPE;
    protected static final VoxelShape X_SHAPE;
    protected static final VoxelShape Z_SHAPE_LOW;
    protected static final VoxelShape X_SHAPE_LOW;
    protected static final VoxelShape Z_COLLISION_SHAPE;
    protected static final VoxelShape X_COLLISION_SHAPE;
    protected static final VoxelShape Z_SUPPORT_SHAPE;
    protected static final VoxelShape X_SUPPORT_SHAPE;
    protected static final VoxelShape Z_OCCLUSION_SHAPE;
    protected static final VoxelShape X_OCCLUSION_SHAPE;
    protected static final VoxelShape Z_OCCLUSION_SHAPE_LOW;
    protected static final VoxelShape X_OCCLUSION_SHAPE_LOW;
    private final BlockSetType blockSetType;

    public @NotNull MapCodec<MMeshGate> codec() {
        return CODEC;
    }

    public MMeshGate(BlockSetType blockSetType, BlockBehaviour.Properties properties) {
        super(properties);
        this.blockSetType = blockSetType;
        this.registerDefaultState(this.stateDefinition.any().setValue(OPEN, false).setValue(POWERED, false).setValue(IN_WALL, false));
    }

    protected @NotNull VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        if (blockState.getValue(IN_WALL)) {
            return blockState.getValue(FACING).getAxis() == Axis.X ? X_SHAPE_LOW : Z_SHAPE_LOW;
        } else {
            return blockState.getValue(FACING).getAxis() == Axis.X ? X_SHAPE : Z_SHAPE;
        }
    }

    public @NotNull BlockState updateShape(BlockState blockState, Direction direction, BlockState blockState2, LevelAccessor levelAccessor, BlockPos blockPos, BlockPos blockPos2) {
        Direction.Axis axis = direction.getAxis();
        if (blockState.getValue(FACING).getClockWise().getAxis() != axis) {
            return super.updateShape(blockState, direction, blockState2, levelAccessor, blockPos, blockPos2);
        } else {
            boolean bl = this.isWall(blockState2) || this.isWall(levelAccessor.getBlockState(blockPos.relative(direction.getOpposite())));
            return blockState.setValue(IN_WALL, bl);
        }
    }

    protected @NotNull VoxelShape getBlockSupportShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        if (blockState.getValue(OPEN)) {
            return Shapes.empty();
        } else {
            return blockState.getValue(FACING).getAxis() == Axis.Z ? Z_SUPPORT_SHAPE : X_SUPPORT_SHAPE;
        }
    }

    protected @NotNull VoxelShape getCollisionShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        if (blockState.getValue(OPEN)) {
            return Shapes.empty();
        } else {
            return blockState.getValue(FACING).getAxis() == Axis.Z ? Z_COLLISION_SHAPE : X_COLLISION_SHAPE;
        }
    }

    protected @NotNull VoxelShape getOcclusionShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        if (blockState.getValue(IN_WALL)) {
            return blockState.getValue(FACING).getAxis() == Axis.X ? X_OCCLUSION_SHAPE_LOW : Z_OCCLUSION_SHAPE_LOW;
        } else {
            return blockState.getValue(FACING).getAxis() == Axis.X ? X_OCCLUSION_SHAPE : Z_OCCLUSION_SHAPE;
        }
    }

    public boolean isPathfindable(BlockState blockState, PathComputationType pathComputationType) {
        switch (pathComputationType) {
            case LAND, AIR -> {
                return blockState.getValue(OPEN);
            }
            default -> {
                return false;
            }
        }
    }

    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        Level level = blockPlaceContext.getLevel();
        BlockPos blockPos = blockPlaceContext.getClickedPos();
        boolean bl = level.hasNeighborSignal(blockPos);
        Direction direction = blockPlaceContext.getHorizontalDirection();
        Direction.Axis axis = direction.getAxis();
        boolean bl2 = axis == Axis.Z && (this.isWall(level.getBlockState(blockPos.west())) || this.isWall(level.getBlockState(blockPos.east()))) || axis == Axis.X && (this.isWall(level.getBlockState(blockPos.north())) || this.isWall(level.getBlockState(blockPos.south())));
        return this.defaultBlockState().setValue(FACING, direction).setValue(OPEN, bl).setValue(POWERED, bl).setValue(IN_WALL, bl2);
    }

    public BlockSetType getBlockSetType() {
        return this.blockSetType;
    }

    private boolean isWall(BlockState blockState) {
        return blockState.is(BlockTags.WALLS);
    }

    public @NotNull InteractionResult useWithoutItem(BlockState blockState, Level level, BlockPos blockPos, Player player, BlockHitResult blockHitResult) {
        if (blockState.getValue(OPEN)) {
            blockState = blockState.setValue(OPEN, false);
            level.setBlock(blockPos, blockState, 10);
        } else {
            Direction direction = player.getDirection();
            if (blockState.getValue(FACING) == direction.getOpposite()) {
                blockState = blockState.setValue(FACING, direction);
            }

            blockState = blockState.setValue(OPEN, true);
            level.setBlock(blockPos, blockState, 10);
        }

        boolean bl = blockState.getValue(OPEN);
        level.playSound(player, blockPos, bl ? this.blockSetType.trapdoorOpen() : this.blockSetType.trapdoorClose(), SoundSource.BLOCKS, 1.0F, level.getRandom().nextFloat() * 0.1F + 0.9F);
        level.gameEvent(player, bl ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, blockPos);
        return InteractionResult.SUCCESS;
    }

    public void onExplosionHit(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, Explosion explosion, BiConsumer<ItemStack, BlockPos> biConsumer) {
        if (explosion.canTriggerBlocks() && !(Boolean)blockState.getValue(POWERED)) {
            boolean bl = blockState.getValue(OPEN);
            serverLevel.setBlockAndUpdate(blockPos, blockState.setValue(OPEN, !bl));
            serverLevel.playSound(null, blockPos, bl ? this.blockSetType.trapdoorClose() : this.blockSetType.trapdoorOpen(), SoundSource.BLOCKS, 1.0F, serverLevel.getRandom().nextFloat() * 0.1F + 0.9F);
            serverLevel.gameEvent(bl ? GameEvent.BLOCK_CLOSE : GameEvent.BLOCK_OPEN, blockPos, Context.of(blockState));
        }

        super.onExplosionHit(blockState, serverLevel, blockPos, explosion, biConsumer);
    }

    public void neighborChanged(BlockState blockState, Level level, BlockPos blockPos, Block block, BlockPos blockPos2, boolean bl) {
        if (!level.isClientSide) {
            boolean bl2 = level.hasNeighborSignal(blockPos);
            if (blockState.getValue(POWERED) != bl2) {
                level.setBlock(blockPos, blockState.setValue(POWERED, bl2).setValue(OPEN, bl2), 2);
                if (blockState.getValue(OPEN) != bl2) {
                    level.playSound(null, blockPos, bl2 ? this.blockSetType.doorOpen() : this.blockSetType.doorClose(), SoundSource.BLOCKS, 1.0F, level.getRandom().nextFloat() * 0.1F + 0.9F);
                    level.gameEvent(null, bl2 ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, blockPos);
                }
            }

        }
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, OPEN, POWERED, IN_WALL);
    }

    public static boolean connectsToDirection(BlockState blockState, Direction direction) {
        return blockState.getValue(FACING).getAxis() == direction.getClockWise().getAxis();
    }

    static {
        OPEN = BlockStateProperties.OPEN;
        POWERED = BlockStateProperties.POWERED;
        IN_WALL = BlockStateProperties.IN_WALL;
        Z_SHAPE = Block.box(0.0F, 0.0F, 6.0F, 16.0F, 16.0F, 10.0F);
        X_SHAPE = Block.box(6.0F, 0.0F, 0.0F, 10.0F, 16.0F, 16.0F);
        Z_SHAPE_LOW = Block.box(0.0F, 0.0F, 6.0F, 16.0F, 13.0F, 10.0F);
        X_SHAPE_LOW = Block.box(6.0F, 0.0F, 0.0F, 10.0F, 13.0F, 16.0F);
        Z_COLLISION_SHAPE = Block.box(0.0F, 0.0F, 6.0F, 16.0F, 24.0F, 10.0F);
        X_COLLISION_SHAPE = Block.box(6.0F, 0.0F, 0.0F, 10.0F, 24.0F, 16.0F);
        Z_SUPPORT_SHAPE = Block.box(0.0F, 5.0F, 6.0F, 16.0F, 24.0F, 10.0F);
        X_SUPPORT_SHAPE = Block.box(6.0F, 5.0F, 0.0F, 10.0F, 24.0F, 16.0F);
        Z_OCCLUSION_SHAPE = Shapes.or(Block.box(0.0F, 5.0F, 7.0F, 2.0F, 16.0F, 9.0F), Block.box(14.0F, 5.0F, 7.0F, 16.0F, 16.0F, 9.0F));
        X_OCCLUSION_SHAPE = Shapes.or(Block.box(7.0F, 5.0F, 0.0F, 9.0F, 16.0F, 2.0F), Block.box(7.0F, 5.0F, 14.0F, 9.0F, 16.0F, 16.0F));
        Z_OCCLUSION_SHAPE_LOW = Shapes.or(Block.box(0.0F, 2.0F, 7.0F, 2.0F, 13.0F, 9.0F), Block.box(14.0F, 2.0F, 7.0F, 16.0F, 13.0F, 9.0F));
        X_OCCLUSION_SHAPE_LOW = Shapes.or(Block.box(7.0F, 2.0F, 0.0F, 9.0F, 13.0F, 2.0F), Block.box(7.0F, 2.0F, 14.0F, 9.0F, 13.0F, 16.0F));
    }
}
