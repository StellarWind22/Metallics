package com.github.stellarwind22.metallics.neoforge.init;

import com.github.stellarwind22.metallics.client.content.MetallicsParticleTypes;
import com.github.stellarwind22.metallics.client.renderer.MCampfireRenderer;
import com.github.stellarwind22.metallics.content.MetallicsBlockEntityTypes;
import com.github.stellarwind22.metallics.content.MetallicsBlocks;
import com.github.stellarwind22.metallics.init.Metallics;
import com.github.stellarwind22.metallics.client.init.MetallicsClient;
import com.github.stellarwind22.metallics.object.blockentity.MBrushingBlockEntity;
import com.github.stellarwind22.metallics.object.blockentity.MCampfireBlockEntity;
import net.minecraft.client.particle.LavaParticle;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.fml.loading.FMLLoader;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Arrays;
import java.util.HashSet;
import java.util.function.Supplier;

@Mod(Metallics.MOD_ID)
public final class MetallicsNeoForge {

    public static DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES;

    public MetallicsNeoForge() {
        // Run our common setup.
        Metallics.init();

        BLOCK_ENTITY_TYPES = DeferredRegister.create(
                Registries.BLOCK_ENTITY_TYPE,
                Metallics.MOD_ID
        );

        MetallicsBlockEntityTypes.CAMPFIRE = registerBlockEntity("campfire",
                MCampfireBlockEntity::new,
                MetallicsBlocks.COPPER_CAMPFIRE.get(),
                MetallicsBlocks.FERROUS_CAMPFIRE.get(),
                MetallicsBlocks.GOLD_CAMPFIRE.get(),
                MetallicsBlocks.INFERNAL_CAMPFIRE.get(),
                MetallicsBlocks.PALE_CAMPFIRE.get()
        );

        MetallicsBlockEntityTypes.BRUSHABLE_BLOCK = registerBlockEntity(
                "brushable_block",
                MBrushingBlockEntity::new,
                MetallicsBlocks.BRUSHING_COPPER_BLOCK.get(),
                MetallicsBlocks.BRUSHING_IRON_BLOCK.get(),
                MetallicsBlocks.BRUSHING_BLUE_IRON_BLOCK.get(),
                MetallicsBlocks.BRUSHING_GOLD_BLOCK.get(),
                MetallicsBlocks.BRUSHING_NETHERITE_BLOCK.get(),
                MetallicsBlocks.BRUSHING_COPPER_SLAB.get(),
                MetallicsBlocks.BRUSHING_IRON_SLAB.get(),
                MetallicsBlocks.BRUSHING_BLUE_IRON_SLAB.get(),
                MetallicsBlocks.BRUSHING_GOLD_SLAB.get(),
                MetallicsBlocks.BRUSHING_NETHERITE_SLAB.get()
        );

        if(FMLLoader.getCurrent().getDist() == Dist.CLIENT) {
            MetallicsClient.init();
            BlockEntityRenderers.register(MetallicsBlockEntityTypes.CAMPFIRE.get(), MCampfireRenderer::new);
        }
    }

    public static <E extends BlockEntity> Supplier<BlockEntityType<E>> registerBlockEntity(String name, BlockEntityType.BlockEntitySupplier<E> supplier, Block... blocks) {
        HashSet<Block> blocksIn = new HashSet<>(Arrays.stream(blocks).toList());
        return BLOCK_ENTITY_TYPES.register(name, () -> new BlockEntityType<>(supplier, blocksIn));
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
            event.registerSpriteSet(MetallicsParticleTypes.FERROUS_FLAME.get(), LavaParticle.Provider::new);
            event.registerSpriteSet(MetallicsParticleTypes.FERROUS_EMBER.get(), LavaParticle.Provider::new);
            event.registerSpriteSet(MetallicsParticleTypes.PALE_FLAME.get(), LavaParticle.Provider::new);
            event.registerSpriteSet(MetallicsParticleTypes.PALE_EMBER.get(), LavaParticle.Provider::new);
            event.registerSpriteSet(MetallicsParticleTypes.GOLD_FLAME.get(), LavaParticle.Provider::new);
            event.registerSpriteSet(MetallicsParticleTypes.GOLD_EMBER.get(), LavaParticle.Provider::new);
            event.registerSpriteSet(MetallicsParticleTypes.INFERNAL_FLAME.get(), LavaParticle.Provider::new);
            event.registerSpriteSet(MetallicsParticleTypes.INFERNAL_EMBER.get(), LavaParticle.Provider::new);
        }
    }
}
