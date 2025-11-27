package com.github.stellarwind22.metallics.content;

import com.github.stellarwind22.metallics.init.Metallics;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ItemContainerContents;

import java.util.function.Function;

public class MetallicsItems {

    private static DeferredRegister<Item> ITEMS;

    //Chemical
    public static RegistrySupplier<Item> NITRE_SALT;

    //Soul
    public static RegistrySupplier<BlockItem> SOUL_JACK_O_LANTERN;

    //Copper
    public static RegistrySupplier<BlockItem> BRUSHED_COPPER_BLOCK;
    public static RegistrySupplier<BlockItem> BRUSHED_EXPOSED_COPPER_BLOCK;
    public static RegistrySupplier<BlockItem> BRUSHED_WEATHERED_COPPER_BLOCK;
    public static RegistrySupplier<BlockItem> BRUSHED_OXIDIZED_COPPER_BLOCK;
    public static RegistrySupplier<BlockItem> WAXED_BRUSHED_COPPER_BLOCK;
    public static RegistrySupplier<BlockItem> WAXED_BRUSHED_EXPOSED_COPPER_BLOCK;
    public static RegistrySupplier<BlockItem> WAXED_BRUSHED_WEATHERED_COPPER_BLOCK;
    public static RegistrySupplier<BlockItem> WAXED_BRUSHED_OXIDIZED_COPPER_BLOCK;

    public static RegistrySupplier<BlockItem> BRUSHED_COPPER_SLAB;
    public static RegistrySupplier<BlockItem> BRUSHED_EXPOSED_COPPER_SLAB;
    public static RegistrySupplier<BlockItem> BRUSHED_WEATHERED_COPPER_SLAB;
    public static RegistrySupplier<BlockItem> BRUSHED_OXIDIZED_COPPER_SLAB;
    public static RegistrySupplier<BlockItem> WAXED_BRUSHED_COPPER_SLAB;
    public static RegistrySupplier<BlockItem> WAXED_BRUSHED_EXPOSED_COPPER_SLAB;
    public static RegistrySupplier<BlockItem> WAXED_BRUSHED_WEATHERED_COPPER_SLAB;
    public static RegistrySupplier<BlockItem> WAXED_BRUSHED_OXIDIZED_COPPER_SLAB;

    public static RegistrySupplier<BlockItem> COPPER_MESH;
    public static RegistrySupplier<BlockItem> EXPOSED_COPPER_MESH;
    public static RegistrySupplier<BlockItem> WEATHERED_COPPER_MESH;
    public static RegistrySupplier<BlockItem> OXIDIZED_COPPER_MESH;
    public static RegistrySupplier<BlockItem> WAXED_COPPER_MESH;
    public static RegistrySupplier<BlockItem> WAXED_EXPOSED_COPPER_MESH;
    public static RegistrySupplier<BlockItem> WAXED_WEATHERED_COPPER_MESH;
    public static RegistrySupplier<BlockItem> WAXED_OXIDIZED_COPPER_MESH;

    public static RegistrySupplier<BlockItem> COPPER_MESH_TRAPDOOR;
    public static RegistrySupplier<BlockItem> EXPOSED_COPPER_MESH_TRAPDOOR;
    public static RegistrySupplier<BlockItem> WEATHERED_COPPER_MESH_TRAPDOOR;
    public static RegistrySupplier<BlockItem> OXIDIZED_COPPER_MESH_TRAPDOOR;
    public static RegistrySupplier<BlockItem> WAXED_COPPER_MESH_TRAPDOOR;
    public static RegistrySupplier<BlockItem> WAXED_EXPOSED_COPPER_MESH_TRAPDOOR;
    public static RegistrySupplier<BlockItem> WAXED_WEATHERED_COPPER_MESH_TRAPDOOR;
    public static RegistrySupplier<BlockItem> WAXED_OXIDIZED_COPPER_MESH_TRAPDOOR;

    public static RegistrySupplier<BlockItem> COPPER_MESH_FENCE;
    public static RegistrySupplier<BlockItem> EXPOSED_COPPER_MESH_FENCE;
    public static RegistrySupplier<BlockItem> WEATHERED_COPPER_MESH_FENCE;
    public static RegistrySupplier<BlockItem> OXIDIZED_COPPER_MESH_FENCE;
    public static RegistrySupplier<BlockItem> WAXED_COPPER_MESH_FENCE;
    public static RegistrySupplier<BlockItem> WAXED_EXPOSED_COPPER_MESH_FENCE;
    public static RegistrySupplier<BlockItem> WAXED_WEATHERED_COPPER_MESH_FENCE;
    public static RegistrySupplier<BlockItem> WAXED_OXIDIZED_COPPER_MESH_FENCE;

