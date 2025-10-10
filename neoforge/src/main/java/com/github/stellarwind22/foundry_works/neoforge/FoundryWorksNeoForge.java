package com.github.stellarwind22.foundry_works.neoforge;

import com.github.stellarwind22.foundry_works.FoundryWorks;
import net.neoforged.fml.common.Mod;

@Mod(FoundryWorks.MOD_ID)
public final class FoundryWorksNeoForge {
    public FoundryWorksNeoForge() {
        // Run our common setup.
        FoundryWorks.init();
    }
}
