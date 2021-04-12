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

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.mootech.stcm.common.StrawberryItems;
import net.mootech.stcm.util.Color;

/**
 * @author Maxine Red
 *
 */
public class JuiceItem extends EdibleBottleItem {
	protected static final Item.Properties BOTTLE_PROPERTIES = new Item.Properties().tab(ItemGroup.TAB_FOOD).stacksTo(16).craftRemainder(StrawberryItems.GLASS_FLASK.get());
	protected final Item crop;
	protected final int craftAmount;
	
	public JuiceItem(String id, Color color, Properties properties, Item crop) {
		this(id, color, properties, crop, 1);
	}
	
	public JuiceItem(String id, Color color, Food foodProperties, Item crop) {
		this(id, color, foodProperties, crop, 1);
	}
	
	public JuiceItem(String id, Color color, Food foodProperties, Item crop, int craftAmount) {
		this(id, color, BOTTLE_PROPERTIES.food(foodProperties), crop, craftAmount);
	}
	
	public JuiceItem(String id, Color color, Properties properties, Item crop, int craftAmount) {
		super(id, color, properties);
		//StrawberryItems.JUICES.add(this);
		this.crop = crop;
		this.craftAmount = craftAmount;
	}
	
	/**
	 * Get the item this juice is made from
	 * @return Item
	 */
	public Item getCrop() {
		return this.crop;
	}
	
	/**
	 * Get amount of crop you need to craft
	 * @return int
	 */
	public int getCraftAmount() {
		return this.craftAmount;
	}


	/**
	 * Fetch Bottle item for this container
	 * @return Item
	 */
	public Item getCraftingRemainderItem() {
		return StrawberryItems.GLASS_FLASK.get();
	}
	
	@Override
	public SoundEvent getEatingSound() {
		return SoundEvents.GENERIC_DRINK;
	}
}
