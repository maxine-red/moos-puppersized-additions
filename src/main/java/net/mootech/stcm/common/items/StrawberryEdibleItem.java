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

package net.mootech.stcm.common.items;

import java.util.regex.Pattern;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

/**
 * @author Maxine Red
 *
 */
public class StrawberryEdibleItem extends StrawberryItem {
	protected final boolean isChorus;
	
	public StrawberryEdibleItem(String id, Properties properties) {
		this(id, properties, -1);
	}
	
	public StrawberryEdibleItem(String id, Properties properties, int burn_time) {
		super(id, properties, burn_time);
		this.isChorus = Pattern.compile("chorus").matcher(id).find();
	}


	
	/**
	 * Create chorus fruit effect
	 */
	@Override
	public ItemStack finishUsingItem(ItemStack stack, World worldIn, LivingEntity consumer) {
		if (isChorus) {
			boolean didTeleport = false;
			for (int i = 0; i < 99; i++) {
				if (!didTeleport) {
					double cx = consumer.getRandomX(16.0);
					double cy = MathHelper.floor(MathHelper.clamp(consumer.getRandomY(), 0.0, worldIn.getHeight()));
					double cz = consumer.getRandomZ(16.0);
					// This method takes coordinates and teleports you to them, if the boolean argument is true
					didTeleport = consumer.randomTeleport(cx, cy, cz, true);
					if (didTeleport) {
						consumer.playSound(SoundEvents.CHORUS_FRUIT_TELEPORT, 1.0f, 1.0f);
					}
				}
			}
		}
		return super.finishUsingItem(stack, worldIn, consumer);
	}
}
