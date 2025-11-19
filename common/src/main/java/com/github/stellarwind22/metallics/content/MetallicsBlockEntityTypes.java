package com.github.stellarwind22.metallics.content;

import com.github.stellarwind22.metallics.init.Metallics;
import com.github.stellarwind22.metallics.object.MCampfireBlockEntity;
import com.github.stellarwind22.metallics.util.MBlockEntityTypeFactory;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.Arrays;
import java.util.HashSet;

public class MetallicsBlockEntityTypes {

    private static DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES;

    public static RegistrySupplier<BlockEntityType<MCampfireBlockEntity>> CAMPFIRE;

    public static void init() {
        BLOCK_ENTITY_TYPES = DeferredRegister.create(Metallics.MOD_ID, Registries.BLOCK_ENTITY_TYPE);

        CAMPFIRE = register("campfire", MCampfireBlockEntity::new, MetallicsBlocks.COPPER_CAMPFIRE.get(), MetallicsBlocks.GOLD_CAMPFIRE.get(), MetallicsBlocks.NETHERITE_CAMPFIRE.get());

        BLOCK_ENTITY_TYPES.register();
    }

    private static <T extends BlockEntity> RegistrySupplier<BlockEntityType<T>> register(String name, BlockEntityType.BlockEntitySupplier<T> supplier, Block... blocks) {
        HashSet<Block> blocksIn = new HashSet<>(Arrays.stream(blocks).toList());
        return BLOCK_ENTITY_TYPES.register(name, () -> MBlockEntityTypeFactory.create(supplier, blocksIn));
    }
}
