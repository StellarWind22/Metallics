package com.github.stellarwind22.metallics.content;

import com.github.stellarwind22.metallics.client.content.MetallicsParticleTypes;
import com.github.stellarwind22.metallics.init.Metallics;
import com.github.stellarwind22.metallics.object.*;
import com.github.stellarwind22.metallics.util.MBlock;
import com.github.stellarwind22.metallics.util.MBlockProps;
import com.github.stellarwind22.metallics.util.StrPair;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

public class MetallicsBlocks {

    private static DeferredRegister<Block> BLOCKS;
    private static final HashMap<Block, Block> BRUSHABLE_MAP = new HashMap<>();

    public static int registeredBlockCount = 0;

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
            .sound(SoundType.LANTERN)
            .lightLevel((blockState) -> 15)
            .noOcclusion()
            .pushReaction(PushReaction.DESTROY);

    private static final MBlockProps barsProps = new MBlockProps()
            .requiresCorrectToolForDrops()
            .sound(SoundType.IRON).noOcclusion();

    private static final MBlockProps meshProps = new MBlockProps()
            .requiresCorrectToolForDrops()
            .strength(5.0F, 6.0F)
            .sound(SoundType.COPPER_GRATE).noOcclusion();

    private static final MBlockProps grateProps = new MBlockProps()
            .sound(SoundType.COPPER_GRATE)
            .noOcclusion().requiresCorrectToolForDrops()
            .isValidSpawn(MBlockProps::never)
            .isRedstoneConductor(MBlockProps::never)
            .isSuffocating(MBlockProps::never)
            .isViewBlocking(MBlockProps::never);

    private static final MBlockProps blockProps = new MBlockProps()
            .sound(SoundType.COPPER)
            .requiresCorrectToolForDrops();

    private static final MBlockProps saltBlockProps = new MBlockProps()
            .sound(SoundType.STONE)
            .instrument(NoteBlockInstrument.BASEDRUM)
            .strength(1.5F, 6.0F)
            .mapColor(DyeColor.WHITE)
            .requiresCorrectToolForDrops();

    private static final MBlockProps stairSlabProps = new MBlockProps()
            .sound(SoundType.COPPER)
            .requiresCorrectToolForDrops()
            .isValidSpawn(MBlockProps::never)
            .isSuffocating(MBlockProps::never);

    private static final MBlockProps campfireProps = new MBlockProps()
            .mapColor(MapColor.PODZOL)
            .instrument(NoteBlockInstrument.BASS)
            .strength(2.0F).sound(SoundType.WOOD)
            .lightLevel((blockState) -> blockState.getValue(BlockStateProperties.LIT)? 15 : 0)
            .noOcclusion()
            .ignitedByLava();

    private static final MBlockProps lampProps = new MBlockProps()
            .forceSolidOn()
            .sound(SoundType.GLASS)
            .lightLevel((blockState) -> blockState.getValue(BlockStateProperties.LIT)? 15 : 0)
            .noOcclusion().requiresCorrectToolForDrops();

    private static final MBlockProps doorProps = new MBlockProps()
            .pushReaction(PushReaction.DESTROY)
            .noOcclusion().requiresCorrectToolForDrops()
            .isSuffocating(MBlockProps::never)
            .isViewBlocking(MBlockProps::never)
            .sound(SoundType.COPPER)
            .isValidSpawn(MBlockProps::never);

    private static final MBlockProps trapdoorProps = new MBlockProps()
            .noOcclusion().requiresCorrectToolForDrops()
            .isSuffocating(MBlockProps::never)
            .isViewBlocking(MBlockProps::never)
            .sound(SoundType.COPPER)
            .isValidSpawn(MBlockProps::never);

    private static final MBlockProps ladderProps = new MBlockProps()
            .requiresCorrectToolForDrops()
            .noOcclusion()
            .forceSolidOff()
            .sound(SoundType.COPPER_GRATE)
            .pushReaction(PushReaction.DESTROY);

    private static final MBlockProps buttonProps = new MBlockProps()
            .noCollision()
            .pushReaction(PushReaction.DESTROY)
            .sound(SoundType.METAL);

    private static final MBlockProps glassProps = new MBlockProps()
            .instrument(NoteBlockInstrument.HAT)
            .sound(SoundType.GLASS)
            .noOcclusion()
            .isValidSpawn(MBlockProps::never)
            .isRedstoneConductor(MBlockProps::never)
            .isSuffocating(MBlockProps::never)
            .isViewBlocking(MBlockProps::never)
            .requiresCorrectToolForDrops();

    public static RegistrySupplier<Block> VITRALITE_BLOCK;

    //Soul
    public static RegistrySupplier<Block> SOUL_JACK_O_LANTERN;

    //Copper
    public static RegistrySupplier<MBrushingBlock> BRUSHING_COPPER_BLOCK;
    public static RegistrySupplier<MBrushingSlab> BRUSHING_COPPER_SLAB;

    public static RegistrySupplier<WeatheringCopperFullBlock> BRUSHED_COPPER_BLOCK;
    public static RegistrySupplier<WeatheringCopperFullBlock> EXPOSED_BRUSHED_COPPER_BLOCK;
    public static RegistrySupplier<WeatheringCopperFullBlock> WEATHERED_BRUSHED_COPPER_BLOCK;
    public static RegistrySupplier<WeatheringCopperFullBlock> WEATHERED_OXIDIZED_COPPER_BLOCK;
    public static RegistrySupplier<Block> WAXED_BRUSHED_COPPER_BLOCK;
    public static RegistrySupplier<Block> WAXED_EXPOSED_BRUSHED_COPPER_BLOCK;
    public static RegistrySupplier<Block> WAXED_WEATHERED_BRUSHED_COPPER_BLOCK;
    public static RegistrySupplier<Block> WAXED_WEATHERED_OXIDIZED_COPPER_BLOCK;

    public static WeatheringCopperBlocks BRUSHED_COPPER_BLOCKS;

    public static RegistrySupplier<WeatheringCopperSlabBlock> BRUSHED_COPPER_SLAB;
    public static RegistrySupplier<WeatheringCopperSlabBlock> EXPOSED_BRUSHED_COPPER_SLAB;
    public static RegistrySupplier<WeatheringCopperSlabBlock> WEATHERED_BRUSHED_COPPER_SLAB;
    public static RegistrySupplier<WeatheringCopperSlabBlock> WEATHERED_OXIDIZED_COPPER_SLAB;
    public static RegistrySupplier<SlabBlock> WAXED_BRUSHED_COPPER_SLAB;
    public static RegistrySupplier<SlabBlock> WAXED_EXPOSED_BRUSHED_COPPER_SLAB;
    public static RegistrySupplier<SlabBlock> WAXED_WEATHERED_BRUSHED_COPPER_SLAB;
    public static RegistrySupplier<SlabBlock> WAXED_WEATHERED_OXIDIZED_COPPER_SLAB;

    public static WeatheringCopperBlocks BRUSHED_COPPER_SLABS;

    public static RegistrySupplier<IronBarsBlock> COPPER_MESH;
    public static RegistrySupplier<IronBarsBlock> EXPOSED_COPPER_MESH;
    public static RegistrySupplier<IronBarsBlock> WEATHERED_COPPER_MESH;
    public static RegistrySupplier<IronBarsBlock> OXIDIZED_COPPER_MESH;
    public static RegistrySupplier<IronBarsBlock> WAXED_COPPER_MESH;
    public static RegistrySupplier<IronBarsBlock> WAXED_EXPOSED_COPPER_MESH;
    public static RegistrySupplier<IronBarsBlock> WAXED_WEATHERED_COPPER_MESH;
    public static RegistrySupplier<IronBarsBlock> WAXED_OXIDIZED_COPPER_MESH;

    public static WeatheringCopperBlocks COPPER_MESHES;

    public static RegistrySupplier<MWeatheringMeshFenceBlock> COPPER_MESH_FENCE;
    public static RegistrySupplier<MWeatheringMeshFenceBlock> EXPOSED_COPPER_MESH_FENCE;
    public static RegistrySupplier<MWeatheringMeshFenceBlock> WEATHERED_COPPER_MESH_FENCE;
    public static RegistrySupplier<MWeatheringMeshFenceBlock> OXIDIZED_COPPER_MESH_FENCE;
    public static RegistrySupplier<MMeshFenceBlock> WAXED_COPPER_MESH_FENCE;
    public static RegistrySupplier<MMeshFenceBlock> WAXED_EXPOSED_COPPER_MESH_FENCE;
    public static RegistrySupplier<MMeshFenceBlock> WAXED_WEATHERED_COPPER_MESH_FENCE;
    public static RegistrySupplier<MMeshFenceBlock> WAXED_OXIDIZED_COPPER_MESH_FENCE;

    public static WeatheringCopperBlocks COPPER_MESH_FENCES;

    public static RegistrySupplier<MWeatheringMeshGate> COPPER_MESH_GATE;
    public static RegistrySupplier<MWeatheringMeshGate> EXPOSED_COPPER_MESH_GATE;
    public static RegistrySupplier<MWeatheringMeshGate> WEATHERED_COPPER_MESH_GATE;
    public static RegistrySupplier<MWeatheringMeshGate> OXIDIZED_COPPER_MESH_GATE;
    public static RegistrySupplier<MMeshGate> WAXED_COPPER_MESH_GATE;
    public static RegistrySupplier<MMeshGate> WAXED_EXPOSED_COPPER_MESH_GATE;
    public static RegistrySupplier<MMeshGate> WAXED_WEATHERED_COPPER_MESH_GATE;
    public static RegistrySupplier<MMeshGate> WAXED_OXIDIZED_COPPER_MESH_GATE;

    public static WeatheringCopperBlocks COPPER_MESH_GATES;

    public static RegistrySupplier<LadderBlock> COPPER_LADDER;
    public static RegistrySupplier<LadderBlock> EXPOSED_COPPER_LADDER;
    public static RegistrySupplier<LadderBlock> WEATHERED_COPPER_LADDER;
    public static RegistrySupplier<LadderBlock> OXIDIZED_COPPER_LADDER;
    public static RegistrySupplier<LadderBlock> WAXED_COPPER_LADDER;
    public static RegistrySupplier<LadderBlock> WAXED_EXPOSED_COPPER_LADDER;
    public static RegistrySupplier<LadderBlock> WAXED_WEATHERED_COPPER_LADDER;
    public static RegistrySupplier<LadderBlock> WAXED_OXIDIZED_COPPER_LADDER;

    public static WeatheringCopperBlocks COPPER_LADDERS;

    public static RegistrySupplier<WeatheringCopperDoorBlock> COPPER_MESH_DOOR;
    public static RegistrySupplier<WeatheringCopperDoorBlock> EXPOSED_COPPER_MESH_DOOR;
    public static RegistrySupplier<WeatheringCopperDoorBlock> WEATHERED_COPPER_MESH_DOOR;
    public static RegistrySupplier<WeatheringCopperDoorBlock> OXIDIZED_COPPER_MESH_DOOR;
    public static RegistrySupplier<DoorBlock> WAXED_COPPER_MESH_DOOR;
    public static RegistrySupplier<DoorBlock> WAXED_EXPOSED_COPPER_MESH_DOOR;
    public static RegistrySupplier<DoorBlock> WAXED_WEATHERED_COPPER_MESH_DOOR;
    public static RegistrySupplier<DoorBlock> WAXED_OXIDIZED_COPPER_MESH_DOOR;

    public static WeatheringCopperBlocks COPPER_MESH_DOORS;

    public static RegistrySupplier<WeatheringCopperTrapDoorBlock> COPPER_MESH_TRAPDOOR;
    public static RegistrySupplier<WeatheringCopperTrapDoorBlock> EXPOSED_COPPER_MESH_TRAPDOOR;
    public static RegistrySupplier<WeatheringCopperTrapDoorBlock> WEATHERED_COPPER_MESH_TRAPDOOR;
    public static RegistrySupplier<WeatheringCopperTrapDoorBlock> OXIDIZED_COPPER_MESH_TRAPDOOR;
    public static RegistrySupplier<TrapDoorBlock> WAXED_COPPER_MESH_TRAPDOOR;
    public static RegistrySupplier<TrapDoorBlock> WAXED_EXPOSED_COPPER_MESH_TRAPDOOR;
    public static RegistrySupplier<TrapDoorBlock> WAXED_WEATHERED_COPPER_MESH_TRAPDOOR;
    public static RegistrySupplier<TrapDoorBlock> WAXED_OXIDIZED_COPPER_MESH_TRAPDOOR;

    public static WeatheringCopperBlocks COPPER_MESH_TRAPDOORS;

    public static RegistrySupplier<Block> COPPER_SLAB;
    public static RegistrySupplier<Block> EXPOSED_COPPER_SLAB;
    public static RegistrySupplier<Block> WEATHERED_COPPER_SLAB;
    public static RegistrySupplier<Block> OXIDIZED_COPPER_SLAB;
    public static RegistrySupplier<Block> WAXED_COPPER_SLAB;
    public static RegistrySupplier<Block> WAXED_EXPOSED_COPPER_SLAB;
    public static RegistrySupplier<Block> WAXED_WEATHERED_COPPER_SLAB;
    public static RegistrySupplier<Block> WAXED_OXIDIZED_COPPER_SLAB;

    public static WeatheringCopperBlocks COPPER_SLABS;

