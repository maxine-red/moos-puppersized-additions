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

import net.minecraft.fluid.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.mootech.stcm.StrawberryTwirlCompanion;
import net.mootech.stcm.common.fluids.AppleJuiceFluid;
import net.mootech.stcm.common.fluids.SaltyWaterFluid;
import net.mootech.stcm.util.Color;

public class StrawberryFluids {
	
	private static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, StrawberryTwirlCompanion.ID);
	
	public static final RegistryObject<Fluid> APPLE_JUICE = FLUIDS.register(AppleJuiceFluid.ID, () -> new AppleJuiceFluid.Source());
	public static final RegistryObject<Fluid> APPLE_JUICE_FLOWING = FLUIDS.register(AppleJuiceFluid.ID + "_flowing", () -> new AppleJuiceFluid.Flowing());
	
	public static final RegistryObject<Fluid> SALTY_WATER = FLUIDS.register(SaltyWaterFluid.ID, () -> new SaltyWaterFluid.Source());
	public static final RegistryObject<Fluid> SALTY_WATER_FLOWING = FLUIDS.register(SaltyWaterFluid.ID + "_flowing", () -> new SaltyWaterFluid.Flowing());
	
	public static final Color APPLE_COLOR = new Color(219, 162, 19);
	public static final Color GOLDEN_APPLE_COLOR = new Color(234, 238, 87);
	public static final Color MELON_COLOR = new Color(193, 60, 45);
	public static final Color CHORUS_COLOR = new Color(143, 102, 141);
	public static final Color SWEET_BERRY_COLOR = new Color(130, 11, 5);
	public static final Color CARROT_COLOR = new Color(255, 142, 9);
	public static final Color GOLDEN_CARROT_COLOR = new Color(236, 203, 69);

	/*public static final StrawberryFluid GELATIN = new StrawberryFluid("gelatin", new Color(232, 232, 211));
	public static final StrawberryFluid SEED_OIL = new StrawberryFluid("seed_oil", new Color(229, 235, 174), 4000);

	public static final JuiceFluid APPLE_JUICE = new JuiceFluid("apple", APPLE_COLOR, () -> StrawberryItems.APPLE_JUICE);
	public static final JuiceFluid GOLDEN_APPLE_JUICE = new JuiceFluid("golden_apple", GOLDEN_APPLE_COLOR, () -> StrawberryItems.GOLDEN_APPLE_JUICE, Rarity.RARE);
	public static final JuiceFluid MELON_JUICE = new JuiceFluid("melon", MELON_COLOR, () -> StrawberryItems.MELON_JUICE);
	public static final JuiceFluid CHORUS_JUICE = new JuiceFluid("chorus", CHORUS_COLOR, () -> StrawberryItems.CHORUS_JUICE);
	public static final JuiceFluid SWEET_BERRY_JUICE = new JuiceFluid("sweet_berry", SWEET_BERRY_COLOR, () -> StrawberryItems.SWEET_BERRY_JUICE);
	public static final JuiceFluid CARROT_JUICE = new JuiceFluid("carrot", CARROT_COLOR, () -> StrawberryItems.CARROT_JUICE);
	public static final JuiceFluid GOLDEN_CARROT_JUICE = new JuiceFluid("golden_carrot", GOLDEN_CARROT_COLOR, () -> StrawberryItems.GOLDEN_CARROT_JUICE, Rarity.UNCOMMON);

	public static final JamFluid APPLE_JAM = new JamFluid("apple", APPLE_COLOR);
	public static final JamFluid GOLDEN_APPLE_JAM = new JamFluid("golden_apple", GOLDEN_APPLE_COLOR);
	public static final JamFluid MELON_JAM = new JamFluid("melon", MELON_COLOR);
	public static final JamFluid CHORUS_JAM = new JamFluid("chorus", CHORUS_COLOR);
	public static final JamFluid SWEET_BERRY_JAM = new JamFluid("sweet_berry", SWEET_BERRY_COLOR);*/
	
    
    private static final Logger LOGGER = LogManager.getLogger();

    public static void init(IEventBus modEventBus) {
    	LOGGER.debug("Registering strawberry fluids");
        FLUIDS.register(modEventBus);
    }

}