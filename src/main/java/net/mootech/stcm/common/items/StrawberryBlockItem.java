package net.mootech.stcm.common.items;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.mootech.stcm.common.StrawberryItems;
import net.mootech.stcm.common.block.StrawberryBlock;
import net.mootech.stcm.util.StringID;

public class StrawberryBlockItem extends BlockItem {

	protected final String id;
	protected final int burn_time;
	protected String name;
	
	public StrawberryBlockItem(String id, Block block, Properties properties) {
		this(id, block, properties, -1);
	}
	
	public StrawberryBlockItem(String id, Block block, Properties properties, int burn_time) {
		this(id, block, properties, -1, StringID.idToName(id));
	}

	public StrawberryBlockItem(String id, Block block, Properties properties, int burn_time, String name) {
		super(block, properties);
		this.id = id;
		this.burn_time = burn_time;
		this.name = name;
		StrawberryItems.REGISTERED_BLOCK_ITEMS.add(this);
	}
	
	/**
	 * String ID for this bucket
	 * @return String
	 */
	public String getId() {
		return this.id;
	}
	
	/**
	 * Get in-game name of item
	 * @return String
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Set in-game name of item
	 * @return this
	 */
	public StrawberryBlockItem setName(String name) {
		this.name = name;
		return this;
	}

	@Override
	public int getBurnTime(ItemStack itemStack)
	{
		return burn_time;
	}
}
