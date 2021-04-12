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

import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.mootech.stcm.StrawberryTwirlCompanion;
import net.mootech.stcm.common.StrawberryFluids;
import net.mootech.stcm.common.StrawberryInitializer;
import net.mootech.stcm.common.StrawberryItems;
import net.mootech.stcm.common.fluids.JuiceFluid;

/**
 * @author Maxine Red
 *
 *	Creates models for items, these can be layered or not.
 */
public class ItemModels extends ItemModelProvider {
	private static final String GENERATED = "item/generated";
	private static final String HAND_HELD = "item/handheld";

	private static final ResourceLocation bucket_base = new ResourceLocation(StrawberryTwirlCompanion.ID, "item/bucket_base");
	
	private static final ResourceLocation bottle_base = new ResourceLocation(StrawberryTwirlCompanion.ID, "item/bottle_base");
	private static final ResourceLocation bottle_overlay = new ResourceLocation(StrawberryTwirlCompanion.ID, "item/bottle_overlay");

	//private static final ResourceLocation jar_base = new ResourceLocation(StrawberryTwirlCompanion.ID, "item/jar_base");
	//private static final ResourceLocation jar_overlay = new ResourceLocation(StrawberryTwirlCompanion.ID, "item/jar_overlay");
	
	private static final Pattern chorus_pattern = Pattern.compile("chorus");
	private static final Pattern juice_pattern = Pattern.compile("_juice");

	/**
	 * Item Model generator
	 * @param generator Generator from generation event
	 * @param existingFileHelper Helper to check if files exist
	 */
	public ItemModels(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, StrawberryTwirlCompanion.ID, existingFileHelper);
	}

	@Override
	protected void registerModels() {
		Set<Item> items = StrawberryInitializer.getRegisteredModItems(StrawberryTwirlCompanion.ID);
		Set<Block> blocks = StrawberryInitializer.getRegisteredModBlocks(StrawberryTwirlCompanion.ID);
		Set<Fluid> fluids = StrawberryInitializer.getRegisteredModFluids(StrawberryTwirlCompanion.ID);

		// Register item models for simple blocks
		blocks.forEach((block) -> registerBlockItem(block, items));
		
		// Register buckets for simple fluids
		fluids.forEach((fluid) -> registerFluidBucketItem(fluid, items));
		
		// Use a simple approach for remaining items
		items.forEach((item) -> registerSimpleItem(item));
		/*for(StrawberryBlockItem block : StrawberryItems.REGISTERED_BLOCK_ITEMS) {
			withExistingParent(block.getId(), block.getBlock().getRegistryName());
		}
		
		for (StrawberryBucketItem bucket : StrawberryItems.BUCKETS) {
			withExistingParent(bucket.getId(), GENERATED).texture("layer0", bucket_base);
			withExistingParent(bucket.getId(), GENERATED).texture("layer1", bucket.getOverlay());
		}
		
		for (JuiceItem juice : StrawberryItems.JUICES) {
			if (!chorus_pattern.matcher(juice.getId()).find()) {
				withExistingParent(juice.getId(), GENERATED).texture("layer0", bottle_base);
				withExistingParent(juice.getId(), GENERATED).texture("layer1", bottle_overlay);
			}
			else {
				withExistingParent(juice.getId(), GENERATED).texture("layer0", "item/bottle_base_chorus");
				withExistingParent(juice.getId(), GENERATED).texture("layer1", "item/bottle_overlay_chorus");
			}
		}*/
			/*else if (jam_pattern.matcher(bottle.getId()).find()) {
				if (!chorus_pattern.matcher(bottle.getId()).find()) {
					withExistingParent(bottle.getId(), GENERATED).texture("layer0", jar_base);
					withExistingParent(bottle.getId(), GENERATED).texture("layer1", jar_overlay);
				}
				else {
					withExistingParent(bottle.getId(), GENERATED).texture("layer0", "item/jar_base_chorus");
					withExistingParent(bottle.getId(), GENERATED).texture("layer1", "item/jar_overlay_chorus");
				}
			}*/
		
		// Register Items, that are not in other groups
		/*for (StrawberryItem item : StrawberryItems.REGISTERED_ITEMS) {
			if(!(StrawberryItems.JUICES.contains(item))) {
				withExistingParent(item.getId(), GENERATED).texture("layer0", "item/" + item.getId());
			}
		}*/
	}
	
	private void registerSimpleItem(Item item) {
		String item_id = item.getRegistryName().getPath();
		withExistingParent(item_id, GENERATED).texture("layer0", "item/" + item_id);
	}
	
	private void registerBlockItem(Block block, Set<Item> items) {
		withExistingParent(block.asItem().getRegistryName().getPath(), StrawberryTwirlCompanion.ID + ":block/" + block.getRegistryName().getPath());
		items.remove(block.asItem());
	}
	
	private void registerFluidBucketItem(Fluid juice, Set<Item> items) {
		String bucket_id = juice.getBucket().getRegistryName().getPath();
		withExistingParent(bucket_id, GENERATED).texture("layer0", bucket_base);
		if (juice_pattern.matcher(bucket_id).find()) {
			withExistingParent(bucket_id, GENERATED).texture("layer1", JuiceFluid.BUCKET_RESOURCE);
		}
		items.remove(juice.getBucket());
	}

}
