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
package net.mootech.stcm.common.fluids.magic;

import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.mootech.stcm.common.StrawberryFluids;
import net.mootech.stcm.common.fluids.MagicFluidDefinition;
import net.mootech.stcm.util.Color;

public class VoidEssenceFluid extends MagicFluidDefinition {
	
	public static final String ID = "void_essence";
	
	public static final int COLOR = new Color(1.0, 45, 0, 45).combine();
	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(StrawberryFluids.VOID_ESSENCE, StrawberryFluids.VOID_ESSENCE_FLOW,
			FluidAttributes.builder(STILL_RESOURCE, FLOWING_RESOURCE).color(COLOR));
}
