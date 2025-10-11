package com.github.stellarwind22.foundry_works.fabric.init;

import com.github.stellarwind22.foundry_works.init.MetallicsClient;
import net.fabricmc.api.ClientModInitializer;

public final class MetallicsFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        MetallicsClient.init();
    }
}
