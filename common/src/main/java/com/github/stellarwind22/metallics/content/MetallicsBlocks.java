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
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
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


    //Soul
    public static RegistrySupplier<Block> SOUL_JACK_O_LANTERN;

    //Copper
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

    //Iron
    public static RegistrySupplier<Block> IRON_PLATE_BLOCK;
    public static RegistrySupplier<Block> IRON_PLATE_SLAB;
    public static RegistrySupplier<Block> CUT_IRON_PLATE;
    public static RegistrySupplier<Block> CUT_IRON_STAIRS;
    public static RegistrySupplier<Block> CUT_IRON_SLAB;
    public static RegistrySupplier<Block> CHISELED_IRON_PLATE;
    public static RegistrySupplier<IronBarsBlock> IRON_MESH;
    public static RegistrySupplier<Block> IRON_MESH_FENCE;
    public static RegistrySupplier<Block> IRON_GRATE;
    public static RegistrySupplier<Block> IRON_LAMP;

    //Gold
    public static RegistrySupplier<Block> GOLD_CHAIN;
    public static RegistrySupplier<Block> GOLD_LANTERN;
    public static RegistrySupplier<IronBarsBlock> GOLD_BARS;
    public static RegistrySupplier<Block> GOLD_PLATE_BLOCK;
    public static RegistrySupplier<Block> GOLD_PLATE_SLAB;
    public static RegistrySupplier<Block> CUT_GOLD_PLATE;
    public static RegistrySupplier<Block> CUT_GOLD_STAIRS;
    public static RegistrySupplier<Block> CUT_GOLD_SLAB;
    public static RegistrySupplier<IronBarsBlock> GOLD_MESH;
    public static RegistrySupplier<MMeshFenceBlock> GOLD_MESH_FENCE;
    public static RegistrySupplier<MGrateBlock> GOLD_GRATE;

    public static RegistrySupplier<Block> GOLD_TORCH;
    public static RegistrySupplier<Block> GOLD_WALL_TORCH;
    public static RegistrySupplier<MCampfireBlock> GOLD_CAMPFIRE;
    public static RegistrySupplier<Block> GOLD_JACK_O_LANTERN;
    public static RegistrySupplier<Block> GOLD_LAMP;

    //Netherite
    public static RegistrySupplier<Block> NETHERITE_CHAIN;
    public static RegistrySupplier<Block> NETHERITE_LANTERN;
    public static RegistrySupplier<IronBarsBlock> NETHERITE_BARS;
    public static RegistrySupplier<Block> NETHERITE_PLATE_BLOCK;
    public static RegistrySupplier<Block> NETHERITE_PLATE_SLAB;
    public static RegistrySupplier<Block> CUT_NETHERITE_PLATE;
    public static RegistrySupplier<Block> CUT_NETHERITE_STAIRS;
    public static RegistrySupplier<Block> CUT_NETHERITE_SLAB;
    public static RegistrySupplier<IronBarsBlock> NETHERITE_MESH;
    public static RegistrySupplier<MMeshFenceBlock> NETHERITE_MESH_FENCE;
    public static RegistrySupplier<MGrateBlock> NETHERITE_GRATE;

    public static RegistrySupplier<Block> NETHERITE_TORCH;
    public static RegistrySupplier<Block> NETHERITE_WALL_TORCH;
    public static RegistrySupplier<MCampfireBlock> NETHERITE_CAMPFIRE;
    public static RegistrySupplier<Block> NETHERITE_JACK_O_LANTERN;
    public static RegistrySupplier<Block> NETHERITE_LAMP;

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



    public static void init() {
        BLOCKS = DeferredRegister.create(Metallics.MOD_ID, Registries.BLOCK);

        //Register stuff here ▼▼▼

        //Soul
        SOUL_JACK_O_LANTERN = registerBlock("soul_jack_o_lantern", new MBlock<>(
                props -> new CarvedPumpkinBlock(props.lightLevel((state) -> 10)),
                Optional.of(jackOLanternProps.getCopy())
        ));

        //Copper
        COPPER_MESH = registerBlock("copper_mesh", new MBlock<>(props -> new WeatheringCopperBarsBlock(WeatheringCopper.WeatherState.UNAFFECTED, props), Optional.of(meshProps.strength(CPR_MSH).getCopy())));
        EXPOSED_COPPER_MESH = registerBlock("exposed_copper_mesh", new MBlock<>(props -> new WeatheringCopperBarsBlock(WeatheringCopper.WeatherState.EXPOSED, props), Optional.of(meshProps.strength(CPR_MSH).getCopy())));
        WEATHERED_COPPER_MESH = registerBlock("weathered_copper_mesh", new MBlock<>(props -> new WeatheringCopperBarsBlock(WeatheringCopper.WeatherState.WEATHERED, props), Optional.of(meshProps.strength(CPR_MSH).getCopy())));
        OXIDIZED_COPPER_MESH = registerBlock("oxidized_copper_mesh", new MBlock<>(props -> new WeatheringCopperBarsBlock(WeatheringCopper.WeatherState.OXIDIZED, props), Optional.of(meshProps.strength(CPR_MSH).getCopy())));
        WAXED_COPPER_MESH = registerBlock("waxed_copper_mesh", new MBlock<>(IronBarsBlock::new, Optional.of(meshProps.strength(CPR_MSH).getCopy())));
        WAXED_EXPOSED_COPPER_MESH = registerBlock("waxed_exposed_copper_mesh", new MBlock<>(IronBarsBlock::new, Optional.of(meshProps.strength(CPR_MSH).getCopy())));
        WAXED_WEATHERED_COPPER_MESH = registerBlock("waxed_weathered_copper_mesh", new MBlock<>(IronBarsBlock::new, Optional.of(meshProps.strength(CPR_MSH).getCopy())));
        WAXED_OXIDIZED_COPPER_MESH = registerBlock("waxed_oxidized_copper_mesh", new MBlock<>(IronBarsBlock::new, Optional.of(meshProps.strength(CPR_MSH).getCopy())));

        COPPER_SLAB = registerBlock("copper_slab", new MBlock<>(props -> new WeatheringCopperSlabBlock(WeatheringCopper.WeatherState.UNAFFECTED, props), Optional.of(grateProps.strength(CPR_GRT).getCopy())));
        EXPOSED_COPPER_SLAB = registerBlock("exposed_copper_slab", new MBlock<>(props -> new WeatheringCopperSlabBlock(WeatheringCopper.WeatherState.EXPOSED, props), Optional.of(grateProps.strength(CPR_GRT).getCopy())));
        WEATHERED_COPPER_SLAB = registerBlock("weathered_copper_slab", new MBlock<>(props -> new WeatheringCopperSlabBlock(WeatheringCopper.WeatherState.WEATHERED, props), Optional.of(grateProps.strength(CPR_GRT).getCopy())));
        OXIDIZED_COPPER_SLAB = registerBlock("oxidized_copper_slab", new MBlock<>(props -> new WeatheringCopperSlabBlock(WeatheringCopper.WeatherState.OXIDIZED, props), Optional.of(grateProps.strength(CPR_GRT).getCopy())));
        WAXED_COPPER_SLAB = registerBlock("waxed_copper_slab", new MBlock<>(SlabBlock::new, Optional.of(grateProps.strength(CPR_GRT).getCopy())));
        WAXED_EXPOSED_COPPER_SLAB = registerBlock("waxed_exposed_copper_slab", new MBlock<>(SlabBlock::new, Optional.of(grateProps.strength(CPR_GRT).getCopy())));
        WAXED_WEATHERED_COPPER_SLAB = registerBlock("waxed_weathered_copper_slab", new MBlock<>(SlabBlock::new, Optional.of(grateProps.strength(CPR_GRT).getCopy())));
        WAXED_OXIDIZED_COPPER_SLAB = registerBlock("waxed_oxidized_copper_slab", new MBlock<>(SlabBlock::new, Optional.of(grateProps.strength(CPR_GRT).getCopy())));

        COPPER_MESH_FENCE = registerBlock("copper_mesh_fence", new MBlock<>(props -> new MWeatheringMeshFenceBlock(props, WeatheringCopper.WeatherState.UNAFFECTED), Optional.of(meshProps.strength(CPR_MSH).getCopy())));
        EXPOSED_COPPER_MESH_FENCE = registerBlock("exposed_copper_mesh_fence", new MBlock<>(props -> new MWeatheringMeshFenceBlock(props, WeatheringCopper.WeatherState.EXPOSED), Optional.of(meshProps.strength(CPR_MSH).getCopy())));
        WEATHERED_COPPER_MESH_FENCE = registerBlock("weathered_copper_mesh_fence", new MBlock<>(props -> new MWeatheringMeshFenceBlock(props, WeatheringCopper.WeatherState.WEATHERED), Optional.of(meshProps.strength(CPR_MSH).getCopy())));
        OXIDIZED_COPPER_MESH_FENCE = registerBlock("oxidized_copper_mesh_fence", new MBlock<>(props -> new MWeatheringMeshFenceBlock(props, WeatheringCopper.WeatherState.OXIDIZED), Optional.of(meshProps.strength(CPR_MSH).getCopy())));
        WAXED_COPPER_MESH_FENCE = registerBlock("waxed_copper_mesh_fence", new MBlock<>(MMeshFenceBlock::new, Optional.of(meshProps.strength(CPR_MSH).getCopy())));
        WAXED_EXPOSED_COPPER_MESH_FENCE = registerBlock("waxed_exposed_copper_mesh_fence", new MBlock<>(MMeshFenceBlock::new, Optional.of(meshProps.strength(CPR_MSH).getCopy())));
        WAXED_WEATHERED_COPPER_MESH_FENCE = registerBlock("waxed_weathered_copper_mesh_fence", new MBlock<>(MMeshFenceBlock::new, Optional.of(meshProps.strength(CPR_MSH).getCopy())));
        WAXED_OXIDIZED_COPPER_MESH_FENCE = registerBlock("waxed_oxidized_copper_mesh_fence", new MBlock<>(MMeshFenceBlock::new, Optional.of(meshProps.strength(CPR_MSH).getCopy())));

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

        //Iron
        IRON_PLATE_BLOCK = registerBlock("iron_plate_block", new MBlock<>(Block::new, Optional.of(grateProps.strength(IRN_GRT).getCopy())));
        IRON_PLATE_SLAB = registerBlock("iron_plate_slab", new MBlock<>(SlabBlock::new, Optional.of(grateProps.strength(IRN_GRT).getCopy())));
        CUT_IRON_PLATE = registerBlock("cut_iron_plate", new MBlock<>(Block::new, Optional.of(grateProps.strength(IRN_GRT).getCopy())));
        CUT_IRON_STAIRS = registerBlock("cut_iron_stairs", new MBlock<>(props -> new StairBlock(Blocks.IRON_BLOCK.defaultBlockState(), props), Optional.of(grateProps.strength(IRN_GRT).getCopy())));
        CUT_IRON_SLAB = registerBlock("cut_iron_slab", new MBlock<>(SlabBlock::new, Optional.of(grateProps.strength(IRN_GRT).getCopy())));
        CHISELED_IRON_PLATE = registerBlock("chiseled_iron_plate", new MBlock<>(Block::new, Optional.of(grateProps.strength(IRN_GRT).getCopy())));
        IRON_MESH = registerBlock("iron_mesh", new MBlock<>(IronBarsBlock::new, Optional.of(meshProps.strength(IRN_MSH).getCopy())));
        IRON_MESH_FENCE = registerBlock("iron_mesh_fence", new MBlock<>(MMeshFenceBlock::new, Optional.of(meshProps.strength(IRN_MSH).getCopy())));
        IRON_GRATE = registerBlock("iron_grate", new MBlock<>(MGrateBlock::new, Optional.of(grateProps.strength(IRN_GRT).getCopy())));
        IRON_LAMP = registerBlock("iron_lamp", new MBlock<>(RedstoneLampBlock::new, Optional.of(lampProps.strength(IRN_LNT).getCopy())));

        //Gold
        GOLD_CHAIN = registerBlock("gold_chain", new MBlock<>(ChainBlock::new, Optional.of(chainProps.getCopy())));
        GOLD_LANTERN = registerBlock("gold_lantern", new MBlock<>(LanternBlock::new, Optional.of(lanternProps.strength(GLD_LNT).getCopy())));
        GOLD_BARS = registerBlock("gold_bars", new MBlock<>(IronBarsBlock::new, Optional.of(barsProps.strength(GLD_STR).getCopy())));
        GOLD_PLATE_BLOCK = registerBlock("gold_plate_block", new MBlock<>(Block::new, Optional.of(grateProps.strength(GLD_GRT).getCopy())));
        GOLD_PLATE_SLAB = registerBlock("gold_plate_slab", new MBlock<>(SlabBlock::new, Optional.of(grateProps.strength(GLD_GRT).getCopy())));
        CUT_GOLD_PLATE = registerBlock("cut_gold_plate", new MBlock<>(Block::new, Optional.of(grateProps.strength(GLD_GRT).getCopy())));
        CUT_GOLD_STAIRS = registerBlock("cut_gold_stairs", new MBlock<>(props -> new StairBlock(Blocks.GOLD_BLOCK.defaultBlockState(), props), Optional.of(grateProps.strength(GLD_GRT).getCopy())));
        CUT_GOLD_SLAB = registerBlock("cut_gold_slab", new MBlock<>(SlabBlock::new, Optional.of(grateProps.strength(GLD_GRT).getCopy())));
        GOLD_MESH = registerBlock("gold_mesh", new MBlock<>(IronBarsBlock::new, Optional.of(meshProps.strength(GLD_MSH).getCopy())));
        GOLD_MESH_FENCE = registerBlock("gold_mesh_fence", new MBlock<>(MMeshFenceBlock::new, Optional.of(meshProps.strength(GLD_MSH).getCopy())));
        GOLD_GRATE = registerBlock("gold_grate", new MBlock<>(MGrateBlock::new, Optional.of(grateProps.strength(GLD_GRT).getCopy())));

        GOLD_TORCH = registerBlock("gold_torch", new MBlock<>(props -> new TorchBlock(MetallicsParticleTypes.GOLD_FLAME.get(), props), Optional.of(torchProps.getCopy())));
        GOLD_WALL_TORCH = registerBlock("gold_wall_torch", new MBlock<>(props -> new WallTorchBlock(MetallicsParticleTypes.GOLD_FLAME.get(), props), Optional.of(torchProps.getCopy())));
        GOLD_CAMPFIRE = registerBlock("gold_campfire", new MBlock<>(props -> new MCampfireBlock(1, MetallicsParticleTypes.GOLD_EMBER.get(), props), Optional.of(campfireProps.getCopy())));
        GOLD_JACK_O_LANTERN = registerBlock("gold_jack_o_lantern", new MBlock<>(CarvedPumpkinBlock::new, Optional.of(jackOLanternProps.getCopy())));
        GOLD_LAMP = registerBlock("gold_lamp", new MBlock<>(RedstoneLampBlock::new, Optional.of(lampProps.strength(GLD_LNT).getCopy())));

        //Netherite
        NETHERITE_CHAIN = registerBlock("netherite_chain", new MBlock<>(ChainBlock::new, Optional.of(chainProps.getCopy())));
        NETHERITE_LANTERN = registerBlock("netherite_lantern", new MBlock<>(LanternBlock::new, Optional.of(lanternProps.strength(NTR_LNT).getCopy())));
        NETHERITE_BARS = registerBlock("netherite_bars", new MBlock<>(IronBarsBlock::new, Optional.of(barsProps.strength(NTR_STR).getCopy())));
        NETHERITE_PLATE_BLOCK = registerBlock("netherite_plate_block", new MBlock<>(Block::new, Optional.of(grateProps.strength(NTR_GRT).getCopy())));
        NETHERITE_PLATE_SLAB = registerBlock("netherite_plate_slab", new MBlock<>(SlabBlock::new, Optional.of(grateProps.strength(NTR_GRT).getCopy())));
        CUT_NETHERITE_PLATE = registerBlock("cut_netherite_plate", new MBlock<>(Block::new, Optional.of(grateProps.strength(NTR_GRT).getCopy())));
        CUT_NETHERITE_STAIRS = registerBlock("cut_netherite_stairs", new MBlock<>(props -> new StairBlock(Blocks.NETHERITE_BLOCK.defaultBlockState(), props), Optional.of(grateProps.strength(NTR_GRT).getCopy())));
        CUT_NETHERITE_SLAB = registerBlock("cut_netherite_slab", new MBlock<>(SlabBlock::new, Optional.of(grateProps.strength(NTR_GRT).getCopy())));
        NETHERITE_MESH = registerBlock("netherite_mesh", new MBlock<>(IronBarsBlock::new, Optional.of(meshProps.strength(NTR_MSH).getCopy())));
        NETHERITE_MESH_FENCE = registerBlock("netherite_mesh_fence", new MBlock<>(MMeshFenceBlock::new, Optional.of(meshProps.strength(NTR_MSH).getCopy())));
        NETHERITE_GRATE = registerBlock("netherite_grate", new MBlock<>(MGrateBlock::new, Optional.of(grateProps.strength(NTR_GRT).getCopy())));

        NETHERITE_TORCH = registerBlock("netherite_torch", new MBlock<>(props -> new TorchBlock(MetallicsParticleTypes.NETHERITE_FLAME.get(), props), Optional.of(torchProps.getCopy())));
        NETHERITE_WALL_TORCH = registerBlock("netherite_wall_torch", new MBlock<>(props -> new WallTorchBlock(MetallicsParticleTypes.NETHERITE_FLAME.get(), props), Optional.of(torchProps.getCopy())));
        NETHERITE_CAMPFIRE = registerBlock("netherite_campfire", new MBlock<>(props -> new MCampfireBlock(1, MetallicsParticleTypes.NETHERITE_EMBER.get(), props), Optional.of(campfireProps.getCopy())));
        NETHERITE_JACK_O_LANTERN = registerBlock("netherite_jack_o_lantern", new MBlock<>(CarvedPumpkinBlock::new, Optional.of(jackOLanternProps.getCopy())));
        NETHERITE_LAMP = registerBlock("netherite_lamp", new MBlock<>(RedstoneLampBlock::new, Optional.of(lampProps.strength(NTR_LNT).getCopy())));

        //Register stuff here ▲▲▲

        BLOCKS.register();
    }

    public static void postRegisterInit() {

        //Post registration stuff here ▼▼▼
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
    }

    private static <T extends Block> RegistrySupplier<T> registerBlock(String name, MBlock<T> mBlock) {
        ResourceKey<Block> key = ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Metallics.MOD_ID, name));
        if(mBlock.feedInProps().isPresent()) {
            return BLOCKS.register(name, () -> mBlock.blockConstructor().apply(mBlock.feedInProps().orElseThrow().setId(key)));
        } else {
            return BLOCKS.register(name, () -> mBlock.blockConstructor().apply(BlockBehaviour.Properties.of().setId(key)));
        }
    }
}
