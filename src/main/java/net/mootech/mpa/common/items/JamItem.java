package net.mootech.mpa.common.items;

import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.mootech.mpa.common.ModItems;

/**
 * Jam jars, to have their own drink sound
 * @author Maxine Red
 *
 */
public class JamItem extends DrinkableItem {

	public JamItem(Properties properties, boolean isChorus) {
		super(properties, isChorus);
	}

	/**
	 * Override drinking sound
	 */
	@Override
	public SoundEvent getEatingSound() {
		return SoundEvents.HONEY_DRINK;
	}
}
