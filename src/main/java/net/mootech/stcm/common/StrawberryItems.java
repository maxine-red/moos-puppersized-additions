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

import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.mootech.stcm.StrawberryTwirlCompanion;
import net.mootech.stcm.common.fluids.VoidEssence;

public class StrawberryItems {
	private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, StrawberryTwirlCompanion.ID);

	public static final Item GLASS_BUCKET = new Item(new Properties().tab(StrawberryInitializer.ITEM_GROUP).rarity(Rarity.UNCOMMON).stacksTo(16));
	public static final RegistryObject<Item> EMPTY_GLASS_BUCKET = ITEMS.register("bucket_glass_empty", () -> GLASS_BUCKET);
	public static final RegistryObject<BucketItem> VOID_ESSENCE_BUCKET = ITEMS.register("bucket_" + VoidEssence.ID, () -> new BucketItem(StrawberryFluids.VOID_ESSENCE, new Properties().tab(StrawberryInitializer.ITEM_GROUP).rarity(Rarity.EPIC).stacksTo(1).craftRemainder(GLASS_BUCKET)));
    private static final Logger LOGGER = LogManager.getLogger();
    


    public static void init(IEventBus modEventBus) {
    	LOGGER.info("Registering strawberry items");
        ITEMS.register(modEventBus);
    }
}
