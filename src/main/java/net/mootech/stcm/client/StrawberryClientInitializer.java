/**
 * Copyright 2021 Maxine Red
 * This file is part of Strawberry Twirl Companion.
 *
 * Strawberry Twirl Companion is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Strawberry Twirl Companion is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Strawberry Twirl Companion.  If not, see <https://www.gnu.org/licenses/>.
 */
package net.mootech.stcm.client;

import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.mootech.stcm.StrawberryTwirlCompanion;
import net.mootech.stcm.common.StrawberryInitializer;
import net.mootech.stcm.common.items.StrawberryBucketItem;

@Mod.EventBusSubscriber(modid = StrawberryTwirlCompanion.ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class StrawberryClientInitializer {
    
	private static final Logger LOGGER = LogManager.getLogger();
	@SubscribeEvent
	public static void registerItemColor(ColorHandlerEvent.Item event) {
		Set<StrawberryBucketItem> buckets = StrawberryInitializer.getRegisteredModBuckets(StrawberryTwirlCompanion.ID);
		buckets.forEach((bucket) -> {
    		LOGGER.debug("Registering color tinting for: " + bucket.getRegistryName().getPath());
    		event.getItemColors().register((stack, tintIndex) -> {
    			if (tintIndex == 1) {
    				return bucket.getColor();
    			}
    			else {
    				return 0xFFFFFFFF;
    			}
    		}, bucket);
		});
    	/*for (EdibleBottleItem bottle : StrawberryItems.JUICES) {
    		LOGGER.debug("Registering color tinting for: " + bottle.getId());
    		event.getItemColors().register((stack, tintIndex) -> {
    			if (tintIndex == 1) {
    				return bottle.getColor();
    			}
    			else {
    				return 0xFFFFFFFF;
    			}
    		}, bottle);
    	}*/
	}

}
