package com.github.stellarwind22.foundry_works.util;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.Optional;
import java.util.function.Function;

public record MBlock(Function<BlockBehaviour.Properties, Block> blockConstructor, Optional<BlockBehaviour.Properties> feedInProps) {

}
