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

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.item.BlockItem;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.mootech.mpa.MoosPuppersizedAdditions;
import net.mootech.mpa.common.items.BurnableBucketItem;
import net.mootech.mpa.common.items.BurnableItem;
import net.mootech.mpa.common.items.JamItem;
import net.mootech.mpa.common.items.JuiceItem;
import net.mootech.mpa.common.items.StorageBlockItem;

public class ModItems {
	private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MoosPuppersizedAdditions.MOD_ID);
	
	private static final Item.Properties DEFAULT_PORPERTIES = new Item.Properties().tab(ModCommonInitializer.ITEM_GROUP);
	private static final Item.Properties DEFAULT_BUCKET_PORPERTIES = new Item.Properties().tab(ModCommonInitializer.ITEM_GROUP).stacksTo(1).craftRemainder(Items.BUCKET);

	// Simple items
	public static final RegistryObject<Item> GLASS_FLASK = ITEMS.register("glass_flask", () -> new Item(DEFAULT_PORPERTIES));
	public static final RegistryObject<Item> GLASS_JAR = ITEMS.register("glass_jar", () -> new Item(DEFAULT_PORPERTIES));
	public static final RegistryObject<Item> GELATIN = ITEMS.register("gelatin", () -> new Item(DEFAULT_PORPERTIES));
	public static final RegistryObject<Item> BEES_WAX = ITEMS.register("bees_wax", () -> new BurnableItem(DEFAULT_PORPERTIES, 400));
	public static final RegistryObject<Item> SALT = ITEMS.register("salt", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_FOOD).food(ModFoods.SALT)));
	public static final RegistryObject<Item> WET_APPLE_PULP = ITEMS.register("wet_apple_pulp", () -> new Item(DEFAULT_PORPERTIES));
	public static final RegistryObject<Item> DRYT_APPLE_PULP = ITEMS.register("dry_apple_pulp", () -> new Item(DEFAULT_PORPERTIES));
	public static final RegistryObject<Item> UNPREPARED_APPLE_LEATHER = ITEMS.register("unprepared_apple_leather", () -> new Item(DEFAULT_PORPERTIES));
	
	// Block items
	public static final RegistryObject<BlockItem> SALT_CRYSTAL = ITEMS.register("salt_crystal", () -> new BlockItem(ModBlocks.SALT_CRYSTAL.get(), DEFAULT_PORPERTIES));
	public static final RegistryObject<BlockItem> SALT_BLOCK = ITEMS.register("salt_block", () -> new BlockItem(ModBlocks.SALT_BLOCK.get(), DEFAULT_PORPERTIES));
	public static final RegistryObject<BlockItem> SALT_SAND_ORE = ITEMS.register("salt_sand_ore", () -> new BlockItem(ModBlocks.SALT_SAND_ORE.get(), DEFAULT_PORPERTIES));
	public static final RegistryObject<BlockItem> SALT_STONE_ORE = ITEMS.register("salt_stone_ore", () -> new BlockItem(ModBlocks.SALT_STONE_ORE.get(), DEFAULT_PORPERTIES));

	// Storage blocks
	public static final List<StorageBlockItem> STORAGE_BLOCKS = new ArrayList<>();
	// TODO add bees wax block as a storage block (should also be burnable as an item)
	public static final RegistryObject<BlockItem> SALT_BAG = ITEMS.register("salt_bag", () -> new StorageBlockItem(ModBlocks.SALT_BAG.get(), DEFAULT_PORPERTIES, ModItems.SALT.get()));
	public static final RegistryObject<BlockItem> WHEAT_SEED_BAG = ITEMS.register("wheat_seed_bag", () -> new StorageBlockItem(ModBlocks.WHEAT_SEED_BAG.get(), DEFAULT_PORPERTIES, Items.WHEAT_SEEDS));
	public static final RegistryObject<BlockItem> BEETROOT_SEED_BAG = ITEMS.register("beetroot_seed_bag", () -> new StorageBlockItem(ModBlocks.BEETROOT_SEED_BAG.get(), DEFAULT_PORPERTIES, Items.BEETROOT_SEEDS));
	public static final RegistryObject<BlockItem> PUMPKIN_SEED_BAG = ITEMS.register("pumpkin_seed_bag", () -> new StorageBlockItem(ModBlocks.PUMPKIN_SEED_BAG.get(), DEFAULT_PORPERTIES, Items.PUMPKIN_SEEDS));
	public static final RegistryObject<BlockItem> MELON_SEED_BAG = ITEMS.register("melon_seed_bag", () -> new StorageBlockItem(ModBlocks.MELON_SEED_BAG.get(), DEFAULT_PORPERTIES, Items.MELON_SEEDS));
	
	// Bucket Items
	
	public static final RegistryObject<BucketItem> SALTY_WATER_BUCKET = ITEMS.register("salty_water_bucket", () -> new BucketItem(ModFluids.SALTY_WATER, DEFAULT_BUCKET_PORPERTIES));
	public static final RegistryObject<BucketItem> SEED_OIL_BUCKET = ITEMS.register("seed_oil_bucket", () -> new BurnableBucketItem(ModFluids.SEED_OIL, DEFAULT_BUCKET_PORPERTIES, 4000));
	public static final RegistryObject<BucketItem> GELATIN_BUCKET = ITEMS.register("gelatin_bucket", () -> new BucketItem(ModFluids.GELATIN, DEFAULT_BUCKET_PORPERTIES));
	
	public static final RegistryObject<BucketItem> APPLE_JUICE_BUCKET = ITEMS.register("apple_juice_bucket", () -> new BucketItem(ModFluids.APPLE_JUICE, DEFAULT_BUCKET_PORPERTIES));
	public static final RegistryObject<BucketItem> MELON_JUICE_BUCKET = ITEMS.register("melon_juice_bucket", () -> new BucketItem(ModFluids.MELON_JUICE, DEFAULT_BUCKET_PORPERTIES));
	public static final RegistryObject<BucketItem> CHORUS_JUICE_BUCKET = ITEMS.register("chorus_juice_bucket", () -> new BucketItem(ModFluids.CHORUS_JUICE, DEFAULT_BUCKET_PORPERTIES));
	public static final RegistryObject<BucketItem> SWEET_BERRY_JUICE_BUCKET = ITEMS.register("sweet_berry_juice_bucket", () -> new BucketItem(ModFluids.SWEET_BERRY_JUICE, DEFAULT_BUCKET_PORPERTIES));
	public static final RegistryObject<BucketItem> CARROT_JUICE_BUCKET = ITEMS.register("carrot_juice_bucket", () -> new BucketItem(ModFluids.CARROT_JUICE, DEFAULT_BUCKET_PORPERTIES));
	public static final RegistryObject<BucketItem> GOLDEN_CARROT_JUICE_BUCKET = ITEMS.register("golden_carrot_juice_bucket", () -> new BucketItem(ModFluids.GOLDEN_CARROT_JUICE, DEFAULT_BUCKET_PORPERTIES.rarity(Rarity.UNCOMMON)));
	public static final RegistryObject<BucketItem> GOLDEN_APPLE_JUICE_BUCKET = ITEMS.register("golden_apple_juice_bucket", () -> new BucketItem(ModFluids.GOLDEN_APPLE_JUICE, DEFAULT_BUCKET_PORPERTIES.rarity(Rarity.RARE)));
	
	public static final RegistryObject<BucketItem> APPLE_JAM_BUCKET = ITEMS.register("apple_jam_bucket", () -> new BucketItem(ModFluids.APPLE_JAM, DEFAULT_BUCKET_PORPERTIES.rarity(Rarity.COMMON))); // Hacky but works.
	public static final RegistryObject<BucketItem> MELON_JAM_BUCKET = ITEMS.register("melon_jam_bucket", () -> new BucketItem(ModFluids.MELON_JAM, DEFAULT_BUCKET_PORPERTIES));
	public static final RegistryObject<BucketItem> CHORUS_JAM_BUCKET = ITEMS.register("chorus_jam_bucket", () -> new BucketItem(ModFluids.CHORUS_JAM, DEFAULT_BUCKET_PORPERTIES));
	public static final RegistryObject<BucketItem> SWEET_BERRY_JAM_BUCKET = ITEMS.register("sweet_berry_jam_bucket", () -> new BucketItem(ModFluids.SWEET_BERRY_JAM, DEFAULT_BUCKET_PORPERTIES));
	public static final RegistryObject<BucketItem> GOLDEN_APPLE_JAM_BUCKET = ITEMS.register("golden_apple_jam_bucket", () -> new BucketItem(ModFluids.GOLDEN_APPLE_JAM, DEFAULT_BUCKET_PORPERTIES.rarity(Rarity.RARE)));
	
	// Drinkables
	private static final Item.Properties DEFAULT_DRINKABLE_PORPERTIES = new Item.Properties().tab(ItemGroup.TAB_FOOD).stacksTo(16);
	public static final List<JuiceItem> JUICES = new ArrayList<>();
	public static final List<JamItem> JAMS = new ArrayList<>();
	public static final RegistryObject<Item> APPLE_JUICE = ITEMS.register("apple_juice", () -> new JuiceItem(DEFAULT_DRINKABLE_PORPERTIES.food(ModFoods.APPLE_JUICE).craftRemainder(GLASS_FLASK.get()), Items.APPLE, APPLE_JUICE_BUCKET.get()));
	public static final RegistryObject<Item> MELON_JUICE = ITEMS.register("melon_juice", () -> new JuiceItem(DEFAULT_DRINKABLE_PORPERTIES.food(ModFoods.MELON_JUICE).craftRemainder(GLASS_FLASK.get()), Items.MELON_SLICE, MELON_JUICE_BUCKET.get()));
	public static final RegistryObject<Item> CHORUS_JUICE = ITEMS.register("chorus_juice", () -> new JuiceItem(DEFAULT_DRINKABLE_PORPERTIES.food(ModFoods.CHORUS_JUICE).craftRemainder(GLASS_FLASK.get()), Items.CHORUS_FRUIT, CHORUS_JUICE_BUCKET.get(), true));
	public static final RegistryObject<Item> SWEET_BERRY_JUICE = ITEMS.register("sweet_berry_juice", () -> new JuiceItem(DEFAULT_DRINKABLE_PORPERTIES.food(ModFoods.SWEET_BERRY_JUICE).craftRemainder(GLASS_FLASK.get()), Items.SWEET_BERRIES, SWEET_BERRY_JUICE_BUCKET.get()));
	public static final RegistryObject<Item> CARROT_JUICE = ITEMS.register("carrot_juice", () -> new JuiceItem(DEFAULT_DRINKABLE_PORPERTIES.food(ModFoods.CARROT_JUICE).craftRemainder(GLASS_FLASK.get()), Items.CARROT, CARROT_JUICE_BUCKET.get()));
	public static final RegistryObject<Item> GOLDEN_CARROT_JUICE = ITEMS.register("golden_carrot_juice", () -> new JuiceItem(DEFAULT_DRINKABLE_PORPERTIES.food(ModFoods.GOLDEN_CARROT_JUICE).craftRemainder(GLASS_FLASK.get()), Items.GOLDEN_CARROT, GOLDEN_CARROT_JUICE_BUCKET.get()));
	public static final RegistryObject<Item> GOLDEN_APPLE_JUICE = ITEMS.register("golden_apple_juice", () -> new JuiceItem(DEFAULT_DRINKABLE_PORPERTIES.food(ModFoods.GOLDEN_APPLE_JUICE).craftRemainder(GLASS_FLASK.get()), Items.GOLDEN_APPLE, GOLDEN_APPLE_JUICE_BUCKET.get()));
	
	public static final RegistryObject<Item> APPLE_JAM = ITEMS.register("apple_jam", () -> new JamItem(DEFAULT_DRINKABLE_PORPERTIES.food(ModFoods.APPLE_JAM).craftRemainder(GLASS_JAR.get()), Items.APPLE, APPLE_JAM_BUCKET.get()));
	public static final RegistryObject<Item> MELON_JAM = ITEMS.register("melon_jam", () -> new JamItem(DEFAULT_DRINKABLE_PORPERTIES.food(ModFoods.MELON_JAM).craftRemainder(GLASS_JAR.get()), Items.MELON_SLICE, MELON_JAM_BUCKET.get()));
	public static final RegistryObject<Item> CHORUS_JAM = ITEMS.register("chorus_jam", () -> new JamItem(DEFAULT_DRINKABLE_PORPERTIES.food(ModFoods.CHORUS_JAM).craftRemainder(GLASS_JAR.get()), Items.CHORUS_FRUIT, CHORUS_JAM_BUCKET.get(), true));
	public static final RegistryObject<Item> SWEET_BERRY_JAM = ITEMS.register("sweet_berry_jam", () -> new JamItem(DEFAULT_DRINKABLE_PORPERTIES.food(ModFoods.SWEET_BERRY_JAM).craftRemainder(GLASS_JAR.get()), Items.SWEET_BERRIES, SWEET_BERRY_JAM_BUCKET.get()));
	public static final RegistryObject<Item> GOLDEN_APPLE_JAM = ITEMS.register("golden_apple_jam", () -> new JamItem(DEFAULT_DRINKABLE_PORPERTIES.food(ModFoods.GOLDEN_APPLE_JAM).craftRemainder(GLASS_JAR.get()), Items.GOLDEN_APPLE, GOLDEN_APPLE_JAM_BUCKET.get()));
	
	// TODO add jelly items
	// TODO once crushing tub and other block entities work, add ability to pick up juice/jam fluids from them with flasks/jars (and buckets of course) and also input should be possible with all of them
	// TODO jars can hold 500mB
	// TODO have vegetable oil bottles, to use in recipe
	// TODO add edible rock candy item
	private static final Logger LOGGER = LogManager.getLogger();
	
    public static void init(IEventBus modEventBus) {
    	LOGGER.debug("Registering strawberry items");
        ITEMS.register(modEventBus);
    }
}
