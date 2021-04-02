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
package net.mootech.stcm.common.fluids;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.Rarity;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.fluids.FluidAttributes;
import net.mootech.stcm.StrawberryTwirlCompanion;
import net.mootech.stcm.common.StrawberryFluids;
import net.mootech.stcm.common.StrawberryInitializer;
import net.mootech.stcm.common.StrawberryItems;
import net.mootech.stcm.common.items.StrawberryBucketItem;
import net.mootech.stcm.util.Color;

public class StrawberryFluid extends FlowingFluid {
	/**
	 * Parts of this class are inspired by IEFluid, from the ImmersiveEngineering project, created by luSunrize.
	 */
	
	public static final Collection<StrawberryFluid> VIRTUAL_FLUIDS = new ArrayList<>();
	
	protected StrawberryFluid flowing;
	protected StrawberryFluid source;
	
	protected final String id;
	protected final ResourceLocation still_resource;
	protected final ResourceLocation flowing_resource;
	protected final boolean is_source;
	
	protected Rarity rarity = Rarity.COMMON;
	protected int viscosity = 1000;
	protected int luminosity = 0;
	protected int temperature = 300;
	protected int density = 1000;
	protected boolean gaseous = false;
	
	protected final Color color;
    
    private static final Logger LOGGER = LogManager.getLogger();
	
	protected StrawberryBucketItem bucket;
	protected static final Item.Properties BUCKET_PROPERTIES = new Item.Properties().tab(StrawberryInitializer.ITEM_GROUP).stacksTo(1).craftRemainder(Items.BUCKET);
	
	/**
	 * Constructor for VirtualFluid
	 * 
	 * Simplest constructor, that assumes textures are under '<modid>:fluids/<id>'
	 * @param id String Fluid ID
	 */
	public StrawberryFluid(String id) {
		this(id, new Color());
	}

	/**
	 * Constructor for VirtualFluid
	 * 
	 * Simplest constructor, that assumes textures are under '<modid>:fluids/<id>'
	 * @param id String Fluid ID
	 * @param color Color Color to use for this fluid (only effects containers)
	 */
	public StrawberryFluid(String id, Color color) {
		this(id, color, new ResourceLocation(StrawberryTwirlCompanion.ID, "fluids/" + id), new ResourceLocation(StrawberryTwirlCompanion.ID, "fluids/" + id + "_flow"));
	}
	
	/**
	 * More advanced constructor
	 * @param id String Fluid ID
	 * @param color Color Color to use for this fluid (only effects containers)
	 * @param still_resource ResourceLocation for still resource
	 * @param flowing_resource ResourceLocation for flowing resource
	 */
	public StrawberryFluid(String id, Color color, ResourceLocation still_resource, ResourceLocation flowing_resource) {
		this(id, color, still_resource, flowing_resource, true);
	}
	
	/**
	 * Most advanced constructor
	 * @param id String Fluid ID
	 * @param color Color Color to use for this fluid (only effects containers)
	 * @param still_resource ResourceLocation for still resource
	 * @param flowing_resource ResourceLocation for flowing resource
	 * @param is_source Boolean wether this fluid is a source or not
	 */
	public StrawberryFluid(String id, Color color, ResourceLocation still_resource, ResourceLocation flowing_resource, boolean is_source) {
		this(id, color, still_resource, flowing_resource, is_source, -1);
	}
	
	/**
	 * Most advanced constructor
	 * @param id String Fluid ID
	 * @param color Color Color to use for this fluid (only effects containers)
	 * @param still_resource ResourceLocation for still resource
	 * @param flowing_resource ResourceLocation for flowing resource
	 * @param is_source Boolean wether this fluid is a source or not
	 * @param burn_time Furnace burning time of this fluid
	 */
	public StrawberryFluid(String id, Color color, ResourceLocation still_resource, ResourceLocation flowing_resource, boolean is_source, int burn_time) {
		this(id, color, still_resource, flowing_resource, is_source, burn_time, true);
	}
	
