package net.mootech.mpa.common.fluids;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.mootech.mpa.MoosPuppersizedAdditions;
import net.mootech.mpa.common.ModFluids;
import net.mootech.mpa.common.ModItems;

public class SaltyWaterFluid {
	public static final String ID = "salty_water";
	private static final FluidAttributes.Builder ATTRIBUTES = FluidAttributes.builder(new ResourceLocation(MoosPuppersizedAdditions.MOD_ID, "fluids/" + ID), new ResourceLocation(MoosPuppersizedAdditions.MOD_ID, "fluids/" + ID + "_flow"));
	private static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(ModFluids.SALTY_WATER, ModFluids.SALTY_WATER_FLOWING, ATTRIBUTES).bucket(ModItems.SALTY_WATER_BUCKET);
	
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
