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

package net.mootech.stcm.data;

import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraftforge.common.data.LanguageProvider;
import net.mootech.stcm.StrawberryTwirlCompanion;
import net.mootech.stcm.common.StrawberryBlocks;
import net.mootech.stcm.common.StrawberryFluids;
import net.mootech.stcm.common.StrawberryItems;
import net.mootech.stcm.common.block.StrawberryBlock;
import net.mootech.stcm.common.fluids.StrawberryFluid;
import net.mootech.stcm.common.items.StrawberryBlockItem;
import net.mootech.stcm.common.items.StrawberryBucketItem;
import net.mootech.stcm.common.items.StrawberryItem;

/**
 * @author Maxine Red
 * 
 * Provider for language file generation.
 *
 */
public class StrawberryTranslator extends LanguageProvider {

	/**
	 * @param gen
	 * @param locale
	 */
	public StrawberryTranslator(DataGenerator gen, String locale) {
		super(gen, StrawberryTwirlCompanion.ID, locale);
	}

	@Override
	protected void addTranslations() {
		add("itemGroup.strawberrytwirl", "Strawberry Twirl");
		// TODO redo translations
		/*for (StrawberryBlock block : StrawberryBlocks.REGISTERED_BLOCKS) {
			add((Block)block, block.getName().getString());
		}
		for (StrawberryBlockItem item : StrawberryItems.REGISTERED_BLOCK_ITEMS) {
			add((Item)item, item.getName());
		}
		for (StrawberryItem item : StrawberryItems.REGISTERED_ITEMS) {
			add((Item)item, item.getName());
		}
		for (StrawberryBucketItem bucket : StrawberryItems.BUCKETS) {
			add((Item)bucket, bucket.getName());
		}
		for (StrawberryFluid fluid : StrawberryFluids.SOURCE_FLUIDS) {
			add("fluid." + StrawberryTwirlCompanion.ID + "." + fluid.getID(), fluid.getName());
		}*/
	}

}
