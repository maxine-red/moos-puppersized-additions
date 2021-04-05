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

package net.mootech.stcm.common.fluids;

import net.minecraft.item.Item;
import net.mootech.stcm.common.StrawberryInitializer;
import net.mootech.stcm.common.StrawberryItems;
import net.mootech.stcm.common.items.StrawberryBottleItem;
import net.mootech.stcm.util.Color;

/**
 * @author Maxine Red
 *
 */
public class JuiceFluid extends StrawberryFluid {

	private static final Item.Properties BOTTLE_PROPERTIES = new Item.Properties().tab(StrawberryInitializer.ITEM_GROUP).stacksTo(16).craftRemainder(StrawberryItems.FLASK_ITEM);;

	
	/**
	 * @param id String ID of juice
	 * @param color Item tinting color
	 */
	public JuiceFluid(String id, Color color) {
		super(id + "_juice", color, -1, true);
		new StrawberryBottleItem(this.id, source, BOTTLE_PROPERTIES, -1);
		LOGGER.debug("Created juice: " + this.id);
	}

}
