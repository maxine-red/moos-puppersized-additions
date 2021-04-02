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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.item.Item;
import net.minecraft.item.Rarity;
import net.minecraft.util.ResourceLocation;
import net.mootech.stcm.StrawberryTwirlCompanion;
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
	
	private static final Item.Properties BOTTLE_PROPERTIES = new Item.Properties().fireResistant().rarity(Rarity.EPIC).tab(StrawberryInitializer.ITEM_GROUP).stacksTo(1).craftRemainder(StrawberryItems.GLASS_BUCKET);;
	private static final String suffix = "_essence";

    
    private static final Logger LOGGER = LogManager.getLogger();
	/**
	 * Constructor for magic essences
	 * @param id ID of essence ("essence" is added automatically)
	 * @param color Color of essence, used for bucket tinting
	 */
	public MagicEssenceFluid(String id, Color color) {
		this(id, color, new ResourceLocation(StrawberryTwirlCompanion.ID, "fluids/" + id + suffix), new ResourceLocation(StrawberryTwirlCompanion.ID, "fluids/" + id + suffix + "_flow"));
	}
	
	public MagicEssenceFluid(String id, Color color, ResourceLocation still_resource, ResourceLocation flowing_resource) {
		this(id, color, still_resource, flowing_resource, -1);
	}
	
	public MagicEssenceFluid(String id, Color color, ResourceLocation still_resource, ResourceLocation flowing_resource, int burn_time) {
		super(id + suffix, color, still_resource, flowing_resource, true, burn_time, false);
		StrawberryItems.BOTTLES.add(new StrawberryBottleItem(this.id, source, BOTTLE_PROPERTIES, burn_time));
		LOGGER.debug("Created essence: " + this.id);
	}

}
