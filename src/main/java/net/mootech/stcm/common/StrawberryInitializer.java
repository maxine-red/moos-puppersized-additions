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
package net.mootech.stcm.common;

import net.mootech.stcm.StrawberryTwirlCompanion;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

@Mod.EventBusSubscriber(modid = StrawberryTwirlCompanion.ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class StrawberryInitializer {
    private static final Logger LOGGER = LogManager.getLogger();
    public static final ItemGroup ITEM_GROUP = new ItemGroup(StrawberryTwirlCompanion.ID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Blocks.DIRT);
        }
    };
	
	public static void init(IEventBus modEventBus) {
		LOGGER.debug("Initializing modded items/blocks/fluids");
        StrawberryItems.init(modEventBus);
        StrawberryFluids.init(modEventBus);
	}

}
