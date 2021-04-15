package net.mootech.mpa.common.items;

import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

/**
 * Juice items to have their own drink sound
 * @author Maxine Red
 *
 */
public class JuiceItem extends DrinkableItem {

	public JuiceItem(Properties properties, boolean isChorus) {
		super(properties, isChorus);
	}

	/**
	 * Override drinking sound
	 */
	@Override
	public SoundEvent getEatingSound() {
		return SoundEvents.GENERIC_DRINK;
	}
}
