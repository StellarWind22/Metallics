package com.github.stellarwind22.metallics.object;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import org.jetbrains.annotations.NotNull;

public class MSupportBlock extends Block implements SimpleWaterloggedBlock {

    public static final MapCodec<MSupportBlock> CODEC = simpleCodec(MSupportBlock::new);

    public static final BooleanProperty WATERLOGGED;
    public static final EnumProperty<Direction> FACING;
    public static final BooleanProperty UP;

    public MSupportBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false).setValue(UP, true));
    }

    protected @NotNull FluidState getFluidState(BlockState blockState) {
        return blockState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(blockState);
    }

    static {
        WATERLOGGED = BlockStateProperties.WATERLOGGED;
        UP = BlockStateProperties.UP;
        FACING = BlockStateProperties.FACING;
    }

    public @NotNull MapCodec<MSupportBlock> codec() {
        return CODEC;
    }
}
