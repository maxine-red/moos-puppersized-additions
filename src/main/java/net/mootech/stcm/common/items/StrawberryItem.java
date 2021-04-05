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
import net.minecraft.item.ItemStack;
import net.mootech.stcm.common.StrawberryInitializer;
import net.mootech.stcm.common.StrawberryItems;
import net.mootech.stcm.util.StringID;

/**
 * @author Maxine Red
 *
 */
public class StrawberryItem extends Item {

	protected final String id;
	protected final int burn_time;
	protected final String name;
	
	public StrawberryItem(String id) {
		this(id, new Item.Properties().tab(StrawberryInitializer.ITEM_GROUP));
	}
	
	public StrawberryItem(String id, Properties properties) {
		this(id, properties, -1);
	}
	
	public StrawberryItem(String id, Properties properties, int burn_time) {
		super(properties);
		this.id = id;
		this.name = StringID.idToName(id);
		this.burn_time = burn_time;
		StrawberryItems.REGISTERED_ITEMS.add(this);
	}
	
	/**
	 * String ID for this bucket
	 * @return String
	 */
	public String getID() {
		return this.id;
	}
	
	/**
	 * Get in-game name of item
	 * @return String
	 */
	public String getName() {
		return this.name;
	}

	@Override
	public int getBurnTime(ItemStack itemStack)
	{
		return burn_time;
	}

}