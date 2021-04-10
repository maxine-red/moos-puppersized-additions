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
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.mootech.stcm.StrawberryTwirlCompanion;
import net.mootech.stcm.common.items.StrawberryEdibleItem;
import net.mootech.stcm.common.items.StrawberryBucketItem;
import net.mootech.stcm.common.items.StrawberryItem;
import net.mootech.stcm.common.items.StrawberryJuiceItem;

public class StrawberryItems {
	private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, StrawberryTwirlCompanion.ID);
	public static final List<StrawberryItem> REGISTERED_ITEMS = new ArrayList<>();
	
	public static final List<StrawberryBucketItem> BUCKETS = new ArrayList<>();
	
	public static final StrawberryItem GLASS_FLASK = new StrawberryItem("glass_flask");
	public static final StrawberryItem GLASS_JAR = new StrawberryItem("glass_jar");
	public static final StrawberryItem GELATIN = new StrawberryItem("gelatin");
	public static final StrawberryItem BEES_WAX = new StrawberryItem("bees_wax", new Item.Properties().tab(StrawberryInitializer.ITEM_GROUP), 400, "Bee's Wax");
	public static final StrawberryEdibleItem SALT = new StrawberryEdibleItem("salt", new Item.Properties().tab(ItemGroup.TAB_FOOD).food(StrawberryFoods.SALT));
	public static final StrawberryItem WET_APPLE_PULP = new StrawberryItem("wet_apple_pup");
	public static final StrawberryItem DRYT_APPLE_PULP = new StrawberryItem("dry_apple_pup");
	public static final StrawberryItem UNPREPARED_APPLE_LEATHER = new StrawberryItem("unprepared_apple_leather");
	
	// TODO: work over jam items and also work over recipes (vanilla based and integrations) (it's 1 to 1 flask, crop, create integration is then 3 for a bucket)
	// melon and sweet berry are always double crop
	// Change texture for chorus fruit
	// additionMod = 0.85 * craftAmount * hunger / fixedJuiceHunger
	// additionMod is multiplied with stauration modifier from crop
	// Make a subclass for melon and sweet berry, that uses two to craft and uses above formula
	// Add a class for golden carrot, to add short amount of night vision
	// add uncommon rarity to rare crop juices/jams and jellies
	// jars can hold 500mB

	public static final List<StrawberryJuiceItem> JUICES = new ArrayList<>();
	public static final StrawberryJuiceItem APPLE_JUICE = new StrawberryJuiceItem("apple_juice", StrawberryFluids.APPLE_COLOR, StrawberryFoods.APPLE_JUICE, Items.APPLE);
	public static final StrawberryJuiceItem GOLDEN_APPLE_JUICE = new StrawberryJuiceItem("golden_apple_juice", StrawberryFluids.GOLDEN_APPLE_COLOR,  new Item.Properties().tab(ItemGroup.TAB_FOOD).stacksTo(16).craftRemainder(StrawberryItems.GLASS_FLASK).food(StrawberryFoods.GOLDEN_APPLE_JUICE).rarity(Rarity.UNCOMMON), Items.GOLDEN_APPLE);
	public static final StrawberryJuiceItem MELON_JUICE = new StrawberryJuiceItem("melon_juice", StrawberryFluids.MELON_COLOR, StrawberryFoods.MELON_JUICE, Items.MELON_SLICE, 2);
	public static final StrawberryJuiceItem CHORUS_JUICE = new StrawberryJuiceItem("chorus_juice", StrawberryFluids.CHORUS_COLOR, StrawberryFoods.CHORUS_JUICE, Items.CHORUS_FRUIT);
	public static final StrawberryJuiceItem SWEET_BERRY_JUICE = new StrawberryJuiceItem("sweet_berry_juice", StrawberryFluids.SWEET_BERRY_COLOR, StrawberryFoods.SWEET_BERRY_JUICE, Items.SWEET_BERRIES, 2);
	
	public static final StrawberryJuiceItem CARROT_JUICE = new StrawberryJuiceItem("carrot_juice", StrawberryFluids.CARROT_COLOR, StrawberryFoods.CARROT_JUICE, Items.CARROT);
	public static final StrawberryJuiceItem GOLDEN_CARROT_JUICE = new StrawberryJuiceItem("golden_carrot_juice", StrawberryFluids.GOLDEN_CARROT_COLOR, new Item.Properties().tab(ItemGroup.TAB_FOOD).stacksTo(16).craftRemainder(StrawberryItems.GLASS_FLASK).food(StrawberryFoods.GOLDEN_CARROT_JUICE).rarity(Rarity.UNCOMMON), Items.GOLDEN_CARROT);
    
	private static final Logger LOGGER = LogManager.getLogger();
	
    public static void init(IEventBus modEventBus) {
    	LOGGER.debug("Registering strawberry items");
    	for (StrawberryBucketItem bucket : BUCKETS) {
    		LOGGER.debug("Registering: " + bucket.getId());
    		ITEMS.register(bucket.getId(), () -> bucket);
    	}
    	for (StrawberryItem item : REGISTERED_ITEMS) {
    		LOGGER.debug("Registering: " + item.getId());
    		ITEMS.register(item.getId(), () -> item);
    	}
        ITEMS.register(modEventBus);
    }
}
