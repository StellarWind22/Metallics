package com.github.stellarwind22.metallics.content;

import com.github.stellarwind22.metallics.init.Metallics;
import com.github.stellarwind22.metallics.object.MGrateBlock;
import com.github.stellarwind22.metallics.object.MWeatheringLamp;
import com.github.stellarwind22.metallics.util.MBlock;
import com.github.stellarwind22.metallics.util.MBlockProps;
import com.github.stellarwind22.metallics.util.StrPair;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.particles.ParticleTypes;
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
    public static RegistrySupplier<Block> COPPER_MESH;
    public static RegistrySupplier<Block> EXPOSED_COPPER_MESH;
    public static RegistrySupplier<Block> WEATHERED_COPPER_MESH;
    public static RegistrySupplier<Block> OXIDIZED_COPPER_MESH;
    public static RegistrySupplier<Block> WAXED_COPPER_MESH;
    public static RegistrySupplier<Block> WAXED_EXPOSED_COPPER_MESH;
    public static RegistrySupplier<Block> WAXED_WEATHERED_COPPER_MESH;
    public static RegistrySupplier<Block> WAXED_OXIDIZED_COPPER_MESH;

    public static WeatheringCopperBlocks COPPER_MESHES;

    public static RegistrySupplier<Block> COPPER_CAMPFIRE;
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

    //Gold
    public static RegistrySupplier<Block> GOLD_CHAIN;
    public static RegistrySupplier<Block> GOLD_LANTERN;
    public static RegistrySupplier<Block> GOLD_BARS;
    public static RegistrySupplier<Block> GOLD_MESH;
    public static RegistrySupplier<Block> GOLD_GRATE;

    public static RegistrySupplier<Block> GOLD_TORCH;
    public static RegistrySupplier<Block> GOLD_WALL_TORCH;
    public static RegistrySupplier<Block> GOLD_CAMPFIRE;
    public static RegistrySupplier<Block> GOLD_JACK_O_LANTERN;
    public static RegistrySupplier<Block> GOLD_LAMP;

    //Iron
    public static RegistrySupplier<Block> IRON_MESH;
    public static RegistrySupplier<Block> IRON_GRATE;
    public static RegistrySupplier<Block> IRON_LAMP;

    //Netherite
    public static RegistrySupplier<Block> NETHERITE_CHAIN;
    public static RegistrySupplier<Block> NETHERITE_LANTERN;
    public static RegistrySupplier<Block> NETHERITE_BARS;
    public static RegistrySupplier<Block> NETHERITE_MESH;
    public static RegistrySupplier<Block> NETHERITE_GRATE;

    public static RegistrySupplier<Block> NETHERITE_TORCH;
    public static RegistrySupplier<Block> NETHERITE_WALL_TORCH;
    public static RegistrySupplier<Block> NETHERITE_CAMPFIRE;
    public static RegistrySupplier<Block> NETHERITE_JACK_O_LANTERN;
    public static RegistrySupplier<Block> NETHERITE_LAMP;

    static final StrPair CPR_STR = new StrPair(3.0F, 6.0F);
    static final StrPair IRN_STR = new StrPair(5.0F, 6.0F);
    static final StrPair GLD_STR = new StrPair(3.0F, 6.0F);
    static final StrPair NTR_STR = new StrPair(50.0F, 1200.0F);

    static final StrPair GRT_MULT = StrPair.of(1.0F);
    static final StrPair BAR_MULT = StrPair.of(1.0F);
    static final StrPair LNT_MULT = new StrPair(0.7F, 0.58F);
    static final StrPair MSH_MULT = StrPair.of(0.5F);
    
    static final StrPair CPR_LNT = CPR_STR.mult(LNT_MULT);
    static final StrPair IRN_LNT = IRN_STR.mult(LNT_MULT);
    static final StrPair GLD_LNT = GLD_STR.mult(LNT_MULT);
    static final StrPair NTR_LNT = NTR_STR.mult(LNT_MULT);



    public static void init() {
        BLOCKS = DeferredRegister.create(Metallics.MOD_ID, Registries.BLOCK);

        //Register stuff here ▼▼▼

        //Soul
        SOUL_JACK_O_LANTERN = registerBlock("soul_jack_o_lantern", new MBlock(
                props -> new CarvedPumpkinBlock(props.lightLevel((state) -> 10)),
                Optional.of(jackOLanternProps.getCopy())
        ));

        //Copper
        COPPER_MESH = registerBlock("copper_mesh", new MBlock(props -> new WeatheringCopperBarsBlock(WeatheringCopper.WeatherState.UNAFFECTED, props), Optional.of(meshProps.getCopy())));
        EXPOSED_COPPER_MESH = registerBlock("exposed_copper_mesh", new MBlock(props -> new WeatheringCopperBarsBlock(WeatheringCopper.WeatherState.EXPOSED, props), Optional.of(meshProps.getCopy())));
        WEATHERED_COPPER_MESH = registerBlock("weathered_copper_mesh", new MBlock(props -> new WeatheringCopperBarsBlock(WeatheringCopper.WeatherState.WEATHERED, props), Optional.of(meshProps.getCopy())));
        OXIDIZED_COPPER_MESH = registerBlock("oxidized_copper_mesh", new MBlock(props -> new WeatheringCopperBarsBlock(WeatheringCopper.WeatherState.OXIDIZED, props), Optional.of(meshProps.getCopy())));
        WAXED_COPPER_MESH = registerBlock("waxed_copper_mesh", new MBlock(IronBarsBlock::new, Optional.of(meshProps.getCopy())));
        WAXED_EXPOSED_COPPER_MESH = registerBlock("waxed_exposed_copper_mesh", new MBlock(IronBarsBlock::new, Optional.of(meshProps.getCopy())));
        WAXED_WEATHERED_COPPER_MESH = registerBlock("waxed_weathered_copper_mesh", new MBlock(IronBarsBlock::new, Optional.of(meshProps.getCopy())));
        WAXED_OXIDIZED_COPPER_MESH = registerBlock("waxed_oxidized_copper_mesh", new MBlock(IronBarsBlock::new, Optional.of(meshProps.getCopy())));

        COPPER_CAMPFIRE = registerBlock("copper_campfire", new MBlock(props -> new CampfireBlock(true, 1, props), Optional.of(campfireProps.getCopy())));
        COPPER_JACK_O_LANTERN = registerBlock("copper_jack_o_lantern", new MBlock(CarvedPumpkinBlock::new, Optional.of(jackOLanternProps.getCopy())));

        COPPER_LAMP = registerBlock("copper_lamp", new MBlock(props -> new MWeatheringLamp(props, WeatheringCopper.WeatherState.UNAFFECTED), Optional.of(lampProps.strength(CPR_LNT).getCopy())));
        EXPOSED_COPPER_LAMP = registerBlock("exposed_copper_lamp", new MBlock(props -> new MWeatheringLamp(props, WeatheringCopper.WeatherState.EXPOSED), Optional.of(lampProps.strength(CPR_LNT).getCopy())));
        WEATHERED_COPPER_LAMP = registerBlock("weathered_copper_lamp", new MBlock(props -> new MWeatheringLamp(props, WeatheringCopper.WeatherState.WEATHERED), Optional.of(lampProps.strength(CPR_LNT).getCopy())));
        OXIDIZED_COPPER_LAMP = registerBlock("oxidized_copper_lamp", new MBlock(props -> new MWeatheringLamp(props, WeatheringCopper.WeatherState.OXIDIZED), Optional.of(lampProps.strength(CPR_LNT).getCopy())));
        WAXED_COPPER_LAMP = registerBlock("waxed_copper_lamp", new MBlock(RedstoneLampBlock::new, Optional.of(lampProps.strength(CPR_LNT).getCopy())));
        WAXED_EXPOSED_COPPER_LAMP = registerBlock("waxed_exposed_copper_lamp", new MBlock(RedstoneLampBlock::new, Optional.of(lampProps.strength(CPR_LNT).getCopy())));
        WAXED_WEATHERED_COPPER_LAMP = registerBlock("waxed_weathered_copper_lamp", new MBlock(RedstoneLampBlock::new, Optional.of(lampProps.strength(CPR_LNT).getCopy())));
        WAXED_OXIDIZED_COPPER_LAMP = registerBlock("waxed_oxidized_copper_lamp", new MBlock(RedstoneLampBlock::new, Optional.of(lampProps.strength(CPR_LNT).getCopy())));

        //Iron
        IRON_MESH = registerBlock("iron_mesh", new MBlock(IronBarsBlock::new, Optional.of(meshProps.strength(IRN_STR).getCopy())));
        IRON_GRATE = registerBlock("iron_grate", new MBlock(MGrateBlock::new, Optional.of(grateProps.strength(IRN_STR).getCopy())));
        IRON_LAMP = registerBlock("iron_lamp", new MBlock(RedstoneLampBlock::new, Optional.of(lampProps.strength(IRN_LNT).getCopy())));

        //Gold
        GOLD_CHAIN = registerBlock("gold_chain", new MBlock(ChainBlock::new, Optional.of(chainProps.getCopy())));
        GOLD_LANTERN = registerBlock("gold_lantern", new MBlock(LanternBlock::new, Optional.of(lanternProps.strength(GLD_LNT).getCopy())));
        GOLD_BARS = registerBlock("gold_bars", new MBlock(IronBarsBlock::new, Optional.of(barsProps.strength(GLD_STR).getCopy())));
        GOLD_MESH = registerBlock("gold_mesh", new MBlock(IronBarsBlock::new, Optional.of(meshProps.strength(GLD_STR).getCopy())));
        GOLD_GRATE = registerBlock("gold_grate", new MBlock(MGrateBlock::new, Optional.of(grateProps.strength(GLD_STR).getCopy())));

        GOLD_TORCH = registerBlock("gold_torch", new MBlock(props -> new TorchBlock(ParticleTypes.SOUL_FIRE_FLAME, props), Optional.of(torchProps.getCopy())));
        GOLD_WALL_TORCH = registerBlock("gold_wall_torch", new MBlock(props -> new WallTorchBlock(ParticleTypes.SOUL_FIRE_FLAME, props), Optional.of(torchProps.getCopy())));
        GOLD_CAMPFIRE = registerBlock("gold_campfire", new MBlock(props -> new CampfireBlock(true, 1, props), Optional.of(campfireProps.getCopy())));
        GOLD_JACK_O_LANTERN = registerBlock("gold_jack_o_lantern", new MBlock(CarvedPumpkinBlock::new, Optional.of(jackOLanternProps.getCopy())));
        GOLD_LAMP = registerBlock("gold_lamp", new MBlock(RedstoneLampBlock::new, Optional.of(lampProps.strength(GLD_LNT).getCopy())));

        //Netherite
        NETHERITE_CHAIN = registerBlock("netherite_chain", new MBlock(ChainBlock::new, Optional.of(chainProps.getCopy())));
        NETHERITE_LANTERN = registerBlock("netherite_lantern", new MBlock(LanternBlock::new, Optional.of(lanternProps.strength(NTR_LNT).getCopy())));
        NETHERITE_BARS = registerBlock("netherite_bars", new MBlock(IronBarsBlock::new, Optional.of(barsProps.strength(NTR_STR).getCopy())));
        NETHERITE_MESH = registerBlock("netherite_mesh", new MBlock(IronBarsBlock::new, Optional.of(meshProps.strength(NTR_STR).getCopy())));
        NETHERITE_GRATE = registerBlock("netherite_grate", new MBlock(MGrateBlock::new, Optional.of(grateProps.strength(NTR_STR).getCopy())));

        NETHERITE_TORCH = registerBlock("netherite_torch", new MBlock(props -> new TorchBlock(ParticleTypes.SOUL_FIRE_FLAME, props), Optional.of(torchProps.getCopy())));
        NETHERITE_WALL_TORCH = registerBlock("netherite_wall_torch", new MBlock(props -> new WallTorchBlock(ParticleTypes.SOUL_FIRE_FLAME, props), Optional.of(torchProps.getCopy())));
        NETHERITE_CAMPFIRE = registerBlock("netherite_campfire", new MBlock(props -> new CampfireBlock(true, 1, props), Optional.of(campfireProps.getCopy())));
        NETHERITE_JACK_O_LANTERN = registerBlock("netherite_jack_o_lantern", new MBlock(CarvedPumpkinBlock::new, Optional.of(jackOLanternProps.getCopy())));
        NETHERITE_LAMP = registerBlock("netherite_lamp", new MBlock(RedstoneLampBlock::new, Optional.of(lampProps.strength(NTR_LNT).getCopy())));

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

    private static RegistrySupplier<Block> registerBlock(String name, MBlock mBlock) {
        ResourceKey<Block> key = ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Metallics.MOD_ID, name));
        if(mBlock.feedInProps().isPresent()) {
            return BLOCKS.register(name, () -> mBlock.blockConstructor().apply(mBlock.feedInProps().orElseThrow().setId(key)));
        } else {
            return BLOCKS.register(name, () -> mBlock.blockConstructor().apply(BlockBehaviour.Properties.of().setId(key)));
        }
    }
}
