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

package net.mootech.stcm.data;

import java.util.function.Consumer;

import javax.annotation.ParametersAreNonnullByDefault;


import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.mootech.stcm.StrawberryTwirlCompanion;
import net.mootech.stcm.common.StrawberryItems;
import net.mootech.stcm.common.items.JuiceBucketItem;
import net.mootech.stcm.common.items.JuiceItem;

/**
 * @author Maxine Red
 *
 * Create recipes automatically.
 */
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class StrawberryRecipes extends RecipeProvider {

	/**
	 * Recipe creation
	 * @param gen Generator
	 */
	public StrawberryRecipes(DataGenerator gen) {
		super(gen);
	}
	
	// TODO Try getting conditional recipes working
	// TODO see if custom recipes might be possible to use to create integration recipes

	@Override
	protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) {
		//addGlassContainerRecipe(consumer);
		//addJuiceRecipes(consumer);
		//addJuiceBucketRecipes(consumer);
		//addJuiceBucketToBottlesRecipes(consumer);
		//addJuiceBottlesToBucketRecipes(consumer);
	}
	/*
	private void addGlassContainerRecipe(Consumer<IFinishedRecipe> consumer) {
		ShapedRecipeBuilder.shaped(StrawberryItems.GLASS_FLASK, 4).pattern("g g").pattern("g g").define('g', Items.GLASS)
		.unlockedBy("has_glass", InventoryChangeTrigger.Instance.hasItems(Items.GLASS))
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
	}
	
	private void addJuiceBottlesToBucketRecipes(Consumer<IFinishedRecipe> consumer) {
		for (JuiceBucketItem bucket : StrawberryItems.JUICE_BUCKETS) {
			JuiceItem bottle = bucket.getBottle();
			ShapelessRecipeBuilder.shapeless(bucket, 1).requires(bottle, 4).requires(Items.BUCKET)
			.unlockedBy("has_" + bottle.getId(), InventoryChangeTrigger.Instance.hasItems(bottle)).group("juice_convenience")
			.save(consumer, new ResourceLocation(StrawberryTwirlCompanion.ID, "crafting/" + bucket.getId() + "_from_" + bottle.getId()));
		}
	}*/
}
