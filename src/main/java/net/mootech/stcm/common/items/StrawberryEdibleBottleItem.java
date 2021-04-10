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

package net.mootech.stcm.common.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.UseAction;
import net.minecraft.world.World;
import net.mootech.stcm.common.StrawberryInitializer;
import net.mootech.stcm.util.Color;

/**
 * @author Maxine Red
 *
 */
public class StrawberryEdibleBottleItem extends StrawberryEdibleItem {
	// TODO Make juice and jam bottles to have distinct drink sounds
	// TODO: Make a special chorus subclass that implements chorus fruit behavior again
	// TODO: Return glass bottle when done drinking
	// TODO: Add apple pulp from golden apple juicing and add a shredding recipe from normal apples (that doesn't produce juice), mixing, cutting and crafting
	protected final int color;
	public StrawberryEdibleBottleItem(String id, Color color) {
		this(id, color, new Item.Properties().tab(StrawberryInitializer.ITEM_GROUP).stacksTo(1).craftRemainder(Items.GLASS_BOTTLE));
	}

	public StrawberryEdibleBottleItem(String id, Color color, Properties properties) {
		this(id, color, properties, -1);
	}
	
	public StrawberryEdibleBottleItem(String id, Color color, Properties properties, int burn_time) {
		super(id, properties, burn_time);
		this.color = color.combine_rgb();
	}
	
	/**
	 * Get color information from fluid
	 * @return integer
	 */
	public int getColor() {
		return color;
	}
	
	/**
	 * Set in-game name of item
	 * @return this
	 */
	@Override
	public StrawberryEdibleBottleItem setName(String name) {
		this.name = name;
		return this;
	}
	
	@Override
	public UseAction getUseAnimation(ItemStack stack) {
		return UseAction.DRINK;
	}
	
	/**
	 * Return a glass bottle on use
	 */
	@Override
	public ItemStack finishUsingItem(ItemStack stack, World worldIn, LivingEntity consumer) {
		ItemStack container = stack.getContainerItem(); // Grab crafting remainer first, or else we can't get it, when stack is emptied
		super.finishUsingItem(stack, worldIn, consumer);
		if (stack.isEmpty()) {
			return container;
		}
		else {
			PlayerEntity player = consumer instanceof PlayerEntity ? (PlayerEntity)consumer : null;
			if (player != null && !player.isCreative()) {
				if (!player.addItem(container)) {
					player.drop(container, false);
				}
			}
			return stack;
		}
	}
}
