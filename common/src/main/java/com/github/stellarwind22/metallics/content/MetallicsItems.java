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
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.item.component.ItemContainerContents;

import java.util.function.Function;

public class MetallicsItems {

    private static DeferredRegister<Item> ITEMS;

    //Soul
    public static RegistrySupplier<BlockItem> SOUL_JACK_O_LANTERN;

    //Copper
    public static RegistrySupplier<BlockItem> COPPER_MESH;
    public static RegistrySupplier<BlockItem> EXPOSED_COPPER_MESH;
    public static RegistrySupplier<BlockItem> WEATHERED_COPPER_MESH;
    public static RegistrySupplier<BlockItem> OXIDIZED_COPPER_MESH;
    public static RegistrySupplier<BlockItem> WAXED_COPPER_MESH;
    public static RegistrySupplier<BlockItem> WAXED_EXPOSED_COPPER_MESH;
    public static RegistrySupplier<BlockItem> WAXED_WEATHERED_COPPER_MESH;
    public static RegistrySupplier<BlockItem> WAXED_OXIDIZED_COPPER_MESH;

    public static RegistrySupplier<BlockItem> COPPER_MESH_FENCE;
    public static RegistrySupplier<BlockItem> EXPOSED_COPPER_MESH_FENCE;
    public static RegistrySupplier<BlockItem> WEATHERED_COPPER_MESH_FENCE;
    public static RegistrySupplier<BlockItem> OXIDIZED_COPPER_MESH_FENCE;
    public static RegistrySupplier<BlockItem> WAXED_COPPER_MESH_FENCE;
    public static RegistrySupplier<BlockItem> WAXED_EXPOSED_COPPER_MESH_FENCE;
    public static RegistrySupplier<BlockItem> WAXED_WEATHERED_COPPER_MESH_FENCE;
    public static RegistrySupplier<BlockItem> WAXED_OXIDIZED_COPPER_MESH_FENCE;

    public static RegistrySupplier<BlockItem> COPPER_CAMPFIRE;
    public static RegistrySupplier<BlockItem> COPPER_JACK_O_LANTERN;
    public static RegistrySupplier<BlockItem> COPPER_LAMP;
    public static RegistrySupplier<BlockItem> EXPOSED_COPPER_LAMP;
    public static RegistrySupplier<BlockItem> WEATHERED_COPPER_LAMP;
    public static RegistrySupplier<BlockItem> OXIDIZED_COPPER_LAMP;
    public static RegistrySupplier<BlockItem> WAXED_COPPER_LAMP;
    public static RegistrySupplier<BlockItem> WAXED_EXPOSED_COPPER_LAMP;
    public static RegistrySupplier<BlockItem> WAXED_WEATHERED_COPPER_LAMP;
    public static RegistrySupplier<BlockItem> WAXED_OXIDIZED_COPPER_LAMP;

    public static RegistrySupplier<BlockItem> COPPER_SUPPORT;

    //Iron
    public static RegistrySupplier<BlockItem> IRON_PLATE_BLOCK;
    public static RegistrySupplier<BlockItem> CUT_IRON_PLATE;
    public static RegistrySupplier<BlockItem> CHISELED_IRON_PLATE;
    public static RegistrySupplier<BlockItem> IRON_MESH;
    public static RegistrySupplier<BlockItem> IRON_MESH_FENCE;
    public static RegistrySupplier<BlockItem> IRON_GRATE;
    public static RegistrySupplier<BlockItem> IRON_LAMP;

    //Gold
    public static RegistrySupplier<BlockItem> GOLD_CHAIN;
    public static RegistrySupplier<BlockItem> GOLD_LANTERN;
    public static RegistrySupplier<BlockItem> GOLD_BARS;
    public static RegistrySupplier<BlockItem> GOLD_PLATE_BLOCK;
    public static RegistrySupplier<BlockItem> CUT_GOLD_PLATE;
    public static RegistrySupplier<BlockItem> GOLD_MESH;
    public static RegistrySupplier<BlockItem> GOLD_MESH_FENCE;
    public static RegistrySupplier<BlockItem> GOLD_GRATE;

    public static RegistrySupplier<BlockItem> GOLD_TORCH;
    public static RegistrySupplier<BlockItem> GOLD_CAMPFIRE;
    public static RegistrySupplier<BlockItem> GOLD_JACK_O_LANTERN;
    public static RegistrySupplier<BlockItem> GOLD_LAMP;

