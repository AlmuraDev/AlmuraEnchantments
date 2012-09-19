package com.almuramc.almuraenchantments.widgets;

import com.almuramc.almuraenchantments.EnchantmentPopup;
import org.bukkit.inventory.ItemStack;
import org.getspout.spoutapi.gui.GenericSlot;

public class MySlot extends GenericSlot{
	private EnchantmentPopup popup;
	
	public MySlot(EnchantmentPopup popup) {
		this.popup = popup;
	}

	@Override
	public boolean onItemPut(ItemStack item) {
		return popup.onItemPut(item);
	}
	
}
