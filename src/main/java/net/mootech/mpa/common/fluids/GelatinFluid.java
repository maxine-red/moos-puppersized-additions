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
package net.mootech.mpa.common.fluids;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.mootech.mpa.MoosPuppersizedAdditions;
import net.mootech.mpa.common.ModFluids;
import net.mootech.mpa.common.ModItems;

/**
 * @author Maxine Red
 *
 */
public class GelatinFluid {
	public static final String ID = "gelatin";
	private static final FluidAttributes.Builder ATTRIBUTES = FluidAttributes.builder(new ResourceLocation(MoosPuppersizedAdditions.MOD_ID, "fluids/" + ID), new ResourceLocation(MoosPuppersizedAdditions.MOD_ID, "fluids/" + ID + "_flow"));
	private static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(ModFluids.GELATIN, ModFluids.GELATIN_FLOWING, ATTRIBUTES).bucket(ModItems.GELATIN_BUCKET);
	
	public static class Source extends VirtualFluid.Source {

		public Source() {
			super(PROPERTIES);
		}
		
	}
	
	public static class Flowing extends VirtualFluid.Flowing {

		public Flowing() {
			super(PROPERTIES);
		}
		
	}

}
