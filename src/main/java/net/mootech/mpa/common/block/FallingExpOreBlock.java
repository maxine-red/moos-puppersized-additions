package net.mootech.mpa.common.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.FallingBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorldReader;

/**
 * Blocks that are exp dropping ores and can fall with gravity
 * @author Maxine Red
 *
 */
public class FallingExpOreBlock extends FallingBlock {
	
	private final int min_exp;
	private final int max_exp;

	public FallingExpOreBlock(Properties properties) {
		this(properties, 2, 5);
	}
	
	public FallingExpOreBlock(Properties properties, int min, int max) {
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