    public static RegistrySupplier<DoubleHighBlockItem> COPPER_MESH_DOOR;
    public static RegistrySupplier<DoubleHighBlockItem> EXPOSED_COPPER_MESH_DOOR;
    public static RegistrySupplier<DoubleHighBlockItem> WEATHERED_COPPER_MESH_DOOR;
    public static RegistrySupplier<DoubleHighBlockItem> OXIDIZED_COPPER_MESH_DOOR;
    public static RegistrySupplier<DoubleHighBlockItem> WAXED_COPPER_MESH_DOOR;
    public static RegistrySupplier<DoubleHighBlockItem> WAXED_EXPOSED_COPPER_MESH_DOOR;
    public static RegistrySupplier<DoubleHighBlockItem> WAXED_WEATHERED_COPPER_MESH_DOOR;
    public static RegistrySupplier<DoubleHighBlockItem> WAXED_OXIDIZED_COPPER_MESH_DOOR;

    public static RegistrySupplier<BlockItem> COPPER_SLAB;
    public static RegistrySupplier<BlockItem> EXPOSED_COPPER_SLAB;
    public static RegistrySupplier<BlockItem> WEATHERED_COPPER_SLAB;
    public static RegistrySupplier<BlockItem> OXIDIZED_COPPER_SLAB;
    public static RegistrySupplier<BlockItem> WAXED_COPPER_SLAB;
    public static RegistrySupplier<BlockItem> WAXED_EXPOSED_COPPER_SLAB;
    public static RegistrySupplier<BlockItem> WAXED_WEATHERED_COPPER_SLAB;
    public static RegistrySupplier<BlockItem> WAXED_OXIDIZED_COPPER_SLAB;

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

    //Iron
    public static RegistrySupplier<BlockItem> IRON_PLATED_BLOCK;
    public static RegistrySupplier<BlockItem> IRON_SLAB;
    public static RegistrySupplier<BlockItem> BRUSHED_IRON_BLOCK;
    public static RegistrySupplier<BlockItem> BRUSHED_IRON_SLAB;
    public static RegistrySupplier<BlockItem> CUT_IRON_BLOCK;
    public static RegistrySupplier<BlockItem> CUT_IRON_STAIRS;
    public static RegistrySupplier<BlockItem> CUT_IRON_SLAB;
    public static RegistrySupplier<BlockItem> CHISELED_IRON_BLOCK;
    public static RegistrySupplier<BlockItem> IRON_MESH;
    public static RegistrySupplier<BlockItem> IRON_MESH_FENCE;
    public static RegistrySupplier<BlockItem> IRON_GRATE;
    public static RegistrySupplier<BlockItem> IRON_LAMP;

    //Blue Iron
    public static RegistrySupplier<BlockItem> BLUE_IRON_PLATED_BLOCK;
    public static RegistrySupplier<BlockItem> BLUE_IRON_SLAB;
    public static RegistrySupplier<BlockItem> BRUSHED_BLUE_IRON_BLOCK;
    public static RegistrySupplier<BlockItem> BRUSHED_BLUE_IRON_SLAB;
    public static RegistrySupplier<BlockItem> CUT_BLUE_IRON_BLOCK;
    public static RegistrySupplier<BlockItem> CUT_BLUE_IRON_STAIRS;
    public static RegistrySupplier<BlockItem> CUT_BLUE_IRON_SLAB;
    public static RegistrySupplier<BlockItem> CHISELED_BLUE_IRON_BLOCK;
    public static RegistrySupplier<BlockItem> BLUE_IRON_MESH;
    public static RegistrySupplier<BlockItem> BLUE_IRON_MESH_FENCE;
    public static RegistrySupplier<BlockItem> BLUE_IRON_GRATE;
    public static RegistrySupplier<BlockItem> BLUE_IRON_LAMP;