	/**
	 * Most advanced constructor
	 * @param id String Fluid ID
	 * @param color Color Color to use for this fluid (only effects containers)
	 * @param still_resource ResourceLocation for still resource
	 * @param flowing_resource ResourceLocation for flowing resource
	 * @param burn_time Furnace burning time of this fluid
	 * @param has_bucket Make standard bucket item or not
	 */
	protected StrawberryFluid(String id, Color color, ResourceLocation still_resource, ResourceLocation flowing_resource, boolean is_source, int burn_time, boolean has_bucket) {
		this.still_resource = still_resource;
		this.flowing_resource = flowing_resource;
		this.is_source = is_source;
		this.color = color;
		StrawberryFluids.REGISTERED_FLUIDS.add(this);
		if (!this.is_source) {
			this.id = id + "_flowing";
			this.flowing = this;
		}
		else {
			this.id = id;
			this.source = this;
			if (has_bucket ) {
				this.bucket = new StrawberryBucketItem(() -> this, BUCKET_PROPERTIES, burn_time);
				StrawberryItems.BUCKETS.add(this.bucket);
			}
			this.flowing = createFlowingFromSource();
			VIRTUAL_FLUIDS.add(this);
		}
		LOGGER.debug("Created fluid: " + id);
	}

	/**
	 * @param virtualFluid
	 * @return
	 */
	protected StrawberryFluid createFlowingFromSource() {
		StrawberryFluid r = new StrawberryFluid(id, color, still_resource, flowing_resource, false);
		r.source = this;
		r.bucket = this.bucket;
		return r;
	}

	/**
	 * @return String ID of fluid
	 */
	public String getID() {
		return id;
	}
	
	/**
	 * Fetch color information for this fluid
	 * @return integer color information
	 */
	public int getColor() {
		return color.combine_rgb();
	}

	/**
	 * Fetch the flowing definition of this fluid
	 * 
	 * @return Fluid Flowing version of this fluid
	 */
	@Override
	public Fluid getFlowing() {
		return flowing;
	}

	/**
	 * Fetch the source definition of this fluid
	 * 
	 * @return Fluid Source version of this fluid
	 */
	@Override
	public Fluid getSource() {
		return source;
	}

	/**
	 * Determine if test fluid is source or not
	 * 
	 * @return Boolean
	 */
	@Override
	public boolean isSource(FluidState state) {
		return state.getType() == source;
	}

	/**
	 * Fetch Bucket item for this fluid
	 * 
	 * @return Item Bucket item
	 */
	@Override
	public Item getBucket() {
		return this.bucket != null ? (Item)bucket : Items.AIR;
	}

	@Override
	protected FluidAttributes createAttributes()
	{
		FluidAttributes.Builder builder = FluidAttributes.builder(still_resource, flowing_resource)
				.rarity(rarity).viscosity(viscosity).density(density).luminosity(luminosity).temperature(temperature);
		if (gaseous) {
			return builder.gaseous().build(this);
		}
		else {
			return builder.build(this);
		}
	}
	
	/*************************************************************************
	 * Methods past this point are not used. They are here as they need to	 *
	 * be overwritten and also for future compability.						 *
	 *************************************************************************/

	/**
	 * This method is not used, as there won't be fluids blocks available
	 */
	@Override
	protected boolean canConvertToSource() {
		return false;
	}
	
	/**
	 * This method is not used, as there won't be fluids blocks available
	 */
	@Override
	protected void beforeDestroyingBlock(IWorld p_205580_1_, BlockPos p_205580_2_, BlockState p_205580_3_) {	}

	/**
	 * This method is not used, as there won't be fluids blocks available
	 */
	@Override
	protected int getSlopeFindDistance(IWorldReader p_185698_1_) {
		return 0;
	}

	/**
	 * This method is not used, as there won't be fluids blocks available
	 */
	@Override
	protected int getDropOff(IWorldReader p_204528_1_) {
		return 0;
	}
	
	/**
	 * This method is not used, as there won't be fluids blocks available
	 */
	@Override
	protected boolean canBeReplacedWith(FluidState p_215665_1_, IBlockReader p_215665_2_, BlockPos p_215665_3_, Fluid p_215665_4_, Direction p_215665_5_) {
		return false;
	}

	/**
	 * This method is not used, as there won't be fluids blocks available
	 */
	@Override
	public int getTickDelay(IWorldReader p_205569_1_) {
		return 5; // Default value from ForgeFlowingFluid, set to try to not break things
	}

	/**
	 * This method is not used, as there won't be fluids blocks available
	 */
	@Override
	protected float getExplosionResistance() {
		return 0;
	}

	/**
	 * This method is not used, as there won't be fluids blocks available
	 */
	@Override
	protected BlockState createLegacyBlock(FluidState p_204527_1_) {
		return Blocks.AIR.defaultBlockState();
	}

	/**
	 * This method is not used, as there won't be fluids blocks available
	 */
	@Override
	public int getAmount(FluidState p_207192_1_) {
		return 0;
	}
	
}
