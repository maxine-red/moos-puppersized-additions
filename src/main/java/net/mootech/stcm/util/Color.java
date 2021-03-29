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

/**
 * 
 * @author Maxine Michalski
 * 
 * A utility class to handle colors more easily.
 * 
 */
public class Color {
	
	private float alpha;
	private int red;
	private int green;
	private int blue;
	
	/**
	 * Represents a color in argb format
	 * @param a alpha channel value as a float between 0.0 and 1.9
	 * @param r red channel value as an int between 0 and 255
	 * @param g green channel value as an int between 0 and 255
	 * @param b blue channel value as an int between 0 and 255
	 */
	public Color(float a, int r, int g, int b) {
		alpha(a);
		red(r);
		green(g);
		blue(b);
	}
	
	/**
	 * Combine all channels into an int
	 * @return Interger to be used in other functions.
	 */
	public int combine() {
		return (int)(alpha * 255) << 24 | red << 16 | green << 8 | blue;
	}
	
	/**
	 * Set alpha channel individually
	 * @param a alpha channel as a float between 0.0 and 1.0
	 * @return this object
	 */
	public Color alpha(float a) {
		alpha = a;
		if (a > 1.0) {
			alpha = 1;
		}
		else if (a < 0.0) {
			alpha = 0;
		}
		return this;
	}
	
	/**
	 * Comfort method to set all channels at once
	 * @param r red channel as an int between 0 and 255
	 * @param g green channel as an int between 0 and 255
	 * @param b blue channel as an int between 0 and 255
	 * @return this object
	 */
	public Color rgb(int r, int g, int b) {
		red = r & 0xff;
		green = g & 0xff;
		blue = b & 0xff;
		return this;
	}
	
	/**
	 * Comfort method to set all channels (except alpha)
	 * @param rgb integer that includes color information as 0xRRGGBB
	 * @return this object
	 */
	public Color rgb(int rgb) {
		red = (rgb & 0xff0000) >> 16;
		green = (rgb & 0xff00) >> 8;
		blue = (rgb & 0xff);
		return this;
	}
	
	/**
	 * Set red channel individually
	 * @param r red channel as an int between 0 and 255
	 * @return this object
	 */
	public Color red(int r) {
		red = r & 0xff;
		return this;
	}
	
	/**
	 * Set blue channel individually
	 * @param b blue channel as an int between 0 and 255
	 * @return this object
	 */
	public Color green(int g) {
		green = g & 0xff;
		return this;
	}
	
	/**
	 * Set green channel individually
	 * @param g green channel as an int between 0 and 255
	 * @return this object
	 */
	public Color blue(int b) {
		blue = b & 0xff;
		return this;
	}

}
