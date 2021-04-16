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
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.mootech.mpa.common.ModItems;

/**
 * Jam jars, to have their own drink sound
 * @author Maxine Red
 *
 */
public class JamItem extends DrinkableItem {
	
	private final BucketItem bucket;

	public JamItem(Properties properties, Item cropItem, BucketItem bucket) {
		this(properties, cropItem, bucket, false);
	}

	public JamItem(Properties properties, Item cropItem, BucketItem bucket, boolean isChorus) {
		super(properties.rarity(cropItem.getDefaultInstance().getRarity()), isChorus);
		this.bucket = bucket;
		ModItems.JAMS.add(this);
	}

	/**
	 * @return the bucket
	 */
	public BucketItem getBucket() {
		return bucket;
	}
	
	/**
	 * Override drinking sound
	 */
	@Override
	public SoundEvent getEatingSound() {
		return SoundEvents.HONEY_DRINK;
	}
}
