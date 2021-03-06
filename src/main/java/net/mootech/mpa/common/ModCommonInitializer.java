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

import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.Block;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.mootech.mpa.MoosPuppersizedAdditions;

@Mod.EventBusSubscriber(modid = MoosPuppersizedAdditions.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModCommonInitializer {
    private static final Logger LOGGER = LogManager.getLogger();
    public static final ItemGroup ITEM_GROUP = new ItemGroup(MoosPuppersizedAdditions.MOD_ID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.GLASS_FLASK.get());
        }
    };
	
	public static void init(IEventBus modEventBus) {
		LOGGER.info("Initializing modded blocks");
        ModBlocks.init(modEventBus);
		LOGGER.info("Initializing modded fluids");
        ModFluids.init(modEventBus);
		LOGGER.info("Initializing modded items");
        ModItems.init(modEventBus);
	}
	
	/**
	 * Gather and return all items for a certain mod
	 * @param modID String mod id
	 * @return Set<Item> All items of said mod, that got registered
	 */
	public static Set<Item> getRegisteredModItems(String modID) {
		return ForgeRegistries.ITEMS.getValues().stream().filter(i -> modID.equals(ForgeRegistries.ITEMS.getKey(i).getNamespace())).collect(Collectors.toSet());
	}

	
	/**
	 * Gather and return all blocks for a certain mod
	 * @param modID String mod id
	 * @return Set<Item> All blocks of said mod, that got registered
	 */
	public static Set<Block> getRegisteredModBlocks(String modID) {
		return ForgeRegistries.BLOCKS.getValues().stream().filter(b -> modID.equals(ForgeRegistries.BLOCKS.getKey(b).getNamespace())).collect(Collectors.toSet());
	}

	
	/**
	 * Gather and return all fluids for a certain mod
	 * @param modID String mod id
	 * @return Set<Item> All fluids of said mod, that got registered
	 */
	public static Set<Fluid> getRegisteredModFluids(String modID) {
		return ForgeRegistries.FLUIDS.getValues().stream().filter(f -> findNotFlowingFluids(f, modID)).collect(Collectors.toSet());
	}
	
	private static final Pattern flowing_pattern = Pattern.compile("flowing");
	
	private static boolean findNotFlowingFluids(Fluid f, String modID) {
		ResourceLocation loc = ForgeRegistries.FLUIDS.getKey(f); 
		return modID.equals(loc.getNamespace()) && !flowing_pattern.matcher(loc.getPath()).find();
	}

}
