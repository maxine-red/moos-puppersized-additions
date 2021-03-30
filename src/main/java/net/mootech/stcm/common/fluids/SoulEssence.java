package net.mootech.stcm.common.fluids;

import net.minecraft.fluid.FluidState;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.mootech.stcm.StrawberryTwirlCompanion;
import net.mootech.stcm.common.StrawberryFluids;
import net.mootech.stcm.common.StrawberryItems;
import net.mootech.stcm.util.Color;

public class SoulEssence {
	
	public static final String ID = "soul_essence";
	
	public static final int COLOR = new Color(0.6, 99, 84, 77).combine();
	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(StrawberryFluids.SOUL_ESSENCE, StrawberryFluids.SOUL_ESSENCE_FLOW,
			FluidAttributes.builder(new ResourceLocation(StrawberryTwirlCompanion.ID, "fluids/thick_still"), new ResourceLocation(StrawberryTwirlCompanion.ID, "fluids/thick_flowing"))
                    .color(COLOR)).bucket(StrawberryItems.SOUL_ESSENCE_BUCKET);
}
