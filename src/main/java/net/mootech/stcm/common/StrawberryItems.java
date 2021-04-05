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

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.mootech.stcm.StrawberryTwirlCompanion;
import net.mootech.stcm.common.items.StrawberryBottleItem;
import net.mootech.stcm.common.items.StrawberryBucketItem;
import net.mootech.stcm.common.items.StrawberryItem;

public class StrawberryItems {
	private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, StrawberryTwirlCompanion.ID);
	public static final List<StrawberryItem> REGISTERED_ITEMS = new ArrayList<>();
	
	public static final List<StrawberryBucketItem> BUCKETS = new ArrayList<>();
	public static final List<StrawberryBottleItem> BOTTLES = new ArrayList<>();
	// TODO Combine items for tinting and also remove magic fluid buckets
	public static final StrawberryItem FLASK_ITEM = new StrawberryItem("empty_flask", new Properties().tab(StrawberryInitializer.ITEM_GROUP).rarity(Rarity.UNCOMMON).stacksTo(16));
    
	private static final Logger LOGGER = LogManager.getLogger();
	
    public static void init(IEventBus modEventBus) {
    	LOGGER.debug("Registering strawberry items");
    	for (StrawberryBucketItem bucket : BUCKETS) {
    		LOGGER.debug("Registering: " + bucket.getId());
    		ITEMS.register(bucket.getId(), () -> bucket);
    	}
    	for (StrawberryItem item : REGISTERED_ITEMS) {
    		LOGGER.debug("Registering: " + item.getID());
    		ITEMS.register(item.getID(), () -> item);
    	}
        ITEMS.register(modEventBus);
    }
}
