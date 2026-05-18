package com.github.stellarwind22.metallics.fabric.mixin;

import net.minecraft.world.level.block.state.properties.BlockSetType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Map;

@Mixin(BlockSetType.class)
public interface BlockSetTypeAccessor {

    @Accessor("TYPES")
    static Map<String, BlockSetType> metallics$getTypes() { throw new AssertionError(); }

    @Accessor("TYPES") @Mutable
    static void metallics$setTypes(Map<String, BlockSetType> types) { throw new AssertionError(); }
}
