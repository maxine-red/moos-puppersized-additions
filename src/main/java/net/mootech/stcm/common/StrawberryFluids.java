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
import net.mootech.stcm.common.fluids.StrawberryFluid;
import net.mootech.stcm.util.Color;

public class StrawberryFluids {
	
	private static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, StrawberryTwirlCompanion.ID);
	public static final List<StrawberryFluid> REGISTERED_FLUIDS = new ArrayList<>();
	
	public static final List<StrawberryFluid> SOURCE_FLUIDS = new ArrayList<>();

	public static final Color APPLE_COLOR = new Color(219, 162, 19);
	public static final Color GOLDEN_APPLE_COLOR = new Color(234, 238, 87);
	public static final Color MELON_COLOR = new Color(193, 60, 45);
	public static final Color CHORUS_COLOR = new Color(143, 102, 141);
	public static final Color SWEET_BERRY_COLOR = new Color(130, 11, 5);
	public static final Color CARROT_COLOR = new Color(255, 142, 9);
	public static final Color GOLDEN_CARROT_COLOR = new Color(236, 203, 69);
    
    private static final Logger LOGGER = LogManager.getLogger();
    
    /**
     * Prepare fruit fluids, to put all of them into one place
     */
    private static void prepareFluids() {
    	HashMap<String, Color> fruits = new HashMap<>();
    	HashMap<String, Color> veggies = new HashMap<>();
    	// Minecraft vanilla fruits
    	fruits.put("apple", APPLE_COLOR);
    	fruits.put("golden_apple", GOLDEN_APPLE_COLOR);
    	fruits.put("melon", MELON_COLOR);
    	fruits.put("chorus", CHORUS_COLOR);
    	fruits.put("sweet_berry", SWEET_BERRY_COLOR);
    	
    	// Minecraft vanilla veggies
    	veggies.put("carrot", CARROT_COLOR);
    	veggies.put("golden_carrot", GOLDEN_CARROT_COLOR);
    	
    	for (String fruit : fruits.keySet()) {
        	LOGGER.debug("Adding juice and jam for " + fruit + " to registry.");
        	new JuiceFluid(fruit, fruits.get(fruit));
        	new JamFluid(fruit, fruits.get(fruit).darken(0.239).saturate(0.068));
    	}
    	
    	for (String veggy : veggies.keySet()) {
        	LOGGER.debug("Adding juice and jam for " + veggy + " to registry.");
        	new JuiceFluid(veggy, veggies.get(veggy));
    	}
    	// Add more here, if special juices or jams (e.g. with burn time are needed
    	// new MagicEssenceFluid(essence, new Color(), 0);
    }

    public static void init(IEventBus modEventBus) {
    	prepareFluids();
    	LOGGER.debug("Registering strawberry fluids");
    	for (StrawberryFluid fluid : REGISTERED_FLUIDS) {
    		LOGGER.debug("Registering: " + fluid.getID());
    		FLUIDS.register(fluid.getID(), () -> fluid);
    	}
        FLUIDS.register(modEventBus);
    }

}