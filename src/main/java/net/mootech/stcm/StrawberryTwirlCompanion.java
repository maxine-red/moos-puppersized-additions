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
package net.mootech.stcm;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.mootech.stcm.common.StrawberryInitializer;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(StrawberryTwirlCompanion.ID)
public class StrawberryTwirlCompanion
{
	public static final String ID = "strawberrytwirl";

    public StrawberryTwirlCompanion() {
    	StrawberryInitializer.init(FMLJavaModLoadingContext.get().getModEventBus());
        MinecraftForge.EVENT_BUS.register(this);
    }
}