    public static RegistrySupplier<MCampfireBlock> COPPER_CAMPFIRE;
    public static RegistrySupplier<Block> COPPER_JACK_O_LANTERN;

    public static RegistrySupplier<Block> COPPER_LAMP;
    public static RegistrySupplier<Block> EXPOSED_COPPER_LAMP;
    public static RegistrySupplier<Block> WEATHERED_COPPER_LAMP;
    public static RegistrySupplier<Block> OXIDIZED_COPPER_LAMP;
    public static RegistrySupplier<Block> WAXED_COPPER_LAMP;
    public static RegistrySupplier<Block> WAXED_EXPOSED_COPPER_LAMP;
    public static RegistrySupplier<Block> WAXED_WEATHERED_COPPER_LAMP;
    public static RegistrySupplier<Block> WAXED_OXIDIZED_COPPER_LAMP;

    public static WeatheringCopperBlocks COPPER_LAMPS;

    public static RegistrySupplier<Block> COPPER_BUTTON;
    public static RegistrySupplier<Block> EXPOSED_COPPER_BUTTON;
    public static RegistrySupplier<Block> WEATHERED_COPPER_BUTTON;
    public static RegistrySupplier<Block> OXIDIZED_COPPER_BUTTON;
    public static RegistrySupplier<Block> WAXED_COPPER_BUTTON;
    public static RegistrySupplier<Block> WAXED_EXPOSED_COPPER_BUTTON;
    public static RegistrySupplier<Block> WAXED_WEATHERED_COPPER_BUTTON;
    public static RegistrySupplier<Block> WAXED_OXIDIZED_COPPER_BUTTON;

    public static WeatheringCopperBlocks COPPER_BUTTONS;

    public static RegistrySupplier<Block> COPPER_PRESSURE_PLATE;
    public static RegistrySupplier<Block> EXPOSED_COPPER_PRESSURE_PLATE;
    public static RegistrySupplier<Block> WEATHERED_COPPER_PRESSURE_PLATE;
    public static RegistrySupplier<Block> OXIDIZED_COPPER_PRESSURE_PLATE;
    public static RegistrySupplier<Block> WAXED_COPPER_PRESSURE_PLATE;
    public static RegistrySupplier<Block> WAXED_EXPOSED_COPPER_PRESSURE_PLATE;
    public static RegistrySupplier<Block> WAXED_WEATHERED_COPPER_PRESSURE_PLATE;
    public static RegistrySupplier<Block> WAXED_OXIDIZED_COPPER_PRESSURE_PLATE;

    public static WeatheringCopperBlocks COPPER_PRESSURE_PLATES;

    public static RegistrySupplier<Block> COPPER_GLASS;
    public static RegistrySupplier<Block> EXPOSED_COPPER_GLASS;
    public static RegistrySupplier<Block> WEATHERED_COPPER_GLASS;
    public static RegistrySupplier<Block> OXIDIZED_COPPER_GLASS;
    public static RegistrySupplier<Block> WAXED_COPPER_GLASS;
    public static RegistrySupplier<Block> WAXED_EXPOSED_COPPER_GLASS;
    public static RegistrySupplier<Block> WAXED_WEATHERED_COPPER_GLASS;
    public static RegistrySupplier<Block> WAXED_OXIDIZED_COPPER_GLASS;

    public static WeatheringCopperBlocks COPPER_GLASS_BLOCKS;

    public static RegistrySupplier<Block> COPPER_GLASS_PANE;
    public static RegistrySupplier<Block> EXPOSED_COPPER_GLASS_PANE;
    public static RegistrySupplier<Block> WEATHERED_COPPER_GLASS_PANE;
    public static RegistrySupplier<Block> OXIDIZED_COPPER_GLASS_PANE;
    public static RegistrySupplier<Block> WAXED_COPPER_GLASS_PANE;
    public static RegistrySupplier<Block> WAXED_EXPOSED_COPPER_GLASS_PANE;
    public static RegistrySupplier<Block> WAXED_WEATHERED_COPPER_GLASS_PANE;
    public static RegistrySupplier<Block> WAXED_OXIDIZED_COPPER_GLASS_PANE;

    public static WeatheringCopperBlocks COPPER_GLASS_PANES;

    public static RegistrySupplier<Block> COPPER_TINTED_GLASS;
    public static RegistrySupplier<Block> EXPOSED_COPPER_TINTED_GLASS;
    public static RegistrySupplier<Block> WEATHERED_COPPER_TINTED_GLASS;
    public static RegistrySupplier<Block> OXIDIZED_COPPER_TINTED_GLASS;
    public static RegistrySupplier<Block> WAXED_COPPER_TINTED_GLASS;
    public static RegistrySupplier<Block> WAXED_EXPOSED_COPPER_TINTED_GLASS;
    public static RegistrySupplier<Block> WAXED_WEATHERED_COPPER_TINTED_GLASS;
    public static RegistrySupplier<Block> WAXED_OXIDIZED_COPPER_TINTED_GLASS;

    public static WeatheringCopperBlocks COPPER_TINTED_GLASS_BLOCKS;

    //Iron
    public static RegistrySupplier<LadderBlock> IRON_LADDER;
    public static RegistrySupplier<IronBarsBlock> IRON_MESH;
    public static RegistrySupplier<Block> IRON_MESH_FENCE;
    public static RegistrySupplier<MMeshGate> IRON_MESH_GATE;
    public static RegistrySupplier<DoorBlock> IRON_MESH_DOOR;
    public static RegistrySupplier<TrapDoorBlock> IRON_MESH_TRAPDOOR;
    public static RegistrySupplier<Block> IRON_GRATE;
    public static RegistrySupplier<Block> IRON_PLATED_BLOCK;
    public static RegistrySupplier<MBrushingBlock> BRUSHING_IRON_BLOCK;
    public static RegistrySupplier<MBrushingSlab> BRUSHING_IRON_SLAB;
    public static RegistrySupplier<Block> BRUSHED_IRON_BLOCK;
    public static RegistrySupplier<SlabBlock> BRUSHED_IRON_SLAB;
    public static RegistrySupplier<Block> IRON_SLAB;
    public static RegistrySupplier<Block> CUT_IRON_BLOCK;
    public static RegistrySupplier<Block> CUT_IRON_STAIRS;
    public static RegistrySupplier<Block> CUT_IRON_SLAB;
    public static RegistrySupplier<Block> CHISELED_IRON_BLOCK;
    public static RegistrySupplier<Block> IRON_LAMP;
    public static RegistrySupplier<Block> IRON_GLASS;
    public static RegistrySupplier<Block> IRON_GLASS_PANE;
    public static RegistrySupplier<Block> IRON_TINTED_GLASS;

    public static RegistrySupplier<Block> IRON_BUTTON;
    public static RegistrySupplier<Block> IRON_PRESSURE_PLATE;

    public static RegistrySupplier<Block> FERROUS_TORCH;
    public static RegistrySupplier<Block> FERROUS_WALL_TORCH;
    public static RegistrySupplier<MCampfireBlock> FERROUS_CAMPFIRE;
    public static RegistrySupplier<Block> FERROUS_JACK_O_LANTERN;
    public static RegistrySupplier<Block> FERROUS_LANTERN;

    //Blue Iron
    public static RegistrySupplier<Block> BLUE_IRON_CHAIN;
    public static RegistrySupplier<Block> BLUE_IRON_LANTERN;
    public static RegistrySupplier<Block> BLUE_IRON_SOUL_LANTERN;
    public static RegistrySupplier<IronBarsBlock> BLUE_IRON_BARS;
    public static RegistrySupplier<Block> BLUE_IRON_BLOCK;
    public static RegistrySupplier<DoorBlock> BLUE_IRON_DOOR;
    public static RegistrySupplier<TrapDoorBlock> BLUE_IRON_TRAPDOOR;
    public static RegistrySupplier<IronBarsBlock> BLUE_IRON_MESH;
    public static RegistrySupplier<LadderBlock> BLUE_IRON_LADDER;
    public static RegistrySupplier<Block> BLUE_IRON_MESH_FENCE;
    public static RegistrySupplier<MMeshGate> BLUE_IRON_MESH_GATE;
    public static RegistrySupplier<DoorBlock> BLUE_IRON_MESH_DOOR;
    public static RegistrySupplier<TrapDoorBlock> BLUE_IRON_MESH_TRAPDOOR;
    public static RegistrySupplier<Block> BLUE_IRON_GRATE;
    public static RegistrySupplier<Block> BLUE_IRON_PLATED_BLOCK;
    public static RegistrySupplier<MBrushingBlock> BRUSHING_BLUE_IRON_BLOCK;
    public static RegistrySupplier<MBrushingSlab> BRUSHING_BLUE_IRON_SLAB;
    public static RegistrySupplier<Block> BRUSHED_BLUE_IRON_BLOCK;
    public static RegistrySupplier<SlabBlock> BRUSHED_BLUE_IRON_SLAB;
    public static RegistrySupplier<Block> BLUE_IRON_SLAB;
    public static RegistrySupplier<Block> CUT_BLUE_IRON_BLOCK;
    public static RegistrySupplier<Block> CUT_BLUE_IRON_STAIRS;
    public static RegistrySupplier<Block> CUT_BLUE_IRON_SLAB;
    public static RegistrySupplier<Block> CHISELED_BLUE_IRON_BLOCK;
    public static RegistrySupplier<Block> BLUE_IRON_LAMP;
    public static RegistrySupplier<Block> BLUE_IRON_GLASS;
    public static RegistrySupplier<Block> BLUE_IRON_GLASS_PANE;
    public static RegistrySupplier<Block> BLUE_IRON_TINTED_GLASS;

    public static RegistrySupplier<Block> BLUE_IRON_BUTTON;
    public static RegistrySupplier<Block> BLUE_IRON_PRESSURE_PLATE;

    public static RegistrySupplier<Block> PALE_TORCH;
    public static RegistrySupplier<Block> PALE_WALL_TORCH;
    public static RegistrySupplier<MCampfireBlock> PALE_CAMPFIRE;
    public static RegistrySupplier<Block> PALE_JACK_O_LANTERN;
    public static RegistrySupplier<Block> PALE_LANTERN;

    //Gold
    public static Supplier<BlockSetType> GOLD_SET;

    public static RegistrySupplier<Block> GOLD_CHAIN;
    public static RegistrySupplier<IronBarsBlock> GOLD_BARS;
    public static RegistrySupplier<DoorBlock> GOLD_DOOR;
    public static RegistrySupplier<TrapDoorBlock> GOLD_TRAPDOOR;
    public static RegistrySupplier<LadderBlock> GOLD_LADDER;
    public static RegistrySupplier<IronBarsBlock> GOLD_MESH;
    public static RegistrySupplier<MMeshFenceBlock> GOLD_MESH_FENCE;
    public static RegistrySupplier<MMeshGate> GOLD_MESH_GATE;
    public static RegistrySupplier<TrapDoorBlock> GOLD_MESH_TRAPDOOR;
    public static RegistrySupplier<DoorBlock> GOLD_MESH_DOOR;
    public static RegistrySupplier<MGrateBlock> GOLD_GRATE;

    public static RegistrySupplier<Block> GOLD_PLATED_BLOCK;
    public static RegistrySupplier<Block> GOLD_SLAB;
    public static RegistrySupplier<MBrushingBlock> BRUSHING_GOLD_BLOCK;
    public static RegistrySupplier<MBrushingSlab> BRUSHING_GOLD_SLAB;
    public static RegistrySupplier<Block> BRUSHED_GOLD_BLOCK;
    public static RegistrySupplier<SlabBlock> BRUSHED_GOLD_SLAB;
    public static RegistrySupplier<Block> CUT_GOLD_BLOCK;
    public static RegistrySupplier<Block> CUT_GOLD_STAIRS;
    public static RegistrySupplier<Block> CUT_GOLD_SLAB;
    public static RegistrySupplier<Block> CHISELED_GOLD_BLOCK;
    public static RegistrySupplier<Block> GOLD_LAMP;
    public static RegistrySupplier<Block> GOLD_GLASS;
    public static RegistrySupplier<Block> GOLD_GLASS_PANE;
    public static RegistrySupplier<Block> GOLD_TINTED_GLASS;
    public static RegistrySupplier<Block> GOLD_BUTTON;
    public static RegistrySupplier<Block> GOLD_PRESSURE_PLATE;

    public static RegistrySupplier<Block> AZURE_TORCH;
    public static RegistrySupplier<Block> AZURE_WALL_TORCH;
    public static RegistrySupplier<MCampfireBlock> AZURE_CAMPFIRE;
    public static RegistrySupplier<Block> AZURE_JACK_O_LANTERN;
    public static RegistrySupplier<Block> AZURE_LANTERN;

    //Netherite
    public static Supplier<BlockSetType> NETHERITE_SET;

