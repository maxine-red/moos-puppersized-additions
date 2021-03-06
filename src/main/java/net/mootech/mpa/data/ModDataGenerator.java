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

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import net.mootech.mpa.MoosPuppersizedAdditions;

/**
 * @author Maxine Red
 * 
 * Data generation handler, for models, recipes and everything else.
 *
 */
@EventBusSubscriber(modid = MoosPuppersizedAdditions.MOD_ID, bus = Bus.MOD)
public class ModDataGenerator {
	
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		ExistingFileHelper helper = event.getExistingFileHelper();
		DataGenerator generator = event.getGenerator();
		if(event.includeClient()) {
			generator.addProvider(new BlockStates(generator, helper));
			generator.addProvider(new ItemModels(generator, helper));
		}
		
		if (event.includeServer()) {
			BlockTags blockTags = new BlockTags(generator, MoosPuppersizedAdditions.MOD_ID, helper);
			generator.addProvider(new ModRecipes(generator));
			generator.addProvider(new Translator(generator, "en_us"));
			generator.addProvider(new ModItemTags(generator, blockTags, helper));
		}
	}
}
