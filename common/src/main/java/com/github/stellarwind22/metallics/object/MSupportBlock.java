package com.github.stellarwind22.metallics.object;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import org.jetbrains.annotations.NotNull;

public class MSupportBlock extends Block implements SimpleWaterloggedBlock {

    public static final MapCodec<MSupportBlock> CODEC = simpleCodec(MSupportBlock::new);

    public static final BooleanProperty WATERLOGGED;
    public static final EnumProperty<Direction> FACING;
    public static final EnumProperty<Half> HALF;

    public MSupportBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false).setValue(HALF, Half.TOP));
    }

    public @NotNull FluidState getFluidState(BlockState blockState) {
        return blockState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(blockState);
    }

    public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, HALF, WATERLOGGED);
    }

    static {
        HALF = BlockStateProperties.HALF;
        FACING = BlockStateProperties.FACING;
        WATERLOGGED = BlockStateProperties.WATERLOGGED;
    }

    public @NotNull MapCodec<MSupportBlock> codec() {
        return CODEC;
    }
}
