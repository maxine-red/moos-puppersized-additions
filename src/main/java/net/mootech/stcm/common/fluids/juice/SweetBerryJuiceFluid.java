package net.mootech.stcm.common.fluids.juice;

import net.minecraft.fluid.FluidState;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.mootech.stcm.StrawberryTwirlCompanion;
import net.mootech.stcm.common.StrawberryFluids;
import net.mootech.stcm.common.StrawberryItems;
import net.mootech.stcm.util.Color;

public class SweetBerryJuiceFluid {
	
	public static final String ID = "void_essence";
	
	public static final int COLOR = new Color(0.4, 6, 0, 10).combine();
	//public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(StrawberryFluids.VOID_ESSENCE, StrawberryFluids.VOID_ESSENCE_FLOW,
	//		FluidAttributes.builder(new ResourceLocation(StrawberryTwirlCompanion.ID, "fluids/thick_still"), new ResourceLocation(StrawberryTwirlCompanion.ID, "fluids/thick_flowing"))
    //                .color(COLOR)).bucket(StrawberryItems.VOID_ESSENCE_BUCKET);
}