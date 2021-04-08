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
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.mootech.stcm.StrawberryTwirlCompanion;
import net.mootech.stcm.common.StrawberryItems;

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

	@Override
	protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) {
		addFlaskRecipe(consumer);
	}
	
	private void addFlaskRecipe(Consumer<IFinishedRecipe> consumer) {
		ShapedRecipeBuilder.shaped(StrawberryItems.FLASK_ITEM, 1).pattern("g g").pattern("ggg").define('g', Items.GLASS)
			.unlockedBy("has_glass", InventoryChangeTrigger.Instance.hasItems(Items.GLASS))
			.save(consumer, new ResourceLocation(StrawberryTwirlCompanion.ID, "crafting/flask_from_glass"));
	}
}