    //Gold
    public static RegistrySupplier<BlockItem> GOLD_CHAIN;
    public static RegistrySupplier<BlockItem> GOLD_LANTERN;
    public static RegistrySupplier<BlockItem> GOLD_BARS;
    public static RegistrySupplier<BlockItem> GOLD_PLATED_BLOCK;
    public static RegistrySupplier<BlockItem> GOLD_SLAB;
    public static RegistrySupplier<BlockItem> BRUSHED_GOLD_BLOCK;
    public static RegistrySupplier<BlockItem> BRUSHED_GOLD_SLAB;
    public static RegistrySupplier<BlockItem> CUT_GOLD_BLOCK;
    public static RegistrySupplier<BlockItem> CUT_GOLD_STAIRS;
    public static RegistrySupplier<BlockItem> CUT_GOLD_SLAB;
    public static RegistrySupplier<BlockItem> CHISELED_GOLD_BLOCK;
    public static RegistrySupplier<DoubleHighBlockItem> GOLD_DOOR;
    public static RegistrySupplier<BlockItem> GOLD_TRAPDOOR;
    public static RegistrySupplier<BlockItem> GOLD_MESH;
    public static RegistrySupplier<BlockItem> GOLD_MESH_FENCE;
    public static RegistrySupplier<BlockItem> GOLD_MESH_TRAPDOOR;
    public static RegistrySupplier<DoubleHighBlockItem> GOLD_MESH_DOOR;
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
    public static RegistrySupplier<BlockItem> NETHERITE_PLATED_BLOCK;
    public static RegistrySupplier<BlockItem> NETHERITE_SLAB;
    public static RegistrySupplier<BlockItem> BRUSHED_NETHERITE_BLOCK;
    public static RegistrySupplier<BlockItem> BRUSHED_NETHERITE_SLAB;
    public static RegistrySupplier<BlockItem> CUT_NETHERITE_BLOCK;
    public static RegistrySupplier<BlockItem> CUT_NETHERITE_STAIRS;
    public static RegistrySupplier<BlockItem> CUT_NETHERITE_SLAB;
    public static RegistrySupplier<BlockItem> CHISELED_NETHERITE_BLOCK;
    public static RegistrySupplier<DoubleHighBlockItem> NETHERITE_DOOR;
    public static RegistrySupplier<BlockItem> NETHERITE_TRAPDOOR;
    public static RegistrySupplier<BlockItem> NETHERITE_MESH;
    public static RegistrySupplier<BlockItem> NETHERITE_MESH_FENCE;
    public static RegistrySupplier<DoubleHighBlockItem> NETHERITE_MESH_DOOR;
    public static RegistrySupplier<BlockItem> NETHERITE_MESH_TRAPDOOR;
    public static RegistrySupplier<BlockItem> NETHERITE_GRATE;

    public static RegistrySupplier<BlockItem> NETHERITE_TORCH;
    public static RegistrySupplier<BlockItem> NETHERITE_CAMPFIRE;
    public static RegistrySupplier<BlockItem> NETHERITE_JACK_O_LANTERN;
    public static RegistrySupplier<BlockItem> NETHERITE_LAMP;

