package com.github.stellarwind22.metallics.neoforge.init;

import com.github.stellarwind22.metallics.init.Metallics;
import com.github.stellarwind22.metallics.init.MetallicsClient;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLEnvironment;

@Mod(Metallics.MOD_ID)
public final class MetallicsNeoForge {
    public MetallicsNeoForge() {
        // Run our common setup.
        Metallics.init();

        if(FMLEnvironment.getDist() == Dist.CLIENT) {
            MetallicsClient.init();
        }
    }
}
