package com.github.stellarwind22.metallics.neoforge.init;

import com.github.stellarwind22.metallics.client.content.MetallicsParticleTypes;
import com.github.stellarwind22.metallics.client.init.MetallicsClient;
import com.github.stellarwind22.metallics.client.renderer.MCampfireRenderer;
import com.github.stellarwind22.metallics.content.MetallicsBlockEntityTypes;
import com.github.stellarwind22.metallics.content.MetallicsBlocks;
import com.github.stellarwind22.metallics.init.Metallics;
import com.github.stellarwind22.metallics.object.blockentity.MBrushingBlockEntity;
import com.github.stellarwind22.metallics.object.blockentity.MCampfireBlockEntity;
import net.minecraft.client.particle.LavaParticle;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.RegisterEvent;

import java.util.HashSet;
import java.util.function.Supplier;

@Mod(Metallics.MOD_ID)
public final class MetallicsNeoForge {

    public static DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES;

    public MetallicsNeoForge(IEventBus modEventBus) {
        BLOCK_ENTITY_TYPES = DeferredRegister.create(
                Registries.BLOCK_ENTITY_TYPE,
                Metallics.MOD_ID
        );

        MetallicsBlocks.NeoForgeInitSetTypes();
        BlockSetType.register(MetallicsBlocks.GOLD_SET.get());
        BlockSetType.register(MetallicsBlocks.NETHERITE_SET.get());

        MetallicsParticleTypes.init();
        Metallics.init();


        MetallicsBlockEntityTypes.CAMPFIRE = registerBlockEntity("campfire",
                MCampfireBlockEntity::new,
                MetallicsBlocks.COPPER_CAMPFIRE,
                MetallicsBlocks.FERROUS_CAMPFIRE,
                MetallicsBlocks.AZURE_CAMPFIRE,
                MetallicsBlocks.INFERNAL_CAMPFIRE,
                MetallicsBlocks.PALE_CAMPFIRE
        );

        MetallicsBlockEntityTypes.BRUSHABLE_BLOCK = registerBlockEntity(
                "brushable_block",
                MBrushingBlockEntity::new,
                MetallicsBlocks.BRUSHING_COPPER_BLOCK,
                MetallicsBlocks.BRUSHING_IRON_BLOCK,
                MetallicsBlocks.BRUSHING_BLUE_IRON_BLOCK,
                MetallicsBlocks.BRUSHING_GOLD_BLOCK,
                MetallicsBlocks.BRUSHING_NETHERITE_BLOCK,
                MetallicsBlocks.BRUSHING_COPPER_SLAB,
                MetallicsBlocks.BRUSHING_IRON_SLAB,
                MetallicsBlocks.BRUSHING_BLUE_IRON_SLAB,
                MetallicsBlocks.BRUSHING_GOLD_SLAB,
                MetallicsBlocks.BRUSHING_NETHERITE_SLAB
        );

        BLOCK_ENTITY_TYPES.register(modEventBus);

        modEventBus.addListener(this::clientSetup);
        modEventBus.addListener(this::registerParticleProviders);
        modEventBus.addListener(this::onRegisterEvent);
    }

    public void onRegisterEvent(RegisterEvent event) {
        if(event.getRegistryKey().equals(Registries.BLOCK)) {
            MetallicsBlocks.postInit();
        }
    }

    // Accept Suppliers instead of Block instances so .get() is deferred
    @SafeVarargs
    public static <E extends BlockEntity> Supplier<BlockEntityType<E>> registerBlockEntity(
            String name, BlockEntityType.BlockEntitySupplier<E> supplier, Supplier<? extends Block>... blocks) {
        return BLOCK_ENTITY_TYPES.register(name, () -> {
            // .get() is called here, inside the supplier, which runs after registration
            HashSet<Block> blocksIn = new HashSet<>();
            for (Supplier<? extends Block> b : blocks) blocksIn.add(b.get());
            return new BlockEntityType<>(supplier, blocksIn);
        });
    }

    private void clientSetup(FMLClientSetupEvent event) {
        MetallicsClient.init();
        BlockEntityRenderers.register(MetallicsBlockEntityTypes.CAMPFIRE.get(), MCampfireRenderer::new);
    }

    private void registerParticleProviders(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(MetallicsParticleTypes.COPPER_EMBER.get(), LavaParticle.Provider::new);
        event.registerSpriteSet(MetallicsParticleTypes.FERROUS_FLAME.get(), LavaParticle.Provider::new);
        event.registerSpriteSet(MetallicsParticleTypes.FERROUS_EMBER.get(), LavaParticle.Provider::new);
        event.registerSpriteSet(MetallicsParticleTypes.PALE_FLAME.get(), LavaParticle.Provider::new);
        event.registerSpriteSet(MetallicsParticleTypes.PALE_EMBER.get(), LavaParticle.Provider::new);
        event.registerSpriteSet(MetallicsParticleTypes.AZURE_FLAME.get(), LavaParticle.Provider::new);
        event.registerSpriteSet(MetallicsParticleTypes.AZURE_EMBER.get(), LavaParticle.Provider::new);
        event.registerSpriteSet(MetallicsParticleTypes.INFERNAL_FLAME.get(), LavaParticle.Provider::new);
        event.registerSpriteSet(MetallicsParticleTypes.INFERNAL_EMBER.get(), LavaParticle.Provider::new);
    }
}