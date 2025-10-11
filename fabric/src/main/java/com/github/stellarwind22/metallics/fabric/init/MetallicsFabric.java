package com.github.stellarwind22.foundry_works.fabric.init;

import com.github.stellarwind22.foundry_works.init.Metallics;
import net.fabricmc.api.ModInitializer;

public final class MetallicsFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Metallics.init();
    }
}
