package com.github.stellarwind22.metallics.content;

import com.github.stellarwind22.metallics.init.Metallics;
import com.github.stellarwind22.metallics.object.blockentity.MBrushingBlockEntity;
import com.github.stellarwind22.metallics.object.blockentity.MCampfireBlockEntity;
import com.github.stellarwind22.metallics.object.blockentity.MetalWorkbenchBlockEntity;
import com.github.stellarwind22.metallics.object.blockentity.MetalWorkbenchMenu;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public class MetallicsBlockEntityTypes {

    public static Supplier<BlockEntityType<MCampfireBlockEntity>> CAMPFIRE;
    public static Supplier<BlockEntityType<MBrushingBlockEntity>> BRUSHABLE_BLOCK;
    public static Supplier<BlockEntityType<MetalWorkbenchBlockEntity>> METAL_WORKBENCH;

    public static Supplier<MenuType<MetalWorkbenchMenu>> METAL_WORKBENCH_MENU;

    private static DeferredRegister<MenuType<?>> MENU_TYPES;

    public static void init() {
        MENU_TYPES = DeferredRegister.create(Metallics.MOD_ID, Registries.MENU);

        METAL_WORKBENCH_MENU = registerMenuType("metal_workbench", MetalWorkbenchMenu::new);

        MENU_TYPES.register();
    }

    private static <T extends AbstractContainerMenu> RegistrySupplier<MenuType<T>> registerMenuType(String name, MenuType.MenuSupplier<T> supplier) {
        return MENU_TYPES.register(ResourceLocation.fromNamespaceAndPath(Metallics.MOD_ID, name),
                () -> new MenuType<>(supplier, FeatureFlags.VANILLA_SET)
        );
    }
}
