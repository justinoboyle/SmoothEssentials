package com.arrayprolc.se.texthandler;

import java.io.IOException;
import java.net.MalformedURLException;

import org.bukkit.entity.Player;

import com.arrayprolc.se.main.PluginUtil;

public class Install {

	public static boolean plugin(String s, Player p) {
		// p.sendMessage(Message.info("Downloading..."));
		try {
			Web.download("http://www.arrayprolc.com/download/" + s + ".jar",
					"plugins/" + s + ".jar");
		} catch (MalformedURLException e) {
			// p.sendMessage(Message.error("Download failed! Malformed URL!"));
			// p.sendMessage(Message
			// .info("Direct link: http://www.arrayprolc.com/download/"
			// + s + ".jar"));
			return false;
		} catch (IOException e) {
			// p.sendMessage(Message
			// .error("Download failed! Could not edit plugins/ directory"));
			// p.sendMessage(Message
			// .info("Direct link: http://www.arrayprolc.com/download/"
			// + s + ".jar"));
			return false;
		}

		// p.sendMessage(Message.info("Attempting to load..."));
		try {
			PluginUtil.unloadPlugin(s);
		} catch (Exception e) {
		}
		try {
			PluginUtil.loadPlugin(s);

		} catch (Exception e) {
			// p.sendMessage(Message.error("Error loading plugin!"));
		}
		p.sendMessage(Message.info("Installed " + s + "!"));
		return true;
	}

	public static boolean plugin(String s) {
		try {
			Web.download("http://www.arrayprolc.com/download/" + s + ".jar",
					"plugins/" + s + ".jar");
		} catch (Exception e) {
			return false;
		}
		try {
			PluginUtil.unloadPlugin(s);
		} catch (Exception e) {
		}
		try {
			PluginUtil.loadPlugin(s);
		} catch (Exception e) {
		}
		return true;
	}
}
