package com.github.stellarwind22.foundry_works.fabric.init;

import com.github.stellarwind22.foundry_works.init.FoundryWorksClient;
import net.fabricmc.api.ClientModInitializer;

public final class FoundryWorksFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        FoundryWorksClient.init();
    }
}
