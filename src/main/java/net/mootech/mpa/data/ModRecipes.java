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

package net.mootech.mpa.data;

import java.util.Set;
import java.util.function.Consumer;
import java.util.regex.Pattern;

import javax.annotation.ParametersAreNonnullByDefault;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;
import net.mootech.mpa.MoosPuppersizedAdditions;
import net.mootech.mpa.common.ModCommonInitializer;
import net.mootech.mpa.common.ModItems;

/**
 * @author Maxine Red
 *
 * Create recipes automatically.
 */
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class ModRecipes extends RecipeProvider {

	/**
	 * Recipe creation
	 * @param gen Generator
	 */
	public ModRecipes(DataGenerator gen) {
		super(gen);
	}
	
	// TODO Try getting conditional recipes working
	// TODO see if custom recipes might be possible to use to create integration recipes

	@Override
	protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) {
		addSaltRecipes(consumer);
		//addGlassContainerRecipe(consumer);
		//addJuiceRecipes(consumer);
		//addJuiceBucketRecipes(consumer);
		//addJuiceBucketToBottlesRecipes(consumer);
		Set<Item> items = ModCommonInitializer.getRegisteredModItems(MoosPuppersizedAdditions.MOD_ID);
		items.forEach(i -> registerRecipesForItems(i, consumer));
	}
	
	private void addSaltRecipes(Consumer<IFinishedRecipe> consumer) {
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
	
	private static final Pattern juice_pattern = Pattern.compile("juice$");
	
	private void registerRecipesForItems(Item item,Consumer<IFinishedRecipe> consumer) {
		String item_id = item.getRegistryName().getPath();
		if (juice_pattern.matcher(item_id).find()) {
			addBottlesToBucketRecipe(item, consumer);
		}
	}
	/*
	private void addGlassContainerRecipe(Consumer<IFinishedRecipe> consumer) {
		ShapedRecipeBuilder.shaped(StrawberryItems.GLASS_FLASK, 4).pattern("g g").pattern("g g").define('g', Items.GLASS)
		.unlockedBy("has_glass", )
		.save(consumer, new ResourceLocation(StrawberryTwirlCompanion.ID, "crafting/empty_juice_bottle"));
		ShapedRecipeBuilder.shaped(StrawberryItems.GLASS_JAR, 4).pattern("g g").pattern("g g").pattern("ggg").define('g', Items.GLASS)
		.unlockedBy("has_glass", InventoryChangeTrigger.Instance.hasItems(Items.GLASS))
		.save(consumer, new ResourceLocation(StrawberryTwirlCompanion.ID, "crafting/empty_jar"));
	}
	
	private void addJuiceRecipes(Consumer<IFinishedRecipe> consumer) {
		for (JuiceItem juice : StrawberryItems.JUICES) {
			ShapelessRecipeBuilder.shapeless(juice).requires(juice.getCraftingRemainderItem()).requires(juice.getCrop(), juice.getCraftAmount())
			.unlockedBy("has_" + juice.getCrop().getRegistryName().getPath(), InventoryChangeTrigger.Instance.hasItems(juice.getCrop())).group("juice_making")
			.save(consumer, new ResourceLocation(StrawberryTwirlCompanion.ID, "crafting/" + juice.getId()));
		}
	}
	
	private void addJuiceBucketRecipes(Consumer<IFinishedRecipe> consumer) {
		for (JuiceBucketItem bucket : StrawberryItems.JUICE_BUCKETS) {
			JuiceItem bottle = bucket.getBottle();
			ShapelessRecipeBuilder.shapeless(bucket).requires(Items.BUCKET).requires(bottle.getCrop(), 4 * bottle.getCraftAmount())
			.unlockedBy("has_" + bottle.getCrop().getRegistryName().getPath(), InventoryChangeTrigger.Instance.hasItems(bottle.getCrop())).group("juice_making")
			.save(consumer, new ResourceLocation(StrawberryTwirlCompanion.ID, "crafting/" + bucket.getId()));
		}
	}
	
	private void addJuiceBucketToBottlesRecipes(Consumer<IFinishedRecipe> consumer) {
		for (JuiceBucketItem bucket : StrawberryItems.JUICE_BUCKETS) {
			JuiceItem bottle = bucket.getBottle();
			ShapelessRecipeBuilder.shapeless(bottle, 4).requires(bucket).requires(Items.GLASS_BOTTLE, 4)
			.unlockedBy("has_" + bucket.getId(), InventoryChangeTrigger.Instance.hasItems(bucket)).group("juice_convenience")
			.save(consumer, new ResourceLocation(StrawberryTwirlCompanion.ID, "crafting/" + bottle.getId() + "_from_" + bucket.getId()));
		}
	}*/
	
	private void addBottlesToBucketRecipe(Item item, Consumer<IFinishedRecipe> consumer) {
		Item bucket = ForgeRegistries.ITEMS.getValue(new ResourceLocation(item.getRegistryName().getNamespace(), item.getRegistryName().getPath() + "_bucket"));
		ShapelessRecipeBuilder.shapeless(bucket, 1).requires(item, 4).requires(Items.BUCKET)
			.unlockedBy("has_" + item.getRegistryName().getPath(), InventoryChangeTrigger.Instance.hasItems(item)).group("juice_convenience")
			.save(consumer, new ResourceLocation(MoosPuppersizedAdditions.MOD_ID, "crafting/" + bucket.getRegistryName().getPath() + "_from_" + item.getRegistryName().getPath()));
		ShapelessRecipeBuilder.shapeless(item, 4).requires(ModItems.GLASS_FLASK.get(), 4).requires(bucket)
		.unlockedBy("has_" + bucket.getRegistryName().getPath(), InventoryChangeTrigger.Instance.hasItems(bucket)).group("juice_convenience")
		.save(consumer, new ResourceLocation(MoosPuppersizedAdditions.MOD_ID, "crafting/" + item.getRegistryName().getPath() + "_from_" + bucket.getRegistryName().getPath()));
	}
}
