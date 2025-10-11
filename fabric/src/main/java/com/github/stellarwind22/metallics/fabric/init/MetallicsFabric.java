package com.github.stellarwind22.metallics.fabric.init;

import com.github.stellarwind22.metallics.init.Metallics;
import net.fabricmc.api.ModInitializer;

public final class MetallicsFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Metallics.init();
    }
}