    public static void init() {

        ITEMS = DeferredRegister.create(Metallics.MOD_ID, Registries.ITEM);

        //Register stuff here ▼▼▼
        NITRE_SALT = registerItem("nitre_salt", Item::new);

        //Soul
        SOUL_JACK_O_LANTERN = registerItem("soul_jack_o_lantern", props -> new BlockItem(MetallicsBlocks.SOUL_JACK_O_LANTERN.get(), props));

        //Copper
        BRUSHED_COPPER_BLOCK= registerItem("brushed_copper_block", props -> new BlockItem(MetallicsBlocks.BRUSHED_COPPER_BLOCK.get(), props));
        BRUSHED_COPPER_SLAB= registerItem("brushed_copper_slab", props -> new BlockItem(MetallicsBlocks.BRUSHED_COPPER_SLAB.get(), props));
        COPPER_MESH = registerItem("copper_mesh", props -> new BlockItem(MetallicsBlocks.COPPER_MESH.get(), props));
        COPPER_MESH_FENCE = registerItem("copper_mesh_fence", props -> new BlockItem(MetallicsBlocks.COPPER_MESH_FENCE.get(), props));
        COPPER_MESH_DOOR = registerItem("copper_mesh_door", props -> new DoubleHighBlockItem(MetallicsBlocks.COPPER_MESH_DOOR.get(), props));
        COPPER_MESH_TRAPDOOR = registerItem("copper_mesh_trapdoor", props -> new BlockItem(MetallicsBlocks.COPPER_MESH_TRAPDOOR.get(), props));
        COPPER_SLAB = registerItem("copper_slab", props -> new BlockItem(MetallicsBlocks.COPPER_SLAB.get(), props));
        COPPER_LAMP = registerItem("copper_lamp", props -> new BlockItem(MetallicsBlocks.COPPER_LAMP.get(), props));

        BRUSHED_EXPOSED_COPPER_BLOCK= registerItem("brushed_exposed_copper_block", props -> new BlockItem(MetallicsBlocks.BRUSHED_EXPOSED_COPPER_BLOCK.get(), props));
        BRUSHED_EXPOSED_COPPER_SLAB= registerItem("brushed_exposed_copper_slab", props -> new BlockItem(MetallicsBlocks.BRUSHED_EXPOSED_COPPER_SLAB.get(), props));
        EXPOSED_COPPER_MESH = registerItem("exposed_copper_mesh", props -> new BlockItem(MetallicsBlocks.EXPOSED_COPPER_MESH.get(), props));
        EXPOSED_COPPER_MESH_FENCE = registerItem("exposed_copper_mesh_fence", props -> new BlockItem(MetallicsBlocks.EXPOSED_COPPER_MESH_FENCE.get(), props));
        EXPOSED_COPPER_MESH_DOOR = registerItem("exposed_copper_mesh_door", props -> new DoubleHighBlockItem(MetallicsBlocks.EXPOSED_COPPER_MESH_DOOR.get(), props));
        EXPOSED_COPPER_MESH_TRAPDOOR = registerItem("exposed_copper_mesh_trapdoor", props -> new BlockItem(MetallicsBlocks.EXPOSED_COPPER_MESH_TRAPDOOR.get(), props));
        EXPOSED_COPPER_SLAB = registerItem("exposed_copper_slab", props -> new BlockItem(MetallicsBlocks.EXPOSED_COPPER_SLAB.get(), props));
        EXPOSED_COPPER_LAMP = registerItem("exposed_copper_lamp", props -> new BlockItem(MetallicsBlocks.EXPOSED_COPPER_LAMP.get(), props));

        BRUSHED_WEATHERED_COPPER_BLOCK= registerItem("brushed_weathered_copper_block", props -> new BlockItem(MetallicsBlocks.BRUSHED_WEATHERED_COPPER_BLOCK.get(), props));
        BRUSHED_WEATHERED_COPPER_SLAB= registerItem("brushed_weathered_copper_slab", props -> new BlockItem(MetallicsBlocks.BRUSHED_WEATHERED_COPPER_SLAB.get(), props));
        WEATHERED_COPPER_MESH = registerItem("weathered_copper_mesh", props -> new BlockItem(MetallicsBlocks.WEATHERED_COPPER_MESH.get(), props));
        WEATHERED_COPPER_MESH_FENCE = registerItem("weathered_copper_mesh_fence", props -> new BlockItem(MetallicsBlocks.WEATHERED_COPPER_MESH_FENCE.get(), props));
        WEATHERED_COPPER_MESH_DOOR = registerItem("weathered_copper_mesh_door", props -> new DoubleHighBlockItem(MetallicsBlocks.WEATHERED_COPPER_MESH_DOOR.get(), props));
        WEATHERED_COPPER_MESH_TRAPDOOR = registerItem("weathered_copper_mesh_trapdoor", props -> new BlockItem(MetallicsBlocks.WEATHERED_COPPER_MESH_TRAPDOOR.get(), props));
        WEATHERED_COPPER_SLAB = registerItem("weathered_copper_slab", props -> new BlockItem(MetallicsBlocks.WEATHERED_COPPER_SLAB.get(), props));
        WEATHERED_COPPER_LAMP = registerItem("weathered_copper_lamp", props -> new BlockItem(MetallicsBlocks.WEATHERED_COPPER_LAMP.get(), props));

        BRUSHED_OXIDIZED_COPPER_BLOCK= registerItem("brushed_oxidized_copper_block", props -> new BlockItem(MetallicsBlocks.BRUSHED_OXIDIZED_COPPER_BLOCK.get(), props));
        BRUSHED_OXIDIZED_COPPER_SLAB= registerItem("brushed_oxidized_copper_slab", props -> new BlockItem(MetallicsBlocks.BRUSHED_OXIDIZED_COPPER_SLAB.get(), props));
        OXIDIZED_COPPER_MESH = registerItem("oxidized_copper_mesh", props -> new BlockItem(MetallicsBlocks.OXIDIZED_COPPER_MESH.get(), props));
        OXIDIZED_COPPER_MESH_FENCE = registerItem("oxidized_copper_mesh_fence", props -> new BlockItem(MetallicsBlocks.OXIDIZED_COPPER_MESH_FENCE.get(), props));
        OXIDIZED_COPPER_MESH_DOOR = registerItem("oxidized_copper_mesh_door", props -> new DoubleHighBlockItem(MetallicsBlocks.OXIDIZED_COPPER_MESH_DOOR.get(), props));
        OXIDIZED_COPPER_MESH_TRAPDOOR = registerItem("oxidized_copper_mesh_trapdoor", props -> new BlockItem(MetallicsBlocks.OXIDIZED_COPPER_MESH_TRAPDOOR.get(), props));
        OXIDIZED_COPPER_SLAB = registerItem("oxidized_copper_slab", props -> new BlockItem(MetallicsBlocks.OXIDIZED_COPPER_SLAB.get(), props));
        OXIDIZED_COPPER_LAMP = registerItem("oxidized_copper_lamp", props -> new BlockItem(MetallicsBlocks.OXIDIZED_COPPER_LAMP.get(), props));

        WAXED_BRUSHED_COPPER_BLOCK= registerItem("waxed_brushed_copper_block", props -> new BlockItem(MetallicsBlocks.WAXED_BRUSHED_COPPER_BLOCK.get(), props));
        WAXED_BRUSHED_COPPER_SLAB= registerItem("waxed_brushed_copper_slab", props -> new BlockItem(MetallicsBlocks.WAXED_BRUSHED_COPPER_SLAB.get(), props));
        WAXED_COPPER_MESH = registerItem("waxed_copper_mesh", props -> new BlockItem(MetallicsBlocks.WAXED_COPPER_MESH.get(), props));
        WAXED_COPPER_MESH_FENCE = registerItem("waxed_copper_mesh_fence", props -> new BlockItem(MetallicsBlocks.WAXED_COPPER_MESH_FENCE.get(), props));
        WAXED_COPPER_MESH_DOOR = registerItem("waxed_copper_mesh_door", props -> new DoubleHighBlockItem(MetallicsBlocks.WAXED_COPPER_MESH_DOOR.get(), props));
        WAXED_COPPER_MESH_TRAPDOOR = registerItem("waxed_copper_mesh_trapdoor", props -> new DoubleHighBlockItem(MetallicsBlocks.WAXED_COPPER_MESH_TRAPDOOR.get(), props));
        WAXED_COPPER_SLAB = registerItem("waxed_copper_slab", props -> new BlockItem(MetallicsBlocks.WAXED_COPPER_SLAB.get(), props));
        WAXED_COPPER_LAMP = registerItem("waxed_copper_lamp", props -> new BlockItem(MetallicsBlocks.WAXED_COPPER_LAMP.get(), props));

        WAXED_BRUSHED_EXPOSED_COPPER_BLOCK= registerItem("waxed_brushed_exposed_copper_block", props -> new BlockItem(MetallicsBlocks.WAXED_BRUSHED_EXPOSED_COPPER_BLOCK.get(), props));
        WAXED_BRUSHED_EXPOSED_COPPER_SLAB= registerItem("waxed_brushed_exposed_copper_slab", props -> new BlockItem(MetallicsBlocks.WAXED_BRUSHED_EXPOSED_COPPER_SLAB.get(), props));
        WAXED_EXPOSED_COPPER_MESH = registerItem("waxed_exposed_copper_mesh", props -> new BlockItem(MetallicsBlocks.WAXED_EXPOSED_COPPER_MESH.get(), props));
        WAXED_EXPOSED_COPPER_MESH_FENCE = registerItem("waxed_exposed_copper_mesh_fence", props -> new BlockItem(MetallicsBlocks.WAXED_EXPOSED_COPPER_MESH_FENCE.get(), props));
        WAXED_EXPOSED_COPPER_MESH_DOOR = registerItem("waxed_exposed_copper_mesh_door", props -> new DoubleHighBlockItem(MetallicsBlocks.WAXED_EXPOSED_COPPER_MESH_DOOR.get(), props));
        WAXED_EXPOSED_COPPER_MESH_TRAPDOOR = registerItem("waxed_exposed_copper_mesh_trapdoor", props -> new DoubleHighBlockItem(MetallicsBlocks.WAXED_EXPOSED_COPPER_MESH_TRAPDOOR.get(), props));
        WAXED_EXPOSED_COPPER_SLAB = registerItem("waxed_exposed_copper_slab", props -> new BlockItem(MetallicsBlocks.WAXED_EXPOSED_COPPER_SLAB.get(), props));
        WAXED_EXPOSED_COPPER_LAMP = registerItem("waxed_exposed_copper_lamp", props -> new BlockItem(MetallicsBlocks.WAXED_EXPOSED_COPPER_LAMP.get(), props));

        WAXED_BRUSHED_WEATHERED_COPPER_BLOCK= registerItem("waxed_brushed_weathered_copper_block", props -> new BlockItem(MetallicsBlocks.WAXED_BRUSHED_WEATHERED_COPPER_BLOCK.get(), props));
        WAXED_BRUSHED_WEATHERED_COPPER_SLAB= registerItem("waxed_brushed_weathered_copper_slab", props -> new BlockItem(MetallicsBlocks.WAXED_BRUSHED_WEATHERED_COPPER_SLAB.get(), props));
        WAXED_WEATHERED_COPPER_MESH = registerItem("waxed_weathered_copper_mesh", props -> new BlockItem(MetallicsBlocks.WAXED_WEATHERED_COPPER_MESH.get(), props));
        WAXED_WEATHERED_COPPER_MESH_FENCE = registerItem("waxed_weathered_copper_mesh_fence", props -> new BlockItem(MetallicsBlocks.WAXED_WEATHERED_COPPER_MESH_FENCE.get(), props));
        WAXED_WEATHERED_COPPER_MESH_DOOR = registerItem("waxed_weathered_copper_mesh_door", props -> new DoubleHighBlockItem(MetallicsBlocks.WAXED_WEATHERED_COPPER_MESH_DOOR.get(), props));
        WAXED_WEATHERED_COPPER_MESH_TRAPDOOR = registerItem("waxed_weathered_copper_mesh_trapdoor", props -> new DoubleHighBlockItem(MetallicsBlocks.WAXED_WEATHERED_COPPER_MESH_TRAPDOOR.get(), props));
        WAXED_WEATHERED_COPPER_SLAB = registerItem("waxed_weathered_copper_slab", props -> new BlockItem(MetallicsBlocks.WAXED_WEATHERED_COPPER_SLAB.get(), props));
        WAXED_WEATHERED_COPPER_LAMP = registerItem("waxed_weathered_copper_lamp", props -> new BlockItem(MetallicsBlocks.WAXED_WEATHERED_COPPER_LAMP.get(), props));

        WAXED_BRUSHED_OXIDIZED_COPPER_BLOCK= registerItem("waxed_brushed_oxidized_copper_block", props -> new BlockItem(MetallicsBlocks.WAXED_BRUSHED_OXIDIZED_COPPER_BLOCK.get(), props));
        WAXED_BRUSHED_OXIDIZED_COPPER_SLAB= registerItem("waxed_brushed_oxidized_copper_slab", props -> new BlockItem(MetallicsBlocks.WAXED_BRUSHED_OXIDIZED_COPPER_SLAB.get(), props));
        WAXED_OXIDIZED_COPPER_MESH = registerItem("waxed_oxidized_copper_mesh", props -> new BlockItem(MetallicsBlocks.WAXED_OXIDIZED_COPPER_MESH.get(), props));
        WAXED_OXIDIZED_COPPER_MESH_FENCE = registerItem("waxed_oxidized_copper_mesh_fence", props -> new BlockItem(MetallicsBlocks.WAXED_OXIDIZED_COPPER_MESH_FENCE.get(), props));
        WAXED_OXIDIZED_COPPER_MESH_DOOR = registerItem("waxed_oxidized_copper_mesh_door", props -> new DoubleHighBlockItem(MetallicsBlocks.WAXED_OXIDIZED_COPPER_MESH_DOOR.get(), props));
        WAXED_OXIDIZED_COPPER_MESH_TRAPDOOR = registerItem("waxed_oxidized_copper_mesh_trapdoor", props -> new DoubleHighBlockItem(MetallicsBlocks.WAXED_OXIDIZED_COPPER_MESH_TRAPDOOR.get(), props));
        WAXED_OXIDIZED_COPPER_SLAB = registerItem("waxed_oxidized_copper_slab", props -> new BlockItem(MetallicsBlocks.WAXED_OXIDIZED_COPPER_SLAB.get(), props));
        WAXED_OXIDIZED_COPPER_LAMP = registerItem("waxed_oxidized_copper_lamp", props -> new BlockItem(MetallicsBlocks.WAXED_OXIDIZED_COPPER_LAMP.get(), props));

        COPPER_CAMPFIRE = registerItem("copper_campfire", props -> new BlockItem(MetallicsBlocks.COPPER_CAMPFIRE.get(), props.component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)));
        COPPER_JACK_O_LANTERN = registerItem("copper_jack_o_lantern", props -> new BlockItem(MetallicsBlocks.COPPER_JACK_O_LANTERN.get(), props));


