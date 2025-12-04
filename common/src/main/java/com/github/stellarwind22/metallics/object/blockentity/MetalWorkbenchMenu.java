package com.github.stellarwind22.metallics.object.blockentity;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MetalWorkbenchMenu extends AbstractContainerMenu {

    public static final int INP_SLOT_1 = 0;
    public static final int INP_SLOT_2 = 1;
    public static final int INP_SLOT_3 = 2;
    public static final int FUEL_SLOT = 4;
    public static final int OUT_SLOT = 5;

    protected MetalWorkbenchMenu(@Nullable MenuType<?> menuType, int i) {
        super(menuType, i);
    }

    @Override
    public @NotNull ItemStack quickMoveStack(Player player, int i) {
        return null;
    }

    @Override
    public boolean stillValid(Player player) {
        return false;
    }
}
