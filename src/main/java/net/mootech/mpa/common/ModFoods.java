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

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

/**
 * Helper class to store food values and create food builders on demand
 * @author Maxine Red
 *
 */
public class ModFoods {
	
	// Item effects to add
	private static final EffectInstance ABSORPTION = new EffectInstance(Effects.ABSORPTION, 2400, 0);
	private static final EffectInstance REGENERATION = new EffectInstance(Effects.REGENERATION, 100, 1);
	private static final EffectInstance NIGHT_VISION = new EffectInstance(Effects.NIGHT_VISION, 1800, 0);
	private static final EffectInstance SALT_HUNGER = new EffectInstance(Effects.HUNGER, 300, 0);
	
	private static final float juice_saturation_multiplier = 0.85f;
	private static final int juice_nutrition = 4;
	
	public static final Food SALT = (new Food.Builder()).nutrition(1).saturationMod(0).alwaysEat().effect(() -> SALT_HUNGER, 0.75f).build();

	// Juices
	public static final Food APPLE_JUICE = create_juice_food_builder(Items.APPLE).build();
	public static final Food GOLDEN_APPLE_JUICE = create_juice_food_builder(Items.GOLDEN_APPLE).effect(() -> ABSORPTION, 1.0f).effect(() -> REGENERATION, 1.0f).build();
	public static final Food MELON_JUICE = create_juice_food_builder(Items.MELON_SLICE).build();
	public static final Food CHORUS_JUICE = create_juice_food_builder(Items.CHORUS_FRUIT).build();
	public static final Food SWEET_BERRY_JUICE = create_juice_food_builder(Items.SWEET_BERRIES).build();
	public static final Food CARROT_JUICE = create_juice_food_builder(Items.CARROT).build();
	public static final Food GOLDEN_CARROT_JUICE = create_juice_food_builder(Items.GOLDEN_CARROT).effect(() -> NIGHT_VISION, 1.0f).build();
	
	// Jams
	public static final Food APPLE_JAM = create_jam_food_builder(APPLE_JUICE).build();
	public static final Food GOLDEN_APPLE_JAM = create_jam_food_builder(GOLDEN_APPLE_JUICE).effect(() -> ABSORPTION, 1.0f).effect(() -> REGENERATION, 1.0f).build();
	public static final Food MELON_JAM = create_jam_food_builder(MELON_JUICE).build();
	public static final Food CHORUS_JAM = create_jam_food_builder(CHORUS_JUICE).build();
	public static final Food SWEET_BERRY_JAM = create_jam_food_builder(SWEET_BERRY_JUICE).build();
	
	// TODO add jelly items

	/**
	 * Helper method to create food properties (need to call `.build()` on
	 * @param crop Base crop to calculate new nutrition values from
	 * @param craftAmount How many of these are used in crafting
	 * @return Food.Builder
	 */
	public static final Food.Builder create_juice_food_builder(Item crop, int craftAmount) {
		float base_nutrition = ((float)crop.getFoodProperties().getNutrition() / (float)juice_nutrition);
		float new_saturation_modifier = base_nutrition * craftAmount * crop.getFoodProperties().getSaturationModifier() * juice_saturation_multiplier;
		return (new Food.Builder()).nutrition(juice_nutrition).saturationMod(new_saturation_modifier).alwaysEat();
	}
	
	public static final Food.Builder create_juice_food_builder(Item crop) {
		return create_juice_food_builder(crop, 1);
	}
	

	
	public static final Food.Builder create_jam_food_builder(Food juice) {
		return (new Food.Builder()).nutrition(juice.getNutrition() * 2).saturationMod(juice.getSaturationModifier() * 1.25f);
	}
}
