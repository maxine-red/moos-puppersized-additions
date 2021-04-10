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

import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.item.Item;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.mootech.stcm.common.StrawberryItems;
import net.mootech.stcm.common.items.JuiceItem;

/**
 * @author Maxine Red
 *
 */
public class StrawberryItemTags extends ItemTagsProvider {
	
	private ITag.INamedTag<Item> CREATE_UPRIGHT_ON_BELT = ItemTags.bind(new ResourceLocation("create", "upright_on_belt").toString());


	// TODO add diet tags for sugar, fruit etc
	// TODO add other items to upright on belt, that should be upright on create belts
	public StrawberryItemTags(DataGenerator gen, BlockTagsProvider provider, String modId, ExistingFileHelper existingFileHelper) {
		super(gen, provider, modId, existingFileHelper);
	}

    @Override
    public void addTags() {
    	for (JuiceItem juice : StrawberryItems.JUICES) {
        	getOrCreateRawBuilder(CREATE_UPRIGHT_ON_BELT).addElement(juice.getRegistryName(), folder);
    	}
    }
}