    public static RegistrySupplier<Block> NETHERITE_CHAIN;
    public static RegistrySupplier<Block> INFERNAL_LANTERN;
    public static RegistrySupplier<IronBarsBlock> NETHERITE_BARS;
    public static RegistrySupplier<DoorBlock> NETHERITE_DOOR;
    public static RegistrySupplier<TrapDoorBlock> NETHERITE_TRAPDOOR;
    public static RegistrySupplier<LadderBlock> NETHERITE_LADDER;
    public static RegistrySupplier<IronBarsBlock> NETHERITE_MESH;
    public static RegistrySupplier<MMeshFenceBlock> NETHERITE_MESH_FENCE;
    public static RegistrySupplier<MMeshGate> NETHERITE_MESH_GATE;
    public static RegistrySupplier<TrapDoorBlock> NETHERITE_MESH_TRAPDOOR;
    public static RegistrySupplier<DoorBlock> NETHERITE_MESH_DOOR;
    public static RegistrySupplier<MGrateBlock> NETHERITE_GRATE;
    public static RegistrySupplier<Block> NETHERITE_PLATED_BLOCK;
    public static RegistrySupplier<Block> NETHERITE_SLAB;
    public static RegistrySupplier<MBrushingBlock> BRUSHING_NETHERITE_BLOCK;
    public static RegistrySupplier<MBrushingSlab> BRUSHING_NETHERITE_SLAB;
    public static RegistrySupplier<Block> BRUSHED_NETHERITE_BLOCK;
    public static RegistrySupplier<SlabBlock> BRUSHED_NETHERITE_SLAB;
    public static RegistrySupplier<Block> CUT_NETHERITE_BLOCK;
    public static RegistrySupplier<Block> CUT_NETHERITE_STAIRS;
    public static RegistrySupplier<Block> CUT_NETHERITE_SLAB;
    public static RegistrySupplier<Block> CHISELED_NETHERITE_BLOCK;
    public static RegistrySupplier<Block> NETHERITE_LAMP;
    public static RegistrySupplier<Block> NETHERITE_GLASS;
    public static RegistrySupplier<Block> NETHERITE_GLASS_PANE;
    public static RegistrySupplier<Block> NETHERITE_TINTED_GLASS;

    public static RegistrySupplier<Block> NETHERITE_BUTTON;
    public static RegistrySupplier<Block> NETHERITE_PRESSURE_PLATE;

    public static RegistrySupplier<Block> INFERNAL_TORCH;
    public static RegistrySupplier<Block> INFERNAL_WALL_TORCH;
    public static RegistrySupplier<MCampfireBlock> INFERNAL_CAMPFIRE;
    public static RegistrySupplier<Block> INFERNAL_JACK_O_LANTERN;

    static final StrPair CPR_STR = new StrPair(3.0F, 6.0F);
    static final StrPair IRN_STR = new StrPair(5.0F, 6.0F);
    static final StrPair GLD_STR = new StrPair(3.0F, 6.0F);
    static final StrPair NTR_STR = new StrPair(50.0F, 1200.0F);

    static final StrPair GRT_MULT = StrPair.of(1.0F);
    static final StrPair LNT_MULT = new StrPair(0.7F, 0.58F);
    static final StrPair MSH_MULT = StrPair.of(0.5F);

    static final StrPair CPR_GRT = CPR_STR.mult(GRT_MULT);
    static final StrPair IRN_GRT = IRN_STR.mult(GRT_MULT);
    static final StrPair GLD_GRT = GLD_STR.mult(GRT_MULT);
    static final StrPair NTR_GRT = NTR_STR.mult(GRT_MULT);
    
    static final StrPair CPR_LNT = CPR_STR.mult(LNT_MULT);
    static final StrPair IRN_LNT = IRN_STR.mult(LNT_MULT);
    static final StrPair GLD_LNT = GLD_STR.mult(LNT_MULT);
    static final StrPair NTR_LNT = NTR_STR.mult(LNT_MULT);

    static final StrPair CPR_MSH = CPR_STR.mult(MSH_MULT);
    static final StrPair IRN_MSH = IRN_STR.mult(MSH_MULT);
    static final StrPair GLD_MSH = GLD_STR.mult(MSH_MULT);
    static final StrPair NTR_MSH = NTR_STR.mult(MSH_MULT);

    public static void InitSetTypes() {
        //Gold
        GOLD_SET = () -> new BlockSetType(
                        "gold",
                        true,
                        true,
                        false,
                        BlockSetType.PressurePlateSensitivity.MOBS,
                        SoundType.COPPER,
                        SoundEvents.COPPER_DOOR_CLOSE,
                        SoundEvents.COPPER_DOOR_OPEN,
                        SoundEvents.COPPER_TRAPDOOR_CLOSE,
                        SoundEvents.COPPER_TRAPDOOR_OPEN,
                        SoundEvents.METAL_PRESSURE_PLATE_CLICK_OFF,
                        SoundEvents.METAL_PRESSURE_PLATE_CLICK_ON,
                        SoundEvents.STONE_BUTTON_CLICK_OFF,
                        SoundEvents.STONE_BUTTON_CLICK_ON);

        //Netherite
        NETHERITE_SET = () -> new BlockSetType(
                        "netherite",
                        false,
                        false,
                        false,
                        BlockSetType.PressurePlateSensitivity.MOBS,
                        SoundType.IRON,
                        SoundEvents.IRON_DOOR_CLOSE,
                        SoundEvents.IRON_DOOR_OPEN,
                        SoundEvents.IRON_TRAPDOOR_CLOSE,
                        SoundEvents.IRON_TRAPDOOR_OPEN,
                        SoundEvents.METAL_PRESSURE_PLATE_CLICK_OFF,
                        SoundEvents.METAL_PRESSURE_PLATE_CLICK_ON,
                        SoundEvents.STONE_BUTTON_CLICK_OFF,
                        SoundEvents.STONE_BUTTON_CLICK_ON);
    }

