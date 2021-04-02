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
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.fluid.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.mootech.stcm.common.fluids.MagicEssenceFluid;
import net.mootech.stcm.common.fluids.StrawberryFluid;
import net.mootech.stcm.util.Color;

public class StrawberryFluids {
	
	private static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, StrawberryTwirlCompanion.ID);
	public static final List<StrawberryFluid> REGISTERED_FLUIDS = new ArrayList<>();
	
	// TODO: Unify fluid creation and put as much into a common class, then have the rest done here.

    public static final StrawberryFluid VOID_ESSENCE = new MagicEssenceFluid("void", new Color(6, 0, 10));
    public static final StrawberryFluid SOUL_ESSENCE = new MagicEssenceFluid("soul", new Color(99, 86, 71));
    public static final StrawberryFluid MELON_JUICE = new StrawberryFluid("melon_juice", new Color(240, 45, 31));
    public static final StrawberryFluid MELON_JAM = new StrawberryFluid("melon_jam", new Color(179, 22, 11));
    
    private static final Logger LOGGER = LogManager.getLogger();
    


    public static void init(IEventBus modEventBus) {
    	LOGGER.info("Registering strawberry fluids");
    	for (StrawberryFluid fluid : REGISTERED_FLUIDS) {
    		LOGGER.info("Registering: " + fluid.getID());
    		FLUIDS.register(fluid.getID(), () -> fluid);
    	}
        FLUIDS.register(modEventBus);
    }

}