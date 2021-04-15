package net.mootech.mpa.common.fluids;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.mootech.mpa.MoosPuppersizedAdditions;
import net.mootech.mpa.common.ModFluids;
import net.mootech.mpa.common.ModItems;

public class AppleJuiceFluid {
	public static final String ID = "apple_juice";
	private static final FluidAttributes.Builder ATTRIBUTES = FluidAttributes.builder(new ResourceLocation(MoosPuppersizedAdditions.MOD_ID, "fluids/" + ID), new ResourceLocation(MoosPuppersizedAdditions.MOD_ID, "fluids/" + ID + "_flow"));
	private static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(ModFluids.APPLE_JUICE, ModFluids.APPLE_JUICE_FLOWING, ATTRIBUTES).bucket(ModItems.APPLE_JUICE_BUCKET);
	
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
