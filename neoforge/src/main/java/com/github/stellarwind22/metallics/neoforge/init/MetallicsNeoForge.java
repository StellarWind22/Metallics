package com.github.stellarwind22.metallics.neoforge.init;

import com.github.stellarwind22.metallics.init.Metallics;
import com.github.stellarwind22.metallics.init.MetallicsClient;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.loading.FMLEnvironment;

@Mod(Metallics.MOD_ID)
public final class MetallicsNeoForge {
    public MetallicsNeoForge() {
        // Run our common setup.
        Metallics.init();
    }

    @EventBusSubscriber
    public static class Events {

        @SubscribeEvent
        public static void setup(FMLClientSetupEvent event) {
            if(FMLEnvironment.getDist() == Dist.CLIENT) {
                MetallicsClient.init();
            }
        }
    }
}
