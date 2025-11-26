package com.github.stellarwind22.metallics.mixin;

import com.github.stellarwind22.metallics.content.MetallicsBlocks;
import com.github.stellarwind22.metallics.object.MBrushable;
import com.github.stellarwind22.metallics.object.MBrushingBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BrushItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BrushItem.class)
public abstract class BrushItemMixin {

    @Invoker("calculateHitResult")
    abstract HitResult metallics$calculateHitResult(Player player);

    @Invoker("spawnDustParticles")
    abstract void metallics$spawnDustParticles(Level level, BlockHitResult result, BlockState state, Vec3 vec3, HumanoidArm humanoidArm);

    @Inject(method = "onUseTick",
    at = @At("HEAD"))
    public void onUseTick(Level level, LivingEntity livingEntity, ItemStack itemStack, int i, CallbackInfo ci) {

        BrushItem self = (BrushItem) (Object) this;

        if (i >= 0 && livingEntity instanceof Player player) {
            HitResult hitResult = metallics$calculateHitResult(player);
            if (hitResult instanceof BlockHitResult blockHitResult) {
                if (hitResult.getType() == HitResult.Type.BLOCK) {

                    BlockPos blockPos = blockHitResult.getBlockPos();
                    BlockState blockState = level.getBlockState(blockPos);
                    Block block = blockState.getBlock();

                    if(MetallicsBlocks.hasBrushable(block)) {
                        level.setBlock(blockPos, MetallicsBlocks.getBrushable(block).withPropertiesOf(blockState), 3);
                    }

                    if (block instanceof MBrushable brushable) {
                        int j = self.getUseDuration(itemStack, livingEntity) - i + 1;
                        boolean bl = j % 10 == 5;
                        if (bl) {
                            HumanoidArm humanoidArm = livingEntity.getUsedItemHand() == InteractionHand.MAIN_HAND ? player.getMainArm() : player.getMainArm().getOpposite();
                            if (blockState.shouldSpawnTerrainParticles() && blockState.getRenderShape() != RenderShape.INVISIBLE) {
                                metallics$spawnDustParticles(level, blockHitResult, blockState, livingEntity.getViewVector(0.0F), humanoidArm);
                            }

                            level.playSound(player, blockPos, brushable.brushSound(), SoundSource.BLOCKS);
                            if (level instanceof ServerLevel serverLevel) {
                                BlockEntity var16 = level.getBlockEntity(blockPos);
                            if (var16 instanceof MBrushingBlockEntity brushableBlockEntity) {
                                boolean bl2 = brushableBlockEntity.brush(brushable.brushesToComplete(), level.getGameTime(), serverLevel, blockHitResult.getDirection());
                                if (bl2) {
                                    EquipmentSlot equipmentSlot = itemStack.equals(player.getItemBySlot(EquipmentSlot.OFFHAND)) ? EquipmentSlot.OFFHAND : EquipmentSlot.MAINHAND;
                                    itemStack.hurtAndBreak(1, player, equipmentSlot);
                                }
                            }
                        }
                    }
                }
                }
            }
        }
    }
}
