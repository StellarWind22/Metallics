package com.github.stellarwind22.metallics.object.blockentity;

import com.github.stellarwind22.metallics.content.MetallicsBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class MetalWorkbenchBlockEntity extends BaseContainerBlockEntity {

    private NonNullList<ItemStack> items;
    private int heat;

    public MetalWorkbenchBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(MetallicsBlockEntityTypes.METAL_WORKBENCH.get(), blockPos, blockState);
    }

    @Override
    protected @NotNull Component getDefaultName() {
        return Component.translatable("block.metallics.metal_workbench");
    }

    @Override
    protected @NotNull NonNullList<ItemStack> getItems() {
        return this.items;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> nonNullList) {
        this.items = nonNullList;
    }

    public boolean isLit() {
        return this.heat > 0;
    }

    @Override
    protected @NotNull AbstractContainerMenu createMenu(int i, Inventory inventory) {
        return new MetalWorkbenchMenu(i, inventory);
    }

    @Override
    public int getContainerSize() {
        return this.items.size();
    }

    public void setItem(int slot, ItemStack itemStack) {

        ItemStack itemStack2 = this.items.get(slot);
        boolean bl = !itemStack.isEmpty() && ItemStack.isSameItemSameComponents(itemStack2, itemStack);
        this.items.set(slot, itemStack);
        itemStack.limitSize(this.getMaxStackSize(itemStack));
        if (slot == 0 && !bl) {
            Level var6 = this.level;
            if (var6 instanceof ServerLevel) {
                this.setChanged();
            }
        }

    }
}
