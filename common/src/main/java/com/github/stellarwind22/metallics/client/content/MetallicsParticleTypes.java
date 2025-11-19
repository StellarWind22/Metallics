package com.github.stellarwind22.metallics.client.content;

import com.github.stellarwind22.metallics.client.object.MSimpleParticleType;
import com.github.stellarwind22.metallics.init.Metallics;
import dev.architectury.registry.client.particle.ParticleProviderRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.FlameParticle;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;

import java.util.function.Supplier;

public class MetallicsParticleTypes {

    private static DeferredRegister<ParticleType<?>> PARTICLE_TYPES;

    public static RegistrySupplier<MSimpleParticleType> GOLD_FLAME;
    public static RegistrySupplier<MSimpleParticleType> NETHERITE_FLAME;

    public static void init() {
        PARTICLE_TYPES = DeferredRegister.create(Metallics.MOD_ID, Registries.PARTICLE_TYPE);

        GOLD_FLAME = register("gold_flame", () -> new MSimpleParticleType(false));
        NETHERITE_FLAME = register("netherite_flame", () -> new MSimpleParticleType(false));

        PARTICLE_TYPES.register();
    }

    @Environment(EnvType.CLIENT)
    public static void initClient() {

        ParticleProviderRegistry.register(GOLD_FLAME, FlameParticle.Provider::new);
        ParticleProviderRegistry.register(NETHERITE_FLAME, FlameParticle.Provider::new);
    }

    private static <T extends ParticleType<?>> RegistrySupplier<T> register(String name, Supplier<T> type) {
        return PARTICLE_TYPES.register(name, type);
    }
}
