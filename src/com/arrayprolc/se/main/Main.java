package com.arrayprolc.se.main;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.arrayprolc.se.command.Heal;
import com.arrayprolc.se.command.Online;
import com.arrayprolc.se.command.Plugin;
import com.arrayprolc.se.command.TP;
import com.arrayprolc.se.texthandler.Install;

public class Main extends JavaPlugin implements Listener {

	public final Logger logger = Logger.getLogger("Minecraft");
	public static Main plugin;
	public final EventListener bl = new EventListener(this);
	Boolean b = false;
	static Boolean essentials = false;
	static Boolean op = true;
	PluginDescriptionFile pdfFile = this.getDescription();

	@Override
	public void onDisable() {
		this.logger.info(pdfFile.getName() + " plugin disabled!");
	}

	@Override
	public void onEnable() {
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents(bl, this);
		getConfig().options().copyDefaults(true);
		saveConfig();
		// String ver = pdfFile.getVersion();
		// String latest =
		// Web.get("http://www.arrayprolc.com/ver/se/latest.txt");
		// if ((!(ver.equalsIgnoreCase(latest)))
		// && (!(latest.equalsIgnoreCase(null)))) {
		// Install.plugin("SmoothEssentials");
		// }
	}

	@SuppressWarnings("unused")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd,
			String commandLabel, String[] args) {
		final Player player = (Player) sender;
		String prefix = "se";
		if (!commandLabel.startsWith(prefix))
			commandLabel = "se" + commandLabel;

		switch (commandLabel) {
		case "seheal":
			Heal.heal(player, args);
			return false;
		case "seh":
			Heal.heal(player, args);
			return false;
		case "setp":
			TP.tp(player, args);
			return false;
		case "setpall":
			TP.tpall(player, args);
			return false;
		case "selist":
			Online.online(player, args);
			return false;
		case "semotd":
			String[] motds = getConfig().getString("motd").replace("&", "§")
					.split("$");
			for (String m : motds) {
				player.sendMessage(m);
			}
			return false;
		case "seonline":
			Online.online(player, args);
			return false;
		case "sedownload":
			if (player.isOp()) {
				if (args.length == 0) {

				}
				Install.plugin(args[0], player);
			}
			return false;
		case "seplugin":
			Plugin.plugin(player, args);
			return false;
		}
		return false;

	}
}