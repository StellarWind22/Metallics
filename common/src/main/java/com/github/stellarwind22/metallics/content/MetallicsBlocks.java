package com.github.stellarwind22.metallics.content;

import com.github.stellarwind22.metallics.init.Metallics;
import com.github.stellarwind22.metallics.object.MGrateBlock;
import com.github.stellarwind22.metallics.util.MBlock;
import com.github.stellarwind22.metallics.util.MBlockProps;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.Optional;

public class MetallicsBlocks {

    private static DeferredRegister<Block> BLOCKS;

    private static final MBlockProps torchProps = new MBlockProps()
            .noCollision()
            .instabreak()
            .lightLevel((blockState) -> 14)
            .sound(SoundType.WOOD)
            .pushReaction(PushReaction.DESTROY);


    private static final MBlockProps jackOLanternProps = new MBlockProps()
            .mapColor(MapColor.COLOR_ORANGE)
            .strength(1.0F)
            .sound(SoundType.WOOD)
            .lightLevel((blockState) -> 15)
            .isValidSpawn(MBlockProps::always)
            .pushReaction(PushReaction.DESTROY);

    private static final MBlockProps chainProps = new MBlockProps()
            .forceSolidOn()
            .requiresCorrectToolForDrops()
            .strength(5.0F, 6.0F)
            .sound(SoundType.CHAIN)
            .noOcclusion();

    private static final MBlockProps lanternProps = new MBlockProps()
            .mapColor(MapColor.METAL)
            .forceSolidOn()
            .strength(3.5F)
            .sound(SoundType.LANTERN)
            .lightLevel((blockState) -> 15)
            .noOcclusion()
            .pushReaction(PushReaction.DESTROY);

    private static final MBlockProps barsProps = new MBlockProps()
            .requiresCorrectToolForDrops()
            .strength(5.0F, 6.0F)
            .sound(SoundType.IRON).noOcclusion();

    private static final MBlockProps grateProps = new MBlockProps()
            .strength(3.0F, 6.0F)
            .sound(SoundType.COPPER_GRATE)
            .noOcclusion().requiresCorrectToolForDrops()
            .isValidSpawn(MBlockProps::never)
            .isRedstoneConductor(MBlockProps::never)
            .isSuffocating(MBlockProps::never)
            .isViewBlocking(MBlockProps::never);


    //Soul
    public static RegistrySupplier<Block> SOUL_JACK_O_LANTERN;

    //Copper
    public static RegistrySupplier<Block> COPPER_JACK_O_LANTERN;

    //Gold
    public static RegistrySupplier<Block> GOLD_CHAIN;
    public static RegistrySupplier<Block> GOLD_LANTERN;
    public static RegistrySupplier<Block> GOLD_BARS;
    public static RegistrySupplier<Block> GOLD_GRATE;

    public static RegistrySupplier<Block> GOLD_TORCH;
    public static RegistrySupplier<Block> GOLD_WALL_TORCH;
    public static RegistrySupplier<Block> GOLD_JACK_O_LANTERN;

    //Iron
    public static RegistrySupplier<Block> IRON_GRATE;

    //Netherite
    public static RegistrySupplier<Block> NETHERITE_CHAIN;
    public static RegistrySupplier<Block> NETHERITE_LANTERN;
    public static RegistrySupplier<Block> NETHERITE_BARS;
    public static RegistrySupplier<Block> NETHERITE_GRATE;

    public static RegistrySupplier<Block> NETHERITE_TORCH;
    public static RegistrySupplier<Block> NETHERITE_WALL_TORCH;
    public static RegistrySupplier<Block> NETHERITE_JACK_O_LANTERN;

    public static void init() {
        BLOCKS = DeferredRegister.create(Metallics.MOD_ID, Registries.BLOCK);

        //Register stuff here ▼▼▼

        //Soul
        SOUL_JACK_O_LANTERN = registerBlock("soul_jack_o_lantern", new MBlock(
                props -> new CarvedPumpkinBlock(props.lightLevel((state) -> 10)),
                Optional.of(jackOLanternProps.getCopy())
        ));

        //Copper
        COPPER_JACK_O_LANTERN = registerBlock("copper_jack_o_lantern", new MBlock(CarvedPumpkinBlock::new, Optional.of(jackOLanternProps.getCopy())));

        //Gold
        GOLD_CHAIN = registerBlock("gold_chain", new MBlock(ChainBlock::new, Optional.of(chainProps.getCopy())));
        GOLD_LANTERN = registerBlock("gold_lantern", new MBlock(LanternBlock::new, Optional.of(lanternProps.getCopy())));
        GOLD_BARS = registerBlock("gold_bars", new MBlock(IronBarsBlock::new, Optional.of(barsProps.getCopy())));
        GOLD_GRATE = registerBlock("gold_grate", new MBlock(MGrateBlock::new, Optional.of(grateProps.getCopy())));

        GOLD_TORCH = registerBlock("gold_torch", new MBlock(props -> new TorchBlock(ParticleTypes.SOUL_FIRE_FLAME, props), Optional.of(torchProps.getCopy())));
        GOLD_WALL_TORCH = registerBlock("gold_wall_torch", new MBlock(props -> new WallTorchBlock(ParticleTypes.SOUL_FIRE_FLAME, props), Optional.of(torchProps.getCopy())));
        GOLD_JACK_O_LANTERN = registerBlock("gold_jack_o_lantern", new MBlock(CarvedPumpkinBlock::new, Optional.of(jackOLanternProps.getCopy())));

        //Iron
        IRON_GRATE = registerBlock("iron_grate", new MBlock(MGrateBlock::new, Optional.of(grateProps.getCopy())));

        //Netherite
        NETHERITE_CHAIN = registerBlock("netherite_chain", new MBlock(ChainBlock::new, Optional.of(chainProps.getCopy())));
        NETHERITE_LANTERN = registerBlock("netherite_lantern", new MBlock(LanternBlock::new, Optional.of(lanternProps.getCopy())));
        NETHERITE_BARS = registerBlock("netherite_bars", new MBlock(IronBarsBlock::new, Optional.of(barsProps.getCopy())));
        NETHERITE_GRATE = registerBlock("netherite_grate", new MBlock(MGrateBlock::new, Optional.of(grateProps.getCopy())));

        NETHERITE_TORCH = registerBlock("netherite_torch", new MBlock(props -> new TorchBlock(ParticleTypes.SOUL_FIRE_FLAME, props), Optional.of(torchProps.getCopy())));
        NETHERITE_WALL_TORCH = registerBlock("netherite_wall_torch", new MBlock(props -> new WallTorchBlock(ParticleTypes.SOUL_FIRE_FLAME, props), Optional.of(torchProps.getCopy())));
        NETHERITE_JACK_O_LANTERN = registerBlock("netherite_jack_o_lantern", new MBlock(CarvedPumpkinBlock::new, Optional.of(jackOLanternProps.getCopy())));


        //Register stuff here ▲▲▲

        BLOCKS.register();
    }

    private static RegistrySupplier<Block> registerBlock(String name, MBlock mBlock) {
        ResourceKey<Block> key = ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Metallics.MOD_ID, name));
        if(mBlock.feedInProps().isPresent()) {
            return BLOCKS.register(name, () -> mBlock.blockConstructor().apply(mBlock.feedInProps().orElseThrow().setId(key)));
        } else {
            return BLOCKS.register(name, () -> mBlock.blockConstructor().apply(BlockBehaviour.Properties.of().setId(key)));
        }
    }
}
