package net.mootech.stcm.common.fluids;

import java.util.function.Supplier;

import net.minecraft.item.Rarity;
import net.mootech.stcm.common.items.JuiceBucketItem;
import net.mootech.stcm.common.items.JuiceItem;
import net.mootech.stcm.util.Color;

public class JuiceFluid extends StrawberryFluid {

	public JuiceFluid(String id, Color color, Supplier<JuiceItem> bottle) {
		this(id, color, bottle, Rarity.COMMON);
	}
	
	public JuiceFluid(String id, Color color, Supplier<JuiceItem> bottle, Rarity rarity) {
		super(id + "_juice", color, -1, false);
		this.bucket = new JuiceBucketItem(() -> this, bottle, rarity);
	}
}
