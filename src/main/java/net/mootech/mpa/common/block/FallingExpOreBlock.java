/**
 * Copyright 2021 Maxine Red
 * This file is part of Moo's Puppersized Additions.
 *
 * Moo's Puppersized Additions is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Moo's Puppersized Additions is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Moo's Puppersized Additions.  If not, see <https://www.gnu.org/licenses/>.
 */
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
