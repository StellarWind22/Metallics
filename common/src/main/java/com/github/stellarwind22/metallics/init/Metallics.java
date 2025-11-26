package com.github.stellarwind22.metallics.init;

import com.github.stellarwind22.metallics.client.content.MetallicsParticleTypes;
import com.github.stellarwind22.metallics.content.MetallicsBlocks;
import com.github.stellarwind22.metallics.content.MetallicsItems;
import com.github.stellarwind22.metallics.content.MetallicsTabs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Metallics {

    public static final String MOD_ID = "metallics";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static void init() {

        LOGGER.info("Initializing common code...");

        MetallicsTabs.init();
        MetallicsParticleTypes.init();
        MetallicsBlocks.preInit();
        MetallicsBlocks.init();
        MetallicsBlocks.postInit();
        MetallicsItems.init();

        LOGGER.info("Metallics tabs/blocks/blockEntities/items registered!");
    }
}
