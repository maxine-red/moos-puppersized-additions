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

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
/**
 * Burnable items. One item is smelted in 200 ticks
 * @author Maxine Red
 *
 */
public class BurnableItem extends Item {
	
	private final int burnTime;
	/**
	 * Constructor for bunarbale items
	 * @param properties Item properties
	 * @param burnTime Burn time (200 ticks smelts one item in furnace)
	 */
	public BurnableItem(Properties properties, int burnTime) {
		super(properties);
		this.burnTime = burnTime;
	}
	
	@Override
	public int getBurnTime(ItemStack item) {
		return burnTime;
	}

}
