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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.mootech.stcm.common.fluids.VoidEssence;

public class StrawberryFluids {
	
	private static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, StrawberryTwirlCompanion.ID);
	
	// TODO: Unify fluid creation and put as much into a common class, then have the rest done here.

    public static final RegistryObject<FlowingFluid> VOID_ESSENCE = FLUIDS.register(VoidEssence.ID, () -> new VoidEssence.Source(VoidEssence.PROPERTIES));
    public static final RegistryObject<FlowingFluid> VOID_ESSENCE_FLOW = FLUIDS.register(VoidEssence.ID + "_flowing", () -> new VoidEssence.Flowing(VoidEssence.PROPERTIES));
    private static final Logger LOGGER = LogManager.getLogger();
    


    public static void init(IEventBus modEventBus) {
    	LOGGER.info("Registering strawberry fluids");
        FLUIDS.register(modEventBus);
    }

}