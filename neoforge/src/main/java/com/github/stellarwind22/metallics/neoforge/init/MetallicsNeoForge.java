package com.github.stellarwind22.metallics.neoforge.init;

import com.github.stellarwind22.metallics.client.content.MetallicsParticleTypes;
import com.github.stellarwind22.metallics.init.Metallics;
import com.github.stellarwind22.metallics.client.init.MetallicsClient;
import net.minecraft.client.particle.LavaParticle;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;

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

        @SubscribeEvent
        public static void registerParticleProviders(RegisterParticleProvidersEvent event) {
            event.registerSpriteSet(MetallicsParticleTypes.COPPER_EMBER.get(), LavaParticle.Provider::new);
            event.registerSpriteSet(MetallicsParticleTypes.GOLD_FLAME.get(), LavaParticle.Provider::new);
            event.registerSpriteSet(MetallicsParticleTypes.GOLD_EMBER.get(), LavaParticle.Provider::new);
            event.registerSpriteSet(MetallicsParticleTypes.NETHERITE_FLAME.get(), LavaParticle.Provider::new);
            event.registerSpriteSet(MetallicsParticleTypes.NETHERITE_EMBER.get(), LavaParticle.Provider::new);
        }
    }
}
