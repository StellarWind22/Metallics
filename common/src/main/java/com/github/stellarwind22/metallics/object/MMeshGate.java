package com.github.stellarwind22.metallics.object;

import com.google.common.collect.Maps;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.Map;
import java.util.function.BiConsumer;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
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
import net.minecraft.world.level.redstone.Orientation;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MMeshGate extends HorizontalDirectionalBlock {

    public static final MapCodec<MMeshGate> CODEC = RecordCodecBuilder.mapCodec((instance) -> instance.group(
            BlockSetType.CODEC.fieldOf("block_set_type").forGetter(MMeshGate::getBlockSetType),
            propertiesCodec()
    ).apply(instance, MMeshGate::new));
    public static final BooleanProperty OPEN;
    public static final BooleanProperty POWERED;
    public static final BooleanProperty IN_WALL;
    private static final Map<Direction.Axis, VoxelShape> SHAPES;
    private static final Map<Direction.Axis, VoxelShape> SHAPES_WALL;
    private static final Map<Direction.Axis, VoxelShape> SHAPE_COLLISION;
    private static final Map<Direction.Axis, VoxelShape> SHAPE_SUPPORT;
    private static final Map<Direction.Axis, VoxelShape> SHAPE_OCCLUSION;
    private static final Map<Direction.Axis, VoxelShape> SHAPE_OCCLUSION_WALL;
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
        Direction.Axis axis = blockState.getValue(FACING).getAxis();
        return (blockState.getValue(IN_WALL) ? SHAPES_WALL : SHAPES).get(axis);
    }

    protected @NotNull BlockState updateShape(BlockState blockState, LevelReader levelReader, ScheduledTickAccess scheduledTickAccess, BlockPos blockPos, Direction direction, BlockPos blockPos2, BlockState blockState2, RandomSource randomSource) {
        Direction.Axis axis = direction.getAxis();
        if (blockState.getValue(FACING).getClockWise().getAxis() != axis) {
            return super.updateShape(blockState, levelReader, scheduledTickAccess, blockPos, direction, blockPos2, blockState2, randomSource);
        } else {
            boolean bl = this.isWall(blockState2) || this.isWall(levelReader.getBlockState(blockPos.relative(direction.getOpposite())));
            return blockState.setValue(IN_WALL, bl);
        }
    }

    protected @NotNull VoxelShape getBlockSupportShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        Direction.Axis axis = blockState.getValue(FACING).getAxis();
        return blockState.getValue(OPEN) ? Shapes.empty() : SHAPE_SUPPORT.get(axis);
    }

    protected @NotNull VoxelShape getCollisionShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        Direction.Axis axis = blockState.getValue(FACING).getAxis();
        return blockState.getValue(OPEN) ? Shapes.empty() : SHAPE_COLLISION.get(axis);
    }

    protected @NotNull VoxelShape getOcclusionShape(BlockState blockState) {
        Direction.Axis axis = blockState.getValue(FACING).getAxis();
        return (blockState.getValue(IN_WALL) ? SHAPE_OCCLUSION_WALL : SHAPE_OCCLUSION).get(axis);
    }

    protected boolean isPathfindable(BlockState blockState, PathComputationType pathComputationType) {
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

    protected @NotNull InteractionResult useWithoutItem(BlockState blockState, Level level, BlockPos blockPos, Player player, BlockHitResult blockHitResult) {
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

    protected void onExplosionHit(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, Explosion explosion, BiConsumer<ItemStack, BlockPos> biConsumer) {
        if (explosion.canTriggerBlocks() && !(Boolean)blockState.getValue(POWERED)) {
            boolean bl = blockState.getValue(OPEN);
            serverLevel.setBlockAndUpdate(blockPos, blockState.setValue(OPEN, !bl));
            serverLevel.playSound(null, blockPos, bl ? this.blockSetType.trapdoorClose() : this.blockSetType.trapdoorOpen(), SoundSource.BLOCKS, 1.0F, serverLevel.getRandom().nextFloat() * 0.1F + 0.9F);
            serverLevel.gameEvent(bl ? GameEvent.BLOCK_CLOSE : GameEvent.BLOCK_OPEN, blockPos, Context.of(blockState));
        }

        super.onExplosionHit(blockState, serverLevel, blockPos, explosion, biConsumer);
    }

    protected void neighborChanged(BlockState blockState, Level level, BlockPos blockPos, Block block, @Nullable Orientation orientation, boolean bl) {
        if (!level.isClientSide()) {
            boolean bl2 = level.hasNeighborSignal(blockPos);
            if (blockState.getValue(POWERED) != bl2) {
                level.setBlock(blockPos, blockState.setValue(POWERED, bl2).setValue(OPEN, bl2), 2);
                if (blockState.getValue(OPEN) != bl2) {
                    level.playSound(null, blockPos, bl2 ? this.blockSetType.trapdoorOpen() : this.blockSetType.trapdoorClose(), SoundSource.BLOCKS, 1.0F, level.getRandom().nextFloat() * 0.1F + 0.9F);
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
        SHAPES = Shapes.rotateHorizontalAxis(Block.cube(16.0F, 16.0F, 4.0F));
        SHAPES_WALL = Maps.newEnumMap(Util.mapValues(SHAPES, (voxelShape) -> Shapes.join(voxelShape, Block.column(16.0F, 13.0F, 16.0F), BooleanOp.ONLY_FIRST)));
        SHAPE_COLLISION = Shapes.rotateHorizontalAxis(Block.column(16.0F, 4.0F, 0.0F, 24.0F));
        SHAPE_SUPPORT = Shapes.rotateHorizontalAxis(Block.column(16.0F, 4.0F, 5.0F, 24.0F));
        SHAPE_OCCLUSION = Shapes.rotateHorizontalAxis(Shapes.or(Block.box(0.0F, 5.0F, 7.0F, 2.0F, 16.0F, 9.0F), Block.box(14.0F, 5.0F, 7.0F, 16.0F, 16.0F, 9.0F)));
        SHAPE_OCCLUSION_WALL = Maps.newEnumMap(Util.mapValues(SHAPE_OCCLUSION, (voxelShape) -> voxelShape.move(0.0F, -0.1875F, 0.0F).optimize()));
    }
}