    //Netherite
    public static RegistrySupplier<Item> NETHERITE_NUGGET;
    public static RegistrySupplier<BlockItem> NETHERITE_CHAIN;
    public static RegistrySupplier<BlockItem> NETHERITE_LANTERN;
    public static RegistrySupplier<BlockItem> NETHERITE_BARS;
    public static RegistrySupplier<BlockItem> NETHERITE_PLATE_BLOCK;
    public static RegistrySupplier<BlockItem> CUT_NETHERITE_PLATE;
    public static RegistrySupplier<BlockItem> NETHERITE_MESH;
    public static RegistrySupplier<BlockItem> NETHERITE_MESH_FENCE;
    public static RegistrySupplier<BlockItem> NETHERITE_GRATE;

    public static RegistrySupplier<BlockItem> NETHERITE_TORCH;
    public static RegistrySupplier<BlockItem> NETHERITE_CAMPFIRE;
    public static RegistrySupplier<BlockItem> NETHERITE_JACK_O_LANTERN;
    public static RegistrySupplier<BlockItem> NETHERITE_LAMP;

    public static void init() {

        ITEMS = DeferredRegister.create(Metallics.MOD_ID, Registries.ITEM);

        //Register stuff here ▼▼▼

        //Soul
        SOUL_JACK_O_LANTERN = registerItem("soul_jack_o_lantern", props -> new BlockItem(MetallicsBlocks.SOUL_JACK_O_LANTERN.get(), props));

        //Copper
        COPPER_MESH = registerItem("copper_mesh", props -> new BlockItem(MetallicsBlocks.COPPER_MESH.get(), props));
        EXPOSED_COPPER_MESH = registerItem("exposed_copper_mesh", props -> new BlockItem(MetallicsBlocks.EXPOSED_COPPER_MESH.get(), props));
        WEATHERED_COPPER_MESH = registerItem("weathered_copper_mesh", props -> new BlockItem(MetallicsBlocks.WEATHERED_COPPER_MESH.get(), props));
        OXIDIZED_COPPER_MESH = registerItem("oxidized_copper_mesh", props -> new BlockItem(MetallicsBlocks.OXIDIZED_COPPER_MESH.get(), props));
        WAXED_COPPER_MESH = registerItem("waxed_copper_mesh", props -> new BlockItem(MetallicsBlocks.WAXED_COPPER_MESH.get(), props));
        WAXED_EXPOSED_COPPER_MESH = registerItem("waxed_exposed_copper_mesh", props -> new BlockItem(MetallicsBlocks.WAXED_EXPOSED_COPPER_MESH.get(), props));
        WAXED_WEATHERED_COPPER_MESH = registerItem("waxed_weathered_copper_mesh", props -> new BlockItem(MetallicsBlocks.WAXED_WEATHERED_COPPER_MESH.get(), props));
        WAXED_OXIDIZED_COPPER_MESH = registerItem("waxed_oxidized_copper_mesh", props -> new BlockItem(MetallicsBlocks.WAXED_OXIDIZED_COPPER_MESH.get(), props));

        COPPER_MESH_FENCE = registerItem("copper_mesh_fence", props -> new BlockItem(MetallicsBlocks.COPPER_MESH_FENCE.get(), props));
        EXPOSED_COPPER_MESH_FENCE = registerItem("exposed_copper_mesh_fence", props -> new BlockItem(MetallicsBlocks.EXPOSED_COPPER_MESH_FENCE.get(), props));
        WEATHERED_COPPER_MESH_FENCE = registerItem("weathered_copper_mesh_fence", props -> new BlockItem(MetallicsBlocks.WEATHERED_COPPER_MESH_FENCE.get(), props));
        OXIDIZED_COPPER_MESH_FENCE = registerItem("oxidized_copper_mesh_fence", props -> new BlockItem(MetallicsBlocks.OXIDIZED_COPPER_MESH_FENCE.get(), props));
        WAXED_COPPER_MESH_FENCE = registerItem("waxed_copper_mesh_fence", props -> new BlockItem(MetallicsBlocks.COPPER_MESH_FENCE.get(), props));
        WAXED_EXPOSED_COPPER_MESH_FENCE = registerItem("waxed_exposed_copper_mesh_fence", props -> new BlockItem(MetallicsBlocks.EXPOSED_COPPER_MESH_FENCE.get(), props));
        WAXED_WEATHERED_COPPER_MESH_FENCE = registerItem("waxed_weathered_copper_mesh_fence", props -> new BlockItem(MetallicsBlocks.WEATHERED_COPPER_MESH_FENCE.get(), props));
        WAXED_OXIDIZED_COPPER_MESH_FENCE = registerItem("waxed_oxidized_copper_mesh_fence", props -> new BlockItem(MetallicsBlocks.OXIDIZED_COPPER_MESH_FENCE.get(), props));

        COPPER_CAMPFIRE = registerItem("copper_campfire", props -> new BlockItem(MetallicsBlocks.COPPER_CAMPFIRE.get(), props.component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)));
        COPPER_JACK_O_LANTERN = registerItem("copper_jack_o_lantern", props -> new BlockItem(MetallicsBlocks.COPPER_JACK_O_LANTERN.get(), props));
        COPPER_LAMP = registerItem("copper_lamp", props -> new BlockItem(MetallicsBlocks.COPPER_LAMP.get(), props));
        EXPOSED_COPPER_LAMP = registerItem("exposed_copper_lamp", props -> new BlockItem(MetallicsBlocks.EXPOSED_COPPER_LAMP.get(), props));
        WEATHERED_COPPER_LAMP = registerItem("weathered_copper_lamp", props -> new BlockItem(MetallicsBlocks.WEATHERED_COPPER_LAMP.get(), props));
        OXIDIZED_COPPER_LAMP = registerItem("oxidized_copper_lamp", props -> new BlockItem(MetallicsBlocks.OXIDIZED_COPPER_LAMP.get(), props));
        WAXED_COPPER_LAMP = registerItem("waxed_copper_lamp", props -> new BlockItem(MetallicsBlocks.WAXED_COPPER_LAMP.get(), props));
        WAXED_EXPOSED_COPPER_LAMP = registerItem("waxed_exposed_copper_lamp", props -> new BlockItem(MetallicsBlocks.WAXED_EXPOSED_COPPER_LAMP.get(), props));
        WAXED_WEATHERED_COPPER_LAMP = registerItem("waxed_weathered_copper_lamp", props -> new BlockItem(MetallicsBlocks.WAXED_WEATHERED_COPPER_LAMP.get(), props));
        WAXED_OXIDIZED_COPPER_LAMP = registerItem("waxed_oxidized_copper_lamp", props -> new BlockItem(MetallicsBlocks.WAXED_OXIDIZED_COPPER_LAMP.get(), props));

