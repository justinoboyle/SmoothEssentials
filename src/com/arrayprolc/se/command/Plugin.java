package com.arrayprolc.se.command;

import org.bukkit.entity.Player;
import org.bukkit.plugin.InvalidDescriptionException;
import org.bukkit.plugin.InvalidPluginException;
import org.bukkit.plugin.UnknownDependencyException;

import com.arrayprolc.se.main.PluginUtil;
import com.arrayprolc.se.main.SPermission;
import com.arrayprolc.se.texthandler.Message;

public class Plugin {

	public static boolean plugin(Player p, String args[]) {
		if (!SPermission.hook("plugin", p)) {
			return false;
		}
		if (args.length == 0) {
			p.sendMessage(Message
					.error("Not enough arguments! /plugin (enable/disable/reload) [name]"));
		} else if (args.length == 1) {
			switch (args[0]) {
			case "download":
				p.sendMessage(Message
						.info("You can download the following plugins:"));
				return false;
			}
		} else if (args.length == 2) {
			switch (args[0]) {
			case "enable":
				try {
					PluginUtil.loadPlugin(args[1]);
				} catch (UnknownDependencyException e) {
					p.sendMessage(Message.error(args[1]
							+ " is missing a dependency."));
					return false;
				} catch (InvalidPluginException e) {
					p.sendMessage(Message.error("plugins/ " + args[1]
							+ ".jar was not found."));
					return false;
				} catch (InvalidDescriptionException e) {
					p.sendMessage(Message.error(args[1]
							+ " has an invalid description."));
					return false;
				}
				p.sendMessage(Message.info(args[1]
						+ " has been loaded and enabled!"));
				return true;
			case "disable":
				try {
					PluginUtil.unloadPlugin(args[1]);
				} catch (UnknownDependencyException e) {
					p.sendMessage(Message.error(args[1]
							+ " is missing a dependency."));
					return false;
				} catch (InvalidPluginException e) {
					p.sendMessage(Message.error("" + args[1]
							+ " was not found."));
					return false;
				} catch (InvalidDescriptionException e) {
					p.sendMessage(Message.error(args[1]
							+ " has an invalid description."));
					return false;
				}
				p.sendMessage(Message.info(args[1] + " has been disabled."));
				return true;
			case "reload":
				try {
					PluginUtil.unloadPlugin(args[1]);
					PluginUtil.loadPlugin(args[1]);
				} catch (UnknownDependencyException e) {
					p.sendMessage(Message.error(args[1]
							+ " is missing a dependency."));
					return false;
				} catch (InvalidPluginException e) {
					p.sendMessage(Message.error("plugins/" + args[1]
							+ ".jar was not found."));
					return false;
				} catch (InvalidDescriptionException e) {
					p.sendMessage(Message.error(args[1]
							+ " has an invalid description."));
					return false;
				}
				p.sendMessage(Message.info(args[1] + " has been reloaded."));
				return true;
			}
		}
		p.sendMessage(Message
				.error("Unknown sub-command. /plugin (enable/disable/reload) [name]"));
		return true;
	}
}
