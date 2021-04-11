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
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.mootech.stcm.StrawberryTwirlCompanion;
import net.mootech.stcm.common.items.EdibleItem;
import net.mootech.stcm.common.items.JuiceBucketItem;
import net.mootech.stcm.common.items.StrawberryBucketItem;
import net.mootech.stcm.common.items.StrawberryItem;
import net.mootech.stcm.common.items.JuiceItem;
import net.mootech.stcm.common.items.StrawberryBlockItem;

public class StrawberryItems {
	private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, StrawberryTwirlCompanion.ID);
	
	private static final Item.Properties DEFAULT_PORPERTIES = new Item.Properties().tab(StrawberryInitializer.ITEM_GROUP);
	
	// Block items
	//public static final StrawberryBlockItem SALT_CRYSTAL = new StrawberryBlockItem("salt_crystal", StrawberryBlocks.SALT_CRYSTAL.get(), new Item.Properties().tab(StrawberryInitializer.ITEM_GROUP));
	
	public static final RegistryObject<Item> GLASS_FLASK = ITEMS.register("glass_flask", () -> new Item(DEFAULT_PORPERTIES));
	//public static final StrawberryItem GLASS_JAR = new StrawberryItem("glass_jar");
	//public static final StrawberryItem GELATIN = new StrawberryItem("gelatin");
	//public static final StrawberryItem BEES_WAX = new StrawberryItem("bees_wax", new Item.Properties().tab(StrawberryInitializer.ITEM_GROUP), 400, "Bee's Wax");
	//public static final EdibleItem SALT = new EdibleItem("salt", new Item.Properties().tab(ItemGroup.TAB_FOOD).food(StrawberryFoods.SALT));
	//public static final StrawberryItem WET_APPLE_PULP = new StrawberryItem("wet_apple_pulp");
	//public static final StrawberryItem DRYT_APPLE_PULP = new StrawberryItem("dry_apple_pulp");
	//public static final StrawberryItem UNPREPARED_APPLE_LEATHER = new StrawberryItem("unprepared_apple_leather");
	
	// TODO work over jam items and also work over recipes (vanilla based and integrations) (it's 1 to 1 flask, crop, create integration is then 3 for a bucket)
	// TODO melon and sweet berry are always double crop
	// TODO Change texture for chorus fruit
	// TODO add uncommon rarity to rare crop juices/jams and jellies
	// TODO jars can hold 500mB
	// TODO have vegetable oil bottles, to use in recipe
	// TODO add recipes for salt making

	/*public static final List<JuiceItem> JUICES = new ArrayList<>();
	public static final JuiceItem APPLE_JUICE = new JuiceItem("apple_juice", StrawberryFluids.APPLE_COLOR, StrawberryFoods.APPLE_JUICE, Items.APPLE);
	public static final JuiceItem GOLDEN_APPLE_JUICE = new JuiceItem("golden_apple_juice", StrawberryFluids.GOLDEN_APPLE_COLOR,  new Item.Properties().tab(ItemGroup.TAB_FOOD).stacksTo(16).craftRemainder(StrawberryItems.GLASS_FLASK).food(StrawberryFoods.GOLDEN_APPLE_JUICE).rarity(Rarity.RARE), Items.GOLDEN_APPLE);
	public static final JuiceItem MELON_JUICE = new JuiceItem("melon_juice", StrawberryFluids.MELON_COLOR, StrawberryFoods.MELON_JUICE, Items.MELON_SLICE, 2);
	public static final JuiceItem CHORUS_JUICE = new JuiceItem("chorus_juice", StrawberryFluids.CHORUS_COLOR, StrawberryFoods.CHORUS_JUICE, Items.CHORUS_FRUIT);
	public static final JuiceItem SWEET_BERRY_JUICE = new JuiceItem("sweet_berry_juice", StrawberryFluids.SWEET_BERRY_COLOR, StrawberryFoods.SWEET_BERRY_JUICE, Items.SWEET_BERRIES, 2);
	public static final JuiceItem CARROT_JUICE = new JuiceItem("carrot_juice", StrawberryFluids.CARROT_COLOR, StrawberryFoods.CARROT_JUICE, Items.CARROT);
	public static final JuiceItem GOLDEN_CARROT_JUICE = new JuiceItem("golden_carrot_juice", StrawberryFluids.GOLDEN_CARROT_COLOR, new Item.Properties().tab(ItemGroup.TAB_FOOD).stacksTo(16).craftRemainder(StrawberryItems.GLASS_FLASK).food(StrawberryFoods.GOLDEN_CARROT_JUICE).rarity(Rarity.UNCOMMON), Items.GOLDEN_CARROT);
 */
	private static final Logger LOGGER = LogManager.getLogger();
	
    public static void init(IEventBus modEventBus) {
    	LOGGER.debug("Registering strawberry items");
        ITEMS.register(modEventBus);
    }
}
