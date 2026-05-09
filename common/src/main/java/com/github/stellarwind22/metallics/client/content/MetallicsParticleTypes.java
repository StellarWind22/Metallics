package com.github.stellarwind22.metallics.client.content;

import com.github.stellarwind22.metallics.client.object.MSimpleParticleType;
import com.github.stellarwind22.metallics.init.Metallics;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.Registries;

import java.util.function.Supplier;

public class MetallicsParticleTypes {

    private static DeferredRegister<ParticleType<?>> PARTICLE_TYPES;

    public static RegistrySupplier<MSimpleParticleType> COPPER_EMBER;
    public static RegistrySupplier<MSimpleParticleType> PALE_FLAME;
    public static RegistrySupplier<MSimpleParticleType> PALE_EMBER;
    public static RegistrySupplier<MSimpleParticleType> GOLD_FLAME;
    public static RegistrySupplier<MSimpleParticleType> GOLD_EMBER;
    public static RegistrySupplier<MSimpleParticleType> NETHERITE_FLAME;
    public static RegistrySupplier<MSimpleParticleType> NETHERITE_EMBER;

    public static void init() {
        PARTICLE_TYPES = DeferredRegister.create(Metallics.MOD_ID, Registries.PARTICLE_TYPE);

        COPPER_EMBER = register("copper_ember", () -> new MSimpleParticleType(false));
        PALE_FLAME = register("pale_flame", () -> new MSimpleParticleType(false));
        PALE_EMBER = register("pale_ember", () -> new MSimpleParticleType(false));
        GOLD_FLAME = register("gold_flame", () -> new MSimpleParticleType(false));
        GOLD_EMBER = register("gold_ember", () -> new MSimpleParticleType(false));
        NETHERITE_FLAME = register("netherite_flame", () -> new MSimpleParticleType(false));
        NETHERITE_EMBER = register("netherite_ember", () -> new MSimpleParticleType(false));

        PARTICLE_TYPES.register();
    }

    private static <T extends ParticleType<?>> RegistrySupplier<T> register(String name, Supplier<T> type) {
        return PARTICLE_TYPES.register(name, type);
    }
}
