package com.github.stellarwind22.metallics.object;

import com.google.common.collect.ImmutableMap;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class MMeshFenceBlock extends Block implements SimpleWaterloggedBlock {

    public static final MapCodec<MMeshFenceBlock> CODEC = simpleCodec(MMeshFenceBlock::new);
    public static final BooleanProperty UP;
    public static final EnumProperty<WallSide> EAST_WALL;
    public static final EnumProperty<WallSide> NORTH_WALL;
    public static final EnumProperty<WallSide> SOUTH_WALL;
    public static final EnumProperty<WallSide> WEST_WALL;
    public static final BooleanProperty WATERLOGGED;
    private final Map<BlockState, VoxelShape> shapeByIndex;
    private final Map<BlockState, VoxelShape> collisionShapeByIndex;
    private static final VoxelShape POST_TEST;
    private static final VoxelShape NORTH_TEST;
    private static final VoxelShape SOUTH_TEST;
    private static final VoxelShape WEST_TEST;
    private static final VoxelShape EAST_TEST;

    public @NotNull MapCodec<MMeshFenceBlock> codec() {
        return CODEC;
    }

    public MMeshFenceBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(UP, true).setValue(NORTH_WALL, WallSide.NONE).setValue(EAST_WALL, WallSide.NONE).setValue(SOUTH_WALL, WallSide.NONE).setValue(WEST_WALL, WallSide.NONE).setValue(WATERLOGGED, false));
        this.shapeByIndex = this.makeShapes(16.0F, 14.0F, 16.0F);
        this.collisionShapeByIndex = this.makeShapes(24.0F, 24.0F, 24.0F);
    }

    private static VoxelShape applyWallShape(VoxelShape voxelShape, WallSide wallSide, VoxelShape voxelShape2, VoxelShape voxelShape3) {
        if (wallSide == WallSide.TALL) {
            return Shapes.or(voxelShape, voxelShape3);
        } else {
            return wallSide == WallSide.LOW ? Shapes.or(voxelShape, voxelShape2) : voxelShape;
        }
    }

    private Map<BlockState, VoxelShape> makeShapes(float h, float j, float k) {
        float l = 8.0F - (float) 4.0;
        float m = 8.0F + (float) 4.0;
        float n = 8.0F - (float) 3.0;
        float o = 8.0F + (float) 3.0;
        VoxelShape voxelShape = Block.box(l, 0.0F, l, m, h, m);
        VoxelShape voxelShape2 = Block.box(n, (float) 0.0, 0.0F, o, j, o);
        VoxelShape voxelShape3 = Block.box(n, (float) 0.0, n, o, j, 16.0F);
        VoxelShape voxelShape4 = Block.box(0.0F, (float) 0.0, n, o, j, o);
        VoxelShape voxelShape5 = Block.box(n, (float) 0.0, n, 16.0F, j, o);
        VoxelShape voxelShape6 = Block.box(n, (float) 0.0, 0.0F, o, k, o);
        VoxelShape voxelShape7 = Block.box(n, (float) 0.0, n, o, k, 16.0F);
        VoxelShape voxelShape8 = Block.box(0.0F, (float) 0.0, n, o, k, o);
        VoxelShape voxelShape9 = Block.box(n, (float) 0.0, n, 16.0F, k, o);
        ImmutableMap.Builder<BlockState, VoxelShape> builder = ImmutableMap.builder();

        for(Boolean boolean_ : UP.getPossibleValues()) {
            for(WallSide wallSide : EAST_WALL.getPossibleValues()) {
                for(WallSide wallSide2 : NORTH_WALL.getPossibleValues()) {
                    for(WallSide wallSide3 : WEST_WALL.getPossibleValues()) {
                        for(WallSide wallSide4 : SOUTH_WALL.getPossibleValues()) {
                            VoxelShape voxelShape10 = Shapes.empty();
                            voxelShape10 = applyWallShape(voxelShape10, wallSide, voxelShape5, voxelShape9);
                            voxelShape10 = applyWallShape(voxelShape10, wallSide3, voxelShape4, voxelShape8);
                            voxelShape10 = applyWallShape(voxelShape10, wallSide2, voxelShape2, voxelShape6);
                            voxelShape10 = applyWallShape(voxelShape10, wallSide4, voxelShape3, voxelShape7);
                            if (boolean_) {
                                voxelShape10 = Shapes.or(voxelShape10, voxelShape);
                            }

                            BlockState blockState = this.defaultBlockState().setValue(UP, boolean_).setValue(EAST_WALL, wallSide).setValue(WEST_WALL, wallSide3).setValue(NORTH_WALL, wallSide2).setValue(SOUTH_WALL, wallSide4);
                            builder.put(blockState.setValue(WATERLOGGED, false), voxelShape10);
                            builder.put(blockState.setValue(WATERLOGGED, true), voxelShape10);
                        }
                    }
                }
            }
        }

        return builder.build();
    }

    public @NotNull VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return this.shapeByIndex.get(blockState);
    }

    public @NotNull VoxelShape getCollisionShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return this.collisionShapeByIndex.get(blockState);
    }

    public boolean isPathfindable(BlockState blockState, PathComputationType pathComputationType) {
        return false;
    }

    private boolean connectsTo(BlockState blockState, boolean bl, Direction direction) {
        Block block = blockState.getBlock();
        boolean bl2 = block instanceof FenceGateBlock && FenceGateBlock.connectsToDirection(blockState, direction) || block instanceof MMeshGate && MMeshGate.connectsToDirection(blockState, direction);
        return blockState.is(BlockTags.WALLS) || !isExceptionForConnection(blockState) && bl || block instanceof IronBarsBlock || bl2;
    }

    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        LevelReader levelReader = blockPlaceContext.getLevel();
        BlockPos blockPos = blockPlaceContext.getClickedPos();
        FluidState fluidState = blockPlaceContext.getLevel().getFluidState(blockPlaceContext.getClickedPos());
        BlockPos blockPos2 = blockPos.north();
        BlockPos blockPos3 = blockPos.east();
        BlockPos blockPos4 = blockPos.south();
        BlockPos blockPos5 = blockPos.west();
        BlockPos blockPos6 = blockPos.above();
        BlockState blockState = levelReader.getBlockState(blockPos2);
        BlockState blockState2 = levelReader.getBlockState(blockPos3);
        BlockState blockState3 = levelReader.getBlockState(blockPos4);
        BlockState blockState4 = levelReader.getBlockState(blockPos5);
        BlockState blockState5 = levelReader.getBlockState(blockPos6);
        boolean bl = this.connectsTo(blockState, blockState.isFaceSturdy(levelReader, blockPos2, Direction.SOUTH), Direction.SOUTH);
        boolean bl2 = this.connectsTo(blockState2, blockState2.isFaceSturdy(levelReader, blockPos3, Direction.WEST), Direction.WEST);
        boolean bl3 = this.connectsTo(blockState3, blockState3.isFaceSturdy(levelReader, blockPos4, Direction.NORTH), Direction.NORTH);
        boolean bl4 = this.connectsTo(blockState4, blockState4.isFaceSturdy(levelReader, blockPos5, Direction.EAST), Direction.EAST);
        BlockState blockState6 = this.defaultBlockState().setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER);
        return this.updateShape(levelReader, blockState6, blockPos6, blockState5, bl, bl2, bl3, bl4);
    }

    public @NotNull BlockState updateShape(BlockState blockState, Direction direction, BlockState blockState2, LevelAccessor levelAccessor, BlockPos blockPos, BlockPos blockPos2) {
        if (blockState.getValue(WATERLOGGED)) {
            levelAccessor.scheduleTick(blockPos, Fluids.WATER, Fluids.WATER.getTickDelay(levelAccessor));
        }

        if (direction == Direction.DOWN) {
            return super.updateShape(blockState, direction, blockState2, levelAccessor, blockPos, blockPos2);
        } else {
            return direction == Direction.UP ? this.topUpdate(levelAccessor, blockState, blockPos2, blockState2) : this.sideUpdate(levelAccessor, blockPos, blockState, blockPos2, blockState2, direction);
        }
    }

    private static boolean isConnected(BlockState blockState, Property<WallSide> property) {
        return blockState.getValue(property) != WallSide.NONE;
    }

    private static boolean isCovered(VoxelShape voxelShape, VoxelShape voxelShape2) {
        return !Shapes.joinIsNotEmpty(voxelShape2, voxelShape, BooleanOp.ONLY_FIRST);
    }

    private BlockState topUpdate(LevelReader levelReader, BlockState blockState, BlockPos blockPos, BlockState blockState2) {
        boolean bl = isConnected(blockState, NORTH_WALL);
        boolean bl2 = isConnected(blockState, EAST_WALL);
        boolean bl3 = isConnected(blockState, SOUTH_WALL);
        boolean bl4 = isConnected(blockState, WEST_WALL);
        return this.updateShape(levelReader, blockState, blockPos, blockState2, bl, bl2, bl3, bl4);
    }

    private BlockState sideUpdate(LevelReader levelReader, BlockPos blockPos, BlockState blockState, BlockPos blockPos2, BlockState blockState2, Direction direction) {
        Direction direction2 = direction.getOpposite();
        boolean bl = direction == Direction.NORTH ? this.connectsTo(blockState2, blockState2.isFaceSturdy(levelReader, blockPos2, direction2), direction2) : isConnected(blockState, NORTH_WALL);
        boolean bl2 = direction == Direction.EAST ? this.connectsTo(blockState2, blockState2.isFaceSturdy(levelReader, blockPos2, direction2), direction2) : isConnected(blockState, EAST_WALL);
        boolean bl3 = direction == Direction.SOUTH ? this.connectsTo(blockState2, blockState2.isFaceSturdy(levelReader, blockPos2, direction2), direction2) : isConnected(blockState, SOUTH_WALL);
        boolean bl4 = direction == Direction.WEST ? this.connectsTo(blockState2, blockState2.isFaceSturdy(levelReader, blockPos2, direction2), direction2) : isConnected(blockState, WEST_WALL);
        BlockPos blockPos3 = blockPos.above();
        BlockState blockState3 = levelReader.getBlockState(blockPos3);
        return this.updateShape(levelReader, blockState, blockPos3, blockState3, bl, bl2, bl3, bl4);
    }

    private BlockState updateShape(LevelReader levelReader, BlockState blockState, BlockPos blockPos, BlockState blockState2, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        VoxelShape voxelShape = blockState2.getCollisionShape(levelReader, blockPos).getFaceShape(Direction.DOWN);
        BlockState blockState3 = this.updateSides(blockState, bl, bl2, bl3, bl4, voxelShape);
        return blockState3.setValue(UP, this.shouldRaisePost(blockState3, blockState2, voxelShape));
    }

    public boolean shouldRaisePost(BlockState blockState, BlockState blockState2, VoxelShape voxelShape) {
        Block block = blockState2.getBlock();
        boolean bars = block instanceof IronBarsBlock;
        boolean match = bars;

        if(match) {
            var bl_n = blockState.getValue(NORTH_WALL) != WallSide.NONE;
            if(bl_n) {
                if(!blockState2.getValue(IronBarsBlock.NORTH)) {
                    match = false;
                }
            }

            var bl_s = blockState.getValue(SOUTH_WALL) != WallSide.NONE;
            if(bl_s) {
                if(!blockState2.getValue(IronBarsBlock.SOUTH)) {
                    match = false;
                }
            }

            var bl_e = blockState.getValue(EAST_WALL) != WallSide.NONE;
            if(bl_e) {
                if(!blockState2.getValue(IronBarsBlock.EAST)) {
                    match = false;
                }
            }

            var bl_w = blockState.getValue(WEST_WALL) != WallSide.NONE;
            if(bl_w) {
                if(!blockState2.getValue(IronBarsBlock.WEST)) {
                    match = false;
                }
            }
        }

        boolean bl = (block instanceof WallBlock && blockState2.getValue(WallBlock.UP) || (block instanceof MMeshFenceBlock && blockState2.getValue(UP)) || (!match && bars));
        if(bl) {
            return true;
        } else {
            WallSide wallSide = blockState.getValue(NORTH_WALL);
            WallSide wallSide2 = blockState.getValue(SOUTH_WALL);
            WallSide wallSide3 = blockState.getValue(EAST_WALL);
            WallSide wallSide4 = blockState.getValue(WEST_WALL);
            boolean bl2 = wallSide2 == WallSide.NONE;
            boolean bl3 = wallSide4 == WallSide.NONE;
            boolean bl4 = wallSide3 == WallSide.NONE;
            boolean bl5 = wallSide == WallSide.NONE;
            boolean bl6 = bl5 && bl2 && bl3 && bl4 || bl5 != bl2 || bl3 != bl4;
            if(bl6) {
                return true;
            } else {
                boolean bl7 = wallSide == WallSide.TALL && wallSide2 == WallSide.TALL || wallSide3 == WallSide.TALL && wallSide4 == WallSide.TALL;
                if(bl7) {
                    return false;
                } else {
                    return blockState2.is(BlockTags.WALL_POST_OVERRIDE) || isCovered(voxelShape, POST_TEST);
                }
            }
        }
    }

    private BlockState updateSides(BlockState blockState, boolean bl, boolean bl2, boolean bl3, boolean bl4, VoxelShape voxelShape) {
        return blockState.setValue(NORTH_WALL, this.makeWallState(bl, voxelShape, NORTH_TEST)).setValue(EAST_WALL, this.makeWallState(bl2, voxelShape, EAST_TEST)).setValue(SOUTH_WALL, this.makeWallState(bl3, voxelShape, SOUTH_TEST)).setValue(WEST_WALL, this.makeWallState(bl4, voxelShape, WEST_TEST));
    }

    private WallSide makeWallState(boolean bl, VoxelShape voxelShape, VoxelShape voxelShape2) {
        if (bl) {
            return isCovered(voxelShape, voxelShape2) ? WallSide.TALL : WallSide.LOW;
        } else {
            return WallSide.NONE;
        }
    }

    public @NotNull FluidState getFluidState(BlockState blockState) {
        return blockState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(blockState);
    }

    public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(UP, NORTH_WALL, EAST_WALL, WEST_WALL, SOUTH_WALL, WATERLOGGED);
    }

    public @NotNull BlockState rotate(BlockState blockState, Rotation rotation) {
        switch (rotation) {
            case CLOCKWISE_180 -> {
                return blockState.setValue(NORTH_WALL, blockState.getValue(SOUTH_WALL)).setValue(EAST_WALL, blockState.getValue(WEST_WALL)).setValue(SOUTH_WALL, blockState.getValue(NORTH_WALL)).setValue(WEST_WALL, blockState.getValue(EAST_WALL));
            }
            case COUNTERCLOCKWISE_90 -> {
                return blockState.setValue(NORTH_WALL, blockState.getValue(EAST_WALL)).setValue(EAST_WALL, blockState.getValue(SOUTH_WALL)).setValue(SOUTH_WALL, blockState.getValue(WEST_WALL)).setValue(WEST_WALL, blockState.getValue(NORTH_WALL));
            }
            case CLOCKWISE_90 -> {
                return blockState.setValue(NORTH_WALL, blockState.getValue(WEST_WALL)).setValue(EAST_WALL, blockState.getValue(NORTH_WALL)).setValue(SOUTH_WALL, blockState.getValue(EAST_WALL)).setValue(WEST_WALL, blockState.getValue(SOUTH_WALL));
            }
            default -> {
                return blockState;
            }
        }
    }

    public @NotNull BlockState mirror(BlockState blockState, Mirror mirror) {
        switch (mirror) {
            case LEFT_RIGHT -> {
                return blockState.setValue(NORTH_WALL, blockState.getValue(SOUTH_WALL)).setValue(SOUTH_WALL, blockState.getValue(NORTH_WALL));
            }
            case FRONT_BACK -> {
                return blockState.setValue(EAST_WALL, blockState.getValue(WEST_WALL)).setValue(WEST_WALL, blockState.getValue(EAST_WALL));
            }
            default -> {
                return super.mirror(blockState, mirror);
            }
        }
    }

    static {
        UP = BlockStateProperties.UP;
        EAST_WALL = BlockStateProperties.EAST_WALL;
        NORTH_WALL = BlockStateProperties.NORTH_WALL;
        SOUTH_WALL = BlockStateProperties.SOUTH_WALL;
        WEST_WALL = BlockStateProperties.WEST_WALL;
        WATERLOGGED = BlockStateProperties.WATERLOGGED;
        POST_TEST = Block.box(7.0F, 0.0F, 7.0F, 9.0F, 16.0F, 9.0F);
        NORTH_TEST = Block.box(7.0F, 0.0F, 0.0F, 9.0F, 16.0F, 9.0F);
        SOUTH_TEST = Block.box(7.0F, 0.0F, 7.0F, 9.0F, 16.0F, 16.0F);
        WEST_TEST = Block.box(0.0F, 0.0F, 7.0F, 9.0F, 16.0F, 9.0F);
        EAST_TEST = Block.box(7.0F, 0.0F, 7.0F, 16.0F, 16.0F, 9.0F);
    }
}
