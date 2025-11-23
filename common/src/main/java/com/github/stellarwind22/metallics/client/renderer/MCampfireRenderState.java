package com.github.stellarwind22.metallics.client.renderer;

import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.core.Direction;

import java.util.Collections;
import java.util.List;

public class MCampfireRenderState extends BlockEntityRenderState {
    public List<ItemStackRenderState> items = Collections.emptyList();
    public Direction facing;

    public MCampfireRenderState() {
        this.facing = Direction.NORTH;
    }
}
