package net.mootech.stcm.common.fluids;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.mootech.stcm.StrawberryTwirlCompanion;
import net.mootech.stcm.common.StrawberryFluids;
import net.mootech.stcm.common.StrawberryItems;

public class AppleJuiceFluid {
	private static final String ID = "apple_juice";
	private static final FluidAttributes.Builder ATTRIBUTES = FluidAttributes.builder(new ResourceLocation(StrawberryTwirlCompanion.ID, "fluids/" + ID), new ResourceLocation(StrawberryTwirlCompanion.ID, "fluids/" + ID + "_flow"));
	private static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(StrawberryFluids.APPLE_JUICE, StrawberryFluids.APPLE_JUICE_FLOWING, ATTRIBUTES).bucket(StrawberryItems.APPLE_JUICE_BUCKET);
	
	public static class Source extends JuiceFluid.Source {

		public Source() {
			super(PROPERTIES);
		}
		
	}
	
	public static class Flowing extends JuiceFluid.Flowing {

		public Flowing() {
			super(PROPERTIES);
		}
		
	}

}
