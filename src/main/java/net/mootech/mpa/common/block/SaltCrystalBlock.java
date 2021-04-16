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

import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

/**
 * Salt Crystal block
 * @author Maxine Red
 *
 */
public class SaltCrystalBlock extends ModelBlock implements IWaterLoggable {
	
	private static final Block.Properties PROPERTIES = Block.Properties.of(Material.ICE);
	public static final DirectionProperty FACING = BlockStateProperties.FACING;
	protected Map<Direction, VoxelShape> directional_shape = new HashMap<>();
	
	// TODO Needs testing for support block and also fixing hit boxes
	
	public SaltCrystalBlock() {
		super(PROPERTIES);
		this.directional_shape.put(Direction.DOWN, Block.box(2.0, 0.0, 3.0, 14.0, 4.0, 12.0));
		this.directional_shape.put(Direction.UP, Block.box(2.0, 16.0, 3.0, 14.0, 12.0, 12.0));
		this.directional_shape.put(Direction.EAST, Block.box(2.0, 0.0, 3.0, 14.0, 4.0, 12.0));
		this.directional_shape.put(Direction.WEST, Block.box(2.0, 0.0, 3.0, 14.0, 4.0, 12.0));
		this.directional_shape.put(Direction.NORTH, Block.box(2.0, 0.0, 3.0, 14.0, 4.0, 12.0));
		this.directional_shape.put(Direction.SOUTH, Block.box(2.0, 0.0, 3.0, 14.0, 4.0, 12.0));
		BlockState state = this.defaultBlockState();
		this.registerDefaultState(state.setValue(FACING, Direction.DOWN));
	}

	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}


	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction facing = state.getValue(FACING);
		if (directional_shape.containsKey(facing)) {
			return directional_shape.get(facing);
		}
		else {
			return shape;
		}
	}


	/*@Override
	public FluidState getFluidState(BlockState state) {
		return state.getValue(WATERLOGGED) ? Fluids.WATER.defaultFluidState() : super.getFluidState(state);
	}*/

	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		//FluidState fluid = context.getLevel().getFluidState(context.getClickedPos());
		return this.defaultBlockState().setValue(FACING, context.getNearestLookingDirection().getOpposite());//.setValue(WATERLOGGED, fluid.getFluidState() == Fluids.WATER.defaultFluidState());
	}
}