    public static void init() {
        BLOCKS = DeferredRegister.create(Metallics.MOD_ID, Registries.BLOCK);

        //Register stuff here ▼▼▼
        VITRALITE_BLOCK = registerBlock("vitralite_block", new MBlock<>(Block::new, Optional.of(saltBlockProps.getCopy())));

        //Soul
        SOUL_JACK_O_LANTERN = registerBlock("soul_jack_o_lantern", new MBlock<>(
                props -> new CarvedPumpkinBlock(props.lightLevel((state) -> 10)),
                Optional.of(jackOLanternProps.getCopy())
        ));

        //Copper
        BRUSHING_COPPER_BLOCK = registerBlock("brushing_copper_block", new MBlock<>(props -> new MBrushingBlock(4, 3, ResourceLocation.fromNamespaceAndPath(Metallics.MOD_ID, "brushed_copper_block"), SoundEvents.BRUSH_GENERIC, SoundEvents.COPPER_PLACE, props), Optional.of(blockProps.strength(CPR_GRT).getCopy())));
        BRUSHING_COPPER_SLAB = registerBlock("brushing_copper_slab", new MBlock<>(props -> new MBrushingSlab(4, 3, ResourceLocation.fromNamespaceAndPath(Metallics.MOD_ID, "brushed_copper_slab"), SoundEvents.BRUSH_GENERIC, SoundEvents.COPPER_PLACE, props), Optional.of(stairSlabProps.strength(CPR_GRT).getCopy())));

        COPPER_LADDER = registerBlock("copper_ladder", new MBlock<>(props -> new MWeatheringLadderBlock(props, WeatheringCopper.WeatherState.UNAFFECTED), Optional.of(ladderProps.strength(CPR_GRT).getCopy())));
        EXPOSED_COPPER_LADDER = registerBlock("exposed_copper_ladder", new MBlock<>(props -> new MWeatheringLadderBlock(props, WeatheringCopper.WeatherState.EXPOSED), Optional.of(ladderProps.strength(CPR_GRT).getCopy())));
        WEATHERED_COPPER_LADDER = registerBlock("weathered_copper_ladder", new MBlock<>(props -> new MWeatheringLadderBlock(props, WeatheringCopper.WeatherState.WEATHERED), Optional.of(ladderProps.strength(CPR_GRT).getCopy())));
        OXIDIZED_COPPER_LADDER = registerBlock("oxidized_copper_ladder", new MBlock<>(props -> new MWeatheringLadderBlock(props, WeatheringCopper.WeatherState.OXIDIZED), Optional.of(ladderProps.strength(CPR_GRT).getCopy())));
        WAXED_COPPER_LADDER = registerBlock("waxed_copper_ladder", new MBlock<>(LadderBlock::new, Optional.of(ladderProps.strength(CPR_GRT).getCopy())));
        WAXED_EXPOSED_COPPER_LADDER = registerBlock("waxed_exposed_copper_ladder", new MBlock<>(LadderBlock::new, Optional.of(ladderProps.strength(CPR_GRT).getCopy())));
        WAXED_WEATHERED_COPPER_LADDER = registerBlock("waxed_weathered_copper_ladder", new MBlock<>(LadderBlock::new, Optional.of(ladderProps.strength(CPR_GRT).getCopy())));
        WAXED_OXIDIZED_COPPER_LADDER = registerBlock("waxed_oxidized_copper_ladder", new MBlock<>(LadderBlock::new, Optional.of(ladderProps.strength(CPR_GRT).getCopy())));

        BRUSHED_COPPER_BLOCK = registerBlock("brushed_copper_block", new MBlock<>(props -> new WeatheringCopperFullBlock(WeatheringCopper.WeatherState.UNAFFECTED, props), Optional.of(blockProps.strength(CPR_GRT).getCopy())));
        EXPOSED_BRUSHED_COPPER_BLOCK = registerBlock("exposed_brushed_copper_block", new MBlock<>(props -> new WeatheringCopperFullBlock(WeatheringCopper.WeatherState.EXPOSED, props), Optional.of(blockProps.strength(CPR_GRT).getCopy())));
        WEATHERED_BRUSHED_COPPER_BLOCK = registerBlock("weathered_brushed_copper_block", new MBlock<>(props -> new WeatheringCopperFullBlock(WeatheringCopper.WeatherState.WEATHERED, props), Optional.of(blockProps.strength(CPR_GRT).getCopy())));
        WEATHERED_OXIDIZED_COPPER_BLOCK = registerBlock("oxidized_brushed_copper_block", new MBlock<>(props -> new WeatheringCopperFullBlock(WeatheringCopper.WeatherState.OXIDIZED, props), Optional.of(blockProps.strength(CPR_GRT).getCopy())));
        WAXED_BRUSHED_COPPER_BLOCK = registerBlock("waxed_brushed_copper_block", new MBlock<>(Block::new, Optional.of(blockProps.strength(CPR_GRT).getCopy())));
        WAXED_EXPOSED_BRUSHED_COPPER_BLOCK = registerBlock("waxed_exposed_brushed_copper_block", new MBlock<>(Block::new, Optional.of(blockProps.strength(CPR_GRT).getCopy())));
        WAXED_WEATHERED_BRUSHED_COPPER_BLOCK = registerBlock("waxed_weathered_brushed_copper_block", new MBlock<>(Block::new, Optional.of(blockProps.strength(CPR_GRT).getCopy())));
        WAXED_WEATHERED_OXIDIZED_COPPER_BLOCK = registerBlock("waxed_oxidized_brushed_copper_block", new MBlock<>(Block::new, Optional.of(blockProps.strength(CPR_GRT).getCopy())));

        BRUSHED_COPPER_SLAB = registerBlock("brushed_copper_slab", new MBlock<>(props -> new WeatheringCopperSlabBlock(WeatheringCopper.WeatherState.UNAFFECTED, props), Optional.of(stairSlabProps.strength(CPR_GRT).getCopy())));
        EXPOSED_BRUSHED_COPPER_SLAB = registerBlock("exposed_brushed_copper_slab", new MBlock<>(props -> new WeatheringCopperSlabBlock(WeatheringCopper.WeatherState.EXPOSED, props), Optional.of(stairSlabProps.strength(CPR_GRT).getCopy())));
        WEATHERED_BRUSHED_COPPER_SLAB = registerBlock("weathered_brushed_copper_slab", new MBlock<>(props -> new WeatheringCopperSlabBlock(WeatheringCopper.WeatherState.WEATHERED, props), Optional.of(stairSlabProps.strength(CPR_GRT).getCopy())));
        WEATHERED_OXIDIZED_COPPER_SLAB = registerBlock("oxidized_brushed_copper_slab", new MBlock<>(props -> new WeatheringCopperSlabBlock(WeatheringCopper.WeatherState.OXIDIZED, props), Optional.of(stairSlabProps.strength(CPR_GRT).getCopy())));
        WAXED_BRUSHED_COPPER_SLAB = registerBlock("waxed_brushed_copper_slab", new MBlock<>(SlabBlock::new, Optional.of(stairSlabProps.strength(CPR_GRT).getCopy())));
        WAXED_EXPOSED_BRUSHED_COPPER_SLAB = registerBlock("waxed_exposed_brushed_copper_slab", new MBlock<>(SlabBlock::new, Optional.of(stairSlabProps.strength(CPR_GRT).getCopy())));
        WAXED_WEATHERED_BRUSHED_COPPER_SLAB = registerBlock("waxed_weathered_brushed_copper_slab", new MBlock<>(SlabBlock::new, Optional.of(stairSlabProps.strength(CPR_GRT).getCopy())));
        WAXED_WEATHERED_OXIDIZED_COPPER_SLAB = registerBlock("waxed_oxidized_brushed_copper_slab", new MBlock<>(SlabBlock::new, Optional.of(stairSlabProps.strength(CPR_GRT).getCopy())));

        COPPER_MESH = registerBlock("copper_mesh", new MBlock<>(props -> new WeatheringCopperBarsBlock(WeatheringCopper.WeatherState.UNAFFECTED, props), Optional.of(meshProps.strength(CPR_MSH).getCopy())));
        EXPOSED_COPPER_MESH = registerBlock("exposed_copper_mesh", new MBlock<>(props -> new WeatheringCopperBarsBlock(WeatheringCopper.WeatherState.EXPOSED, props), Optional.of(meshProps.strength(CPR_MSH).getCopy())));
        WEATHERED_COPPER_MESH = registerBlock("weathered_copper_mesh", new MBlock<>(props -> new WeatheringCopperBarsBlock(WeatheringCopper.WeatherState.WEATHERED, props), Optional.of(meshProps.strength(CPR_MSH).getCopy())));
        OXIDIZED_COPPER_MESH = registerBlock("oxidized_copper_mesh", new MBlock<>(props -> new WeatheringCopperBarsBlock(WeatheringCopper.WeatherState.OXIDIZED, props), Optional.of(meshProps.strength(CPR_MSH).getCopy())));
        WAXED_COPPER_MESH = registerBlock("waxed_copper_mesh", new MBlock<>(IronBarsBlock::new, Optional.of(meshProps.strength(CPR_MSH).getCopy())));
        WAXED_EXPOSED_COPPER_MESH = registerBlock("waxed_exposed_copper_mesh", new MBlock<>(IronBarsBlock::new, Optional.of(meshProps.strength(CPR_MSH).getCopy())));
        WAXED_WEATHERED_COPPER_MESH = registerBlock("waxed_weathered_copper_mesh", new MBlock<>(IronBarsBlock::new, Optional.of(meshProps.strength(CPR_MSH).getCopy())));
        WAXED_OXIDIZED_COPPER_MESH = registerBlock("waxed_oxidized_copper_mesh", new MBlock<>(IronBarsBlock::new, Optional.of(meshProps.strength(CPR_MSH).getCopy())));

        COPPER_MESH_FENCE = registerBlock("copper_mesh_fence", new MBlock<>(props -> new MWeatheringMeshFenceBlock(props, WeatheringCopper.WeatherState.UNAFFECTED), Optional.of(meshProps.strength(CPR_MSH).getCopy())));
        EXPOSED_COPPER_MESH_FENCE = registerBlock("exposed_copper_mesh_fence", new MBlock<>(props -> new MWeatheringMeshFenceBlock(props, WeatheringCopper.WeatherState.EXPOSED), Optional.of(meshProps.strength(CPR_MSH).getCopy())));
        WEATHERED_COPPER_MESH_FENCE = registerBlock("weathered_copper_mesh_fence", new MBlock<>(props -> new MWeatheringMeshFenceBlock(props, WeatheringCopper.WeatherState.WEATHERED), Optional.of(meshProps.strength(CPR_MSH).getCopy())));
        OXIDIZED_COPPER_MESH_FENCE = registerBlock("oxidized_copper_mesh_fence", new MBlock<>(props -> new MWeatheringMeshFenceBlock(props, WeatheringCopper.WeatherState.OXIDIZED), Optional.of(meshProps.strength(CPR_MSH).getCopy())));

        WAXED_COPPER_MESH_FENCE = registerBlock("waxed_copper_mesh_fence", new MBlock<>(MMeshFenceBlock::new, Optional.of(meshProps.strength(CPR_MSH).getCopy())));
        WAXED_EXPOSED_COPPER_MESH_FENCE = registerBlock("waxed_exposed_copper_mesh_fence", new MBlock<>(MMeshFenceBlock::new, Optional.of(meshProps.strength(CPR_MSH).getCopy())));
        WAXED_WEATHERED_COPPER_MESH_FENCE = registerBlock("waxed_weathered_copper_mesh_fence", new MBlock<>(MMeshFenceBlock::new, Optional.of(meshProps.strength(CPR_MSH).getCopy())));
        WAXED_OXIDIZED_COPPER_MESH_FENCE = registerBlock("waxed_oxidized_copper_mesh_fence", new MBlock<>(MMeshFenceBlock::new, Optional.of(meshProps.strength(CPR_MSH).getCopy())));

        COPPER_MESH_GATE = registerBlock("copper_mesh_gate", new MBlock<>(props -> new MWeatheringMeshGate(WeatheringCopper.WeatherState.UNAFFECTED, BlockSetType.COPPER, props), Optional.of(meshProps.strength(CPR_GRT).getCopy())));
        EXPOSED_COPPER_MESH_GATE = registerBlock("exposed_copper_mesh_gate", new MBlock<>(props -> new MWeatheringMeshGate(WeatheringCopper.WeatherState.EXPOSED, BlockSetType.COPPER, props), Optional.of(meshProps.strength(CPR_GRT).getCopy())));
        WEATHERED_COPPER_MESH_GATE = registerBlock("weathered_copper_mesh_gate", new MBlock<>(props -> new MWeatheringMeshGate(WeatheringCopper.WeatherState.WEATHERED, BlockSetType.COPPER, props), Optional.of(meshProps.strength(CPR_GRT).getCopy())));
        OXIDIZED_COPPER_MESH_GATE = registerBlock("oxidized_copper_mesh_gate", new MBlock<>(props -> new MWeatheringMeshGate(WeatheringCopper.WeatherState.OXIDIZED, BlockSetType.COPPER, props), Optional.of(meshProps.strength(CPR_GRT).getCopy())));
        WAXED_COPPER_MESH_GATE = registerBlock("waxed_copper_mesh_gate", new MBlock<>(props -> new MMeshGate(BlockSetType.COPPER, props), Optional.of(meshProps.strength(CPR_GRT).getCopy())));
        WAXED_EXPOSED_COPPER_MESH_GATE = registerBlock("waxed_exposed_copper_mesh_gate", new MBlock<>(props -> new MMeshGate(BlockSetType.COPPER, props), Optional.of(meshProps.strength(CPR_GRT).getCopy())));
        WAXED_WEATHERED_COPPER_MESH_GATE = registerBlock("waxed_weathered_copper_mesh_gate", new MBlock<>(props -> new MMeshGate(BlockSetType.COPPER, props), Optional.of(meshProps.strength(CPR_GRT).getCopy())));
        WAXED_OXIDIZED_COPPER_MESH_GATE = registerBlock("waxed_oxidized_copper_mesh_gate", new MBlock<>(props -> new MMeshGate(BlockSetType.COPPER, props), Optional.of(meshProps.strength(CPR_GRT).getCopy())));

        COPPER_MESH_TRAPDOOR = registerBlock("copper_mesh_trapdoor", new MBlock<>(props -> new WeatheringCopperTrapDoorBlock(BlockSetType.COPPER, WeatheringCopper.WeatherState.UNAFFECTED, props), Optional.of(meshProps.strength(CPR_GRT).getCopy())));
        EXPOSED_COPPER_MESH_TRAPDOOR = registerBlock("exposed_copper_mesh_trapdoor", new MBlock<>(props -> new WeatheringCopperTrapDoorBlock(BlockSetType.COPPER, WeatheringCopper.WeatherState.EXPOSED, props), Optional.of(trapdoorProps.strength(CPR_GRT).getCopy())));
        WEATHERED_COPPER_MESH_TRAPDOOR = registerBlock("weathered_copper_mesh_trapdoor", new MBlock<>(props -> new WeatheringCopperTrapDoorBlock(BlockSetType.COPPER, WeatheringCopper.WeatherState.WEATHERED, props), Optional.of(trapdoorProps.strength(CPR_GRT).getCopy())));
        OXIDIZED_COPPER_MESH_TRAPDOOR = registerBlock("oxidized_copper_mesh_trapdoor", new MBlock<>(props -> new WeatheringCopperTrapDoorBlock(BlockSetType.COPPER, WeatheringCopper.WeatherState.OXIDIZED, props), Optional.of(trapdoorProps.strength(CPR_GRT).getCopy())));
        WAXED_COPPER_MESH_TRAPDOOR = registerBlock("waxed_copper_mesh_trapdoor", new MBlock<>(props -> new TrapDoorBlock(BlockSetType.COPPER, props), Optional.of(trapdoorProps.strength(CPR_GRT).getCopy())));
        WAXED_EXPOSED_COPPER_MESH_TRAPDOOR = registerBlock("waxed_exposed_copper_mesh_trapdoor", new MBlock<>(props -> new TrapDoorBlock(BlockSetType.COPPER, props), Optional.of(trapdoorProps.strength(CPR_GRT).getCopy())));
        WAXED_WEATHERED_COPPER_MESH_TRAPDOOR = registerBlock("waxed_weathered_copper_mesh_trapdoor", new MBlock<>(props -> new TrapDoorBlock(BlockSetType.COPPER, props), Optional.of(trapdoorProps.strength(CPR_GRT).getCopy())));
        WAXED_OXIDIZED_COPPER_MESH_TRAPDOOR = registerBlock("waxed_oxidized_copper_mesh_trapdoor", new MBlock<>(props -> new TrapDoorBlock(BlockSetType.COPPER, props), Optional.of(trapdoorProps.strength(CPR_GRT).getCopy())));

        COPPER_MESH_DOOR = registerBlock("copper_mesh_door", new MBlock<>(props -> new WeatheringCopperDoorBlock(BlockSetType.COPPER,WeatheringCopper.WeatherState.UNAFFECTED, props), Optional.of(doorProps.strength(CPR_GRT).getCopy())));
        EXPOSED_COPPER_MESH_DOOR = registerBlock("exposed_copper_mesh_door", new MBlock<>(props -> new WeatheringCopperDoorBlock(BlockSetType.COPPER,WeatheringCopper.WeatherState.EXPOSED, props), Optional.of(doorProps.strength(CPR_GRT).getCopy())));
        WEATHERED_COPPER_MESH_DOOR = registerBlock("weathered_copper_mesh_door", new MBlock<>(props -> new WeatheringCopperDoorBlock(BlockSetType.COPPER,WeatheringCopper.WeatherState.WEATHERED, props), Optional.of(doorProps.strength(CPR_GRT).getCopy())));
        OXIDIZED_COPPER_MESH_DOOR = registerBlock("oxidized_copper_mesh_door", new MBlock<>(props -> new WeatheringCopperDoorBlock(BlockSetType.COPPER,WeatheringCopper.WeatherState.OXIDIZED, props), Optional.of(doorProps.strength(CPR_GRT).getCopy())));
        WAXED_COPPER_MESH_DOOR = registerBlock("waxed_copper_mesh_door", new MBlock<>(props -> new DoorBlock(BlockSetType.COPPER, props), Optional.of(doorProps.strength(CPR_GRT).getCopy())));
        WAXED_EXPOSED_COPPER_MESH_DOOR = registerBlock("waxed_exposed_copper_mesh_door", new MBlock<>(props -> new DoorBlock(BlockSetType.COPPER, props), Optional.of(doorProps.strength(CPR_GRT).getCopy())));
        WAXED_WEATHERED_COPPER_MESH_DOOR = registerBlock("waxed_weathered_copper_mesh_door", new MBlock<>(props -> new DoorBlock(BlockSetType.COPPER, props), Optional.of(doorProps.strength(CPR_GRT).getCopy())));
        WAXED_OXIDIZED_COPPER_MESH_DOOR = registerBlock("waxed_oxidized_copper_mesh_door", new MBlock<>(props -> new DoorBlock(BlockSetType.COPPER, props), Optional.of(doorProps.strength(CPR_GRT).getCopy())));

        COPPER_SLAB = registerBlock("copper_slab", new MBlock<>(props -> new WeatheringCopperSlabBlock(WeatheringCopper.WeatherState.UNAFFECTED, props), Optional.of(stairSlabProps.strength(CPR_GRT).getCopy())));
        EXPOSED_COPPER_SLAB = registerBlock("exposed_copper_slab", new MBlock<>(props -> new WeatheringCopperSlabBlock(WeatheringCopper.WeatherState.EXPOSED, props), Optional.of(stairSlabProps.strength(CPR_GRT).getCopy())));
        WEATHERED_COPPER_SLAB = registerBlock("weathered_copper_slab", new MBlock<>(props -> new WeatheringCopperSlabBlock(WeatheringCopper.WeatherState.WEATHERED, props), Optional.of(stairSlabProps.strength(CPR_GRT).getCopy())));
        OXIDIZED_COPPER_SLAB = registerBlock("oxidized_copper_slab", new MBlock<>(props -> new WeatheringCopperSlabBlock(WeatheringCopper.WeatherState.OXIDIZED, props), Optional.of(stairSlabProps.strength(CPR_GRT).getCopy())));
        WAXED_COPPER_SLAB = registerBlock("waxed_copper_slab", new MBlock<>(SlabBlock::new, Optional.of(stairSlabProps.strength(CPR_GRT).getCopy())));
        WAXED_EXPOSED_COPPER_SLAB = registerBlock("waxed_exposed_copper_slab", new MBlock<>(SlabBlock::new, Optional.of(stairSlabProps.strength(CPR_GRT).getCopy())));
        WAXED_WEATHERED_COPPER_SLAB = registerBlock("waxed_weathered_copper_slab", new MBlock<>(SlabBlock::new, Optional.of(stairSlabProps.strength(CPR_GRT).getCopy())));
        WAXED_OXIDIZED_COPPER_SLAB = registerBlock("waxed_oxidized_copper_slab", new MBlock<>(SlabBlock::new, Optional.of(stairSlabProps.strength(CPR_GRT).getCopy())));

        COPPER_CAMPFIRE = registerBlock("copper_campfire", new MBlock<>(props -> new MCampfireBlock(1, MetallicsParticleTypes.COPPER_EMBER.get(), props), Optional.of(campfireProps.getCopy())));
        COPPER_JACK_O_LANTERN = registerBlock("copper_jack_o_lantern", new MBlock<>(CarvedPumpkinBlock::new, Optional.of(jackOLanternProps.getCopy())));

        COPPER_LAMP = registerBlock("copper_lamp", new MBlock<>(props -> new MWeatheringLampBlock(props, WeatheringCopper.WeatherState.UNAFFECTED), Optional.of(lampProps.strength(CPR_LNT).getCopy())));
        EXPOSED_COPPER_LAMP = registerBlock("exposed_copper_lamp", new MBlock<>(props -> new MWeatheringLampBlock(props, WeatheringCopper.WeatherState.EXPOSED), Optional.of(lampProps.strength(CPR_LNT).getCopy())));
        WEATHERED_COPPER_LAMP = registerBlock("weathered_copper_lamp", new MBlock<>(props -> new MWeatheringLampBlock(props, WeatheringCopper.WeatherState.WEATHERED), Optional.of(lampProps.strength(CPR_LNT).getCopy())));
        OXIDIZED_COPPER_LAMP = registerBlock("oxidized_copper_lamp", new MBlock<>(props -> new MWeatheringLampBlock(props, WeatheringCopper.WeatherState.OXIDIZED), Optional.of(lampProps.strength(CPR_LNT).getCopy())));
        WAXED_COPPER_LAMP = registerBlock("waxed_copper_lamp", new MBlock<>(RedstoneLampBlock::new, Optional.of(lampProps.strength(CPR_LNT).getCopy())));
        WAXED_EXPOSED_COPPER_LAMP = registerBlock("waxed_exposed_copper_lamp", new MBlock<>(RedstoneLampBlock::new, Optional.of(lampProps.strength(CPR_LNT).getCopy())));
        WAXED_WEATHERED_COPPER_LAMP = registerBlock("waxed_weathered_copper_lamp", new MBlock<>(RedstoneLampBlock::new, Optional.of(lampProps.strength(CPR_LNT).getCopy())));
        WAXED_OXIDIZED_COPPER_LAMP = registerBlock("waxed_oxidized_copper_lamp", new MBlock<>(RedstoneLampBlock::new, Optional.of(lampProps.strength(CPR_LNT).getCopy())));

        COPPER_BUTTON = registerBlock("copper_button", new MBlock<>(props -> new MWeatheringButtonBlock(BlockSetType.COPPER, 20, props, WeatheringCopper.WeatherState.UNAFFECTED), Optional.of(buttonProps.strength(CPR_GRT).getCopy())));
        EXPOSED_COPPER_BUTTON = registerBlock("exposed_copper_button", new MBlock<>(props -> new MWeatheringButtonBlock(BlockSetType.COPPER, 20, props, WeatheringCopper.WeatherState.EXPOSED), Optional.of(buttonProps.strength(CPR_GRT).getCopy())));
        WEATHERED_COPPER_BUTTON = registerBlock("weathered_copper_button", new MBlock<>(props -> new MWeatheringButtonBlock(BlockSetType.COPPER, 20, props, WeatheringCopper.WeatherState.WEATHERED), Optional.of(buttonProps.strength(CPR_GRT).getCopy())));
        OXIDIZED_COPPER_BUTTON = registerBlock("oxidized_copper_button", new MBlock<>(props -> new MWeatheringButtonBlock(BlockSetType.COPPER, 20, props, WeatheringCopper.WeatherState.OXIDIZED), Optional.of(buttonProps.strength(CPR_GRT).getCopy())));
        WAXED_COPPER_BUTTON = registerBlock("waxed_copper_button", new MBlock<>(props -> new ButtonBlock(BlockSetType.COPPER, 20, props), Optional.of(buttonProps.strength(CPR_GRT).getCopy())));
        WAXED_EXPOSED_COPPER_BUTTON = registerBlock("waxed_exposed_copper_button", new MBlock<>(props -> new ButtonBlock(BlockSetType.COPPER, 20, props), Optional.of(buttonProps.strength(CPR_GRT).getCopy())));
        WAXED_WEATHERED_COPPER_BUTTON = registerBlock("waxed_weathered_copper_button", new MBlock<>(props -> new ButtonBlock(BlockSetType.COPPER, 20, props), Optional.of(buttonProps.strength(CPR_GRT).getCopy())));
        WAXED_OXIDIZED_COPPER_BUTTON = registerBlock("waxed_oxidized_copper_button", new MBlock<>(props -> new ButtonBlock(BlockSetType.COPPER, 20, props), Optional.of(buttonProps.strength(CPR_GRT).getCopy())));

        COPPER_PRESSURE_PLATE = registerBlock("copper_pressure_plate", new MBlock<>(props -> new MWeatheringPressurePlateBlock(BlockSetType.COPPER, props, WeatheringCopper.WeatherState.UNAFFECTED), Optional.of(buttonProps.strength(CPR_GRT).getCopy())));
        EXPOSED_COPPER_PRESSURE_PLATE = registerBlock("exposed_copper_pressure_plate", new MBlock<>(props -> new MWeatheringPressurePlateBlock(BlockSetType.COPPER, props, WeatheringCopper.WeatherState.EXPOSED), Optional.of(buttonProps.strength(CPR_GRT).getCopy())));
        WEATHERED_COPPER_PRESSURE_PLATE = registerBlock("weathered_copper_pressure_plate", new MBlock<>(props -> new MWeatheringPressurePlateBlock(BlockSetType.COPPER, props, WeatheringCopper.WeatherState.WEATHERED), Optional.of(buttonProps.strength(CPR_GRT).getCopy())));
        OXIDIZED_COPPER_PRESSURE_PLATE = registerBlock("oxidized_copper_pressure_plate", new MBlock<>(props -> new MWeatheringPressurePlateBlock(BlockSetType.COPPER, props, WeatheringCopper.WeatherState.OXIDIZED), Optional.of(buttonProps.strength(CPR_GRT).getCopy())));
        WAXED_COPPER_PRESSURE_PLATE = registerBlock("waxed_copper_pressure_plate", new MBlock<>(props -> new PressurePlateBlock(BlockSetType.COPPER,  props), Optional.of(buttonProps.strength(CPR_GRT).getCopy())));
        WAXED_EXPOSED_COPPER_PRESSURE_PLATE = registerBlock("waxed_exposed_copper_pressure_plate", new MBlock<>(props -> new PressurePlateBlock(BlockSetType.COPPER, props), Optional.of(buttonProps.strength(CPR_GRT).getCopy())));
        WAXED_WEATHERED_COPPER_PRESSURE_PLATE = registerBlock("waxed_weathered_copper_pressure_plate", new MBlock<>(props -> new PressurePlateBlock(BlockSetType.COPPER, props), Optional.of(buttonProps.strength(CPR_GRT).getCopy())));
        WAXED_OXIDIZED_COPPER_PRESSURE_PLATE = registerBlock("waxed_oxidized_copper_pressure_plate", new MBlock<>(props -> new PressurePlateBlock(BlockSetType.COPPER, props), Optional.of(buttonProps.strength(CPR_GRT).getCopy())));

        COPPER_GLASS = registerBlock("copper_glass", new MBlock<>(props -> new MWeatheringTransparentBlock(props, WeatheringCopper.WeatherState.UNAFFECTED), Optional.of(glassProps.strength(CPR_MSH).getCopy())));
        EXPOSED_COPPER_GLASS = registerBlock("exposed_copper_glass", new MBlock<>(props -> new MWeatheringTransparentBlock(props, WeatheringCopper.WeatherState.EXPOSED), Optional.of(glassProps.strength(CPR_MSH).getCopy())));
        WEATHERED_COPPER_GLASS = registerBlock("weathered_copper_glass", new MBlock<>(props -> new MWeatheringTransparentBlock(props, WeatheringCopper.WeatherState.WEATHERED), Optional.of(glassProps.strength(CPR_MSH).getCopy())));
        OXIDIZED_COPPER_GLASS = registerBlock("oxidized_copper_glass", new MBlock<>(props -> new MWeatheringTransparentBlock(props, WeatheringCopper.WeatherState.OXIDIZED), Optional.of(glassProps.strength(CPR_MSH).getCopy())));
        WAXED_COPPER_GLASS = registerBlock("waxed_copper_glass", new MBlock<>(TransparentBlock::new, Optional.of(glassProps.strength(CPR_MSH).getCopy())));
        WAXED_EXPOSED_COPPER_GLASS = registerBlock("waxed_exposed_copper_glass", new MBlock<>(TransparentBlock::new, Optional.of(glassProps.strength(CPR_MSH).getCopy())));
        WAXED_WEATHERED_COPPER_GLASS = registerBlock("waxed_weathered_copper_glass", new MBlock<>(TransparentBlock::new, Optional.of(glassProps.strength(CPR_MSH).getCopy())));
        WAXED_OXIDIZED_COPPER_GLASS = registerBlock("waxed_oxidized_copper_glass", new MBlock<>(TransparentBlock::new, Optional.of(glassProps.strength(CPR_MSH).getCopy())));

        COPPER_GLASS_PANE = registerBlock("copper_glass_pane", new MBlock<>(props -> new WeatheringCopperBarsBlock(WeatheringCopper.WeatherState.UNAFFECTED, props), Optional.of(glassProps.strength(CPR_MSH).getCopy())));
        EXPOSED_COPPER_GLASS_PANE = registerBlock("exposed_copper_glass_pane", new MBlock<>(props -> new WeatheringCopperBarsBlock(WeatheringCopper.WeatherState.EXPOSED, props), Optional.of(glassProps.strength(CPR_MSH).getCopy())));
        WEATHERED_COPPER_GLASS_PANE = registerBlock("weathered_copper_glass_pane", new MBlock<>(props -> new WeatheringCopperBarsBlock(WeatheringCopper.WeatherState.WEATHERED, props), Optional.of(glassProps.strength(CPR_MSH).getCopy())));
        OXIDIZED_COPPER_GLASS_PANE = registerBlock("oxidized_copper_glass_pane", new MBlock<>(props -> new WeatheringCopperBarsBlock(WeatheringCopper.WeatherState.OXIDIZED, props), Optional.of(glassProps.strength(CPR_MSH).getCopy())));
        WAXED_COPPER_GLASS_PANE = registerBlock("waxed_copper_glass_pane", new MBlock<>(IronBarsBlock::new, Optional.of(glassProps.strength(CPR_MSH).getCopy())));
        WAXED_EXPOSED_COPPER_GLASS_PANE = registerBlock("waxed_exposed_copper_glass_pane", new MBlock<>(IronBarsBlock::new, Optional.of(glassProps.strength(CPR_MSH).getCopy())));
        WAXED_WEATHERED_COPPER_GLASS_PANE = registerBlock("waxed_weathered_copper_glass_pane", new MBlock<>(IronBarsBlock::new, Optional.of(glassProps.strength(CPR_MSH).getCopy())));
        WAXED_OXIDIZED_COPPER_GLASS_PANE = registerBlock("waxed_oxidized_copper_glass_pane", new MBlock<>(IronBarsBlock::new, Optional.of(glassProps.strength(CPR_MSH).getCopy())));

        COPPER_TINTED_GLASS = registerBlock("copper_tinted_glass", new MBlock<>(props -> new MWeatheringTintedBlock(props, WeatheringCopper.WeatherState.UNAFFECTED), Optional.of(glassProps.strength(CPR_GRT).getCopy())));
        EXPOSED_COPPER_TINTED_GLASS = registerBlock("exposed_copper_tinted_glass", new MBlock<>(props -> new MWeatheringTintedBlock(props, WeatheringCopper.WeatherState.EXPOSED), Optional.of(glassProps.strength(CPR_GRT).getCopy())));
        WEATHERED_COPPER_TINTED_GLASS = registerBlock("weathered_copper_tinted_glass", new MBlock<>(props -> new MWeatheringTintedBlock(props, WeatheringCopper.WeatherState.WEATHERED), Optional.of(glassProps.strength(CPR_GRT).getCopy())));
        OXIDIZED_COPPER_TINTED_GLASS = registerBlock("oxidized_copper_tinted_glass", new MBlock<>(props -> new MWeatheringTintedBlock(props, WeatheringCopper.WeatherState.OXIDIZED), Optional.of(glassProps.strength(CPR_GRT).getCopy())));
        WAXED_COPPER_TINTED_GLASS = registerBlock("waxed_copper_tinted_glass", new MBlock<>(TintedGlassBlock::new, Optional.of(glassProps.strength(CPR_GRT).getCopy())));
        WAXED_EXPOSED_COPPER_TINTED_GLASS = registerBlock("waxed_exposed_copper_tinted_glass", new MBlock<>(TintedGlassBlock::new, Optional.of(glassProps.strength(CPR_GRT).getCopy())));
        WAXED_WEATHERED_COPPER_TINTED_GLASS = registerBlock("waxed_weathered_copper_tinted_glass", new MBlock<>(TintedGlassBlock::new, Optional.of(glassProps.strength(CPR_GRT).getCopy())));
        WAXED_OXIDIZED_COPPER_TINTED_GLASS = registerBlock("waxed_oxidized_copper_tinted_glass", new MBlock<>(TintedGlassBlock::new, Optional.of(glassProps.strength(CPR_GRT).getCopy())));

        //Iron
        IRON_PLATED_BLOCK = registerBlock("iron_plated_block", new MBlock<>(Block::new, Optional.of(blockProps.strength(IRN_GRT).getCopy())));
        IRON_SLAB = registerBlock("iron_slab", new MBlock<>(SlabBlock::new, Optional.of(stairSlabProps.strength(IRN_GRT).getCopy())));
        BRUSHING_IRON_BLOCK = registerBlock("brushing_iron_block", new MBlock<>(props -> new MBrushingBlock(4, 3, ResourceLocation.fromNamespaceAndPath(Metallics.MOD_ID, "brushed_iron_block"), SoundEvents.BRUSH_GENERIC, SoundEvents.COPPER_PLACE, props), Optional.of(blockProps.strength(IRN_GRT).getCopy())));
        BRUSHING_IRON_SLAB = registerBlock("brushing_iron_slab", new MBlock<>(props -> new MBrushingSlab(4, 3, ResourceLocation.fromNamespaceAndPath(Metallics.MOD_ID, "brushed_iron_slab"), SoundEvents.BRUSH_GENERIC, SoundEvents.COPPER_PLACE, props), Optional.of(stairSlabProps.strength(IRN_GRT).getCopy())));

        BRUSHED_IRON_BLOCK = registerBlock("brushed_iron_block", new MBlock<>(Block::new, Optional.of(blockProps.strength(IRN_GRT).getCopy())));
        BRUSHED_IRON_SLAB = registerBlock("brushed_iron_slab", new MBlock<>(SlabBlock::new, Optional.of(stairSlabProps.strength(IRN_GRT).getCopy())));
        CUT_IRON_BLOCK = registerBlock("cut_iron_block", new MBlock<>(Block::new, Optional.of(blockProps.strength(IRN_GRT).getCopy())));
        CUT_IRON_STAIRS = registerBlock("cut_iron_stairs", new MBlock<>(props -> new StairBlock(Blocks.IRON_BLOCK.defaultBlockState(), props), Optional.of(stairSlabProps.strength(IRN_GRT).getCopy())));
        CUT_IRON_SLAB = registerBlock("cut_iron_slab", new MBlock<>(SlabBlock::new, Optional.of(stairSlabProps.strength(IRN_GRT).getCopy())));
        CHISELED_IRON_BLOCK = registerBlock("chiseled_iron_block", new MBlock<>(Block::new, Optional.of(blockProps.strength(IRN_GRT).getCopy())));
        IRON_LADDER = registerBlock("iron_ladder", new MBlock<>(LadderBlock::new, Optional.of(ladderProps.strength(IRN_MSH).getCopy())));
        IRON_MESH = registerBlock("iron_mesh", new MBlock<>(IronBarsBlock::new, Optional.of(meshProps.strength(IRN_MSH).getCopy())));
        IRON_MESH_FENCE = registerBlock("iron_mesh_fence", new MBlock<>(MMeshFenceBlock::new, Optional.of(meshProps.strength(IRN_MSH).getCopy())));
        IRON_MESH_GATE = registerBlock("iron_mesh_gate", new MBlock<>(props -> new MMeshGate(BlockSetType.IRON, props), Optional.of(meshProps.strength(CPR_GRT).getCopy())));
        IRON_MESH_DOOR = registerBlock("iron_mesh_door", new MBlock<>(props -> new DoorBlock(BlockSetType.IRON, props), Optional.of(meshProps.strength(IRN_GRT).getCopy())));
        IRON_MESH_TRAPDOOR = registerBlock("iron_mesh_trapdoor", new MBlock<>(props -> new TrapDoorBlock(BlockSetType.IRON, props), Optional.of(trapdoorProps.strength(IRN_GRT).getCopy())));
        IRON_GRATE = registerBlock("iron_grate", new MBlock<>(MGrateBlock::new, Optional.of(grateProps.strength(IRN_GRT).getCopy())));
        IRON_LAMP = registerBlock("iron_lamp", new MBlock<>(RedstoneLampBlock::new, Optional.of(lampProps.strength(IRN_LNT).getCopy())));
        IRON_GLASS = registerBlock("iron_glass", new MBlock<>(TransparentBlock::new, Optional.of(glassProps.strength(IRN_MSH).getCopy())));
        IRON_GLASS_PANE = registerBlock("iron_glass_pane", new MBlock<>(IronBarsBlock::new, Optional.of(glassProps.strength(IRN_MSH).getCopy())));
        IRON_TINTED_GLASS = registerBlock("iron_tinted_glass", new MBlock<>(TintedGlassBlock::new, Optional.of(glassProps.strength(IRN_GRT).getCopy())));

        IRON_BUTTON = registerBlock("iron_button", new MBlock<>(props -> new ButtonBlock(BlockSetType.IRON, 20, props), Optional.of(buttonProps.strength(IRN_GRT).getCopy())));
        IRON_PRESSURE_PLATE = registerBlock("iron_pressure_plate", new MBlock<>(props -> new PressurePlateBlock(BlockSetType.IRON, props), Optional.of(buttonProps.strength(IRN_GRT).getCopy())));

        FERROUS_TORCH = registerBlock("ferrous_torch", new MBlock<>(props -> new TorchBlock(MetallicsParticleTypes.FERROUS_FLAME.get(), props), Optional.of(torchProps.getCopy())));
        FERROUS_WALL_TORCH = registerBlock("ferrous_wall_torch", new MBlock<>(props -> new WallTorchBlock(MetallicsParticleTypes.FERROUS_FLAME.get(), props), Optional.of(torchProps.getCopy())));
        FERROUS_CAMPFIRE = registerBlock("ferrous_campfire", new MBlock<>(props -> new MCampfireBlock(1, MetallicsParticleTypes.FERROUS_EMBER.get(), props), Optional.of(campfireProps.getCopy())));
        FERROUS_JACK_O_LANTERN = registerBlock("ferrous_jack_o_lantern", new MBlock<>(CarvedPumpkinBlock::new, Optional.of(jackOLanternProps.getCopy())));
        FERROUS_LANTERN = registerBlock("ferrous_lantern", new MBlock<>(LanternBlock::new, Optional.of(lanternProps.strength(IRN_LNT).getCopy())));

        //Blue Iron
        BLUE_IRON_CHAIN = registerBlock("blue_iron_chain", new MBlock<>(ChainBlock::new, Optional.of(chainProps.strength(IRN_MSH).getCopy())));
        BLUE_IRON_LANTERN = registerBlock("blue_iron_lantern", new MBlock<>(LanternBlock::new, Optional.of(lanternProps.strength(IRN_LNT).getCopy())));
        BLUE_IRON_SOUL_LANTERN = registerBlock("blue_iron_soul_lantern", new MBlock<>(LanternBlock::new, Optional.of(lanternProps.strength(IRN_LNT).getCopy())));
        BLUE_IRON_BARS = registerBlock("blue_iron_bars", new MBlock<>(IronBarsBlock::new, Optional.of(barsProps.strength(GLD_STR).getCopy())));
        BLUE_IRON_BLOCK = registerBlock("blue_iron_block",  new MBlock<>(Block::new, Optional.of(blockProps.strength(IRN_GRT).getCopy())));
        BLUE_IRON_PLATED_BLOCK = registerBlock("blue_iron_plated_block", new MBlock<>(Block::new, Optional.of(blockProps.strength(IRN_GRT).getCopy())));
        BLUE_IRON_SLAB = registerBlock("blue_iron_slab", new MBlock<>(SlabBlock::new, Optional.of(stairSlabProps.strength(IRN_GRT).getCopy())));
        BRUSHING_BLUE_IRON_BLOCK = registerBlock("brushing_blue_iron_block", new MBlock<>(props -> new MBrushingBlock(4, 3, ResourceLocation.fromNamespaceAndPath(Metallics.MOD_ID, "brushed_blue_iron_block"), SoundEvents.BRUSH_GENERIC, SoundEvents.COPPER_PLACE, props), Optional.of(blockProps.strength(IRN_GRT).getCopy())));
        BRUSHING_BLUE_IRON_SLAB = registerBlock("brushing_blue_iron_slab", new MBlock<>(props -> new MBrushingSlab(4, 3, ResourceLocation.fromNamespaceAndPath(Metallics.MOD_ID, "brushed_blue_iron_slab"), SoundEvents.BRUSH_GENERIC, SoundEvents.COPPER_PLACE, props), Optional.of(stairSlabProps.strength(IRN_GRT).getCopy())));
        BRUSHED_BLUE_IRON_BLOCK = registerBlock("brushed_blue_iron_block", new MBlock<>(Block::new, Optional.of(blockProps.strength(IRN_GRT).getCopy())));
        BRUSHED_BLUE_IRON_SLAB = registerBlock("brushed_blue_iron_slab", new MBlock<>(SlabBlock::new, Optional.of(stairSlabProps.strength(IRN_GRT).getCopy())));
        CUT_BLUE_IRON_BLOCK = registerBlock("cut_blue_iron_block", new MBlock<>(Block::new, Optional.of(blockProps.strength(IRN_GRT).getCopy())));
        CUT_BLUE_IRON_STAIRS = registerBlock("cut_blue_iron_stairs", new MBlock<>(props -> new StairBlock(Blocks.IRON_BLOCK.defaultBlockState(), props), Optional.of(stairSlabProps.strength(IRN_GRT).getCopy())));
        CUT_BLUE_IRON_SLAB = registerBlock("cut_blue_iron_slab", new MBlock<>(SlabBlock::new, Optional.of(stairSlabProps.strength(IRN_GRT).getCopy())));
        CHISELED_BLUE_IRON_BLOCK = registerBlock("chiseled_blue_iron_block", new MBlock<>(Block::new, Optional.of(blockProps.strength(IRN_GRT).getCopy())));
        BLUE_IRON_DOOR = registerBlock("blue_iron_door", new MBlock<>(props -> new DoorBlock(BlockSetType.IRON, props), Optional.of(doorProps.strength(IRN_GRT).getCopy())));
        BLUE_IRON_TRAPDOOR = registerBlock("blue_iron_trapdoor", new MBlock<>(props -> new TrapDoorBlock(BlockSetType.IRON, props), Optional.of(trapdoorProps.strength(IRN_GRT).getCopy())));
        BLUE_IRON_LADDER = registerBlock("blue_iron_ladder", new MBlock<>(LadderBlock::new, Optional.of(ladderProps.strength(IRN_MSH).getCopy())));
        BLUE_IRON_MESH = registerBlock("blue_iron_mesh", new MBlock<>(IronBarsBlock::new, Optional.of(meshProps.strength(IRN_MSH).getCopy())));
        BLUE_IRON_MESH_FENCE = registerBlock("blue_iron_mesh_fence", new MBlock<>(MMeshFenceBlock::new, Optional.of(meshProps.strength(IRN_MSH).getCopy())));
        BLUE_IRON_MESH_GATE = registerBlock("blue_iron_mesh_gate", new MBlock<>(props -> new MMeshGate(BlockSetType.IRON, props), Optional.of(meshProps.strength(CPR_GRT).getCopy())));
        BLUE_IRON_MESH_DOOR = registerBlock("blue_iron_mesh_door", new MBlock<>(props -> new DoorBlock(BlockSetType.IRON, props), Optional.of(doorProps.strength(IRN_GRT).getCopy())));
        BLUE_IRON_MESH_TRAPDOOR = registerBlock("blue_iron_mesh_trapdoor", new MBlock<>(props -> new TrapDoorBlock(BlockSetType.IRON, props), Optional.of(trapdoorProps.strength(IRN_GRT).getCopy())));
        BLUE_IRON_GRATE = registerBlock("blue_iron_grate", new MBlock<>(MGrateBlock::new, Optional.of(grateProps.strength(IRN_GRT).getCopy())));
        BLUE_IRON_LAMP = registerBlock("blue_iron_lamp", new MBlock<>(RedstoneLampBlock::new, Optional.of(lampProps.strength(IRN_LNT).getCopy())));
        BLUE_IRON_GLASS = registerBlock("blue_iron_glass", new MBlock<>(TransparentBlock::new, Optional.of(glassProps.strength(IRN_MSH).getCopy())));
        BLUE_IRON_GLASS_PANE = registerBlock("blue_iron_glass_pane", new MBlock<>(IronBarsBlock::new, Optional.of(glassProps.strength(IRN_MSH).getCopy())));
        BLUE_IRON_TINTED_GLASS = registerBlock("blue_iron_tinted_glass", new MBlock<>(TintedGlassBlock::new, Optional.of(glassProps.strength(IRN_GRT).getCopy())));

        BLUE_IRON_BUTTON = registerBlock("blue_iron_button", new MBlock<>(props -> new ButtonBlock(BlockSetType.IRON, 20, props), Optional.of(buttonProps.strength(IRN_GRT).getCopy())));
        BLUE_IRON_PRESSURE_PLATE = registerBlock("blue_iron_pressure_plate", new MBlock<>(props -> new PressurePlateBlock(BlockSetType.IRON, props), Optional.of(buttonProps.strength(IRN_GRT).getCopy())));

        PALE_TORCH = registerBlock("pale_torch", new MBlock<>(props -> new TorchBlock(MetallicsParticleTypes.PALE_FLAME.get(), props), Optional.of(torchProps.getCopy())));
        PALE_WALL_TORCH = registerBlock("pale_wall_torch", new MBlock<>(props -> new WallTorchBlock(MetallicsParticleTypes.PALE_FLAME.get(), props), Optional.of(torchProps.getCopy())));
        PALE_CAMPFIRE = registerBlock("pale_campfire", new MBlock<>(props -> new MCampfireBlock(1, MetallicsParticleTypes.PALE_EMBER.get(), props), Optional.of(campfireProps.getCopy())));
        PALE_JACK_O_LANTERN = registerBlock("pale_jack_o_lantern", new MBlock<>(CarvedPumpkinBlock::new, Optional.of(jackOLanternProps.getCopy())));
        PALE_LANTERN = registerBlock("pale_lantern", new MBlock<>(LanternBlock::new, Optional.of(lanternProps.strength(IRN_LNT).getCopy())));

        //Gold
        GOLD_CHAIN = registerBlock("gold_chain", new MBlock<>(ChainBlock::new, Optional.of(chainProps.strength(GLD_MSH).getCopy())));
        GOLD_BARS = registerBlock("gold_bars", new MBlock<>(IronBarsBlock::new, Optional.of(barsProps.strength(GLD_STR).getCopy())));
        GOLD_PLATED_BLOCK = registerBlock("gold_plated_block", new MBlock<>(Block::new, Optional.of(blockProps.strength(GLD_GRT).getCopy())));
        GOLD_SLAB = registerBlock("gold_slab", new MBlock<>(SlabBlock::new, Optional.of(stairSlabProps.strength(GLD_GRT).getCopy())));
        BRUSHING_GOLD_BLOCK = registerBlock("brushing_gold_block", new MBlock<>(props -> new MBrushingBlock(4, 3, ResourceLocation.fromNamespaceAndPath(Metallics.MOD_ID, "brushed_gold_block"), SoundEvents.BRUSH_GENERIC, SoundEvents.COPPER_PLACE, props), Optional.of(blockProps.strength(GLD_GRT).getCopy())));
        BRUSHING_GOLD_SLAB = registerBlock("brushing_gold_slab", new MBlock<>(props -> new MBrushingSlab(4, 3, ResourceLocation.fromNamespaceAndPath(Metallics.MOD_ID, "brushed_gold_slab"), SoundEvents.BRUSH_GENERIC, SoundEvents.COPPER_PLACE, props), Optional.of(stairSlabProps.strength(GLD_GRT).getCopy())));
        BRUSHED_GOLD_BLOCK = registerBlock("brushed_gold_block", new MBlock<>(Block::new, Optional.of(blockProps.strength(GLD_GRT).getCopy())));
        BRUSHED_GOLD_SLAB = registerBlock("brushed_gold_slab", new MBlock<>(SlabBlock::new, Optional.of(stairSlabProps.strength(GLD_GRT).getCopy())));
        CUT_GOLD_BLOCK = registerBlock("cut_gold_block", new MBlock<>(Block::new, Optional.of(blockProps.strength(GLD_GRT).getCopy())));
        CUT_GOLD_STAIRS = registerBlock("cut_gold_stairs", new MBlock<>(props -> new StairBlock(Blocks.GOLD_BLOCK.defaultBlockState(), props), Optional.of(stairSlabProps.strength(GLD_GRT).getCopy())));
        CUT_GOLD_SLAB = registerBlock("cut_gold_slab", new MBlock<>(SlabBlock::new, Optional.of(stairSlabProps.strength(GLD_GRT).getCopy())));
        CHISELED_GOLD_BLOCK = registerBlock("chiseled_gold_block", new MBlock<>(Block::new, Optional.of(blockProps.strength(GLD_GRT).getCopy())));
        GOLD_DOOR = registerBlock("gold_door", new MBlock<>(props -> new DoorBlock(GOLD_SET.get(), props), Optional.of(doorProps.strength(GLD_GRT).pushReaction(PushReaction.BLOCK).getCopy())));
        GOLD_TRAPDOOR = registerBlock("gold_trapdoor", new MBlock<>(props -> new TrapDoorBlock(GOLD_SET.get(), props), Optional.of(trapdoorProps.strength(GLD_GRT).getCopy())));
        GOLD_LADDER = registerBlock("gold_ladder", new MBlock<>(LadderBlock::new, Optional.of(ladderProps.strength(GLD_MSH).getCopy())));
        GOLD_MESH = registerBlock("gold_mesh", new MBlock<>(IronBarsBlock::new, Optional.of(meshProps.strength(GLD_MSH).getCopy())));
        GOLD_MESH_FENCE = registerBlock("gold_mesh_fence", new MBlock<>(MMeshFenceBlock::new, Optional.of(meshProps.strength(GLD_MSH).getCopy())));
        GOLD_MESH_GATE = registerBlock("gold_mesh_gate", new MBlock<>(props -> new MMeshGate(GOLD_SET.get(), props), Optional.of(trapdoorProps.strength(CPR_GRT).getCopy())));
        GOLD_MESH_TRAPDOOR = registerBlock("gold_mesh_trapdoor", new MBlock<>(props -> new TrapDoorBlock(GOLD_SET.get(), props), Optional.of(trapdoorProps.strength(GLD_GRT).getCopy())));
        GOLD_MESH_DOOR = registerBlock("gold_mesh_door", new MBlock<>(props -> new DoorBlock(GOLD_SET.get(), props), Optional.of(doorProps.strength(GLD_GRT).getCopy())));
        GOLD_GRATE = registerBlock("gold_grate", new MBlock<>(MGrateBlock::new, Optional.of(grateProps.strength(GLD_GRT).getCopy())));
        GOLD_LAMP = registerBlock("gold_lamp", new MBlock<>(RedstoneLampBlock::new, Optional.of(lampProps.strength(GLD_LNT).getCopy())));
        GOLD_BUTTON = registerBlock("gold_button", new MBlock<>(props -> new ButtonBlock(GOLD_SET.get(), 20, props), Optional.of(buttonProps.strength(GLD_GRT).getCopy())));
        GOLD_PRESSURE_PLATE = registerBlock("gold_pressure_plate", new MBlock<>(props -> new PressurePlateBlock(GOLD_SET.get(), props), Optional.of(buttonProps.strength(GLD_GRT).getCopy())));

        GOLD_GLASS = registerBlock("gold_glass", new MBlock<>(TransparentBlock::new, Optional.of(glassProps.strength(GLD_MSH).getCopy())));
        GOLD_GLASS_PANE = registerBlock("gold_glass_pane", new MBlock<>(IronBarsBlock::new, Optional.of(glassProps.strength(GLD_MSH).getCopy())));
        GOLD_TINTED_GLASS = registerBlock("gold_tinted_glass", new MBlock<>(TintedGlassBlock::new, Optional.of(glassProps.strength(GLD_GRT).getCopy())));

        AZURE_TORCH = registerBlock("azure_torch", new MBlock<>(props -> new TorchBlock(MetallicsParticleTypes.AZURE_FLAME.get(), props), Optional.of(torchProps.getCopy())));
        AZURE_WALL_TORCH = registerBlock("azure_wall_torch", new MBlock<>(props -> new WallTorchBlock(MetallicsParticleTypes.AZURE_FLAME.get(), props), Optional.of(torchProps.getCopy())));
        AZURE_CAMPFIRE = registerBlock("azure_campfire", new MBlock<>(props -> new MCampfireBlock(1, MetallicsParticleTypes.AZURE_EMBER.get(), props), Optional.of(campfireProps.getCopy())));
        AZURE_JACK_O_LANTERN = registerBlock("azure_jack_o_lantern", new MBlock<>(CarvedPumpkinBlock::new, Optional.of(jackOLanternProps.getCopy())));
        AZURE_LANTERN = registerBlock("azure_lantern", new MBlock<>(LanternBlock::new, Optional.of(lanternProps.strength(GLD_LNT).getCopy())));

        //Netherite
        NETHERITE_CHAIN = registerBlock("netherite_chain", new MBlock<>(ChainBlock::new, Optional.of(chainProps.strength(NTR_MSH).getCopy())));
        INFERNAL_LANTERN = registerBlock("infernal_lantern", new MBlock<>(LanternBlock::new, Optional.of(lanternProps.strength(NTR_LNT).getCopy())));
        NETHERITE_BARS = registerBlock("netherite_bars", new MBlock<>(IronBarsBlock::new, Optional.of(barsProps.strength(NTR_STR).getCopy())));
        NETHERITE_PLATED_BLOCK = registerBlock("netherite_plated_block", new MBlock<>(Block::new, Optional.of(blockProps.strength(NTR_GRT).getCopy())));
        NETHERITE_SLAB = registerBlock("netherite_slab", new MBlock<>(SlabBlock::new, Optional.of(stairSlabProps.strength(NTR_GRT).getCopy())));
        BRUSHING_NETHERITE_BLOCK = registerBlock("brushing_netherite_block", new MBlock<>(props -> new MBrushingBlock(4, 3, ResourceLocation.fromNamespaceAndPath(Metallics.MOD_ID, "brushed_netherite_block"), SoundEvents.BRUSH_GENERIC, SoundEvents.COPPER_PLACE, props), Optional.of(blockProps.strength(NTR_GRT).getCopy())));
        BRUSHING_NETHERITE_SLAB = registerBlock("brushing_netherite_slab", new MBlock<>(props -> new MBrushingSlab(4, 3, ResourceLocation.fromNamespaceAndPath(Metallics.MOD_ID, "brushed_netherite_slab"), SoundEvents.BRUSH_GENERIC, SoundEvents.COPPER_PLACE, props), Optional.of(stairSlabProps.strength(NTR_GRT).getCopy())));
        BRUSHED_NETHERITE_BLOCK = registerBlock("brushed_netherite_block", new MBlock<>(Block::new, Optional.of(blockProps.strength(NTR_GRT).getCopy())));
        BRUSHED_NETHERITE_SLAB = registerBlock("brushed_netherite_slab", new MBlock<>(SlabBlock::new, Optional.of(stairSlabProps.strength(NTR_GRT).getCopy())));
        CUT_NETHERITE_BLOCK = registerBlock("cut_netherite_block", new MBlock<>(Block::new, Optional.of(blockProps.strength(NTR_GRT).getCopy())));
        CUT_NETHERITE_STAIRS = registerBlock("cut_netherite_stairs", new MBlock<>(props -> new StairBlock(Blocks.NETHERITE_BLOCK.defaultBlockState(), props), Optional.of(stairSlabProps.strength(NTR_GRT).getCopy())));
        CUT_NETHERITE_SLAB = registerBlock("cut_netherite_slab", new MBlock<>(SlabBlock::new, Optional.of(stairSlabProps.strength(NTR_GRT).getCopy())));
        CHISELED_NETHERITE_BLOCK = registerBlock("chiseled_netherite_block", new MBlock<>(Block::new, Optional.of(blockProps.strength(NTR_GRT).getCopy())));
        NETHERITE_DOOR = registerBlock("netherite_door", new MBlock<>(props -> new DoorBlock(NETHERITE_SET.get(), props), Optional.of(doorProps.strength(NTR_GRT).pushReaction(PushReaction.BLOCK).getCopy())));
        NETHERITE_TRAPDOOR = registerBlock("netherite_trapdoor", new MBlock<>(props -> new TrapDoorBlock(NETHERITE_SET.get(), props), Optional.of(trapdoorProps.strength(NTR_GRT).getCopy())));
        NETHERITE_LADDER = registerBlock("netherite_ladder", new MBlock<>(LadderBlock::new, Optional.of(ladderProps.strength(NTR_MSH).getCopy())));
        NETHERITE_MESH = registerBlock("netherite_mesh", new MBlock<>(IronBarsBlock::new, Optional.of(meshProps.strength(NTR_MSH).getCopy())));
        NETHERITE_MESH_FENCE = registerBlock("netherite_mesh_fence", new MBlock<>(MMeshFenceBlock::new, Optional.of(meshProps.strength(NTR_MSH).getCopy())));
        NETHERITE_MESH_GATE = registerBlock("netherite_mesh_gate", new MBlock<>(props -> new MMeshGate(NETHERITE_SET.get(), props), Optional.of(trapdoorProps.strength(NTR_GRT).getCopy())));
        NETHERITE_MESH_TRAPDOOR = registerBlock("netherite_mesh_trapdoor", new MBlock<>(props -> new TrapDoorBlock(NETHERITE_SET.get(), props), Optional.of(trapdoorProps.strength(NTR_GRT).getCopy())));
        NETHERITE_MESH_DOOR = registerBlock("netherite_mesh_door", new MBlock<>(props -> new DoorBlock(NETHERITE_SET.get(), props), Optional.of(doorProps.strength(NTR_GRT).getCopy())));
        NETHERITE_GRATE = registerBlock("netherite_grate", new MBlock<>(MGrateBlock::new, Optional.of(grateProps.strength(NTR_GRT).getCopy())));
        NETHERITE_LAMP = registerBlock("netherite_lamp", new MBlock<>(RedstoneLampBlock::new, Optional.of(lampProps.strength(NTR_LNT).getCopy())));
        NETHERITE_BUTTON = registerBlock("netherite_button", new MBlock<>(props -> new ButtonBlock(NETHERITE_SET.get(), 20, props), Optional.of(buttonProps.strength(NTR_GRT).getCopy())));
        NETHERITE_PRESSURE_PLATE = registerBlock("netherite_pressure_plate", new MBlock<>(props -> new PressurePlateBlock(NETHERITE_SET.get(), props), Optional.of(buttonProps.strength(NTR_GRT).getCopy())));

        NETHERITE_GLASS = registerBlock("netherite_glass", new MBlock<>(TransparentBlock::new, Optional.of(glassProps.strength(NTR_MSH).getCopy())));
        NETHERITE_GLASS_PANE = registerBlock("netherite_glass_pane", new MBlock<>(IronBarsBlock::new, Optional.of(glassProps.strength(NTR_MSH).getCopy())));
        NETHERITE_TINTED_GLASS = registerBlock("netherite_tinted_glass", new MBlock<>(TintedGlassBlock::new, Optional.of(glassProps.strength(NTR_GRT).getCopy())));

        INFERNAL_TORCH = registerBlock("infernal_torch", new MBlock<>(props -> new TorchBlock(MetallicsParticleTypes.INFERNAL_FLAME.get(), props), Optional.of(torchProps.getCopy())));
        INFERNAL_WALL_TORCH = registerBlock("infernal_wall_torch", new MBlock<>(props -> new WallTorchBlock(MetallicsParticleTypes.INFERNAL_FLAME.get(), props), Optional.of(torchProps.getCopy())));
        INFERNAL_CAMPFIRE = registerBlock("infernal_campfire", new MBlock<>(props -> new MCampfireBlock(1, MetallicsParticleTypes.INFERNAL_EMBER.get(), props), Optional.of(campfireProps.getCopy())));
        INFERNAL_JACK_O_LANTERN = registerBlock("infernal_jack_o_lantern", new MBlock<>(CarvedPumpkinBlock::new, Optional.of(jackOLanternProps.getCopy())));

        //Register stuff here ▲▲▲

        BLOCKS.register();

        if(registeredBlockCount != MBlock.blockCount) {
            Metallics.LOGGER.warn("Count mismatch! {}/{} blocks registered!", MBlock.blockCount, registeredBlockCount);
        } else {
            Metallics.LOGGER.info("Registered {} blocks...", registeredBlockCount);
        }
    }

