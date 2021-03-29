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
package net.mootech.stcm.common.fluids;

import net.minecraft.fluid.FluidState;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.mootech.stcm.StrawberryTwirlCompanion;
import net.mootech.stcm.common.StrawberryFluids;
import net.mootech.stcm.common.StrawberryItems;
import net.mootech.stcm.util.Color;

public abstract class VoidEssence extends ForgeFlowingFluid {
	
	public static final String ID = "void_essence";
	
	public static final int COLOR = new Color(0.4f, 6, 0, 10).combine();
	public static final Properties PROPERTIES = new Properties(StrawberryFluids.VOID_ESSENCE, StrawberryFluids.VOID_ESSENCE_FLOW,
			FluidAttributes.builder(new ResourceLocation(StrawberryTwirlCompanion.ID, "fluids/thick_still"), new ResourceLocation(StrawberryTwirlCompanion.ID, "fluids/thick_flowing"))
                    .color(COLOR)).bucket(StrawberryItems.VOID_ESSENCE_BUCKET);
	
	protected VoidEssence(Properties properties) {
		super(properties);
	}

	public static class Flowing extends VoidEssence {

		public Flowing(Properties properties) {
			super(properties);
		}

        @Override
        public int getAmount(FluidState fluidState) {
            return 0;
        }

        @Override
        public boolean isSource(FluidState state) {
            return false;
        }
		
	}
	
	public static class Source extends VoidEssence {

		public Source(Properties properties) {
			super(properties);
		}

        @Override
        public int getAmount(FluidState fluidState) {
            return 0;
        }

        @Override
        public boolean isSource(FluidState state) {
            return true;
        }
		
	}

}
