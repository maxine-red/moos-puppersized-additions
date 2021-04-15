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

package net.mootech.mpa.data;

import java.util.Set;

import net.minecraft.data.DataGenerator;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraftforge.common.data.LanguageProvider;
import net.mootech.mpa.MoosPuppersizedAdditions;
import net.mootech.mpa.common.ModCommonInitializer;
import net.mootech.mpa.common.ModItems;
import net.mootech.mpa.util.StringID;

/**
 * @author Maxine Red
 * 
 * Provider for language file generation.
 *
 */
public class Translator extends LanguageProvider {

	/**
	 * @param gen
	 * @param locale
	 */
	public Translator(DataGenerator gen, String locale) {
		super(gen, MoosPuppersizedAdditions.MOD_ID, locale);
	}

	@Override
	protected void addTranslations() {
		add("itemGroup.moospuppersizedadditions", "Moo's Puppersized Additions");
		addItems();
		addFluids();
		
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
	
	private void addItems() {
		Set<Item> items = ModCommonInitializer.getRegisteredModItems(MoosPuppersizedAdditions.MOD_ID);
		
		add(ModItems.BEES_WAX.get(), "Bee's Wax");
		items.remove(ModItems.BEES_WAX.get());
		
		add(ModItems.SALT_SAND_ORE.get(), "Salt Shale");
		items.remove(ModItems.SALT_SAND_ORE.get());
		add(ModItems.SALT_STONE_ORE.get(), "Rock Salt");
		items.remove(ModItems.SALT_STONE_ORE.get());
		
		// Use a simple approach for remaining items
		items.forEach((item) -> translateSimpleItem(item));
	}
	
	private void translateSimpleItem(Item item) {
		add(item, StringID.idToName(item.getRegistryName().getPath()));
	}

	
	private void addFluids() {
		Set<Fluid> fluids = ModCommonInitializer.getRegisteredModFluids(MoosPuppersizedAdditions.MOD_ID);
		
		fluids.forEach((fluid) -> add("fluid." + MoosPuppersizedAdditions.MOD_ID + "." + fluid.getRegistryName().getPath(), StringID.idToName(fluid.getRegistryName().getPath())));
	}

}
