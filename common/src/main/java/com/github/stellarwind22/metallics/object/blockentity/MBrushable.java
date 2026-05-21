package com.github.stellarwind22.metallics.object.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public interface MBrushable {

    int tickDelay();

    int brushesToComplete();

    Block getBrushableBlock();

    Identifier getTurnsInto();

    SoundEvent brushSound();

    SoundEvent brushCompletedSound();

    default void tickBrushable(ServerLevel serverLevel, BlockPos blockPos) {
        BlockEntity blockEntity = serverLevel.getBlockEntity(blockPos);
        if (blockEntity instanceof MBrushingBlockEntity brushableBlockEntity) {
            brushableBlockEntity.checkReset(serverLevel);
        }
    }

    default void animateTickBrushable(BlockState blockState, Level level, BlockPos blockPos, RandomSource randomSource) {
        if (randomSource.nextInt(16) == 0) {
            BlockPos blockPos2 = blockPos.below();
            if (FallingBlock.isFree(level.getBlockState(blockPos2))) {
                double d = (double)blockPos.getX() + randomSource.nextDouble();
                double e = (double)blockPos.getY() - 0.05;
                double f = (double)blockPos.getZ() + randomSource.nextDouble();
                level.addParticle(new BlockParticleOption(ParticleTypes.BLOCK, blockState), d, e, f, 0.0F, 0.0F, 0.0F);
            }
        }
    }

    default void onPlaceBrushable(Level level, BlockPos blockPos) {
        level.scheduleTick(blockPos, this.getBrushableBlock(), 2);
    }
}
