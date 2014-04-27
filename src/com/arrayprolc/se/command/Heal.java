package com.arrayprolc.se.command;

import org.bukkit.entity.Player;

import com.arrayprolc.se.texthandler.Message;

public class Heal {

	@SuppressWarnings("deprecation")
	public static void heal(Player p, String[] args) {
		if (args.length == 0) {
			if (p.hasPermission("player.heal") || p.isOp()) {
				p.setFireTicks(0);
				p.setHealth(20);
				p.setFoodLevel(20);
				p.sendMessage(Message.info("You have been healed."));
			} else {
				p.sendMessage(Message.noPerm());
			}
		}

	}

}
