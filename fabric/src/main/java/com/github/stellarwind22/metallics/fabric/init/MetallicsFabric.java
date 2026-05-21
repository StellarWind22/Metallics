package com.github.stellarwind22.metallics.fabric.init;

import com.github.stellarwind22.metallics.client.content.MetallicsParticleTypes;
import com.github.stellarwind22.metallics.content.MetallicsBlockEntityTypes;
import com.github.stellarwind22.metallics.content.MetallicsBlocks;
import com.github.stellarwind22.metallics.fabric.mixin.BlockSetTypeAccessor;
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
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.levelgen.GenerationStep;

import java.util.Map;
import java.util.function.Supplier;

public final class MetallicsFabric implements ModInitializer {

    private static Map<String, BlockSetType> BLOCK_SETS;
    @Override
    public void onInitialize() {

        //Handle set type fabric weirdness
        BLOCK_SETS = BlockSetTypeAccessor.metallics$getTypes();

        MetallicsBlocks.InitSetTypes();
        registerBlockSetType(MetallicsBlocks.GOLD_SET.get());
        registerBlockSetType(MetallicsBlocks.NETHERITE_SET.get());

        BlockSetTypeAccessor.metallics$setTypes(BLOCK_SETS);

        //Normal Init stuff
        MetallicsParticleTypes.init();
        Metallics.init();
        MetallicsBlocks.postInit();

        MetallicsBlockEntityTypes.CAMPFIRE = registerBlockEntity(
                "campfire",
                MCampfireBlockEntity::new,
                MetallicsBlocks.COPPER_CAMPFIRE.get(),
                MetallicsBlocks.FERROUS_CAMPFIRE.get(),
                MetallicsBlocks.AZURE_CAMPFIRE.get(),
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
                        Identifier.fromNamespaceAndPath(
                                Metallics.MOD_ID,
                                "nitre_ore_biomes"
                        )
                )),
                GenerationStep.Decoration.UNDERGROUND_ORES,
                ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(Metallics.MOD_ID, "ore_vitralite"))
        );
    }

    public static <E extends BlockEntity> Supplier<BlockEntityType<E>> registerBlockEntity(String name, FabricBlockEntityTypeBuilder.Factory<? extends E> factory, Block... blocks) {
        var type = Registry.register(
                BuiltInRegistries.BLOCK_ENTITY_TYPE,
                Identifier.fromNamespaceAndPath(Metallics.MOD_ID, name),
                FabricBlockEntityTypeBuilder.<E>create(factory, blocks).build()
        );
        return () -> type;
    }

    private static void registerBlockSetType(BlockSetType type) {
        BLOCK_SETS.put(type.name(), type);
    }
}
