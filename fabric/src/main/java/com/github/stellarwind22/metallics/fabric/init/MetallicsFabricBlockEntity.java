package com.github.stellarwind22.metallics.fabric.init;

import com.github.stellarwind22.metallics.content.MetallicsBlocks;
import com.github.stellarwind22.metallics.init.Metallics;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.CampfireBlockEntity;

public class MetallicsFabricBlockEntity {

    public static BlockEntityType<CampfireBlockEntity> CAMPFIRE;

    protected static void init() {
        CAMPFIRE = registerExisting("campfire", CampfireBlockEntity::new, MetallicsBlocks.COPPER_CAMPFIRE.get(), MetallicsBlocks.GOLD_CAMPFIRE.get(), MetallicsBlocks.NETHERITE_CAMPFIRE.get());
    }

    protected static <T extends BlockEntity> BlockEntityType<T> register(String name, FabricBlockEntityTypeBuilder.Factory<? extends T> entityFactory, Block... blocks) {
        ResourceLocation key = ResourceLocation.fromNamespaceAndPath(Metallics.MOD_ID, name);
        return Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, key, FabricBlockEntityTypeBuilder.<T>create(entityFactory, blocks).build());
    }

    protected static <T extends BlockEntity> BlockEntityType<T> registerExisting(String name, FabricBlockEntityTypeBuilder.Factory<? extends T> entityFactory, Block... blocks) {
        ResourceLocation key = ResourceLocation.withDefaultNamespace(name);
        return Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, key, FabricBlockEntityTypeBuilder.<T>create(entityFactory, blocks).build());
    }
}
