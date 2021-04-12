package net.mootech.stcm.common.fluids;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.mootech.stcm.StrawberryTwirlCompanion;
import net.mootech.stcm.common.StrawberryFluids;
import net.mootech.stcm.common.StrawberryItems;

public class SaltyWaterFluid {
	public static final String ID = "salty_water";
	private static final FluidAttributes.Builder ATTRIBUTES = FluidAttributes.builder(new ResourceLocation(StrawberryTwirlCompanion.ID, "fluids/" + ID), new ResourceLocation(StrawberryTwirlCompanion.ID, "fluids/" + ID + "_flow"));
	private static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(StrawberryFluids.SALTY_WATER, StrawberryFluids.SALTY_WATER_FLOWING, ATTRIBUTES).bucket(StrawberryItems.SALTY_WATER_BUCKET);
	
	public static class Source extends StrawberryFluid.Source {

		public Source() {
			super(PROPERTIES);
		}
		
	}
	
	public static class Flowing extends StrawberryFluid.Flowing {

		public Flowing() {
			super(PROPERTIES);
		}
		
	}

}
