package net.mootech.mpa.client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import net.mootech.mpa.MoosPuppersizedAdditions;

@Mod.EventBusSubscriber(modid = MoosPuppersizedAdditions.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModClientInitializer {
    
	private static final Logger LOGGER = LogManager.getLogger();

}
