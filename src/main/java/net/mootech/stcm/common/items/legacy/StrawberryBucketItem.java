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

package net.mootech.stcm.common.items.legacy;

/**
 * @author Maxine Red
 *
 */
/*public class StrawberryBucketItem extends BucketItem {
	
	protected final String id;
	protected final int burn_time;
	protected final String name;
	protected ResourceLocation overlay;
	
	private final int color;
	
	protected static final Item.Properties DEFAULT_BUCKET_PROPERTIES = new Item.Properties().tab(StrawberryInitializer.ITEM_GROUP).stacksTo(1).craftRemainder(Items.BUCKET);

	protected static final ResourceLocation OVERLAY_THIN = new ResourceLocation(StrawberryTwirlCompanion.ID, "item/bucket_overlay_thin");
	protected static final ResourceLocation OVERLAY_DRINK = new ResourceLocation(StrawberryTwirlCompanion.ID, "item/bucket_overlay_drink");

	/**
	 * Custom bucket class constructor, to allow for ID handling.
	 * @param fluid VirtualFluid that is contained by this bucket
	 * @param properties Item properties for this bucket
	 *
	public StrawberryBucketItem(Supplier<StrawberryFluid> fluid, Properties properties) {
		this(fluid, properties, -1);
	}
	
	public StrawberryBucketItem(Supplier<StrawberryFluid> fluid, Properties properties, int burn_time) {
		super((Supplier<? extends Fluid>)fluid, properties);
		this.id = fluid.get().getID() + "_bucket";
		this.name = fluid.get().getName() + " Bucket";
		this.color = fluid.get().getColor();
		this.burn_time = burn_time;
		this.overlay = OVERLAY_THIN;
		//StrawberryItems.BUCKETS.add(this);
	}
	
	/**
	 * String ID for this bucket
	 * @return String
	 *
	public String getId() {
		return this.id;
	}
	
	/**
	 * Get in-game name of item
	 * @return String
	 *
	public String getName() {
		return this.name;
	}
	
	/**
	 * Get color information from fluid
	 * @return integer
	 *
	public int getColor() {
		return color;
	}
	
	public ResourceLocation getOverlay() {
		return this.overlay;
	}
	
	@Override
	public ItemStack getContainerItem(ItemStack itemStack) {
		return new ItemStack(Items.BUCKET);
	}
	
	@Override
	public boolean hasContainerItem(ItemStack itemStack) {
		return true;
	}
	
	@Override
	public ICapabilityProvider initCapabilities(ItemStack itemStack, @Nullable CompoundNBT nbt) {
		return new FluidBucketWrapper(itemStack);
	}

	@Override
	public int getBurnTime(ItemStack itemStack)
	{
		return burn_time;
	}

}*/
