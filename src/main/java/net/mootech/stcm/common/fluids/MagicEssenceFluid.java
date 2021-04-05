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
import net.minecraft.item.Rarity;
import net.mootech.stcm.common.StrawberryInitializer;
import net.mootech.stcm.common.StrawberryItems;
import net.mootech.stcm.common.items.StrawberryBottleItem;
import net.mootech.stcm.util.Color;

/**
 * @author Maxine Red
 *
 */

// TODO Make a BottleFluid class, that this extends. Juie and Jam will extend it too, but in a different way. All of them add a suffix and create a bottle item, jam and juice also add buckets though
// TODO remove ability to construct with custom textures with sub classes and instead use id, set instead
public class MagicEssenceFluid extends StrawberryFluid {
	
	private static final Item.Properties BOTTLE_PROPERTIES = new Item.Properties().fireResistant().rarity(Rarity.EPIC).tab(StrawberryInitializer.ITEM_GROUP).stacksTo(1).craftRemainder(StrawberryItems.FLASK_ITEM);
	
    /**
	 * Constructor for magic essences
	 * @param id ID of essence ("essence" is added automatically)
	 * @param color Color of essence, used for bucket tinting
	 */	
	public MagicEssenceFluid(String id, Color color) {
		this(id, color, -1);
	}
	
	/**
	 * Constructor for magic essences
	 * @param id String id of essence
	 * @param color Item tinting color
	 * @param burn_time Burn time in furnace
	 */
	public MagicEssenceFluid(String id, Color color, int burn_time) {
		super(id + "_essence", color, burn_time, false);
		new StrawberryBottleItem(this.id + "_flask", source, BOTTLE_PROPERTIES, burn_time);
		LOGGER.debug("Created essence: " + this.id);
	}

}
