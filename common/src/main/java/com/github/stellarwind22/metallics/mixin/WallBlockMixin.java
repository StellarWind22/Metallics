package com.github.stellarwind22.metallics.mixin;

import com.github.stellarwind22.metallics.object.MMeshGate;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(net.minecraft.world.level.block.WallBlock.class)
public class WallBlockMixin {

    @Inject(method = "connectsTo", at = @At("HEAD"), cancellable = true)
    private void connectsTo(BlockState blockState, boolean bl, Direction direction, CallbackInfoReturnable<Boolean> cir) {
        if(blockState.getBlock() instanceof MMeshGate && MMeshGate.connectsToDirection(blockState, direction)) {
            cir.setReturnValue(true);
        }
    }
}
