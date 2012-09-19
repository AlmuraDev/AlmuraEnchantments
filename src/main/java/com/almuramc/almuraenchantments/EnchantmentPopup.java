package com.almuramc.almuraenchantments;

import com.almuramc.almuraenchantments.widgets.MySlot;
import java.util.Map;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.gui.GenericListWidget;
import org.getspout.spoutapi.gui.GenericPopup;
import org.getspout.spoutapi.gui.ListWidgetItem;
import org.getspout.spoutapi.gui.WidgetAnchor;
import org.getspout.spoutapi.player.SpoutPlayer;

public class EnchantmentPopup extends GenericPopup {

	private SpoutPlayer player;
	private AlmuraEnchantments pinstance;
	private GenericListWidget glw;
	private GenericLabel glabel;
	private MySlot slot;
	private static final WidgetAnchor cr = WidgetAnchor.CENTER_CENTER;

	public EnchantmentPopup(SpoutPlayer player, AlmuraEnchantments plugin) {
		this.player = player;
		this.pinstance = plugin;
		
		glw = new GenericListWidget();
		glabel = new GenericLabel("Please insert an item into the slot!");
		slot = new MySlot(this);
		
		glw.setHeight(600).setWidth(100);
		glabel.setHeight(20).setWidth(100);
		
		glw.setAnchor(cr).shiftXPos(-50).shiftYPos(-50);
		glabel.setAnchor(cr).shiftXPos(-50).shiftYPos(-80);

		updateEList();

		attachWidgets(plugin, glw, slot, glabel);
	}

	public boolean onItemPut(ItemStack item) {
		updateEList();
		return true;
	}

	private void updateEList() {
		ItemStack inSlot = slot.getItem();
		glw.clear();
		if (inSlot == null) {
			return;
		}
		Map<Enchantment, Integer> ens = inSlot.getEnchantments();
		for (Enchantment ee : ens.keySet()) {
			int level = ens.get(ee);
			glw.addItem(new ListWidgetItem(ee.getName(), "Level " + level));
		}
		glw.setDirty(true);
	}
}
