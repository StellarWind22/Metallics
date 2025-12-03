package com.github.stellarwind22.metallics.object;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class MetalWorkbenchBlockEntity extends AbstractContainerScreen<MetalWorkbenchMenu> {

    public MetalWorkbenchBlockEntity(MetalWorkbenchMenu metalWorkbenchMenu, Inventory inventory, Component component) {
        super(metalWorkbenchMenu, inventory, component);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float f, int i, int j) {

    }
}
