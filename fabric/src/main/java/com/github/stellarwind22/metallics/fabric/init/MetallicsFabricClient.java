package com.github.stellarwind22.metallics.fabric.init;

import com.github.stellarwind22.metallics.client.content.MetallicsParticleTypes;
import com.github.stellarwind22.metallics.client.init.MetallicsClient;
import com.github.stellarwind22.metallics.client.renderer.MCampfireRenderer;
import com.github.stellarwind22.metallics.content.MetallicsBlockEntityTypes;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.particle.FlameParticle;
import net.minecraft.client.particle.LavaParticle;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;

public final class MetallicsFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        MetallicsClient.init();

        ParticleFactoryRegistry particleFR = ParticleFactoryRegistry.getInstance();

        particleFR.register(MetallicsParticleTypes.COPPER_EMBER.get(), LavaParticle.Provider::new);
        particleFR.register(MetallicsParticleTypes.GOLD_FLAME.get(), FlameParticle.Provider::new);
        particleFR.register(MetallicsParticleTypes.GOLD_EMBER.get(), LavaParticle.Provider::new);
        particleFR.register(MetallicsParticleTypes.INFERNAL_FLAME.get(), FlameParticle.Provider::new);
        particleFR.register(MetallicsParticleTypes.INFERNAL_EMBER.get(), LavaParticle.Provider::new);
        particleFR.register(MetallicsParticleTypes.PALE_FLAME.get(), FlameParticle.Provider::new);
        particleFR.register(MetallicsParticleTypes.PALE_EMBER.get(), LavaParticle.Provider::new);

        BlockEntityRenderers.register(MetallicsBlockEntityTypes.CAMPFIRE.get(), MCampfireRenderer::new);
    }
}
