package com.github.stellarwind22.metallics.object.blockentity;

import com.github.stellarwind22.metallics.content.MetallicsBlockEntityTypes;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class MetalWorkbenchMenu extends AbstractContainerMenu {

    public static final int INP_SLOT_1 = 0;
    public static final int INP_SLOT_2 = 1;
    public static final int INP_SLOT_3 = 2;
    public static final int FUEL_SLOT = 4;
    public static final int OUT_SLOT = 5;

    private final Container container;
    private final ContainerData containerData;
    private final Level level;

    public MetalWorkbenchMenu(int i, Inventory inventory) {
        super(MetallicsBlockEntityTypes.METAL_WORKBENCH_MENU.get(), i);
        this.container = new SimpleContainer(5);
        this.containerData = new SimpleContainerData(1);
        this.level = inventory.player.level();
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
