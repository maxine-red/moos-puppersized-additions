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

package net.mootech.mpa.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Maxine Red
 *
 */
public class StringID {
    
    protected static final Logger LOGGER = LogManager.getLogger();
	public static final String idToName(String id) {
		String name = id.substring(0, 1).toUpperCase() + id.substring(1);
		int pos = name.indexOf('_');
		while (pos >= 0) {
			name = name.replaceAll(name.substring(pos, pos + 2), " " + name.substring(pos + 1, pos + 2).toUpperCase());
			pos = name.indexOf('_');
		};
		return name;
	}

}
