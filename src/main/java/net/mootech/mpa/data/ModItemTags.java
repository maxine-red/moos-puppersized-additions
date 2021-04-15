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
import java.util.regex.Pattern;

import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.item.Item;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.mootech.mpa.MoosPuppersizedAdditions;
import net.mootech.mpa.common.ModCommonInitializer;

/**
 * @author Maxine Red
 *
 */
public class ModItemTags extends ItemTagsProvider {
	
	private ITag.INamedTag<Item> CREATE_UPRIGHT_ON_BELT = ItemTags.bind(new ResourceLocation("create", "upright_on_belt").toString());
	private ITag.INamedTag<Item> DIET_FRUITS = ItemTags.bind(new ResourceLocation("diet", "fruits").toString());
	private ITag.INamedTag<Item> DIET_VEGETABLES = ItemTags.bind(new ResourceLocation("diet", "vegetables").toString());
	private ITag.INamedTag<Item> DIET_PROTEINS = ItemTags.bind(new ResourceLocation("diet", "proteins").toString());
	private ITag.INamedTag<Item> DIET_GRAINS = ItemTags.bind(new ResourceLocation("diet", "grains").toString());
	private ITag.INamedTag<Item> DIET_SUGARS = ItemTags.bind(new ResourceLocation("diet", "sugars").toString());
	private ITag.INamedTag<Item> DIET_WATER = ItemTags.bind(new ResourceLocation("diet", "water").toString());
	private ITag.INamedTag<Item> FORGE_EDIBLES = ItemTags.bind(new ResourceLocation("forge", "edibles").toString());

	private final Pattern carrot_pattern = Pattern.compile("carrot");
	private final Pattern juice_pattern = Pattern.compile("juice");
	private final Pattern bucket_pattern = Pattern.compile("bucket");


	// TODO add diet tags for sugar, fruit etc
	// TODO add other items to upright on belt, that should be upright on create belts
	public ModItemTags(DataGenerator gen, BlockTagsProvider provider, ExistingFileHelper existingFileHelper) {
		super(gen, provider,  MoosPuppersizedAdditions.MOD_ID, existingFileHelper);
	}

    @Override
    public void addTags() {
    	Set<Item> items = ModCommonInitializer.getRegisteredModItems(modId);
    	items.forEach(i -> addItemsToTags(i));
    }
    
    private void addItemsToTags(Item item) {
    	String item_id = item.getRegistryName().getPath();
    	if (juice_pattern.matcher(item_id).find() && !bucket_pattern.matcher(item_id).find()) {
        	getOrCreateRawBuilder(CREATE_UPRIGHT_ON_BELT).addElement(item.getRegistryName(), folder);
        	getOrCreateRawBuilder(FORGE_EDIBLES).addElement(item.getRegistryName(), folder);
        	getOrCreateRawBuilder(DIET_WATER).addElement(item.getRegistryName(), folder);
        	if (carrot_pattern.matcher(item_id).find()) {
            	getOrCreateRawBuilder(DIET_VEGETABLES).addElement(item.getRegistryName(), folder);
        	}
        	else {
            	getOrCreateRawBuilder(DIET_FRUITS).addElement(item.getRegistryName(), folder);
        	}
    	}
    }
}