        COPPER_SUPPORT = registerItem("copper_support", props -> new BlockItem(MetallicsBlocks.COPPER_SUPPORT.get(), props));

        //Iron
        IRON_PLATE_BLOCK = registerItem("iron_plate_block", props -> new BlockItem(MetallicsBlocks.IRON_PLATE_BLOCK.get(), props));
        CUT_IRON_PLATE = registerItem("cut_iron_plate", props -> new BlockItem(MetallicsBlocks.CUT_IRON_PLATE.get(), props));
        CHISELED_IRON_PLATE = registerItem("chiseled_iron_plate", props -> new BlockItem(MetallicsBlocks.CHISELED_IRON_PLATE.get(), props));
        IRON_MESH = registerItem("iron_mesh", props -> new BlockItem(MetallicsBlocks.IRON_MESH.get(), props));
        IRON_MESH_FENCE = registerItem("iron_mesh_fence", props -> new BlockItem(MetallicsBlocks.IRON_MESH_FENCE.get(), props));
        IRON_GRATE = registerItem("iron_grate", props -> new BlockItem(MetallicsBlocks.IRON_GRATE.get(), props));
        IRON_LAMP = registerItem("iron_lamp", props -> new BlockItem(MetallicsBlocks.IRON_LAMP.get(), props));

