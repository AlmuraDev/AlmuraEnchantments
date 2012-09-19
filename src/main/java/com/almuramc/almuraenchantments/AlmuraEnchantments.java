package com.almuramc.almuraenchantments;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.getspout.spoutapi.event.input.KeyPressedEvent;
import org.getspout.spoutapi.gui.ScreenType;
import org.getspout.spoutapi.keyboard.Keyboard;

public class AlmuraEnchantments extends JavaPlugin implements Listener{

	@Override
	public void onDisable() {
	}

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
	}
	
	@EventHandler
	public void onPlayerPress(KeyPressedEvent event) {
		if(event.getPlayer().getMainScreen().getScreenType() != ScreenType.GAME_SCREEN) {
			return;
		}
		if(event.getKey() != Keyboard.KEY_P) {
			return;
		}
		event.getPlayer().getMainScreen().attachPopupScreen(new EnchantmentPopup(event.getPlayer(), this));
	}
	
}
