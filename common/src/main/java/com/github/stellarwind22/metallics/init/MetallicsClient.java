package com.github.stellarwind22.metallics.init;

import com.github.stellarwind22.metallics.content.MetallicsBlocks;
import dev.architectury.registry.client.rendering.RenderTypeRegistry;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;

public class MetallicsClient {

    public static void init() {
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.COPPER_MESH.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.EXPOSED_COPPER_MESH.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.WEATHERED_COPPER_MESH.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.OXIDIZED_COPPER_MESH.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.WAXED_COPPER_MESH.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.WAXED_EXPOSED_COPPER_MESH.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.WAXED_WEATHERED_COPPER_MESH.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.WAXED_OXIDIZED_COPPER_MESH.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.COPPER_CAMPFIRE.get());

        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.GOLD_CHAIN.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.GOLD_BARS.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.GOLD_MESH.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.GOLD_GRATE.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.GOLD_LANTERN.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.GOLD_CAMPFIRE.get());

        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.IRON_MESH.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.IRON_GRATE.get());

        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.NETHERITE_CHAIN.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.NETHERITE_BARS.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.NETHERITE_LANTERN.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.NETHERITE_CAMPFIRE.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.NETHERITE_MESH.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.NETHERITE_GRATE.get());
    }
}