        //Iron
        IRON_MESH = registerItem("iron_mesh", props -> new BlockItem(MetallicsBlocks.IRON_MESH.get(), props));
        IRON_MESH_FENCE = registerItem("iron_mesh_fence", props -> new BlockItem(MetallicsBlocks.IRON_MESH_FENCE.get(), props));
        IRON_GRATE = registerItem("iron_grate", props -> new BlockItem(MetallicsBlocks.IRON_GRATE.get(), props));
        IRON_PLATED_BLOCK = registerItem("iron_plated_block", props -> new BlockItem(MetallicsBlocks.IRON_PLATED_BLOCK.get(), props));
        IRON_SLAB = registerItem("iron_slab", props -> new BlockItem(MetallicsBlocks.IRON_SLAB.get(), props));
        BRUSHED_IRON_BLOCK= registerItem("brushed_iron_block", props -> new BlockItem(MetallicsBlocks.BRUSHED_IRON_BLOCK.get(), props));
        BRUSHED_IRON_SLAB= registerItem("brushed_iron_slab", props -> new BlockItem(MetallicsBlocks.BRUSHED_IRON_SLAB.get(), props));
        CUT_IRON_BLOCK= registerItem("cut_iron_block", props -> new BlockItem(MetallicsBlocks.CUT_IRON_BLOCK.get(), props));
        CUT_IRON_STAIRS = registerItem("cut_iron_stairs", props -> new BlockItem(MetallicsBlocks.CUT_IRON_STAIRS.get(), props));
        CUT_IRON_SLAB = registerItem("cut_iron_slab", props -> new BlockItem(MetallicsBlocks.CUT_IRON_SLAB.get(), props));
        CHISELED_IRON_BLOCK = registerItem("chiseled_iron_block", props -> new BlockItem(MetallicsBlocks.CHISELED_IRON_BLOCK.get(), props));
        IRON_LAMP = registerItem("iron_lamp", props -> new BlockItem(MetallicsBlocks.IRON_LAMP.get(), props));

