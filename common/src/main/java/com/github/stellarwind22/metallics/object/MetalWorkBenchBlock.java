package com.github.stellarwind22.metallics.object;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MetalWorkBenchBlock extends BaseEntityBlock implements SimpleWaterloggedBlock {

    private static final MapCodec<MetalWorkBenchBlock> CODEC = simpleCodec(MetalWorkBenchBlock::new);

    private static final BooleanProperty LIT;
    private static final BooleanProperty WATERLOGGED;

    public MetalWorkBenchBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(LIT, false).setValue(WATERLOGGED, false));
    }

    @Override
    protected @NotNull MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return null;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(LIT, WATERLOGGED);
    }

    protected @NotNull FluidState getFluidState(BlockState blockState) {
        return blockState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(true) : super.getFluidState(blockState);
    }

    static {
        LIT = BlockStateProperties.LIT;
        WATERLOGGED = BlockStateProperties.WATERLOGGED;
    }
}
