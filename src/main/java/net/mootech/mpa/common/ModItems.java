/**
 * Copyright 2021 Maxine Red
 * This file is part of Moo's Puppersized Additions.
 *
 * Moo's Puppersized Additions is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Moo's Puppersized Additions is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Moo's Puppersized Additions.  If not, see <https://www.gnu.org/licenses/>.
 */
package net.mootech.mpa.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.item.BlockItem;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.mootech.mpa.MoosPuppersizedAdditions;
import net.mootech.mpa.common.items.BurnAbleItem;
import net.mootech.mpa.common.items.JuiceItem;

public class ModItems {
	private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MoosPuppersizedAdditions.MOD_ID);
	
	private static final Item.Properties DEFAULT_PORPERTIES = new Item.Properties().tab(ModCommonInitializer.ITEM_GROUP);
	private static final Item.Properties DEFAULT_BUCKET_PORPERTIES = new Item.Properties().tab(ModCommonInitializer.ITEM_GROUP).stacksTo(1).craftRemainder(Items.BUCKET);
	
	// Block items
	public static final RegistryObject<BlockItem> SALT_CRYSTAL = ITEMS.register("salt_crystal", () -> new BlockItem(ModBlocks.SALT_CRYSTAL.get(), DEFAULT_PORPERTIES));
	public static final RegistryObject<BlockItem> SALT_BLOCK = ITEMS.register("salt_block", () -> new BlockItem(ModBlocks.SALT_BLOCK.get(), DEFAULT_PORPERTIES));
	public static final RegistryObject<BlockItem> SALT_SAND_ORE = ITEMS.register("salt_sand_ore", () -> new BlockItem(ModBlocks.SALT_SAND_ORE.get(), DEFAULT_PORPERTIES));
	public static final RegistryObject<BlockItem> SALT_STONE_ORE = ITEMS.register("salt_stone_ore", () -> new BlockItem(ModBlocks.SALT_STONE_ORE.get(), DEFAULT_PORPERTIES));
	
	// Simple items
	public static final RegistryObject<Item> GLASS_FLASK = ITEMS.register("glass_flask", () -> new Item(DEFAULT_PORPERTIES));
	public static final RegistryObject<Item> GLASS_JAR = ITEMS.register("glass_jar", () -> new Item(DEFAULT_PORPERTIES));
	public static final RegistryObject<Item> GELATIN = ITEMS.register("gelatin", () -> new Item(DEFAULT_PORPERTIES));
	public static final RegistryObject<Item> BEES_WAX = ITEMS.register("bees_wax", () -> new BurnAbleItem(DEFAULT_PORPERTIES, 400));
	public static final RegistryObject<Item> SALT = ITEMS.register("salt", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_FOOD).food(ModFoods.SALT)));
	public static final RegistryObject<Item> WET_APPLE_PULP = ITEMS.register("wet_apple_pulp", () -> new Item(DEFAULT_PORPERTIES));
	public static final RegistryObject<Item> DRYT_APPLE_PULP = ITEMS.register("dry_apple_pulp", () -> new Item(DEFAULT_PORPERTIES));
	public static final RegistryObject<Item> UNPREPARED_APPLE_LEATHER = ITEMS.register("unprepared_apple_leather", () -> new Item(DEFAULT_PORPERTIES));
	
	// Juices
	private static final Item.Properties DEFAULT_JUICE_PORPERTIES = new Item.Properties().tab(ItemGroup.TAB_FOOD).stacksTo(16);
	// TODO Need to get crafting remainder in here somehow
	public static final RegistryObject<Item> APPLE_JUICE = ITEMS.register("apple_juice", () -> new JuiceItem(DEFAULT_JUICE_PORPERTIES.food(ModFoods.APPLE_JUICE).craftRemainder(GLASS_FLASK.get()), false));
	
	// Bucket Items
	public static final RegistryObject<BucketItem> APPLE_JUICE_BUCKET = ITEMS.register("apple_juice_bucket", () -> new BucketItem(ModFluids.APPLE_JUICE, DEFAULT_BUCKET_PORPERTIES));
	public static final RegistryObject<BucketItem> SALTY_WATER_BUCKET = ITEMS.register("salty_water_bucket", () -> new BucketItem(ModFluids.SALTY_WATER, DEFAULT_BUCKET_PORPERTIES));
	
	// TODO use pupper salt color on salty wter bucket
	
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
