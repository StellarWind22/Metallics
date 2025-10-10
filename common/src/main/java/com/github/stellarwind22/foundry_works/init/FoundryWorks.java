package com.github.stellarwind22.foundry_works.init;

import com.github.stellarwind22.foundry_works.content.FoundryWorksBlocks;
import com.github.stellarwind22.foundry_works.content.FoundryWorksItems;
import com.github.stellarwind22.foundry_works.content.FoundryWorksTabs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class FoundryWorks {

    public static final String MOD_ID = "foundry_works";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static void init() {

        FoundryWorksTabs.init();
        FoundryWorksBlocks.init();
        FoundryWorksItems.init();
    }
}
