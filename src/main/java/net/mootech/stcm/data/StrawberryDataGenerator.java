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

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import net.mootech.stcm.StrawberryTwirlCompanion;

/**
 * @author Maxine Red
 * 
 * Data generation handler, for models, recipes and everything else.
 *
 */
@EventBusSubscriber(modid = StrawberryTwirlCompanion.ID, bus = Bus.MOD)
public class StrawberryDataGenerator {
	
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		ExistingFileHelper helper = event.getExistingFileHelper();
		DataGenerator generator = event.getGenerator();
		if(event.includeClient()) {
			generator.addProvider(new BlockStates(generator, helper));
			generator.addProvider(new ItemModels(generator, helper));
		}
		
		if (event.includeServer()) {
			BlockTags blockTags = new BlockTags(generator, StrawberryTwirlCompanion.ID, helper);
			generator.addProvider(new StrawberryRecipes(generator));
			generator.addProvider(new StrawberryTranslator(generator, "en_us"));
			generator.addProvider(new StrawberryItemTags(generator, blockTags, StrawberryTwirlCompanion.ID, helper));
		}
	}
}
