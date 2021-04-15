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

import net.minecraft.fluid.FluidState;
import net.minecraftforge.fluids.ForgeFlowingFluid;

public abstract class VirtualFluid {
	
	public static class Source extends ForgeFlowingFluid.Source {

		public Source(Properties properties) {
			super(properties);
		}
		
		@Override
		public int getAmount(FluidState state) {
			return 0;
		}
		
		@Override
		public boolean isSource(FluidState state) {
			return true;
		}
		
	}

	
	public static class Flowing extends ForgeFlowingFluid.Flowing {

		public Flowing(Properties properties) {
			super(properties);
		}
		
		@Override
		public int getAmount(FluidState state) {
			return 0;
		}
		
		@Override
		public boolean isSource(FluidState state) {
			return false;
		}
		
	}
}
