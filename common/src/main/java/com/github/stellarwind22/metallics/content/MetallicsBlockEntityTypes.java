package com.github.stellarwind22.metallics.content;

import com.github.stellarwind22.metallics.object.MBrushingBlockEntity;
import com.github.stellarwind22.metallics.object.MCampfireBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public class MetallicsBlockEntityTypes {

    public static Supplier<BlockEntityType<MCampfireBlockEntity>> CAMPFIRE;
    public static Supplier<BlockEntityType<MBrushingBlockEntity>> BRUSHABLE_BLOCK;
}
