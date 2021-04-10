package net.mootech.stcm.common.items;

import java.util.function.Supplier;

import net.minecraft.item.Rarity;
import net.mootech.stcm.common.StrawberryItems;
import net.mootech.stcm.common.fluids.StrawberryFluid;

/**
 * Juice buckets are buckets for juices and hold additional info, like crop they are made from
 * @author Maxine Red
 *
 */
public class JuiceBucketItem extends StrawberryBucketItem {
	
	private final Supplier<JuiceItem> bottle;
	
	public JuiceBucketItem(Supplier<StrawberryFluid> fluid, Supplier<JuiceItem> bottle, Rarity rarity) {
		super(fluid, DEFAULT_BUCKET_PROPERTIES.rarity(rarity));
		this.bottle = bottle;
		StrawberryItems.JUICE_BUCKETS.add(this);
	}

	
	/**
	 * Get the bottle, associated with this bucket
	 * @return Item
	 */
	public JuiceItem getBottle() {
		return this.bottle.get();
	}
}
