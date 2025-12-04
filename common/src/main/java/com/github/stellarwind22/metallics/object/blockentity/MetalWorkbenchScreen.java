package com.github.stellarwind22.metallics.object.blockentity;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class MetalWorkbenchScreen extends AbstractContainerScreen<MetalWorkbenchMenu> {

    public MetalWorkbenchScreen(MetalWorkbenchMenu metalWorkbenchMenu, Inventory inventory, Component component) {
        super(metalWorkbenchMenu, inventory, component);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float f, int i, int j) {

    }
}
