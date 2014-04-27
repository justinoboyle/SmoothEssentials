package com.arrayprolc.se.main;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.InvalidDescriptionException;
import org.bukkit.plugin.InvalidPluginException;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.UnknownDependencyException;

public class PluginUtil {

	@SuppressWarnings({ "unused" })
	public static void loadPlugin(String pluginName)
			throws InvalidPluginException, InvalidDescriptionException,
			UnknownDependencyException {
		// loading a plugin on the other hand is way simpler

		PluginManager manager = Bukkit.getServer().getPluginManager();

		Plugin plugin = manager.loadPlugin(new File("plugins", pluginName
				+ ".jar"));

		if (plugin == null)
			return;

		manager.enablePlugin(plugin);

		List<Permission> permissionlist = plugin.getDescription()
				.getPermissions();
		Iterator<Permission> p = permissionlist.iterator();
		try {
			while (p.hasNext()) {
				manager.addPermission(p.next());
			}
		} catch (NoSuchMethodError e) {
			// Do nothing
		}
	}

	public static void unloadPlugin(String pluginName)
			throws InvalidPluginException, InvalidDescriptionException,
			UnknownDependencyException {
		Bukkit.getServer()
				.getPluginManager()
				.disablePlugin(
						Bukkit.getServer().getPluginManager()
								.getPlugin(pluginName));
	}

	public static void reloadPlugin(String s) {
		try {
			unloadPlugin(s);
		} catch (UnknownDependencyException | InvalidPluginException
				| InvalidDescriptionException e1) {
		}
		try {
			loadPlugin(s);
		} catch (UnknownDependencyException | InvalidPluginException
				| InvalidDescriptionException e) {
		}

	}
}
