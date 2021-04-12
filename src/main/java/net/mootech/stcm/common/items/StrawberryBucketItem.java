package net.mootech.stcm.common.items;

import java.util.function.Supplier;

import net.minecraft.fluid.Fluid;
import net.minecraft.item.BucketItem;
import net.mootech.stcm.util.Color;

/**
 * Juice buckets are buckets for juices and hold additional info, like crop they are made from
 * @author Maxine Red
 *
 */
public class StrawberryBucketItem extends BucketItem {
	
	protected final Color color;

	public StrawberryBucketItem(Supplier<? extends Fluid> supplier, Properties builder, Color color) {
		super(supplier, builder);
		this.color = color;
	}
	
	public int getColor() {
		return this.color.combine_rgb();
	}
}
