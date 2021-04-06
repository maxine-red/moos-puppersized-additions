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

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.mootech.stcm.StrawberryTwirlCompanion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.fluid.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.mootech.stcm.common.fluids.JamFluid;
import net.mootech.stcm.common.fluids.JuiceFluid;
import net.mootech.stcm.common.fluids.MagicEssenceFluid;
import net.mootech.stcm.common.fluids.StrawberryFluid;
import net.mootech.stcm.util.Color;
import net.mootech.stcm.util.ModTest;

public class StrawberryFluids {
	
	private static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, StrawberryTwirlCompanion.ID);
	public static final List<StrawberryFluid> REGISTERED_FLUIDS = new ArrayList<>();
	
	public static final List<StrawberryFluid> SOURCE_FLUIDS = new ArrayList<>();
    
    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * Prepare magical essence fluids, to put all of them into one place
     */
    private static void prepareEssences() {
    	HashMap<String, Color> essences = new HashMap<>();
    	essences.put("void", new Color(6, 0, 10));
    	essences.put("soul", new Color(99, 86, 71));
    	for (String essence : essences.keySet()) {
        	LOGGER.debug("Adding essence for " + essence + " to registry.");
        	new MagicEssenceFluid(essence, essences.get(essence));
    	}
    	// Add more here, if special essences (e.g. with burn time are needed
    	// new MagicEssenceFluid(essence, new Color(), 0);
    }
    
    /**
     * Prepare fruit fluids, to put all of them into one place
     */
    private static void prepareFruits() {
    	HashMap<String, Color> fruits = new HashMap<>();
    	// Minecraft vanilla fruits
    	fruits.put("apple", new Color(219, 162, 19));
    	fruits.put("golden_apple", new Color(234, 238, 87));
    	fruits.put("melon", new Color(193, 60, 45));
    	fruits.put("chorus", new Color(143, 102, 141));
    	fruits.put("sweet_berry", new Color(130, 11, 5));
    	
    	// Fruit trees fruits (Only add if FrtuiTrees mod is actually loaded)
    	if (ModTest.isPresent("fruittrees")) {
	    	fruits.put("cherry", new Color(235, 52, 49));
	    	fruits.put("redlove", new Color(182, 29, 29));
	    	fruits.put("citron", new Color(191, 177, 67));
	    	fruits.put("grapefruit", new Color(254, 155, 60));
	    	fruits.put("lemon", new Color(219, 203, 93));
	    	fruits.put("lime", new Color(144, 191, 63));
	    	fruits.put("mandarin", new Color(240, 154, 42));
	    	fruits.put("orange", new Color(227, 104, 25));
	    	fruits.put("pomelo", new Color(231, 207, 76));
    	}
    	
    	
    	for (String fruit : fruits.keySet()) {
        	LOGGER.debug("Adding juice and jam for " + fruit + " to registry.");
        	new JuiceFluid(fruit, fruits.get(fruit));
        	new JamFluid(fruit, fruits.get(fruit).darken(0.239).saturate(0.068));
    	}
    	// Add more here, if special juices or jams (e.g. with burn time are needed
    	// new MagicEssenceFluid(essence, new Color(), 0);
    }

    public static void init(IEventBus modEventBus) {
    	prepareEssences();
    	prepareFruits();
    	LOGGER.debug("Registering strawberry fluids");
    	for (StrawberryFluid fluid : REGISTERED_FLUIDS) {
    		LOGGER.info("Registering: " + fluid.getID());
    		FLUIDS.register(fluid.getID(), () -> fluid);
    	}
        FLUIDS.register(modEventBus);
    }

}