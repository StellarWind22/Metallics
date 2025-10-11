package com.github.stellarwind22.metallics.fabric.init;

import com.github.stellarwind22.metallics.init.MetallicsClient;
import net.fabricmc.api.ClientModInitializer;

public final class MetallicsFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        MetallicsClient.init();
    }
}
