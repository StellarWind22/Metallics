package com.github.stellarwind22.foundry_works.init;

import com.github.stellarwind22.foundry_works.content.FoundryWorksBlocks;
import dev.architectury.registry.client.rendering.RenderTypeRegistry;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;

public class FoundryWorksClient {

    public static void init() {
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, FoundryWorksBlocks.GOLD_CHAIN.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, FoundryWorksBlocks.GOLD_BARS.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, FoundryWorksBlocks.GOLD_LANTERN.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, FoundryWorksBlocks.NETHERITE_CHAIN.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, FoundryWorksBlocks.NETHERITE_BARS.get());
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, FoundryWorksBlocks.NETHERITE_LANTERN.get());
    }
}
