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
 * A utility class to handle colors more easily.
 * 
 * @author Maxine Michalski
 * 
 */
public class Color {
	
	private double alpha;
	
	private float hue;
	private float saturation;
	private float luminosity;
	
	/**
	 * Solid white color constructor
	 */
	public Color() {
		this(1.0, 255, 255, 255);
	}
	
	/**
	 * Represents a color in argb format
	 * @param red red channel value as an int between 0 and 255
	 * @param green green channel value as an int between 0 and 255
	 * @param bblue blue channel value as an int between 0 and 255
	 */
	public Color(int red, int green, int blue) {
		this(1.0, red, green, blue);
	}
	
	/**
	 * Represents a color in argb format
	 * @param alpha alpha channel value as a double between 0.0 and 1.9
	 * @param red red channel value as an int between 0 and 255
	 * @param green green channel value as an int between 0 and 255
	 * @param bblue blue channel value as an int between 0 and 255
	 */
	public Color(double alpha, int red, int green, int blue) {
		this.alpha = alpha;
		float hsb[] = java.awt.Color.RGBtoHSB(red, green, blue, null);
		
		this.hue = hsb[0];
		this.saturation = hsb[1];
		this.luminosity = hsb[2];
	}
	
	/**
	 * Combine all channels into an int
	 * @return Interger to be used in other functions.
	 */
	public int combine() {
		return (int)(alpha * 255) << 24 | java.awt.Color.HSBtoRGB(hue, saturation, luminosity);
	}
	
	/**
	 * Combine all channels into an int, as a fully opaque color
	 * @return Integer to be used in other functions.
	 */
	public int combine_rgb() {
		return (int)(255) << 24 | java.awt.Color.HSBtoRGB(hue, saturation, luminosity);
	}
	
	/**
	 * Darken the color by a certain percentage.
	 * @param percent Amount to darken color, must be > 0
	 */
	public Color darken(double percent) {
		this.luminosity -= percent;
		if (this.luminosity < 0.0) {
			this.luminosity = 0;
		}
		return this;
	}
	
	/**
	 * Lighten the color by a certain percentage.
	 * @param percent Amount to darken color, must be > 0
	 */
	public Color lighten(double percent) {
		this.luminosity += percent;
		if (this.luminosity > 1.0) {
			this.luminosity = 1;
		}
		return this;
	}
	
	/**
	 * Saturate the color by a certain percentage.
	 * @param percent Amount to darken color, must be > 0
	 */
	public Color saturate(double percent) {
		this.saturation += percent;
		if (this.saturation > 1.0) {
			this.saturation = 1;
		}
		return this;
	}
	
	/**
	 * Desaturate the color by a certain percentage.
	 * @param percent Amount to darken color, must be > 0
	 */
	public Color desaturate(double percent) {
		this.saturation -= percent;
		if (this.saturation < 0.0) {
			this.saturation = 0;
		}
		return this;
	}
	
	/**
	 * Shift Hue of color. This method takes care of degrees.
	 * @param hue Hue to shift color by
	 */
	public Color shiftHue(int hue) {
		if (hue >= 0) {
			this.hue = (this.hue + hue) % 360;
		}
		else {
			this.hue -= Math.abs(hue) % 360;
			if (this.hue < 0) {
				this.hue += 360;
			}
		}
		return this;
	}
}
