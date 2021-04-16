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
package net.mootech.mpa.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.Block;
import net.minecraft.block.FallingBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.mootech.mpa.MoosPuppersizedAdditions;
import net.mootech.mpa.common.block.ExpOreBlock;
import net.mootech.mpa.common.block.FallingExpOreBlock;
import net.mootech.mpa.common.block.SaltCrystalBlock;
import net.mootech.mpa.common.block.StorageBagBlock;

public class ModBlocks {
	
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MoosPuppersizedAdditions.MOD_ID);
    
    private static final Block.Properties DEFAULT_SAND_PROPERTIES = Block.Properties.of(Material.SAND, MaterialColor.SAND).harvestTool(ToolType.SHOVEL).sound(SoundType.SAND);
    private static final Block.Properties DEFAULT_STONE_PROPERTIERS = Block.Properties.of(Material.STONE, MaterialColor.STONE).harvestLevel(1).requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE).sound(SoundType.STONE);
	
	public static final RegistryObject<Block> SALT_CRYSTAL = BLOCKS.register("salt_crystal", SaltCrystalBlock::new);
	public static final RegistryObject<Block> SALT_BLOCK = BLOCKS.register("salt_block", () -> new FallingBlock(DEFAULT_SAND_PROPERTIES));
	public static final RegistryObject<Block> SALT_SAND_ORE = BLOCKS.register("salt_sand_ore", () -> new FallingExpOreBlock(DEFAULT_SAND_PROPERTIES));
	public static final RegistryObject<Block> SALT_STONE_ORE = BLOCKS.register("salt_stone_ore", () -> new ExpOreBlock(DEFAULT_STONE_PROPERTIERS));
	
	// TODO add jelly storage blocks
	// Storage bags
	public static final RegistryObject<Block> SALT_BAG = BLOCKS.register("salt_bag", StorageBagBlock::new);
	public static final RegistryObject<Block> WHEAT_SEED_BAG = BLOCKS.register("wheat_seed_bag", StorageBagBlock::new);
	public static final RegistryObject<Block> BEETROOT_SEED_BAG = BLOCKS.register("beetroot_seed_bag", StorageBagBlock::new);
	public static final RegistryObject<Block> PUMPKIN_SEED_BAG = BLOCKS.register("pumpkin_seed_bag", StorageBagBlock::new);
	public static final RegistryObject<Block> MELON_SEED_BAG = BLOCKS.register("melon_seed_bag", StorageBagBlock::new);
	
	// TODO add in world spawning behavior for ores and other salt blocks (pneumaticcraft does it, so look there)
	private static final Logger LOGGER = LogManager.getLogger();
	
	public static void init(IEventBus modEventBus) {
    	LOGGER.debug("Registering strawberry blocks");
		BLOCKS.register(modEventBus);
	}

}