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
package net.mootech.mpa.client;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.mootech.mpa.MoosPuppersizedAdditions;
import net.mootech.mpa.common.ModBlocks;

@Mod.EventBusSubscriber(modid = MoosPuppersizedAdditions.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModClientInitializer {
    
	private static final Logger LOGGER = LogManager.getLogger();
	
	public static void init(final FMLClientSetupEvent event) {
		LOGGER.info("Registering block render types");
		List<RenderType> oreRenders = new ArrayList<>();
		oreRenders.add(RenderType.solid());
		oreRenders.add(RenderType.translucent());
		RenderTypeLookup.setRenderLayer(ModBlocks.SALT_CRYSTAL.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(ModBlocks.SALT_SAND_ORE.get(), oreRenders::contains); // use this version for multi-layer models
		RenderTypeLookup.setRenderLayer(ModBlocks.SALT_STONE_ORE.get(), oreRenders::contains);
	}

}
