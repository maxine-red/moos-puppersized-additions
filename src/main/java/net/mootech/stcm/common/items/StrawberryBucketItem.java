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

import java.util.function.Supplier;

import net.minecraft.fluid.Fluid;
import net.minecraft.item.BucketItem;
import net.mootech.stcm.common.fluids.VirtualFluid;

/**
 * @author Maxine Red
 *
 */
public class StrawberryBucketItem extends BucketItem {
	
	protected final String id;
	
	private final int color;

	/**
	 * Custom bucket class constructor, to allow for ID handling.
	 * @param fluid VirtualFluid that is contained by this bucket
	 * @param properties Item properties for this bucket
	 */
	public StrawberryBucketItem(Supplier<VirtualFluid> fluid, Properties properties) {
		super((Supplier<? extends Fluid>)fluid, properties);
		this.id = fluid.get().getID() + "_bucket";
		this.color = fluid.get().getColor();
	}
	
	/**
	 * String ID for this bucket
	 * @return String
	 */
	public String id() {
		return this.id;
	}
	
	/**
	 * Get color information from fluid
	 * @return integer
	 */
	public int getColor() {
		return color;
	}

}