        //Gold
        GOLD_CHAIN = registerItem("gold_chain", props -> new BlockItem(MetallicsBlocks.GOLD_CHAIN.get(), props));
        GOLD_BARS = registerItem("gold_bars", props -> new BlockItem(MetallicsBlocks.GOLD_BARS.get(), props));
        GOLD_MESH = registerItem("gold_mesh", props -> new BlockItem(MetallicsBlocks.GOLD_MESH.get(), props));
        GOLD_MESH_FENCE = registerItem("gold_mesh_fence", props -> new BlockItem(MetallicsBlocks.GOLD_MESH_FENCE.get(), props));
        GOLD_PLATE_BLOCK = registerItem("gold_plate_block", props -> new BlockItem(MetallicsBlocks.GOLD_PLATE_BLOCK.get(), props));
        CUT_GOLD_PLATE = registerItem("cut_gold_plate", props -> new BlockItem(MetallicsBlocks.CUT_GOLD_PLATE.get(), props));
        GOLD_LANTERN = registerItem("gold_lantern", props -> new BlockItem(MetallicsBlocks.GOLD_LANTERN.get(), props));
        GOLD_GRATE = registerItem("gold_grate", props -> new BlockItem(MetallicsBlocks.GOLD_GRATE.get(), props));

        GOLD_TORCH = registerItem("gold_torch", props -> new StandingAndWallBlockItem(MetallicsBlocks.GOLD_TORCH.get(), MetallicsBlocks.GOLD_WALL_TORCH.get(), Direction.DOWN, props));
        GOLD_CAMPFIRE = registerItem("gold_campfire", props -> new BlockItem(MetallicsBlocks.GOLD_CAMPFIRE.get(), props.component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)));
        GOLD_JACK_O_LANTERN = registerItem("gold_jack_o_lantern", props -> new BlockItem(MetallicsBlocks.GOLD_JACK_O_LANTERN.get(), props));
        GOLD_LAMP = registerItem("gold_lamp", props -> new BlockItem(MetallicsBlocks.GOLD_LAMP.get(), props));

        //Netherite
        NETHERITE_NUGGET = registerItem("netherite_nugget", props -> new Item(props.fireResistant()));
        NETHERITE_CHAIN = registerItem("netherite_chain", props -> new BlockItem(MetallicsBlocks.NETHERITE_CHAIN.get(), props.fireResistant()));
        NETHERITE_BARS = registerItem("netherite_bars", props -> new BlockItem(MetallicsBlocks.NETHERITE_BARS.get(), props.fireResistant()));
        NETHERITE_PLATE_BLOCK = registerItem("netherite_plate_block", props -> new BlockItem(MetallicsBlocks.NETHERITE_PLATE_BLOCK.get(), props.fireResistant()));
        CUT_NETHERITE_PLATE = registerItem("cut_netherite_plate", props -> new BlockItem(MetallicsBlocks.CUT_NETHERITE_PLATE.get(), props.fireResistant()));
        NETHERITE_LANTERN = registerItem("netherite_lantern", props -> new BlockItem(MetallicsBlocks.NETHERITE_LANTERN.get(), props.fireResistant()));
        NETHERITE_MESH = registerItem("netherite_mesh", props -> new BlockItem(MetallicsBlocks.NETHERITE_MESH.get(), props.fireResistant()));
        NETHERITE_MESH_FENCE = registerItem("netherite_mesh_fence", props -> new BlockItem(MetallicsBlocks.NETHERITE_MESH_FENCE.get(), props));
        NETHERITE_GRATE = registerItem("netherite_grate", props -> new BlockItem(MetallicsBlocks.NETHERITE_GRATE.get(), props.fireResistant()));

        NETHERITE_TORCH = registerItem("netherite_torch", props -> new StandingAndWallBlockItem(MetallicsBlocks.NETHERITE_TORCH.get(), MetallicsBlocks.NETHERITE_WALL_TORCH.get(), Direction.DOWN, props));
        NETHERITE_CAMPFIRE = registerItem("netherite_campfire", props -> new BlockItem(MetallicsBlocks.NETHERITE_CAMPFIRE.get(), props.component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)));
        NETHERITE_JACK_O_LANTERN = registerItem("netherite_jack_o_lantern", props -> new BlockItem(MetallicsBlocks.NETHERITE_JACK_O_LANTERN.get(), props));
        NETHERITE_LAMP = registerItem("netherite_lamp", props -> new BlockItem(MetallicsBlocks.NETHERITE_LAMP.get(), props.fireResistant()));

        //Register stuff here ▲▲▲

        ITEMS.register();
    }

    @SuppressWarnings("UnstableApiUsage")
    private static <T extends Item> RegistrySupplier<T> registerItem(String name, Function<Item.Properties, T> constructor) {
        return ITEMS.register(name, () -> constructor.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Metallics.MOD_ID, name))).arch$tab(MetallicsTabs.TAB)));
    }
}
