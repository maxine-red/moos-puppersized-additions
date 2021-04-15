package net.mootech.mpa.data;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.mootech.mpa.MoosPuppersizedAdditions;
import net.mootech.mpa.common.ModBlocks;

public class BlockStates extends BlockStateProvider {

	public BlockStates(DataGenerator gen, ExistingFileHelper exFileHelper) {
		super(gen, MoosPuppersizedAdditions.MOD_ID, exFileHelper);
	}

	@Override
	protected void registerStatesAndModels() {
		this.simpleBlock(ModBlocks.SALT_BLOCK.get());
		
	}

}
