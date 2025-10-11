package com.github.stellarwind22.metallics.content;

import com.github.stellarwind22.foundry_works.init.Metallics;
import com.github.stellarwind22.foundry_works.util.DeferredItem;
import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class MetallicsTabs {

    protected static DeferredRegister<CreativeModeTab> TABS;

    public static RegistrySupplier<CreativeModeTab> TAB;

    public static void init() {
        TABS = DeferredRegister.create(Metallics.MOD_ID, Registries.CREATIVE_MODE_TAB);

        //Register stuff here ▼▼▼

        TAB = registerTab("main", CreativeTabRegistry.create(Component.translatable("tab.foundry_works.main"), () -> new ItemStack(new DeferredItem<>(MetallicsItems.NETHERITE_NUGGET))));

        //Register stuff here ▲▲▲

        TABS.register();
    }

    private static RegistrySupplier<CreativeModeTab> registerTab(String name, CreativeModeTab tab) {
        return TABS.register(name, () -> tab);
    }
}
