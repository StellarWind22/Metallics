package com.github.stellarwind22.foundry_works.content;

import com.github.stellarwind22.foundry_works.init.FoundryWorks;
import com.github.stellarwind22.foundry_works.util.MBlock;
import com.github.stellarwind22.foundry_works.util.MBlockProps;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.Optional;

public class FoundryWorksBlocks {

    private static DeferredRegister<Block> BLOCKS;

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

    //Soul
    public static RegistrySupplier<Block> SOUL_JACK_O_LANTERN;

    //Copper
    public static RegistrySupplier<Block> COPPER_JACK_O_LANTERN;

    //Gold
    public static RegistrySupplier<Block> GOLD_JACK_O_LANTERN;

    public static RegistrySupplier<Block> GOLD_CHAIN;
    public static RegistrySupplier<Block> HANGING_GOLD_LANTERN;
    public static RegistrySupplier<Block> GOLD_LANTERN;

    //Iron

    //Netherite
    public static RegistrySupplier<Block> NETHERITE_JACK_O_LANTERN;

    public static RegistrySupplier<Block> NETHERITE_CHAIN;
    public static RegistrySupplier<Block> HANGING_NETHERITE_LANTERN;
    public static RegistrySupplier<Block> NETHERITE_LANTERN;

    public static void init() {
        BLOCKS = DeferredRegister.create(FoundryWorks.MOD_ID, Registries.BLOCK);

        //Register stuff here ▼▼▼

        //Soul
        SOUL_JACK_O_LANTERN = registerBlock("soul_jack_o_lantern", new MBlock(props -> new CarvedPumpkinBlock(props.lightLevel((state) -> 10)),
                Optional.of(jackOLanternProps.getCopy()
                )
        ));

        //Copper
        COPPER_JACK_O_LANTERN = registerBlock("copper_jack_o_lantern", new MBlock(CarvedPumpkinBlock::new, Optional.of(jackOLanternProps.getCopy())));

        //Gold
        GOLD_JACK_O_LANTERN = registerBlock("gold_jack_o_lantern", new MBlock(CarvedPumpkinBlock::new, Optional.of(jackOLanternProps.getCopy())));
        GOLD_CHAIN = registerBlock("gold_chain", new MBlock(ChainBlock::new, Optional.of(chainProps.getCopy())));

        //Iron

        //Netherite
        NETHERITE_JACK_O_LANTERN = registerBlock("netherite_jack_o_lantern", new MBlock(CarvedPumpkinBlock::new, Optional.of(jackOLanternProps.getCopy())));
        NETHERITE_CHAIN = registerBlock("netherite_chain", new MBlock(ChainBlock::new, Optional.of(chainProps.getCopy())));


        //Register stuff here ▲▲▲

        BLOCKS.register();
    }

    private static RegistrySupplier<Block> registerBlock(String name, MBlock mBlock) {
        ResourceKey<Block> key = ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(FoundryWorks.MOD_ID, name));
        if(mBlock.feedInProps().isPresent()) {
            return BLOCKS.register(name, () -> mBlock.blockConstructor().apply(mBlock.feedInProps().orElseThrow().setId(key)));
        } else {
            return BLOCKS.register(name, () -> mBlock.blockConstructor().apply(BlockBehaviour.Properties.of().setId(key)));
        }
    }
}
