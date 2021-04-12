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

package net.mootech.stcm.common.items.legacy;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.mootech.stcm.common.StrawberryInitializer;
import net.mootech.stcm.common.StrawberryItems;
import net.mootech.stcm.util.StringID;

/**
 * Generic item class for all Strawberry items, except buckets
 * @author Maxine Red
 *
 */
public class StrawberryItem extends Item {

	protected final String id;
	protected final int burn_time;
	protected String name;
	
	public StrawberryItem(String id) {
		this(id, new Item.Properties().tab(StrawberryInitializer.ITEM_GROUP));
	}
	
	public StrawberryItem(String id, Properties properties) {
		this(id, properties, -1);
	}
	
	public StrawberryItem(String id, Properties properties, int burn_time) {
		this(id, properties, burn_time, StringID.idToName(id));
	}
	
	public StrawberryItem(String id, Properties properties, int burn_time, String name) {
		super(properties);
		this.id = id;
		this.name = name;
		this.burn_time = burn_time;
		//StrawberryItems.REGISTERED_ITEMS.add(this);
	}
	
	/**
	 * String ID for this bucket
	 * @return String
	 */
	public String getId() {
		return this.id;
	}
	
	/**
	 * Get in-game name of item
	 * @return String
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Set in-game name of item
	 * @return this
	 */
	public StrawberryItem setName(String name) {
		this.name = name;
		return this;
	}

	@Override
	public int getBurnTime(ItemStack itemStack)
	{
		return burn_time;
	}

}
