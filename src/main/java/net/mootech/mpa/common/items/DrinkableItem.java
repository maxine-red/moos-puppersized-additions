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
package net.mootech.mpa.common.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.world.World;

/**
 * Items you can drink and return their container item, when drunk
 * @author Maxine Red
 *
 */
public class DrinkableItem extends EdibleItem {

	public DrinkableItem(Properties properties, boolean isChorus) {
		super(properties, isChorus);
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
		ItemStack container = stack.getContainerItem(); // Grab crafting remainder first, or else we can't get it, when stack is emptied
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
