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
package net.mootech.mpa.data;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.data.DataGenerator;
import net.minecraft.state.Property;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.mootech.mpa.MoosPuppersizedAdditions;
import net.mootech.mpa.common.ModBlocks;

public class BlockStates extends BlockStateProvider {
	private static final int DEFAULT_ANGLE_OFFSET = 180;

	public BlockStates(DataGenerator gen, ExistingFileHelper exFileHelper) {
		super(gen, MoosPuppersizedAdditions.MOD_ID, exFileHelper);
	}

	@Override
	protected void registerStatesAndModels() {
		this.simpleBlock(ModBlocks.SALT_BLOCK.get());
		this.customDirectionalBlock(ModBlocks.SALT_CRYSTAL.get());
		this.directionalStorageBlock(ModBlocks.SALT_BAG.get());
		this.directionalStorageBlock(ModBlocks.WHEAT_SEED_BAG.get());
		this.directionalStorageBlock(ModBlocks.BEETROOT_SEED_BAG.get());
		this.directionalStorageBlock(ModBlocks.PUMPKIN_SEED_BAG.get());
		this.directionalStorageBlock(ModBlocks.MELON_SEED_BAG.get());
	}
	
	private void directionalStorageBlock(Block block) {
		this.directionalBlock(block, state -> directionalStorageState(state));
	}
	
	/**
	 * Create a block state file for custom shaped, directional blocks
	 * @param block Block
	 * @param ignored Ignored properties of block
	 */
	private void customDirectionalBlock(Block block, Property<?>... ignored) {
		getVariantBuilder(block).forAllStatesExcept(state -> directionalStateIgnore(state), ignored);
	}
	
	/**
	 * Get the existing model file for a block
	 * @param block Block
	 * @return ModelFile of block
	 */
	private ModelFile existingModel(Block block) {
		ResourceLocation model_location = new ResourceLocation(MoosPuppersizedAdditions.MOD_ID, "block/" + block.getRegistryName().getPath());
		return new ModelFile.ExistingModelFile(model_location, models().existingFileHelper);
	}
	
	/**
	 * Create a block state file
	 * @param state BlockState
	 * @return block state file information
	 */
	private ConfiguredModel[] directionalStateIgnore(BlockState state) {
		Direction dir = state.getValue(BlockStateProperties.FACING);
		return ConfiguredModel.builder().modelFile(this.existingModel(state.getBlock()))
				.rotationX(dir == Direction.DOWN ? 180 : dir.getAxis().isHorizontal() ? 90 : 0)
				.rotationY(dir.getAxis().isVertical() ? 0 : ((int) dir.toYRot() + DEFAULT_ANGLE_OFFSET) % 360)
				.build();
	}
	
	private ModelFile directionalStorageState(BlockState state) {
		Direction dir = state.getValue(BlockStateProperties.FACING);
		return buildModelStorage(state.getBlock(), dir);
	}
	
	/**
	 * Build a model for storage blocks
	 * @param block Block
	 * @return Model builder
	 */
	private BlockModelBuilder buildModelStorage(Block block, Direction dir) {
		String block_name = block.getRegistryName().getPath();
		ResourceLocation side = new ResourceLocation(MoosPuppersizedAdditions.MOD_ID, "block/" + block_name + "_side");
		ResourceLocation bottom = new ResourceLocation(MoosPuppersizedAdditions.MOD_ID, "block/" + block_name + "_bottom");
		ResourceLocation top = new ResourceLocation(MoosPuppersizedAdditions.MOD_ID, "block/" + block_name + (dir == Direction.UP ? "_top" : "_bottom")); // TODO replace with top closed texture
		return 	models().cubeBottomTop(block_name + (dir == Direction.UP ? "" : "_closed"), side, bottom, top);
	}

}
