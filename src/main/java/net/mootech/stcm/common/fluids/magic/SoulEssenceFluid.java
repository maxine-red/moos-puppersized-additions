package net.mootech.stcm.common.fluids.magic;

import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.mootech.stcm.common.StrawberryFluids;
import net.mootech.stcm.common.fluids.MagicFluidDefinition;
import net.mootech.stcm.util.Color;

public class SoulEssenceFluid extends MagicFluidDefinition {
	
	public static final String ID = "soul_essence";
	
	public static final int COLOR = new Color(0.9, 0,0,45).combine();
	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(StrawberryFluids.SOUL_ESSENCE, StrawberryFluids.SOUL_ESSENCE_FLOW,
			FluidAttributes.builder(STILL_RESOURCE, FLOWING_RESOURCE).color(COLOR));
}
