package net.mootech.stcm.common.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
/**
 * Burnable items. One item is smelted in 200 ticks
 * @author Maxine Red
 *
 */
public class BurnAbleItem extends Item {
	
	private final int burnTime;
	/**
	 * Constructor for bunarbale items
	 * @param properties Item properties
	 * @param burnTime Burn time (200 ticks smelts one item in furnace)
	 */
	public BurnAbleItem(Properties properties, int burnTime) {
		super(properties);
		this.burnTime = burnTime;
	}
	
	@Override
	public int getBurnTime(ItemStack item) {
		return burnTime;
	}

}
