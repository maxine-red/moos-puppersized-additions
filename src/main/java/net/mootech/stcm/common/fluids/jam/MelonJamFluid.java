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

package net.mootech.stcm.common.fluids.jam;

import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.mootech.stcm.common.StrawberryFluids;
import net.mootech.stcm.common.StrawberryItems;
import net.mootech.stcm.common.fluids.JamFluidDefinition;
import net.mootech.stcm.util.Color;

/**
 * @author Maxine Red
 *
 */
public class MelonJamFluid extends JamFluidDefinition {
	public static final String ID = "melon" + group;
	
	public static final int COLOR = new Color(alpha, 22, 179, 11).combine();
	//public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(StrawberryFluids.MELON_JAM, StrawberryFluids.MELON_JAM_FLOW,
	//		FluidAttributes.builder(STILL_RESOURCE, FLOWING_RESOURCE).color(COLOR)).bucket(StrawberryItems.MELON_JAM_BUCKET);
}
