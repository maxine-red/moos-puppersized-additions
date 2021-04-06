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

package net.mootech.stcm.util;

import java.util.Objects;

import net.minecraftforge.fml.ModList;

/**
 * @author Maxine Red
 *
 */
public class ModTest {
	
	/**
	 * Test if a mod is present in the current environment and also ensure that data is generated regardless
	 * @param modID String id of mod
	 * @return boolean
	 */
	public static final boolean isPresent(String modID) {
		return ModList.get().isLoaded(modID) || Objects.equals(System.getProperty("net.mootech.stcm.datagen"), "running");
	}
	
	/**
	 * Test if a mod is **not** present in the current environment and also ensure that data is generated regardless
	 * @param modID String id of mod
	 * @return boolean
	 */
	public static final boolean isNotPresent(String modID) {
		return !ModList.get().isLoaded(modID) || Objects.equals(System.getProperty("net.mootech.stcm.datagen"), "running");
	}

}
