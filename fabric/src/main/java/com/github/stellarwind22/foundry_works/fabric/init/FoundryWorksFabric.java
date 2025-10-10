package com.github.stellarwind22.foundry_works.fabric.init;

import com.github.stellarwind22.foundry_works.init.FoundryWorks;
import net.fabricmc.api.ModInitializer;

public final class FoundryWorksFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        FoundryWorks.init();
    }
}
