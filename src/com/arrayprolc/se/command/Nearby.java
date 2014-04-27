package com.arrayprolc.se.command;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import com.arrayprolc.se.texthandler.Message;

public class Nearby {

	public static void nearby(Player p, String args[]) {
		String s = p.getName();
		for (Entity e : p.getNearbyEntities(10, 10, 10)) {
			s = s
					+ ", "
					+ (e instanceof Player ? ((Player) e).getName() : e
							.getType().name().toLowerCase());
		}
		p.sendMessage(Message.info("Nearby entities: §a" + s));
	}
}