        //Blue Iron
        BLUE_IRON_MESH = registerItem("blue_iron_mesh", props -> new BlockItem(MetallicsBlocks.BLUE_IRON_MESH.get(), props));
        BLUE_IRON_MESH_FENCE = registerItem("blue_iron_mesh_fence", props -> new BlockItem(MetallicsBlocks.BLUE_IRON_MESH_FENCE.get(), props));
        BLUE_IRON_GRATE = registerItem("blue_iron_grate", props -> new BlockItem(MetallicsBlocks.BLUE_IRON_GRATE.get(), props));
        BLUE_IRON_PLATED_BLOCK = registerItem("blue_iron_plated_block", props -> new BlockItem(MetallicsBlocks.BLUE_IRON_PLATED_BLOCK.get(), props));
        BLUE_IRON_SLAB = registerItem("blue_iron_slab", props -> new BlockItem(MetallicsBlocks.BLUE_IRON_SLAB.get(), props));
        BRUSHED_BLUE_IRON_BLOCK= registerItem("brushed_blue_iron_block", props -> new BlockItem(MetallicsBlocks.BRUSHED_BLUE_IRON_BLOCK.get(), props));
        BRUSHED_BLUE_IRON_SLAB= registerItem("brushed_blue_iron_slab", props -> new BlockItem(MetallicsBlocks.BRUSHED_BLUE_IRON_SLAB.get(), props));
        CUT_BLUE_IRON_BLOCK= registerItem("cut_blue_iron_block", props -> new BlockItem(MetallicsBlocks.CUT_BLUE_IRON_BLOCK.get(), props));
        CUT_BLUE_IRON_STAIRS = registerItem("cut_blue_iron_stairs", props -> new BlockItem(MetallicsBlocks.CUT_BLUE_IRON_STAIRS.get(), props));
        CUT_BLUE_IRON_SLAB = registerItem("cut_blue_iron_slab", props -> new BlockItem(MetallicsBlocks.CUT_BLUE_IRON_SLAB.get(), props));
        CHISELED_BLUE_IRON_BLOCK = registerItem("chiseled_blue_iron_block", props -> new BlockItem(MetallicsBlocks.CHISELED_BLUE_IRON_BLOCK.get(), props));
        BLUE_IRON_LAMP = registerItem("blue_iron_lamp", props -> new BlockItem(MetallicsBlocks.BLUE_IRON_LAMP.get(), props));