    public static void postInit() {
        registerBrushable(Blocks.COPPER_BLOCK, BRUSHING_COPPER_BLOCK.get());
        registerBrushable(IRON_PLATED_BLOCK.get(), BRUSHING_IRON_BLOCK.get());
        registerBrushable(BLUE_IRON_PLATED_BLOCK.get(), BRUSHING_BLUE_IRON_BLOCK.get());
        registerBrushable(GOLD_PLATED_BLOCK.get(), BRUSHING_GOLD_BLOCK.get());
        registerBrushable(NETHERITE_PLATED_BLOCK.get(), BRUSHING_NETHERITE_BLOCK.get());
        registerBrushable(COPPER_SLAB.get(), BRUSHING_COPPER_SLAB.get());
        registerBrushable(IRON_SLAB.get(), BRUSHING_IRON_SLAB.get());
        registerBrushable(BLUE_IRON_SLAB.get(), BRUSHING_BLUE_IRON_SLAB.get());
        registerBrushable(GOLD_SLAB.get(), BRUSHING_GOLD_SLAB.get());
        registerBrushable(NETHERITE_SLAB.get(), BRUSHING_NETHERITE_SLAB.get());
    }

    private static void registerBrushable(Block block, Block brushable) {
        BRUSHABLE_MAP.put(block, brushable);
    }

