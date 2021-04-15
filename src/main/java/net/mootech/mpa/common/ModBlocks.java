/**
 * Copyright 2021 Maxine Red
 * This file is part of Strawberry Twirl Companion.
 *
 * Strawberry Twirl Companion is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Strawberry Twirl Companion is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Strawberry Twirl Companion.  If not, see <https://www.gnu.org/licenses/>.
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

public class ModBlocks {
	
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MoosPuppersizedAdditions.MOD_ID);
    
    private static final Block.Properties DEFAULT_SAND_PROPERTIES = Block.Properties.of(Material.SAND, MaterialColor.SAND).harvestTool(ToolType.SHOVEL).sound(SoundType.SAND);
    private static final Block.Properties DEFAULT_STONE_PROPERTIERS = Block.Properties.of(Material.STONE, MaterialColor.STONE).harvestLevel(1).requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE).sound(SoundType.STONE);
	
    // TODO Crystals need special class to handle different hit boxes and render types
    // TODO Ore need render type to work, find out how
    // TODO Change salt block texture and try it out for pupper
	public static final RegistryObject<Block> SALT_CRYSTAL = BLOCKS.register("salt_crystal", () -> new Block(Block.Properties.of(Material.ICE)));
	public static final RegistryObject<Block> SALT_BLOCK = BLOCKS.register("salt_block", () -> new FallingBlock(DEFAULT_SAND_PROPERTIES));
	public static final RegistryObject<Block> SALT_SAND_ORE = BLOCKS.register("salt_sand_ore", () -> new FallingExpOreBlock(DEFAULT_SAND_PROPERTIES));
	public static final RegistryObject<Block> SALT_STONE_ORE = BLOCKS.register("salt_stone_ore", () -> new ExpOreBlock(DEFAULT_STONE_PROPERTIERS));
	
	private static final Logger LOGGER = LogManager.getLogger();
	
	public static void init(IEventBus modEventBus) {
    	LOGGER.debug("Registering strawberry blocks");
		BLOCKS.register(modEventBus);
	}

}