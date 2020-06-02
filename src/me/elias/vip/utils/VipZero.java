package me.elias.vip.utils;

import java.io.File;
import java.util.Arrays;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import me.elias.vip.Main;

public class VipZero {
	
	public static File file;
	public static FileConfiguration f;
	
	public static void loadConfigFile() {
		file = new File("plugins/VipZero", "config.yml");
		try {
		f = YamlConfiguration.loadConfiguration(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings("deprecation")
	public static void LoadVips(Player p) {
		p.sendMessage(Main.plugin.getConfig().getString("Prefixo").replace("&", "§") + Main.plugin.carregando);
		p.openInventory(Main.plugin.info);
		for (String vip : f.getConfigurationSection("vips").getKeys(false)) {
			ItemStack head = new ItemStack(397, 1, (short)1);
			SkullMeta meta = (SkullMeta) head.getItemMeta();
			meta.setOwner(vip);
			meta.addEnchant(Enchantment.DURABILITY, 1, true);
			meta.setDisplayName("§7Jogador: §a" + vip);
			if (f.getString("vips." + vip + Main.plugin.getConfig().getInt("Tipos.VIP1")) != null) {
				meta.setLore(Arrays.asList("", "§7Tipo do vip: " + Main.plugin.getConfig().getString("Prefixos.VIP1").replace("&", "§"), "§7Data do inicio: §a" + f.getString("vips." + vip + ".inicio", "")));
			}
			if (f.getString("vips." + vip + Main.plugin.getConfig().getInt("Tipos.VIP2")) != null) {
				meta.setLore(Arrays.asList("", "§7Tipo do vip: " + Main.plugin.getConfig().getString("Prefixos.VIP2").replace("&", "§"), "§7Data do inicio: §a" + f.getString("vips." + vip + ".inicio", "")));
			}
			if (f.getString("vips." + vip + Main.plugin.getConfig().getInt("Tipos.VIP3")) != null) {
				meta.setLore(Arrays.asList("", "§7Tipo do vip: " + Main.plugin.getConfig().getString("Prefixos.VIP3").replace("&", "§"), "§7Data do inicio: §a" + f.getString("vips." + vip + ".inicio", "")));
			}
			if (f.getString("vips." + vip + Main.plugin.getConfig().getInt("Tipos.VIP4")) != null) {
				meta.setLore(Arrays.asList("", "§7Tipo do vip: " + Main.plugin.getConfig().getString("Prefixos.VIP4").replace("&", "§"), "§7Data do inicio: §a" + f.getString("vips." + vip + ".inicio", "")));
			}
			head.setItemMeta(meta);
			Main.plugin.info.addItem(head);
			
			try {
				Thread.sleep(80);
			} catch (InterruptedException e) {
				e.printStackTrace();
				p.sendMessage(Main.plugin.getConfig().getString("PrefixoErro").replace("&", "§") + Main.plugin.getConfig().getString("Erro").replace("&", "§"));
			}
			p.updateInventory();
		}
		p.sendMessage(Main.plugin.getConfig().getString("Prefixo").replace("&", "§") + Main.plugin.carregado);
		p.updateInventory();
	}
}
