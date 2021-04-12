package net.mootech.stcm.common.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.world.World;

/**
 * Items you can drink and return their container item, when drunk
 * @author Maxine Red
 *
 */
public class DrinkableItem extends EdibleItem {

	public DrinkableItem(Properties properties, boolean isChorus) {
		super(properties, isChorus);
	}
	
	@Override
	public UseAction getUseAnimation(ItemStack stack) {
		return UseAction.DRINK;
	}
	
	/**
	 * Return a glass bottle on use
	 */
	@Override
	public ItemStack finishUsingItem(ItemStack stack, World worldIn, LivingEntity consumer) {
		ItemStack container = stack.getContainerItem(); // Grab crafting remainder first, or else we can't get it, when stack is emptied
		super.finishUsingItem(stack, worldIn, consumer);
		if (stack.isEmpty()) {
			return container;
		}
		else {
			PlayerEntity player = consumer instanceof PlayerEntity ? (PlayerEntity)consumer : null;
			if (player != null && !player.isCreative()) {
				if (!player.addItem(container)) {
					player.drop(container, false);
				}
			}
			return stack;
		}
	}

}
