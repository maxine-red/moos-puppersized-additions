package net.mootech.mpa.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorldReader;

/**
 * Generic class for ores, that drop experience
 * @author Maxine Red
 *
 */
public class ExpOreBlock extends Block {
	
	private final int min_exp;
	private final int max_exp;

	public ExpOreBlock(Properties properties) {
		this(properties, 2, 5);
	}
	
	public ExpOreBlock(Properties properties, int min, int max) {
		super(properties);
		this.min_exp = min;
		this.max_exp = max;
	}

	/**
	 * Drop exp for mining
	 */
    @Override
    public int getExpDrop(BlockState state, IWorldReader world, BlockPos pos, int fortune, int silktouch) {
        return silktouch == 0 ? fortune * MathHelper.nextInt(RANDOM, min_exp, max_exp) : 0;
    }
}
