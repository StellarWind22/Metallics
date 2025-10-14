package com.github.stellarwind22.metallics.fabric.init;

import com.github.stellarwind22.metallics.content.MetallicsBlocks;
import com.github.stellarwind22.metallics.init.Metallics;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry;

public final class MetallicsFabric implements ModInitializer {
    @Override
    public void onInitialize() {

        Metallics.init();
        MetallicsBlocks.postRegisterInit();
        OxidizableBlocksRegistry.registerCopperBlockSet(MetallicsBlocks.COPPER_MESHES);
        OxidizableBlocksRegistry.registerCopperBlockSet(MetallicsBlocks.COPPER_LAMPS);
    }
}
