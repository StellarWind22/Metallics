package com.github.stellarwind22.metallics.client.init;

import com.github.stellarwind22.metallics.content.MetallicsBlocks;
import com.github.stellarwind22.metallics.init.Metallics;
import dev.architectury.registry.client.rendering.RenderTypeRegistry;
import net.minecraft.client.renderer.RenderType;

public class MetallicsClient {

    public static void init() {

        Metallics.LOGGER.info("Initializing client code...");

        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.COPPER_LADDER.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.EXPOSED_COPPER_LADDER.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.WEATHERED_COPPER_LADDER.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.OXIDIZED_COPPER_LADDER.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.WAXED_COPPER_LADDER.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.WAXED_EXPOSED_COPPER_LADDER.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.WAXED_WEATHERED_COPPER_LADDER.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.WAXED_OXIDIZED_COPPER_LADDER.get());

        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.COPPER_MESH.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.EXPOSED_COPPER_MESH.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.WEATHERED_COPPER_MESH.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.OXIDIZED_COPPER_MESH.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.WAXED_COPPER_MESH.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.WAXED_EXPOSED_COPPER_MESH.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.WAXED_WEATHERED_COPPER_MESH.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.WAXED_OXIDIZED_COPPER_MESH.get());

        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.COPPER_MESH_FENCE.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.EXPOSED_COPPER_MESH_FENCE.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.WEATHERED_COPPER_MESH_FENCE.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.OXIDIZED_COPPER_MESH_FENCE.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.WAXED_COPPER_MESH_FENCE.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.WAXED_EXPOSED_COPPER_MESH_FENCE.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.WAXED_WEATHERED_COPPER_MESH_FENCE.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.WAXED_OXIDIZED_COPPER_MESH_FENCE.get());

        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.COPPER_MESH_GATE.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.EXPOSED_COPPER_MESH_GATE.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.WEATHERED_COPPER_MESH_GATE.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.OXIDIZED_COPPER_MESH_GATE.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.WAXED_COPPER_MESH_GATE.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.WAXED_EXPOSED_COPPER_MESH_GATE.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.WAXED_WEATHERED_COPPER_MESH_GATE.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.WAXED_OXIDIZED_COPPER_MESH_GATE.get());

        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.COPPER_MESH_DOOR.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.EXPOSED_COPPER_MESH_DOOR.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.WEATHERED_COPPER_MESH_DOOR.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.OXIDIZED_COPPER_MESH_DOOR.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.WAXED_COPPER_MESH_DOOR.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.WAXED_EXPOSED_COPPER_MESH_DOOR.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.WAXED_WEATHERED_COPPER_MESH_DOOR.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.WAXED_OXIDIZED_COPPER_MESH_DOOR.get());

        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.COPPER_MESH_TRAPDOOR.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.EXPOSED_COPPER_MESH_TRAPDOOR.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.WEATHERED_COPPER_MESH_TRAPDOOR.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.OXIDIZED_COPPER_MESH_TRAPDOOR.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.WAXED_COPPER_MESH_TRAPDOOR.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.WAXED_EXPOSED_COPPER_MESH_TRAPDOOR.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.WAXED_WEATHERED_COPPER_MESH_TRAPDOOR.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.WAXED_OXIDIZED_COPPER_MESH_TRAPDOOR.get());

        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.COPPER_GLASS.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.EXPOSED_COPPER_GLASS.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.WEATHERED_COPPER_GLASS.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.OXIDIZED_COPPER_GLASS.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.WAXED_COPPER_GLASS.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.WAXED_EXPOSED_COPPER_GLASS.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.WAXED_WEATHERED_COPPER_GLASS.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.WAXED_OXIDIZED_COPPER_GLASS.get());

        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.COPPER_GLASS_PANE.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.EXPOSED_COPPER_GLASS_PANE.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.WEATHERED_COPPER_GLASS_PANE.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.OXIDIZED_COPPER_GLASS_PANE.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.WAXED_COPPER_GLASS_PANE.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.WAXED_EXPOSED_COPPER_GLASS_PANE.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.WAXED_WEATHERED_COPPER_GLASS_PANE.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.WAXED_OXIDIZED_COPPER_GLASS_PANE.get());

        RenderTypeRegistry.register(RenderType.translucent(), MetallicsBlocks.COPPER_TINTED_GLASS.get());
        RenderTypeRegistry.register(RenderType.translucent(), MetallicsBlocks.EXPOSED_COPPER_TINTED_GLASS.get());
        RenderTypeRegistry.register(RenderType.translucent(), MetallicsBlocks.WEATHERED_COPPER_TINTED_GLASS.get());
        RenderTypeRegistry.register(RenderType.translucent(), MetallicsBlocks.OXIDIZED_COPPER_TINTED_GLASS.get());
        RenderTypeRegistry.register(RenderType.translucent(), MetallicsBlocks.WAXED_COPPER_TINTED_GLASS.get());
        RenderTypeRegistry.register(RenderType.translucent(), MetallicsBlocks.WAXED_EXPOSED_COPPER_TINTED_GLASS.get());
        RenderTypeRegistry.register(RenderType.translucent(), MetallicsBlocks.WAXED_WEATHERED_COPPER_TINTED_GLASS.get());
        RenderTypeRegistry.register(RenderType.translucent(), MetallicsBlocks.WAXED_OXIDIZED_COPPER_TINTED_GLASS.get());

        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.COPPER_CAMPFIRE.get());

        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.IRON_LADDER.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.IRON_MESH.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.IRON_MESH_FENCE.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.IRON_GRATE.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.IRON_MESH_GATE.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.IRON_MESH_DOOR.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.IRON_MESH_TRAPDOOR.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.IRON_GLASS.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.IRON_GLASS_PANE.get());
        RenderTypeRegistry.register(RenderType.translucent(), MetallicsBlocks.IRON_TINTED_GLASS.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.FERROUS_LANTERN.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.FERROUS_CAMPFIRE.get());

        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.BLUE_IRON_LADDER.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.BLUE_IRON_CHAIN.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.BLUE_IRON_BARS.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.BLUE_IRON_LANTERN.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.BLUE_IRON_SOUL_LANTERN.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.BLUE_IRON_DOOR.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.BLUE_IRON_TRAPDOOR.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.BLUE_IRON_MESH.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.BLUE_IRON_MESH_FENCE.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.BLUE_IRON_MESH_DOOR.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.BLUE_IRON_MESH_TRAPDOOR.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.BLUE_IRON_GRATE.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.BLUE_IRON_MESH_GATE.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.BLUE_IRON_GLASS.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.BLUE_IRON_GLASS_PANE.get());
        RenderTypeRegistry.register(RenderType.translucent(), MetallicsBlocks.BLUE_IRON_TINTED_GLASS.get());

        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.PALE_CAMPFIRE.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.PALE_LANTERN.get());

        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.GOLD_LADDER.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.GOLD_CHAIN.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.GOLD_BARS.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.GOLD_DOOR.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.GOLD_MESH.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.GOLD_MESH_FENCE.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.GOLD_MESH_DOOR.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.GOLD_MESH_TRAPDOOR.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.GOLD_GRATE.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.AZURE_LANTERN.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.AZURE_CAMPFIRE.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.GOLD_MESH_GATE.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.GOLD_GLASS.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.GOLD_GLASS_PANE.get());
        RenderTypeRegistry.register(RenderType.translucent(), MetallicsBlocks.GOLD_TINTED_GLASS.get());

        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.NETHERITE_LADDER.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.NETHERITE_CHAIN.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.NETHERITE_BARS.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.INFERNAL_LANTERN.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.INFERNAL_CAMPFIRE.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.NETHERITE_DOOR.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.NETHERITE_MESH.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.NETHERITE_MESH_FENCE.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.NETHERITE_MESH_DOOR.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.NETHERITE_MESH_TRAPDOOR.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.NETHERITE_GRATE.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.NETHERITE_MESH_GATE.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.NETHERITE_GLASS.get());
        RenderTypeRegistry.register(RenderType.cutout(), MetallicsBlocks.NETHERITE_GLASS_PANE.get());
        RenderTypeRegistry.register(RenderType.translucent(), MetallicsBlocks.NETHERITE_TINTED_GLASS.get());

        Metallics.LOGGER.info("Metallics blockRenderTypes/Particles registered!");
    }
}
