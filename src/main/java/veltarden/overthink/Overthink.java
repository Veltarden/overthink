package veltarden.overthink;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import veltarden.overthink.item.ModItemGroups;
import veltarden.overthink.item.ModItems;

public class Overthink implements ModInitializer {
	public static final String MOD_ID = "overthink";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		//ModBlocks.registerModBlocks();
		ModItems.registerModItems();
		ModItemGroups.registerModItemGroups();

		LOGGER.info("Metiendo webadas de overthink!1!");

	}
}