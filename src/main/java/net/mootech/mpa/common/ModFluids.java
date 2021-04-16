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

import net.minecraft.fluid.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.mootech.mpa.MoosPuppersizedAdditions;
import net.mootech.mpa.common.fluids.GelatinFluid;
import net.mootech.mpa.common.fluids.SaltyWaterFluid;
import net.mootech.mpa.common.fluids.SeedOilFluid;
import net.mootech.mpa.common.fluids.jams.AppleJamFluid;
import net.mootech.mpa.common.fluids.jams.ChorusJamFluid;
import net.mootech.mpa.common.fluids.jams.GoldenAppleJamFluid;
import net.mootech.mpa.common.fluids.jams.MelonJamFluid;
import net.mootech.mpa.common.fluids.jams.SweetBerryJamFluid;
import net.mootech.mpa.common.fluids.juices.AppleJuiceFluid;
import net.mootech.mpa.common.fluids.juices.CarrotJuiceFluid;
import net.mootech.mpa.common.fluids.juices.ChorusJuiceFluid;
import net.mootech.mpa.common.fluids.juices.GoldenAppleJuiceFluid;
import net.mootech.mpa.common.fluids.juices.GoldenCarrotJuiceFluid;
import net.mootech.mpa.common.fluids.juices.MelonJuiceFluid;
import net.mootech.mpa.common.fluids.juices.SweetBerryJuiceFluid;

public class ModFluids {
	
	private static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, MoosPuppersizedAdditions.MOD_ID);
	
	// Juices
	public static final RegistryObject<Fluid> APPLE_JUICE = FLUIDS.register(AppleJuiceFluid.ID, () -> new AppleJuiceFluid.Source());
	public static final RegistryObject<Fluid> APPLE_JUICE_FLOWING = FLUIDS.register(AppleJuiceFluid.ID + "_flowing", () -> new AppleJuiceFluid.Flowing());
	
	public static final RegistryObject<Fluid> GOLDEN_APPLE_JUICE = FLUIDS.register(GoldenAppleJuiceFluid.ID, () -> new GoldenAppleJuiceFluid.Source());
	public static final RegistryObject<Fluid> GOLDEN_APPLE_JUICE_FLOWING = FLUIDS.register(GoldenAppleJuiceFluid.ID + "_flowing", () -> new GoldenAppleJuiceFluid.Flowing());
	
	public static final RegistryObject<Fluid> MELON_JUICE = FLUIDS.register(MelonJuiceFluid.ID, () -> new MelonJuiceFluid.Source());
	public static final RegistryObject<Fluid> MELON_JUICE_FLOWING = FLUIDS.register(MelonJuiceFluid.ID + "_flowing", () -> new MelonJuiceFluid.Flowing());
	
	public static final RegistryObject<Fluid> CHORUS_JUICE = FLUIDS.register(ChorusJuiceFluid.ID, () -> new ChorusJuiceFluid.Source());
	public static final RegistryObject<Fluid> CHORUS_JUICE_FLOWING = FLUIDS.register(ChorusJuiceFluid.ID + "_flowing", () -> new ChorusJuiceFluid.Flowing());
	
	public static final RegistryObject<Fluid> SWEET_BERRY_JUICE = FLUIDS.register(SweetBerryJuiceFluid.ID, () -> new SweetBerryJuiceFluid.Source());
	public static final RegistryObject<Fluid> SWEET_BERRY_JUICE_FLOWING = FLUIDS.register(SweetBerryJuiceFluid.ID + "_flowing", () -> new SweetBerryJuiceFluid.Flowing());
	
	public static final RegistryObject<Fluid> CARROT_JUICE = FLUIDS.register(CarrotJuiceFluid.ID, () -> new CarrotJuiceFluid.Source());
	public static final RegistryObject<Fluid> CARROT_JUICE_FLOWING = FLUIDS.register(CarrotJuiceFluid.ID + "_flowing", () -> new CarrotJuiceFluid.Flowing());
	
	public static final RegistryObject<Fluid> GOLDEN_CARROT_JUICE = FLUIDS.register(GoldenCarrotJuiceFluid.ID, () -> new GoldenCarrotJuiceFluid.Source());
	public static final RegistryObject<Fluid> GOLDEN_CARROT_JUICE_FLOWING = FLUIDS.register(GoldenCarrotJuiceFluid.ID + "_flowing", () -> new GoldenCarrotJuiceFluid.Flowing());
	
	// Jams
	public static final RegistryObject<Fluid> APPLE_JAM = FLUIDS.register(AppleJamFluid.ID, () -> new AppleJamFluid.Source());
	public static final RegistryObject<Fluid> APPLE_JAM_FLOWING = FLUIDS.register(AppleJamFluid.ID + "_flowing", () -> new AppleJamFluid.Flowing());
	
	public static final RegistryObject<Fluid> GOLDEN_APPLE_JAM = FLUIDS.register(GoldenAppleJamFluid.ID, () -> new GoldenAppleJamFluid.Source());
	public static final RegistryObject<Fluid> GOLDEN_APPLE_JAM_FLOWING = FLUIDS.register(GoldenAppleJamFluid.ID + "_flowing", () -> new GoldenAppleJamFluid.Flowing());
	
	public static final RegistryObject<Fluid> MELON_JAM = FLUIDS.register(MelonJamFluid.ID, () -> new MelonJamFluid.Source());
	public static final RegistryObject<Fluid> MELON_JAM_FLOWING = FLUIDS.register(MelonJamFluid.ID + "_flowing", () -> new MelonJamFluid.Flowing());
	
	public static final RegistryObject<Fluid> CHORUS_JAM = FLUIDS.register(ChorusJamFluid.ID, () -> new ChorusJamFluid.Source());
	public static final RegistryObject<Fluid> CHORUS_JAM_FLOWING = FLUIDS.register(ChorusJamFluid.ID + "_flowing", () -> new ChorusJamFluid.Flowing());
	
	public static final RegistryObject<Fluid> SWEET_BERRY_JAM = FLUIDS.register(SweetBerryJamFluid.ID, () -> new SweetBerryJamFluid.Source());
	public static final RegistryObject<Fluid> SWEET_BERRY_JAM_FLOWING = FLUIDS.register(SweetBerryJamFluid.ID + "_flowing", () -> new SweetBerryJamFluid.Flowing());
	
	// Other
	public static final RegistryObject<Fluid> SALTY_WATER = FLUIDS.register(SaltyWaterFluid.ID, () -> new SaltyWaterFluid.Source());
	public static final RegistryObject<Fluid> SALTY_WATER_FLOWING = FLUIDS.register(SaltyWaterFluid.ID + "_flowing", () -> new SaltyWaterFluid.Flowing());

	public static final RegistryObject<Fluid> GELATIN = FLUIDS.register(GelatinFluid.ID, () -> new GelatinFluid.Source());
	public static final RegistryObject<Fluid> GELATIN_FLOWING = FLUIDS.register(GelatinFluid.ID + "_flowing", () -> new GelatinFluid.Flowing());

	public static final RegistryObject<Fluid> SEED_OIL = FLUIDS.register(SeedOilFluid.ID, () -> new SeedOilFluid.Source());
	public static final RegistryObject<Fluid> SEED_OIL_FLOWING = FLUIDS.register(SeedOilFluid.ID + "_flowing", () -> new SeedOilFluid.Flowing());

	
	private static final Logger LOGGER = LogManager.getLogger();

    public static void init(IEventBus modEventBus) {
    	LOGGER.debug("Registering strawberry fluids");
        FLUIDS.register(modEventBus);
    }

}