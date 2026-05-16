package com.github.stellarwind22.metallics.fabric.init;

import com.github.stellarwind22.metallics.content.MetallicsBlockEntityTypes;
import com.github.stellarwind22.metallics.content.MetallicsBlocks;
import com.github.stellarwind22.metallics.init.Metallics;
import com.github.stellarwind22.metallics.object.blockentity.MBrushingBlockEntity;
import com.github.stellarwind22.metallics.object.blockentity.MCampfireBlockEntity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.levelgen.GenerationStep;

import java.util.function.Supplier;

public final class MetallicsFabric implements ModInitializer {
    @Override
    public void onInitialize() {

        Metallics.init();

        MetallicsBlockEntityTypes.CAMPFIRE = registerBlockEntity(
                "campfire",
                MCampfireBlockEntity::new,
                MetallicsBlocks.COPPER_CAMPFIRE.get(),
                MetallicsBlocks.GOLD_CAMPFIRE.get(),
                MetallicsBlocks.INFERNAL_CAMPFIRE.get(),
                MetallicsBlocks.PALE_CAMPFIRE.get()
        );

        MetallicsBlockEntityTypes.BRUSHABLE_BLOCK = registerBlockEntity(
                "brushable_block",
                MBrushingBlockEntity::new,
                MetallicsBlocks.BRUSHING_COPPER_BLOCK.get(),
                MetallicsBlocks.BRUSHING_IRON_BLOCK.get(),
                MetallicsBlocks.BRUSHING_BLUE_IRON_BLOCK.get(),
                MetallicsBlocks.BRUSHING_GOLD_BLOCK.get(),
                MetallicsBlocks.BRUSHING_NETHERITE_BLOCK.get(),
                MetallicsBlocks.BRUSHING_COPPER_SLAB.get(),
                MetallicsBlocks.BRUSHING_IRON_SLAB.get(),
                MetallicsBlocks.BRUSHING_BLUE_IRON_SLAB.get(),
                MetallicsBlocks.BRUSHING_GOLD_SLAB.get(),
                MetallicsBlocks.BRUSHING_NETHERITE_SLAB.get()
        );

        MetallicsBlocks.oxidizationInit();

        OxidizableBlocksRegistry.registerCopperBlockSet(MetallicsBlocks.BRUSHED_COPPER_BLOCKS);
        OxidizableBlocksRegistry.registerCopperBlockSet(MetallicsBlocks.BRUSHED_COPPER_SLABS);
        OxidizableBlocksRegistry.registerCopperBlockSet(MetallicsBlocks.COPPER_LADDERS);
        OxidizableBlocksRegistry.registerCopperBlockSet(MetallicsBlocks.COPPER_MESHES);
        OxidizableBlocksRegistry.registerCopperBlockSet(MetallicsBlocks.COPPER_LAMPS);
        OxidizableBlocksRegistry.registerCopperBlockSet(MetallicsBlocks.COPPER_SLABS);
        OxidizableBlocksRegistry.registerCopperBlockSet(MetallicsBlocks.COPPER_MESH_FENCES);
        OxidizableBlocksRegistry.registerCopperBlockSet(MetallicsBlocks.COPPER_MESH_GATES);
        OxidizableBlocksRegistry.registerCopperBlockSet(MetallicsBlocks.COPPER_MESH_DOORS);
        OxidizableBlocksRegistry.registerCopperBlockSet(MetallicsBlocks.COPPER_MESH_TRAPDOORS);
        OxidizableBlocksRegistry.registerCopperBlockSet(MetallicsBlocks.COPPER_BUTTONS);
        OxidizableBlocksRegistry.registerCopperBlockSet(MetallicsBlocks.COPPER_PRESSURE_PLATES);
        OxidizableBlocksRegistry.registerCopperBlockSet(MetallicsBlocks.COPPER_GLASS_BLOCKS);
        OxidizableBlocksRegistry.registerCopperBlockSet(MetallicsBlocks.COPPER_GLASS_PANES);
        OxidizableBlocksRegistry.registerCopperBlockSet(MetallicsBlocks.COPPER_TINTED_GLASS_BLOCKS);

        BiomeModifications.addFeature(
                BiomeSelectors.tag(TagKey.create(
                        Registries.BIOME,
                        ResourceLocation.fromNamespaceAndPath(
                                Metallics.MOD_ID,
                                "nitre_ore_biomes"
                        )
                )),
                GenerationStep.Decoration.UNDERGROUND_ORES,
                ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(Metallics.MOD_ID, "ore_nitre_salt"))
        );
    }

    public static <E extends BlockEntity> Supplier<BlockEntityType<E>> registerBlockEntity(String name, FabricBlockEntityTypeBuilder.Factory<? extends E> factory, Block... blocks) {
        var type = Registry.register(
                BuiltInRegistries.BLOCK_ENTITY_TYPE,
                ResourceLocation.fromNamespaceAndPath(Metallics.MOD_ID, name),
                FabricBlockEntityTypeBuilder.<E>create(factory, blocks).build()
        );
        return () -> type;
    }
}
