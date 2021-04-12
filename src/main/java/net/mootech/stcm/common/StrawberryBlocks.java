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
package net.mootech.stcm.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.Block;
import net.minecraft.block.FallingBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.mootech.stcm.StrawberryTwirlCompanion;

public class StrawberryBlocks {
	
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, StrawberryTwirlCompanion.ID);
	
    // TODO Crystals need special class to handle different hit boxes and render types
	//public static final RegistryObject<Block> SALT_CRYSTAL = BLOCKS.register("salt_crystal", () -> new Block(Block.Properties.of(Material.ICE)));
	public static final RegistryObject<Block> SALT_BLOCK = BLOCKS.register("salt_block", () -> new FallingBlock(Block.Properties.of(Material.SAND).sound(SoundType.SAND)));
	
	private static final Logger LOGGER = LogManager.getLogger();
	
	public static void init(IEventBus modEventBus) {
    	LOGGER.debug("Registering strawberry blocks");
		BLOCKS.register(modEventBus);
	}

}