    public static boolean hasBrushable(Block block) {
        return BRUSHABLE_MAP.containsKey(block);
    }

    public static Block getBrushable(Block block) {
        return BRUSHABLE_MAP.get(block);
    }

    public static void oxidizationInit() {

        //Post registration stuff here ▼▼▼
        BRUSHED_COPPER_BLOCKS = new WeatheringCopperBlocks(
                BRUSHED_COPPER_BLOCK.get(),
                EXPOSED_BRUSHED_COPPER_BLOCK.get(),
                WEATHERED_BRUSHED_COPPER_BLOCK.get(),
                WEATHERED_OXIDIZED_COPPER_BLOCK.get(),
                WAXED_BRUSHED_COPPER_BLOCK.get(),
                WAXED_EXPOSED_BRUSHED_COPPER_BLOCK.get(),
                WAXED_WEATHERED_BRUSHED_COPPER_BLOCK.get(),
                WAXED_WEATHERED_OXIDIZED_COPPER_BLOCK.get()
        );

        BRUSHED_COPPER_SLABS = new WeatheringCopperBlocks(
                BRUSHED_COPPER_SLAB.get(),
                EXPOSED_BRUSHED_COPPER_SLAB.get(),
                WEATHERED_BRUSHED_COPPER_SLAB.get(),
                WEATHERED_OXIDIZED_COPPER_SLAB.get(),
                WAXED_BRUSHED_COPPER_SLAB.get(),
                WAXED_EXPOSED_BRUSHED_COPPER_SLAB.get(),
                WAXED_WEATHERED_BRUSHED_COPPER_SLAB.get(),
                WAXED_WEATHERED_OXIDIZED_COPPER_SLAB.get()
        );

        COPPER_MESHES = new WeatheringCopperBlocks(
                COPPER_MESH.get(),
                EXPOSED_COPPER_MESH.get(),
                WEATHERED_COPPER_MESH.get(),
                OXIDIZED_COPPER_MESH.get(),
                WAXED_COPPER_MESH.get(),
                WAXED_EXPOSED_COPPER_MESH.get(),
                WAXED_WEATHERED_COPPER_MESH.get(),
                WAXED_OXIDIZED_COPPER_MESH.get()
        );

        COPPER_MESH_FENCES = new WeatheringCopperBlocks(
                COPPER_MESH_FENCE.get(),
                EXPOSED_COPPER_MESH_FENCE.get(),
                WEATHERED_COPPER_MESH_FENCE.get(),
                OXIDIZED_COPPER_MESH_FENCE.get(),
                WAXED_COPPER_MESH_FENCE.get(),
                WAXED_EXPOSED_COPPER_MESH_FENCE.get(),
                WAXED_WEATHERED_COPPER_MESH_FENCE.get(),
                WAXED_OXIDIZED_COPPER_MESH_FENCE.get()
        );

        COPPER_MESH_GATES = new WeatheringCopperBlocks(
                COPPER_MESH_GATE.get(),
                EXPOSED_COPPER_MESH_GATE.get(),
                WEATHERED_COPPER_MESH_GATE.get(),
                OXIDIZED_COPPER_MESH_GATE.get(),
                WAXED_COPPER_MESH_GATE.get(),
                WAXED_EXPOSED_COPPER_MESH_GATE.get(),
                WAXED_WEATHERED_COPPER_MESH_GATE.get(),
                WAXED_OXIDIZED_COPPER_MESH_GATE.get()
        );

        COPPER_LADDERS = new WeatheringCopperBlocks(
                COPPER_LADDER.get(),
                EXPOSED_COPPER_LADDER.get(),
                WEATHERED_COPPER_LADDER.get(),
                OXIDIZED_COPPER_LADDER.get(),
                WAXED_COPPER_LADDER.get(),
                WAXED_EXPOSED_COPPER_LADDER.get(),
                WAXED_WEATHERED_COPPER_LADDER.get(),
                WAXED_OXIDIZED_COPPER_LADDER.get()
        );

        COPPER_MESH_DOORS = new WeatheringCopperBlocks(
                COPPER_MESH_DOOR.get(),
                EXPOSED_COPPER_MESH_DOOR.get(),
                WEATHERED_COPPER_MESH_DOOR.get(),
                OXIDIZED_COPPER_MESH_DOOR.get(),
                WAXED_COPPER_MESH_DOOR.get(),
                WAXED_EXPOSED_COPPER_MESH_DOOR.get(),
                WAXED_WEATHERED_COPPER_MESH_DOOR.get(),
                WAXED_OXIDIZED_COPPER_MESH_DOOR.get()
        );

        COPPER_MESH_TRAPDOORS = new WeatheringCopperBlocks(
                COPPER_MESH_TRAPDOOR.get(),
                EXPOSED_COPPER_MESH_TRAPDOOR.get(),
                WEATHERED_COPPER_MESH_TRAPDOOR.get(),
                OXIDIZED_COPPER_MESH_TRAPDOOR.get(),
                WAXED_COPPER_MESH_TRAPDOOR.get(),
                WAXED_EXPOSED_COPPER_MESH_TRAPDOOR.get(),
                WAXED_WEATHERED_COPPER_MESH_TRAPDOOR.get(),
                WAXED_OXIDIZED_COPPER_MESH_TRAPDOOR.get()
        );

        COPPER_SLABS = new WeatheringCopperBlocks(
                COPPER_SLAB.get(),
                EXPOSED_COPPER_SLAB.get(),
                WEATHERED_COPPER_SLAB.get(),
                OXIDIZED_COPPER_SLAB.get(),
                WAXED_COPPER_SLAB.get(),
                WAXED_EXPOSED_COPPER_SLAB.get(),
                WAXED_WEATHERED_COPPER_SLAB.get(),
                WAXED_OXIDIZED_COPPER_SLAB.get()
        );

        COPPER_LAMPS = new WeatheringCopperBlocks(
                COPPER_LAMP.get(),
                EXPOSED_COPPER_LAMP.get(),
                WEATHERED_COPPER_LAMP.get(),
                OXIDIZED_COPPER_LAMP.get(),
                WAXED_COPPER_LAMP.get(),
                WAXED_EXPOSED_COPPER_LAMP.get(),
                WAXED_WEATHERED_COPPER_LAMP.get(),
                WAXED_OXIDIZED_COPPER_LAMP.get()
        );

        COPPER_BUTTONS = new WeatheringCopperBlocks(
                COPPER_BUTTON.get(),
                EXPOSED_COPPER_BUTTON.get(),
                WEATHERED_COPPER_BUTTON.get(),
                OXIDIZED_COPPER_BUTTON.get(),
                WAXED_COPPER_BUTTON.get(),
                WAXED_EXPOSED_COPPER_BUTTON.get(),
                WAXED_WEATHERED_COPPER_BUTTON.get(),
                WAXED_OXIDIZED_COPPER_BUTTON.get()
        );

        COPPER_PRESSURE_PLATES = new WeatheringCopperBlocks(
                COPPER_PRESSURE_PLATE.get(),
                EXPOSED_COPPER_PRESSURE_PLATE.get(),
                WEATHERED_COPPER_PRESSURE_PLATE.get(),
                OXIDIZED_COPPER_PRESSURE_PLATE.get(),
                WAXED_COPPER_PRESSURE_PLATE.get(),
                WAXED_EXPOSED_COPPER_PRESSURE_PLATE.get(),
                WAXED_WEATHERED_COPPER_PRESSURE_PLATE.get(),
                WAXED_OXIDIZED_COPPER_PRESSURE_PLATE.get()
        );

        COPPER_GLASS_BLOCKS = new WeatheringCopperBlocks(
                COPPER_GLASS.get(),
                EXPOSED_COPPER_GLASS.get(),
                WEATHERED_COPPER_GLASS.get(),
                OXIDIZED_COPPER_GLASS.get(),
                WAXED_COPPER_GLASS.get(),
                WAXED_EXPOSED_COPPER_GLASS.get(),
                WAXED_WEATHERED_COPPER_GLASS.get(),
                WAXED_OXIDIZED_COPPER_GLASS.get()
        );

        COPPER_GLASS_PANES = new WeatheringCopperBlocks(
                COPPER_GLASS_PANE.get(),
                EXPOSED_COPPER_GLASS_PANE.get(),
                WEATHERED_COPPER_GLASS_PANE.get(),
                OXIDIZED_COPPER_GLASS_PANE.get(),
                WAXED_COPPER_GLASS_PANE.get(),
                WAXED_EXPOSED_COPPER_GLASS_PANE.get(),
                WAXED_WEATHERED_COPPER_GLASS_PANE.get(),
                WAXED_OXIDIZED_COPPER_GLASS_PANE.get()
        );

        COPPER_TINTED_GLASS_BLOCKS = new WeatheringCopperBlocks(
                COPPER_TINTED_GLASS.get(),
                EXPOSED_COPPER_TINTED_GLASS.get(),
                WEATHERED_COPPER_TINTED_GLASS.get(),
                OXIDIZED_COPPER_TINTED_GLASS.get(),
                WAXED_COPPER_TINTED_GLASS.get(),
                WAXED_EXPOSED_COPPER_TINTED_GLASS.get(),
                WAXED_WEATHERED_COPPER_TINTED_GLASS.get(),
                WAXED_OXIDIZED_COPPER_TINTED_GLASS.get()
        );
    }

    private static <T extends Block> RegistrySupplier<T> registerBlock(String name, MBlock<T> mBlock) {
        ResourceKey<Block> key = ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Metallics.MOD_ID, name));
        if(mBlock.feedInProps().isPresent()) {
            registeredBlockCount += 1;
            return BLOCKS.register(name, () -> mBlock.blockConstructor().apply(mBlock.feedInProps().orElseThrow().setId(key)));
        } else {
            registeredBlockCount += 1;
            return BLOCKS.register(name, () -> mBlock.blockConstructor().apply(BlockBehaviour.Properties.of().setId(key)));
        }
    }
}
