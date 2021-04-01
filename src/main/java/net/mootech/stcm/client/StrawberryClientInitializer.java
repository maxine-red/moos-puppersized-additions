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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.mootech.stcm.StrawberryTwirlCompanion;
import net.mootech.stcm.common.StrawberryItems;
import net.mootech.stcm.common.fluids.magic.SoulEssenceFluid;
import net.mootech.stcm.common.fluids.magic.VoidEssenceFluid;
import net.mootech.stcm.common.items.StrawberryBucketItem;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@Mod.EventBusSubscriber(modid = StrawberryTwirlCompanion.ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class StrawberryClientInitializer {
    
	private static final Logger LOGGER = LogManager.getLogger();
	static final IItemColor VOID_ESSENCE_FLUID_COLOR = (stack, tintIndex) -> {
		if (tintIndex == 0) {
			return VoidEssenceFluid.COLOR;
		}
		else {
			return 0xFFFFFFFF;
		}
	};
	static final IItemColor SOUL_ESSENCE_FLUID_COLOR = (stack, tintIndex) -> {
		if (tintIndex == 0) {
			return SoulEssenceFluid.COLOR;
		}
		else {
			return 0xFFFFFFFF;
		}
	};
	@SubscribeEvent
	public static void registerItemColor(ColorHandlerEvent.Item event) {
    	for (StrawberryBucketItem bucket : StrawberryItems.BUCKETS) {
    		LOGGER.info("Registering: " + bucket.id());
    		event.getItemColors().register((stack, tintIndex) -> {
    			if (tintIndex == 0) {
    				return bucket.getColor();
    			}
    			else {
    				return 0xFFFFFFFF;
    			}
    		}, bucket);
    	}
	}

}
