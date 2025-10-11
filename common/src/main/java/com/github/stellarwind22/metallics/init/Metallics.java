package com.github.stellarwind22.foundry_works.init;

import com.github.stellarwind22.foundry_works.content.MetallicsBlocks;
import com.github.stellarwind22.foundry_works.content.MetallicsItems;
import com.github.stellarwind22.foundry_works.content.MetallicsTabs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Metallics {

    public static final String MOD_ID = "foundry_works";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static void init() {

        MetallicsTabs.init();
        MetallicsBlocks.init();
        MetallicsItems.init();
    }
}
