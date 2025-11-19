package com.github.stellarwind22.metallics.fabric.init;

import com.github.stellarwind22.metallics.client.content.MetallicsParticleTypes;
import com.github.stellarwind22.metallics.client.init.MetallicsClient;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.particle.FlameParticle;
import net.minecraft.client.particle.LavaParticle;

public final class MetallicsFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        MetallicsClient.init();

        ParticleFactoryRegistry particleFR = ParticleFactoryRegistry.getInstance();

        particleFR.register(MetallicsParticleTypes.COPPER_EMBER.get(), LavaParticle.Provider::new);
        particleFR.register(MetallicsParticleTypes.GOLD_FLAME.get(), FlameParticle.Provider::new);
        particleFR.register(MetallicsParticleTypes.GOLD_EMBER.get(), LavaParticle.Provider::new);
        particleFR.register(MetallicsParticleTypes.NETHERITE_FLAME.get(), FlameParticle.Provider::new);
        particleFR.register(MetallicsParticleTypes.NETHERITE_EMBER.get(), LavaParticle.Provider::new);
    }
}
