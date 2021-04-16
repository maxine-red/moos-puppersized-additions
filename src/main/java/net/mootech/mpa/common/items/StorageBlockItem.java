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

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.mootech.mpa.common.ModItems;

/**
 * Item class to add a block item to ModItems.STORAGE_BLOCKS
 * This is used to later register recipes for them
 * @author Maxine Red
 *
 */
public class StorageBlockItem extends BlockItem {
	private final Item baseItem;
	public StorageBlockItem(Block block, Properties properties, Item baseItem) {
		super(block, properties);
		this.baseItem = baseItem;
		ModItems.STORAGE_BLOCKS.add(this);
	}
	/**
	 * @return the baseItem
	 */
	public Item getBaseItem() {
		return baseItem;
	}

}