        //Gold
        GOLD_CHAIN = registerItem("gold_chain", props -> new BlockItem(MetallicsBlocks.GOLD_CHAIN.get(), props));
        GOLD_BARS = registerItem("gold_bars", props -> new BlockItem(MetallicsBlocks.GOLD_BARS.get(), props));
        GOLD_DOOR = registerItem("gold_door", props -> new DoubleHighBlockItem(MetallicsBlocks.GOLD_DOOR.get(), props));
        GOLD_TRAPDOOR = registerItem("gold_trapdoor", props -> new BlockItem(MetallicsBlocks.GOLD_TRAPDOOR.get(), props));
        GOLD_MESH = registerItem("gold_mesh", props -> new BlockItem(MetallicsBlocks.GOLD_MESH.get(), props));
        GOLD_MESH_FENCE = registerItem("gold_mesh_fence", props -> new BlockItem(MetallicsBlocks.GOLD_MESH_FENCE.get(), props));
        GOLD_MESH_DOOR = registerItem("gold_mesh_door", props -> new DoubleHighBlockItem(MetallicsBlocks.GOLD_MESH_DOOR.get(), props));
        GOLD_MESH_TRAPDOOR = registerItem("gold_mesh_trapdoor", props -> new BlockItem(MetallicsBlocks.GOLD_MESH_TRAPDOOR.get(), props));
        GOLD_LANTERN = registerItem("gold_lantern", props -> new BlockItem(MetallicsBlocks.GOLD_LANTERN.get(), props));
        GOLD_GRATE = registerItem("gold_grate", props -> new BlockItem(MetallicsBlocks.GOLD_GRATE.get(), props));
        GOLD_PLATED_BLOCK = registerItem("gold_plated_block", props -> new BlockItem(MetallicsBlocks.GOLD_PLATED_BLOCK.get(), props));
        GOLD_SLAB = registerItem("gold_slab", props -> new BlockItem(MetallicsBlocks.GOLD_SLAB.get(), props));
        BRUSHED_GOLD_BLOCK= registerItem("brushed_gold_block", props -> new BlockItem(MetallicsBlocks.BRUSHED_GOLD_BLOCK.get(), props));
        BRUSHED_GOLD_SLAB= registerItem("brushed_gold_slab", props -> new BlockItem(MetallicsBlocks.BRUSHED_GOLD_SLAB.get(), props));
        CUT_GOLD_BLOCK = registerItem("cut_gold_block", props -> new BlockItem(MetallicsBlocks.CUT_GOLD_BLOCK.get(), props));
        CHISELED_GOLD_BLOCK = registerItem("chiseled_gold_block", props -> new BlockItem(MetallicsBlocks.CHISELED_GOLD_BLOCK.get(), props));
        CUT_GOLD_STAIRS = registerItem("cut_gold_stairs", props -> new BlockItem(MetallicsBlocks.CUT_GOLD_STAIRS.get(), props));
        CUT_GOLD_SLAB = registerItem("cut_gold_slab", props -> new BlockItem(MetallicsBlocks.CUT_GOLD_SLAB.get(), props));

