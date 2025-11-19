package com.github.stellarwind22.metallics.util;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.Set;

public class MBlockEntityTypeFactory {

    public static <T extends BlockEntity> BlockEntityType<T> create(BlockEntityType.BlockEntitySupplier<T> supplier, Set<Block> blocks) {
        return new BlockEntityType<>(supplier, blocks);
    }
}
