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

import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.mootech.stcm.common.StrawberryInitializer;
import net.mootech.stcm.common.StrawberryItems;
import net.mootech.stcm.common.fluids.StrawberryFluid;

/**
 * @author Maxine Red
 *
 */
public class StrawberryBottleItem extends StrawberryItem {
	protected final int color;
	public StrawberryBottleItem(String id, StrawberryFluid fluid) {
		this(id, fluid, new Item.Properties().tab(StrawberryInitializer.ITEM_GROUP).stacksTo(1).craftRemainder(Items.GLASS_BOTTLE));
	}

	public StrawberryBottleItem(String id, StrawberryFluid fluid, Properties properties) {
		this(id, fluid, properties, -1);
	}
	
	public StrawberryBottleItem(String id, StrawberryFluid fluid, Properties properties, int burn_time) {
		super(id, properties, burn_time);
		this.color = fluid.getColor();
		StrawberryItems.BOTTLES.add(this);
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
	public StrawberryBottleItem setName(String name) {
		this.name = name;
		return this;
	}
}