        GOLD_TORCH = registerItem("gold_torch", props -> new StandingAndWallBlockItem(MetallicsBlocks.GOLD_TORCH.get(), MetallicsBlocks.GOLD_WALL_TORCH.get(), Direction.DOWN, props));
        GOLD_CAMPFIRE = registerItem("gold_campfire", props -> new BlockItem(MetallicsBlocks.GOLD_CAMPFIRE.get(), props.component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)));
        GOLD_JACK_O_LANTERN = registerItem("gold_jack_o_lantern", props -> new BlockItem(MetallicsBlocks.GOLD_JACK_O_LANTERN.get(), props));
        GOLD_LAMP = registerItem("gold_lamp", props -> new BlockItem(MetallicsBlocks.GOLD_LAMP.get(), props));

        //Netherite
        NETHERITE_NUGGET = registerItem("netherite_nugget", props -> new Item(props.fireResistant()));
        NETHERITE_CHAIN = registerItem("netherite_chain", props -> new BlockItem(MetallicsBlocks.NETHERITE_CHAIN.get(), props.fireResistant()));
        NETHERITE_BARS = registerItem("netherite_bars", props -> new BlockItem(MetallicsBlocks.NETHERITE_BARS.get(), props.fireResistant()));
        NETHERITE_LANTERN = registerItem("netherite_lantern", props -> new BlockItem(MetallicsBlocks.NETHERITE_LANTERN.get(), props.fireResistant()));
        NETHERITE_DOOR = registerItem("netherite_door", props -> new DoubleHighBlockItem(MetallicsBlocks.NETHERITE_DOOR.get(), props.fireResistant()));
        NETHERITE_TRAPDOOR = registerItem("netherite_trapdoor", props -> new BlockItem(MetallicsBlocks.NETHERITE_TRAPDOOR.get(), props.fireResistant()));
        NETHERITE_MESH = registerItem("netherite_mesh", props -> new BlockItem(MetallicsBlocks.NETHERITE_MESH.get(), props.fireResistant()));
        NETHERITE_MESH_FENCE = registerItem("netherite_mesh_fence", props -> new BlockItem(MetallicsBlocks.NETHERITE_MESH_FENCE.get(), props.fireResistant()));
        NETHERITE_MESH_DOOR = registerItem("netherite_mesh_door", props -> new DoubleHighBlockItem(MetallicsBlocks.NETHERITE_MESH_DOOR.get(), props.fireResistant()));
        NETHERITE_MESH_TRAPDOOR = registerItem("netherite_mesh_trapdoor", props -> new BlockItem(MetallicsBlocks.NETHERITE_MESH_TRAPDOOR.get(), props.fireResistant()));
        NETHERITE_GRATE = registerItem("netherite_grate", props -> new BlockItem(MetallicsBlocks.NETHERITE_GRATE.get(), props.fireResistant()));
        NETHERITE_PLATED_BLOCK = registerItem("netherite_plated_block", props -> new BlockItem(MetallicsBlocks.NETHERITE_PLATED_BLOCK.get(), props.fireResistant()));
        NETHERITE_SLAB = registerItem("netherite_slab", props -> new BlockItem(MetallicsBlocks.NETHERITE_SLAB.get(), props.fireResistant()));
        BRUSHED_NETHERITE_BLOCK= registerItem("brushed_netherite_block", props -> new BlockItem(MetallicsBlocks.BRUSHED_NETHERITE_BLOCK.get(), props.fireResistant()));
        BRUSHED_NETHERITE_SLAB= registerItem("brushed_netherite_slab", props -> new BlockItem(MetallicsBlocks.BRUSHED_NETHERITE_SLAB.get(), props.fireResistant()));
        CUT_NETHERITE_BLOCK= registerItem("cut_netherite_block", props -> new BlockItem(MetallicsBlocks.CUT_NETHERITE_BLOCK.get(), props.fireResistant()));
        CUT_NETHERITE_STAIRS = registerItem("cut_netherite_stairs", props -> new BlockItem(MetallicsBlocks.CUT_NETHERITE_STAIRS.get(), props.fireResistant()));
        CUT_NETHERITE_SLAB = registerItem("cut_netherite_slab", props -> new BlockItem(MetallicsBlocks.CUT_NETHERITE_SLAB.get(), props.fireResistant()));
        CHISELED_NETHERITE_BLOCK = registerItem("chiseled_netherite_block", props -> new BlockItem(MetallicsBlocks.CHISELED_NETHERITE_BLOCK.get(), props.fireResistant()));

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
