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
import net.minecraftforge.fluids.ForgeFlowingFluid;

public abstract class VirtualFluid extends ForgeFlowingFluid {
	
	protected VirtualFluid(Properties properties) {
		super(properties);
	}

	public static class Flowing extends VirtualFluid {

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
	
	public static class Source extends VirtualFluid {

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
