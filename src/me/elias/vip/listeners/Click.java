package me.elias.vip.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import me.elias.vip.Main;

public class Click implements Listener{
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		if(e.getInventory().getName().equalsIgnoreCase(Main.plugin.inventario)) {
			if(e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR) {
				e.setCancelled(true);
				return;
			}else {
				e.setCancelled(true);
			}
		}
	}
}
