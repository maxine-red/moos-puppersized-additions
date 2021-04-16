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

package net.mootech.mpa.data;

import java.util.function.Consumer;

import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.mootech.mpa.MoosPuppersizedAdditions;
import net.mootech.mpa.common.ModItems;
import net.mootech.mpa.common.items.JuiceItem;
import net.mootech.mpa.common.items.StorageBlockItem;

/**
 * @author Maxine Red
 *
 * Create recipes automatically.
 */
public class ModRecipes extends RecipeProvider {

	/**
	 * Recipe creation
	 * @param gen Generator
	 */
	public ModRecipes(DataGenerator gen) {
		super(gen);
	}

	@Override
	protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) {
		// Add integration with other mods, at some point
		addSaltRecipes(consumer);
		addGlassContainerRecipe(consumer);
		addJuiceRecipes(consumer);
		addStorageBlockRecipes(consumer);
		// TODO add crushing tub recipe for seed oil
		// TODO seed oil recipes should respect seed rarity
		// TODO add cooking and drying recipes (drying is liquid -> item) for gelatin
		// TODO add cooking recipes for juice -> jam and juice -> jelly (jam is juice + sugar and jelly is juice + gelatin)
	}
	
	/**
	 * Adds Salt related recipes
	 * @param consumer
	 */
	private void addSaltRecipes(Consumer<IFinishedRecipe> consumer) {
		// TODO Add recipes for salt crystals and other missing salt recipes
		String unlock_by_string = "has_salt";
		Item salt = ModItems.SALT.get();
		Item salt_block = ModItems.SALT_BLOCK.get();
		// Salt to salt block
		ShapedRecipeBuilder.shaped(salt_block).pattern("##").pattern("##").define('#', salt).unlockedBy(unlock_by_string, InventoryChangeTrigger.Instance.hasItems(salt))
		.save(consumer, new ResourceLocation(MoosPuppersizedAdditions.MOD_ID, "crafting/salt_block"));
		ShapelessRecipeBuilder.shapeless(salt, 4).requires(salt_block)
		.unlockedBy(unlock_by_string + "_block", InventoryChangeTrigger.Instance.hasItems(salt_block))
		.save(consumer, new ResourceLocation(MoosPuppersizedAdditions.MOD_ID, "crafting/salt_from_salt_block"));
	}
	
	/**
	 * Add mod glass container (flask and jar)
	 * @param consumer
	 */
	private void addGlassContainerRecipe(Consumer<IFinishedRecipe> consumer) {
		ShapedRecipeBuilder.shaped(ModItems.GLASS_FLASK.get(), 4).pattern("g g").pattern("g g").define('g', Items.GLASS)
		.unlockedBy("has_glass", InventoryChangeTrigger.Instance.hasItems(Items.GLASS))
		.save(consumer, new ResourceLocation(MoosPuppersizedAdditions.MOD_ID, "crafting/glass_flask"));
		ShapedRecipeBuilder.shaped(ModItems.GLASS_JAR.get(), 4).pattern("g g").pattern("g g").pattern("ggg").define('g', Items.GLASS)
		.unlockedBy("has_glass", InventoryChangeTrigger.Instance.hasItems(Items.GLASS))
		.save(consumer, new ResourceLocation(MoosPuppersizedAdditions.MOD_ID, "crafting/glass_jar"));
	}
	
	/**
	 * Make recipes for juices
	 * @param consumer Recipe consumer
	 */
	private void addJuiceRecipes(Consumer<IFinishedRecipe> consumer) {
		// TODO add crushing tub recipes for juice making
		for (JuiceItem juice : ModItems.JUICES) {
			Item bucket = juice.getBucket();
			String juice_name = juice.getRegistryName().getPath();
			String bucket_name = bucket.getRegistryName().getPath();
			// bucket from 4 bottles
			ShapelessRecipeBuilder.shapeless(bucket, 1).requires(juice, 4).requires(Items.BUCKET)
			.unlockedBy("has_" + juice_name, InventoryChangeTrigger.Instance.hasItems(juice)).group(juice_name + "_convenience")
			.save(consumer, new ResourceLocation(MoosPuppersizedAdditions.MOD_ID, "crafting/" + bucket_name + "_from_" + juice_name));
			
			// 4 bottles from bucket
			ShapelessRecipeBuilder.shapeless(juice, 4).requires(ModItems.GLASS_FLASK.get(), 4).requires(bucket)
			.unlockedBy("has_" + bucket_name, InventoryChangeTrigger.Instance.hasItems(bucket)).group(juice_name + "_convenience")
			.save(consumer, new ResourceLocation(MoosPuppersizedAdditions.MOD_ID, "crafting/" + juice_name + "_from_" + bucket_name));
		}
	}
	
	/**
	 * Add recipes to make storage blocks and uncraft them again
	 * @param consumer
	 */
	private void addStorageBlockRecipes(Consumer<IFinishedRecipe> consumer) {
		for (StorageBlockItem bag : ModItems.STORAGE_BLOCKS) {
			Item base = bag.getBaseItem();
			String bag_path = bag.getRegistryName().getPath();
			String base_path = base.getRegistryName().getPath();
			String bag_namespace = bag.getRegistryName().getNamespace();
			String base_namespace = base.getRegistryName().getNamespace();
			// Storage from items
			ShapelessRecipeBuilder.shapeless(bag, 1).requires(base, 9)
			.unlockedBy("has_" + base_path, InventoryChangeTrigger.Instance.hasItems(base)).group(bag_path + "_storage")
			.save(consumer, new ResourceLocation(bag_namespace, "crafting/" + bag_path));
			// Items from storage
			ShapelessRecipeBuilder.shapeless(base, 9).requires(bag, 1)
			.unlockedBy("has_" + bag_path, InventoryChangeTrigger.Instance.hasItems(bag)).group(bag_path + "_storage")
			.save(consumer, new ResourceLocation(base_namespace, "crafting/" + base_path + "_from_" + bag_path));
		}
	}
}
