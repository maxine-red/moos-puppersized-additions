package net.mootech.stcm.common.fluids;

import net.minecraft.util.ResourceLocation;
import net.mootech.stcm.StrawberryTwirlCompanion;

public abstract class JuiceFluid {
	
	public static final ResourceLocation BUCKET_RESOURCE = new ResourceLocation(StrawberryTwirlCompanion.ID, "item/bucket_overlay_drink"); 
	
	public static class Source extends StrawberryFluid.Source {

		public Source(Properties properties) {
			super(properties);
		}
		
	}
	
	public static class Flowing extends StrawberryFluid.Flowing {

		public Flowing(Properties properties) {
			super(properties);
		}
		
	}
	
}
