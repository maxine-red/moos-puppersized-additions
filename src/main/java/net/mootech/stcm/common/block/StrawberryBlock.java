package net.mootech.stcm.common.block;

import net.minecraft.block.Block;

public class StrawberryBlock extends Block {
	
	protected final String id;

	public StrawberryBlock(String id, Properties properties) {
		super(properties);
		this.id = id;
	}
	
	/**
	 * Get block id
	 * @return String
	 */
	public String getId() {
		return this.id;
	}

}
