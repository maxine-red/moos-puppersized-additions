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

import net.mootech.stcm.StrawberryTwirlCompanion;
import net.mootech.stcm.common.StrawberryItems;
import net.mootech.stcm.common.fluids.VoidEssence;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@Mod.EventBusSubscriber(modid = StrawberryTwirlCompanion.ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class StrawberryClientInitializer {

	static final IItemColor VOID_ESSENCE_COLOR = (stack, tintIndex) -> {
		if (tintIndex == 0) {
			return VoidEssence.COLOR;
		}
		else {
			return 0xFFFFFFFF;
		}
	};
	@SubscribeEvent
	public static void registerItemColor(ColorHandlerEvent.Item event) {
		event.getItemColors().register(VOID_ESSENCE_COLOR, StrawberryItems.VOID_ESSENCE_BUCKET.get());
	}

}
