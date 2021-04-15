package net.mootech.mpa.data;

import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockTags extends BlockTagsProvider {

	public BlockTags(DataGenerator gen, String modId, ExistingFileHelper existingFileHelper) {
		super(gen, modId, existingFileHelper);
	}

}
