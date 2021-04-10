package net.mootech.stcm.common.fluids;

import net.mootech.stcm.common.items.StrawberryBucketItem;
import net.mootech.stcm.util.Color;

public class JamFluid extends StrawberryFluid {

	public JamFluid(String id, Color color) {
		super(id + "_jam", color.darken(0.239).saturate(0.068), -1, false);
		this.bucket = new StrawberryBucketItem(() -> this, BUCKET_PROPERTIES);
	}

}
