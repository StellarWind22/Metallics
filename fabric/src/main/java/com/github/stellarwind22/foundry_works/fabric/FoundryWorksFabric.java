package com.github.stellarwind22.foundry_works.fabric;

import com.github.stellarwind22.foundry_works.init.FoundryWorks;
import net.fabricmc.api.ModInitializer;

public final class FoundryWorksFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run our common setup.
        FoundryWorks.init();
    }
}
