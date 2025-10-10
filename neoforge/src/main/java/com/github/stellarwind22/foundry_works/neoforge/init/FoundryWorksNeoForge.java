package com.github.stellarwind22.foundry_works.neoforge.init;

import com.github.stellarwind22.foundry_works.init.FoundryWorks;
import com.github.stellarwind22.foundry_works.init.FoundryWorksClient;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLEnvironment;

@Mod(FoundryWorks.MOD_ID)
public final class FoundryWorksNeoForge {
    public FoundryWorksNeoForge() {
        // Run our common setup.
        FoundryWorks.init();

        if(FMLEnvironment.getDist() == Dist.CLIENT) {
            FoundryWorksClient.init();
        }
    }
}
