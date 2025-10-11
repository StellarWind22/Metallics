package com.github.stellarwind22.foundry_works.init;

import com.github.stellarwind22.foundry_works.content.MetallicsBlocks;
import dev.architectury.registry.client.rendering.RenderTypeRegistry;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;

public class MetallicsClient {

    public static void init() {
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.GOLD_CHAIN.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.GOLD_BARS.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.GOLD_LANTERN.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.NETHERITE_CHAIN.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.NETHERITE_BARS.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, MetallicsBlocks.NETHERITE_LANTERN.get());
    }
}
