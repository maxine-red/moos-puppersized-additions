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

import java.util.regex.Pattern;

import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.mootech.stcm.StrawberryTwirlCompanion;
import net.mootech.stcm.common.StrawberryItems;
import net.mootech.stcm.common.items.StrawberryItem;
import net.mootech.stcm.common.items.JuiceItem;
import net.mootech.stcm.common.items.StrawberryBucketItem;

/**
 * @author Maxine Red
 *
 *	Creates models for items, these can be layered or not.
 */
public class StrawberryItemModelProvider extends ItemModelProvider {
	private static final String GENERATED = "item/generated";

	private static final ResourceLocation bucket_base = new ResourceLocation(StrawberryTwirlCompanion.ID, "item/bucket_base");
	private static final ResourceLocation bucket_overlay_thin = new ResourceLocation(StrawberryTwirlCompanion.ID, "item/bucket_overlay_thin");
	private static final ResourceLocation bucket_overlay_drink = new ResourceLocation(StrawberryTwirlCompanion.ID, "item/bucket_overlay_drink");
	
	private static final ResourceLocation bottle_base = new ResourceLocation(StrawberryTwirlCompanion.ID, "item/bottle_base");
	private static final ResourceLocation bottle_overlay = new ResourceLocation(StrawberryTwirlCompanion.ID, "item/bottle_overlay");

	//private static final ResourceLocation jar_base = new ResourceLocation(StrawberryTwirlCompanion.ID, "item/jar_base");
	//private static final ResourceLocation jar_overlay = new ResourceLocation(StrawberryTwirlCompanion.ID, "item/jar_overlay");
	
	private static final Pattern juice_pattern = Pattern.compile("_juice");
	private static final Pattern jam_pattern = Pattern.compile("_jam");
	private static final Pattern chorus_pattern = Pattern.compile("chorus");

	/**
	 * Item Model generator
	 * @param generator Generator from generation event
	 * @param existingFileHelper Helper to check if files exist
	 */
	public StrawberryItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, StrawberryTwirlCompanion.ID, existingFileHelper);
	}

	@Override
	protected void registerModels() {
		for (StrawberryItem item : StrawberryItems.REGISTERED_ITEMS) {
			if(!(StrawberryItems.JUICES.contains(item))) {
				withExistingParent(item.getId(), GENERATED).texture("layer0", "item/" + item.getId());
			}
			
		}
		for (StrawberryBucketItem bucket : StrawberryItems.BUCKETS) {
			if (juice_pattern.matcher(bucket.getId()).find()) {
				withExistingParent(bucket.getId(), GENERATED).texture("layer0", bucket_base);
				withExistingParent(bucket.getId(), GENERATED).texture("layer1", bucket_overlay_drink);
			}
			else if (jam_pattern.matcher(bucket.getId()).find()) {
				withExistingParent(bucket.getId(), GENERATED).texture("layer0", bucket_base);
				withExistingParent(bucket.getId(), GENERATED).texture("layer1", bucket_overlay_thin);
			}
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
		}
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
	}

}
