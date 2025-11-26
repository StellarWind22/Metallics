package com.github.stellarwind22.metallics.object;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MBrushingBlock extends BaseEntityBlock implements MBrushable {

    public static final MapCodec<MBrushingBlock> CODEC = RecordCodecBuilder.mapCodec((instance) -> instance.group(
            ExtraCodecs.POSITIVE_INT.fieldOf("tick_delay").forGetter(MBrushingBlock::tickDelay),
            ExtraCodecs.POSITIVE_INT.fieldOf("brushes_to_complete").forGetter(MBrushingBlock::brushesToComplete),
            ResourceLocation.CODEC.fieldOf("turns_into").forGetter(MBrushingBlock::getTurnsInto),
            BuiltInRegistries.SOUND_EVENT.byNameCodec().fieldOf("brush_sound").forGetter(MBrushingBlock::brushSound),
            BuiltInRegistries.SOUND_EVENT.byNameCodec().fieldOf("brush_completed_sound").forGetter(MBrushingBlock::brushCompletedSound),
            propertiesCodec()).apply(instance, MBrushingBlock::new));

    private final int tickDelay;
    private final int brushesToComplete;
    private final ResourceLocation turnsInto;
    private final SoundEvent brushSound;
    private final SoundEvent brushCompletedSound;

    private static final IntegerProperty DUSTED;

    public MBrushingBlock(int tickDelay, int brushesToComplete, ResourceLocation turnsInto, SoundEvent brushSound, SoundEvent brushCompletedSound, Properties properties) {
        super(properties);
        this.tickDelay = tickDelay;
        this.brushesToComplete = brushesToComplete;
        this.turnsInto = turnsInto;
        this.brushSound = brushSound;
        this.brushCompletedSound = brushCompletedSound;
        this.registerDefaultState(this.stateDefinition.any().setValue(DUSTED, 0));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(DUSTED);
    }

    @Override
    public int tickDelay() {
        return this.tickDelay;
    }

    @Override
    public int brushesToComplete() {
        return this.brushesToComplete;
    }

    @Override
    public Block getBrushableBlock() {
        return this;
    }

    @Override
    public ResourceLocation getTurnsInto() {
        return this.turnsInto;
    }

    @Override
    public SoundEvent brushSound() {
        return this.brushSound;
    }

    @Override
    public SoundEvent brushCompletedSound() {
        return this.brushCompletedSound;
    }

    @Override
    public Holder<Block> arch$holder() {
        return super.arch$holder();
    }

    @Override
    public void animateTick(BlockState blockState, Level level, BlockPos blockPos, RandomSource randomSource) {
        this.animateTickBrushable(blockState, level, blockPos, randomSource);
    }

    @Override
    public void onPlace(BlockState blockState, Level level, BlockPos blockPos, BlockState blockState2, boolean bl) {
        this.onPlaceBrushable(level, blockPos);
    }

    @Override
    protected @NotNull MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new MBrushingBlockEntity(blockPos, blockState);
    }

    @Override
    public void tick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
        this.tickBrushable(serverLevel, blockPos);
    }

    static {
        DUSTED = BlockStateProperties.DUSTED;
    }
}
