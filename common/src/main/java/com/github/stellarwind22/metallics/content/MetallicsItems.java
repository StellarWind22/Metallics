package com.github.stellarwind22.metallics.content;

import com.github.stellarwind22.metallics.init.Metallics;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.item.component.ItemContainerContents;

import java.util.function.Function;

public class MetallicsItems {

    private static DeferredRegister<Item> ITEMS;

    //Soul
    public static RegistrySupplier<BlockItem> SOUL_JACK_O_LANTERN;

    //Copper
    public static RegistrySupplier<BlockItem> COPPER_CAMPFIRE;
    public static RegistrySupplier<BlockItem> COPPER_JACK_O_LANTERN;

    //Gold
    public static RegistrySupplier<BlockItem> GOLD_CHAIN;
    public static RegistrySupplier<BlockItem> GOLD_LANTERN;
    public static RegistrySupplier<BlockItem> GOLD_BARS;
    public static RegistrySupplier<BlockItem> GOLD_GRATE;

    public static RegistrySupplier<BlockItem> GOLD_TORCH;
    public static RegistrySupplier<BlockItem> GOLD_CAMPFIRE;
    public static RegistrySupplier<BlockItem> GOLD_JACK_O_LANTERN;

    //Iron
    public static RegistrySupplier<BlockItem> IRON_GRATE;

    //Netherite
    public static RegistrySupplier<Item> NETHERITE_NUGGET;
    public static RegistrySupplier<BlockItem> NETHERITE_CHAIN;
    public static RegistrySupplier<BlockItem> NETHERITE_LANTERN;
    public static RegistrySupplier<BlockItem> NETHERITE_BARS;
    public static RegistrySupplier<BlockItem> NETHERITE_GRATE;

    public static RegistrySupplier<BlockItem> NETHERITE_TORCH;
    public static RegistrySupplier<BlockItem> NETHERITE_CAMPFIRE;
    public static RegistrySupplier<BlockItem> NETHERITE_JACK_O_LANTERN;

    public static void init() {

        ITEMS = DeferredRegister.create(Metallics.MOD_ID, Registries.ITEM);

        //Register stuff here ▼▼▼

        //Soul
        SOUL_JACK_O_LANTERN = registerItem("soul_jack_o_lantern", props -> new BlockItem(MetallicsBlocks.SOUL_JACK_O_LANTERN.get(), props));

        //Copper
        COPPER_CAMPFIRE = registerItem("copper_campfire", props -> new BlockItem(MetallicsBlocks.COPPER_CAMPFIRE.get(), props.component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)));
        COPPER_JACK_O_LANTERN = registerItem("copper_jack_o_lantern", props -> new BlockItem(MetallicsBlocks.COPPER_JACK_O_LANTERN.get(), props));

        //Gold
        GOLD_CHAIN = registerItem("gold_chain", props -> new BlockItem(MetallicsBlocks.GOLD_CHAIN.get(), props));
        GOLD_BARS = registerItem("gold_bars", props -> new BlockItem(MetallicsBlocks.GOLD_BARS.get(), props));
        GOLD_LANTERN = registerItem("gold_lantern", props -> new BlockItem(MetallicsBlocks.GOLD_LANTERN.get(), props));
        GOLD_GRATE = registerItem("gold_grate", props -> new BlockItem(MetallicsBlocks.GOLD_GRATE.get(), props));

        GOLD_TORCH = registerItem("gold_torch", props -> new StandingAndWallBlockItem(MetallicsBlocks.GOLD_TORCH.get(), MetallicsBlocks.GOLD_WALL_TORCH.get(), Direction.DOWN, props));
        GOLD_CAMPFIRE = registerItem("gold_campfire", props -> new BlockItem(MetallicsBlocks.GOLD_CAMPFIRE.get(), props.component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)));
        GOLD_JACK_O_LANTERN = registerItem("gold_jack_o_lantern", props -> new BlockItem(MetallicsBlocks.GOLD_JACK_O_LANTERN.get(), props));

        //Iron
        IRON_GRATE = registerItem("iron_grate", props -> new BlockItem(MetallicsBlocks.IRON_GRATE.get(), props));

        //Netherite
        NETHERITE_NUGGET = registerItem("netherite_nugget", Item::new);
        NETHERITE_CHAIN = registerItem("netherite_chain", props -> new BlockItem(MetallicsBlocks.NETHERITE_CHAIN.get(), props));
        NETHERITE_BARS = registerItem("netherite_bars", props -> new BlockItem(MetallicsBlocks.NETHERITE_BARS.get(), props));
        NETHERITE_LANTERN = registerItem("netherite_lantern", props -> new BlockItem(MetallicsBlocks.NETHERITE_LANTERN.get(), props));
        NETHERITE_GRATE = registerItem("netherite_grate", props -> new BlockItem(MetallicsBlocks.NETHERITE_GRATE.get(), props));

        NETHERITE_TORCH = registerItem("netherite_torch", props -> new StandingAndWallBlockItem(MetallicsBlocks.NETHERITE_TORCH.get(), MetallicsBlocks.NETHERITE_WALL_TORCH.get(), Direction.DOWN, props));
        NETHERITE_CAMPFIRE = registerItem("netherite_campfire", props -> new BlockItem(MetallicsBlocks.NETHERITE_CAMPFIRE.get(), props.component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)));
        NETHERITE_JACK_O_LANTERN = registerItem("netherite_jack_o_lantern", props -> new BlockItem(MetallicsBlocks.NETHERITE_JACK_O_LANTERN.get(), props));

        //Register stuff here ▲▲▲

        ITEMS.register();
    }

    @SuppressWarnings("UnstableApiUsage")
    private static <T extends Item> RegistrySupplier<T> registerItem(String name, Function<Item.Properties, T> constructor) {
        return ITEMS.register(name, () -> constructor.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Metallics.MOD_ID, name))).arch$tab(MetallicsTabs.TAB)));
    }
}
