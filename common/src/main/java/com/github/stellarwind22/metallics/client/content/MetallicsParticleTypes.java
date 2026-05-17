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
    public static RegistrySupplier<MSimpleParticleType> FERROUS_FLAME;
    public static RegistrySupplier<MSimpleParticleType> FERROUS_EMBER;
    public static RegistrySupplier<MSimpleParticleType> PALE_FLAME;
    public static RegistrySupplier<MSimpleParticleType> PALE_EMBER;
    public static RegistrySupplier<MSimpleParticleType> AZURE_FLAME;
    public static RegistrySupplier<MSimpleParticleType> AZURE_EMBER;
    public static RegistrySupplier<MSimpleParticleType> INFERNAL_FLAME;
    public static RegistrySupplier<MSimpleParticleType> INFERNAL_EMBER;

    public static void init() {
        PARTICLE_TYPES = DeferredRegister.create(Metallics.MOD_ID, Registries.PARTICLE_TYPE);

        COPPER_EMBER = register("copper_ember", () -> new MSimpleParticleType(false));
        FERROUS_FLAME = register("ferrous_flame", () -> new MSimpleParticleType(false));
        FERROUS_EMBER = register("ferrous_ember", () -> new MSimpleParticleType(false));
        PALE_FLAME = register("pale_flame", () -> new MSimpleParticleType(false));
        PALE_EMBER = register("pale_ember", () -> new MSimpleParticleType(false));
        AZURE_FLAME = register("azure_flame", () -> new MSimpleParticleType(false));
        AZURE_EMBER = register("azure_ember", () -> new MSimpleParticleType(false));
        INFERNAL_FLAME = register("infernal_flame", () -> new MSimpleParticleType(false));
        INFERNAL_EMBER = register("infernal_ember", () -> new MSimpleParticleType(false));

        PARTICLE_TYPES.register();
    }

    private static <T extends ParticleType<?>> RegistrySupplier<T> register(String name, Supplier<T> type) {
        return PARTICLE_TYPES.register(name, type);
    }
}
