package com.arrayprolc.se.texthandler;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Tools {

	public static Player getPlayer(String s) {
		for (Player p : Bukkit.getOnlinePlayers()) {
			if (p.getName().toLowerCase().equals(s.toLowerCase())) {
				return p;
			} else if (p.getName().toLowerCase().startsWith(s)) {
				return p;
			}
		}
		return null;
	}
}
