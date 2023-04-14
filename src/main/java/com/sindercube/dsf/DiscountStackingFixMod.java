package com.sindercube.dsf;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DiscountStackingFixMod implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("Discount Stacking Fix");

	@Override
	public void onInitialize() {
		LOGGER.info("Initialized!");
	}
}
