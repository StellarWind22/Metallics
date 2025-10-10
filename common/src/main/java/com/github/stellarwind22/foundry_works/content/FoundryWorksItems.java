package com.github.stellarwind22.foundry_works.content;

import com.github.stellarwind22.foundry_works.init.FoundryWorks;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

import java.util.function.Function;

public class FoundryWorksItems {

    private static DeferredRegister<Item> ITEMS;

    //Soul
    public static RegistrySupplier<BlockItem> SOUL_JACK_O_LANTERN;

    //Copper
    public static RegistrySupplier<BlockItem> COPPER_JACK_O_LANTERN;

    //Gold
    public static RegistrySupplier<BlockItem> GOLD_CHAIN;
    public static RegistrySupplier<BlockItem> GOLD_JACK_O_LANTERN;

    //Iron

    //Netherite
    public static RegistrySupplier<Item> NETHERITE_NUGGET;
    public static RegistrySupplier<BlockItem> NETHERITE_CHAIN;
    public static RegistrySupplier<BlockItem> NETHERITE_JACK_O_LANTERN;

    public static void init() {

        ITEMS = DeferredRegister.create(FoundryWorks.MOD_ID, Registries.ITEM);

        //Register stuff here ▼▼▼

        //Soul
        SOUL_JACK_O_LANTERN = registerItem("soul_jack_o_lantern", props -> new BlockItem(FoundryWorksBlocks.SOUL_JACK_O_LANTERN.get(), props));

        //Copper
        COPPER_JACK_O_LANTERN = registerItem("copper_jack_o_lantern", props -> new BlockItem(FoundryWorksBlocks.COPPER_JACK_O_LANTERN.get(), props));

        //Gold
        GOLD_CHAIN = registerItem("gold_chain", props -> new BlockItem(FoundryWorksBlocks.GOLD_CHAIN.get(), props));
        GOLD_JACK_O_LANTERN = registerItem("gold_jack_o_lantern", props -> new BlockItem(FoundryWorksBlocks.GOLD_JACK_O_LANTERN.get(), props));

        //Iron

        //Netherite
        NETHERITE_NUGGET = registerItem("netherite_nugget", Item::new);
        NETHERITE_CHAIN = registerItem("netherite_chain", props -> new BlockItem(FoundryWorksBlocks.NETHERITE_CHAIN.get(), props));
        NETHERITE_JACK_O_LANTERN = registerItem("netherite_jack_o_lantern", props -> new BlockItem(FoundryWorksBlocks.NETHERITE_JACK_O_LANTERN.get(), props));

        //Register stuff here ▲▲▲

        ITEMS.register();
    }

    @SuppressWarnings("UnstableApiUsage")
    private static <T extends Item> RegistrySupplier<T> registerItem(String name, Function<Item.Properties, T> constructor) {
        return ITEMS.register(name, () -> constructor.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(FoundryWorks.MOD_ID, name))).arch$tab(FoundryWorksTabs.TAB)));
    }
}
