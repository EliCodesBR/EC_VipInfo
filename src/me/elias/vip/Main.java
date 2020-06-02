package me.elias.vip;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

import me.elias.vip.listeners.Click;
import me.elias.vip.utils.VipZero;


public class Main extends JavaPlugin{
	
	public String carregando = getConfig().getString("Carregando").replace("&", "§");
	public String carregado = getConfig().getString("Carregado").replace("&", "§");
	
	public String inventario = getConfig().getString("Inventario").replace("&", "§");
	
	public Inventory info;
	public static Main plugin;
	
	@Override
	public void onEnable() {
		plugin = this;
		if(Bukkit.getPluginManager().getPlugin("VipZero") == null) {
			getLogger().warning("§4[CIKE NETWORK] §cVipZero nao encontrado, desativando..");
			getLogger().warning("§4[CIKE NETWORK] §cPlugin desabilitado com sucesso.");
			getServer().getPluginManager().disablePlugin(this);
			return; 
		}	
		saveDefaultConfig();
		VipZero.loadConfigFile();

		getServer().getPluginManager().registerEvents(new Click(), this);
		info = Bukkit.createInventory(null, 54, "§7Info dos VIPs do servidor:");
		System.out.println("§e[CIKE NETWORK] §7VipZero encontrado, ativando..");
		System.out.println("§e[CIKE NETWORK] §7Plugin habilitado com sucesso.");

	}
	@Override
	public boolean onCommand(CommandSender s, Command cmd, String lb, String[] args) {
		if(s instanceof Player) {
			Player p = (Player)s;
			if(lb.equalsIgnoreCase("vipinfo")) {
				VipZero.LoadVips(p);
			}
		}
		return false;
	}
}
