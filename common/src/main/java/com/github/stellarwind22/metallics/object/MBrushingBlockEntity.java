package com.github.stellarwind22.metallics.object;

import com.github.stellarwind22.metallics.content.MetallicsBlockEntityTypes;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MBrushingBlockEntity extends BlockEntity {

    private int brushCount;
    private long brushCountResetsAtTick;
    private long coolDownEndsAtTick;
    @Nullable
    private Direction hitDirection;
    private Block turnsInto = null;

    public MBrushingBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(MetallicsBlockEntityTypes.BRUSHABLE_BLOCK.get(), blockPos, blockState);
    }

    public boolean brush(int maxBrushes, long l, ServerLevel serverLevel, Direction direction) {

        if (this.hitDirection == null) {
            this.hitDirection = direction;
        }

        this.brushCountResetsAtTick = l + 40L;
        if (l < this.coolDownEndsAtTick) {
            return false;
        } else {
            this.coolDownEndsAtTick = l + 10L;
            int i = this.getCompletionState();
            if (++this.brushCount >= maxBrushes) {
                this.brushingCompleted(serverLevel);
                return true;
            } else {
                serverLevel.scheduleTick(this.getBlockPos(), this.getBlockState().getBlock(), 2);
                int j = this.getCompletionState();
                if (i != j) {
                    BlockState blockState = this.getBlockState();
                    BlockState blockState2 = blockState.setValue(BlockStateProperties.DUSTED, j);
                    serverLevel.setBlock(this.getBlockPos(), blockState2, 3);
                }

                return false;
            }
        }
    }

    private void brushingCompleted(ServerLevel serverLevel) {
        BlockState blockState = this.getBlockState();
        serverLevel.levelEvent(3008, this.getBlockPos(), Block.getId(blockState));
        Block block = this.getBlockState().getBlock();
        Block block2;
        if (block instanceof MBrushable mBrushableBlock) {
            if(turnsInto == null) {
                turnsInto = serverLevel.registryAccess().lookup(Registries.BLOCK).orElseThrow().get(mBrushableBlock.getTurnsInto()).orElseThrow().value();
            }
            block2 = this.turnsInto;
        } else {
            block2 = Blocks.AIR;
        }
        serverLevel.setBlock(this.worldPosition, block2.withPropertiesOf(blockState), 3);
    }

    public void checkReset(ServerLevel serverLevel) {
        if (this.brushCount != 0 && serverLevel.getGameTime() >= this.brushCountResetsAtTick) {
            int i = this.getCompletionState();
            this.brushCount = Math.max(0, this.brushCount - 2);
            int j = this.getCompletionState();
            if (i != j) {
                serverLevel.setBlock(this.getBlockPos(), this.getBlockState().setValue(BlockStateProperties.DUSTED, j), 3);
            }
            this.brushCountResetsAtTick = serverLevel.getGameTime() + 4L;
        }

        if (this.brushCount == 0) {
            this.hitDirection = null;
            this.brushCountResetsAtTick = 0L;
            this.coolDownEndsAtTick = 0L;
        } else {
            serverLevel.scheduleTick(this.getBlockPos(), this.getBlockState().getBlock(), 2);
        }
    }

    public @NotNull CompoundTag getUpdateTag(HolderLookup.Provider provider) {
        return super.getUpdateTag(provider);
    }

    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    private int getCompletionState() {
        if (this.brushCount == 0) {
            return 0;
        } else if (this.brushCount < 3) {
            return 1;
        } else {
            return this.brushCount < 6 ? 2 : 3;
        }
    }
}
