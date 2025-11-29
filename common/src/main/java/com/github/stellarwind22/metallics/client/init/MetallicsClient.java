package com.github.stellarwind22.metallics.client.init;

import com.github.stellarwind22.metallics.content.MetallicsBlocks;
import com.github.stellarwind22.metallics.init.Metallics;
import dev.architectury.registry.client.rendering.RenderTypeRegistry;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;

public class MetallicsClient {

    public static void init() {

        Metallics.LOGGER.info("Initializing client code...");

        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.COPPER_MESH.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.EXPOSED_COPPER_MESH.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.WEATHERED_COPPER_MESH.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.OXIDIZED_COPPER_MESH.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.WAXED_COPPER_MESH.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.WAXED_EXPOSED_COPPER_MESH.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.WAXED_WEATHERED_COPPER_MESH.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.WAXED_OXIDIZED_COPPER_MESH.get());

        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.COPPER_MESH_FENCE.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.EXPOSED_COPPER_MESH_FENCE.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.WEATHERED_COPPER_MESH_FENCE.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.OXIDIZED_COPPER_MESH_FENCE.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.WAXED_COPPER_MESH_FENCE.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.WAXED_EXPOSED_COPPER_MESH_FENCE.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.WAXED_WEATHERED_COPPER_MESH_FENCE.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.WAXED_OXIDIZED_COPPER_MESH_FENCE.get());

        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.COPPER_MESH_DOOR.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.EXPOSED_COPPER_MESH_DOOR.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.WEATHERED_COPPER_MESH_DOOR.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.OXIDIZED_COPPER_MESH_DOOR.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.WAXED_COPPER_MESH_DOOR.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.WAXED_EXPOSED_COPPER_MESH_DOOR.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.WAXED_WEATHERED_COPPER_MESH_DOOR.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.WAXED_OXIDIZED_COPPER_MESH_DOOR.get());

        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.COPPER_MESH_TRAPDOOR.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.EXPOSED_COPPER_MESH_TRAPDOOR.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.WEATHERED_COPPER_MESH_TRAPDOOR.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.OXIDIZED_COPPER_MESH_TRAPDOOR.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.WAXED_COPPER_MESH_TRAPDOOR.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.WAXED_EXPOSED_COPPER_MESH_TRAPDOOR.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.WAXED_WEATHERED_COPPER_MESH_TRAPDOOR.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.WAXED_OXIDIZED_COPPER_MESH_TRAPDOOR.get());

        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.COPPER_CAMPFIRE.get());

        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.GOLD_CHAIN.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.GOLD_BARS.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.GOLD_DOOR.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.GOLD_MESH.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.GOLD_MESH_FENCE.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.GOLD_MESH_DOOR.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.GOLD_MESH_TRAPDOOR.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.GOLD_GRATE.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.GOLD_LANTERN.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.GOLD_CAMPFIRE.get());

        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.IRON_MESH.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.IRON_MESH_FENCE.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.IRON_GRATE.get());

        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.BLUE_IRON_CHAIN.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.BLUE_IRON_BARS.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.BLUE_IRON_LANTERN.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.BLUE_IRON_SOUL_LANTERN.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.BLUE_IRON_DOOR.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.BLUE_IRON_TRAPDOOR.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.BLUE_IRON_MESH.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.BLUE_IRON_MESH_FENCE.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.BLUE_IRON_MESH_DOOR.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.BLUE_IRON_MESH_TRAPDOOR.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.BLUE_IRON_GRATE.get());

        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.NETHERITE_CHAIN.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.NETHERITE_BARS.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.NETHERITE_LANTERN.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.NETHERITE_CAMPFIRE.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.NETHERITE_DOOR.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.NETHERITE_MESH.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.NETHERITE_MESH_FENCE.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.NETHERITE_MESH_DOOR.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.NETHERITE_MESH_TRAPDOOR.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.NETHERITE_GRATE.get());

        Metallics.LOGGER.info("Metallics blockRenderTypes/Particles registered!");
    }
}
