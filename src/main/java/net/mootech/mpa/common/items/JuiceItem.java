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

import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.mootech.mpa.common.ModItems;

/**
 * Juice items to have their own drink sound
 * @author Maxine Red
 *
 */
public class JuiceItem extends DrinkableItem {
	
	private final Item cropItem;
	private final BucketItem bucket;
	private final int cropMultiplier;

	public JuiceItem(Properties properties, Item cropItem, BucketItem bucket) {
		this(properties, cropItem, bucket, false);
	}

	public JuiceItem(Properties properties, Item cropItem, BucketItem bucket, boolean isChorus) {
		super(properties, isChorus);
		this.cropItem = cropItem;
		this.bucket = bucket;
		this.cropMultiplier = (cropItem == Items.SWEET_BERRIES || cropItem == Items.MELON_SLICE ? 2 : 1);
		ModItems.JUICES.add(this);
	}

	/**
	 * @return the cropMultiplier
	 */
	public int getCropMultiplier() {
		return cropMultiplier;
	}

	/**
	 * @return the bucket
	 */
	public BucketItem getBucket() {
		return bucket;
	}

	/**
	 * @return the cropItem
	 */
	public Item getCropItem() {
		return cropItem;
	}

	/**
	 * Override drinking sound
	 */
	@Override
	public SoundEvent getEatingSound() {
		return SoundEvents.GENERIC_DRINK;
	}
}
