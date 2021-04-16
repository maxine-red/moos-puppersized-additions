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

import java.util.function.Supplier;

import net.minecraft.fluid.Fluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.ItemStack;

/**
 * @author Maxine Red
 *
 */
public class BurnableBucketItem extends BucketItem {
	
	private final int burnTime; 

	/**
	 * @param supplier Fluid for this bucket
	 * @param builder Properties
	 */
	public BurnableBucketItem(Supplier<? extends Fluid> supplier, Properties builder, int burnTime) {
		super(supplier, builder);
		this.burnTime = burnTime;
	}

	/**
	 * @return the burnTime
	 */
	@Override
	public int getBurnTime(ItemStack stack) {
		return burnTime;
	}

}