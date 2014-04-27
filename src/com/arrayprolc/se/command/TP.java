package com.arrayprolc.se.command;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.arrayprolc.se.texthandler.Message;
import com.arrayprolc.se.texthandler.Tools;

public class TP {

	public static void tp(Player p, String[] args) {
		if (args.length == 1) {
			if (p.hasPermission("player.tp") || p.isOp()) {
				if (Tools.getPlayer(args[0]) == null) {
					p.sendMessage(Message.error("Player not found."));
				} else {
					p.teleport(Tools.getPlayer(args[0]));
					p.sendMessage(Message.info("You teleported to "
							+ Tools.getPlayer(args[0]).getDisplayName() + "."));
				}
			} else {
				p.sendMessage(Message.noPerm());
			}
		} else if (args.length == 2) {
			Player target = Tools.getPlayer(args[0]);
			Player player = Tools.getPlayer(args[1]);
			if (p.hasPermission("player.tp") || p.isOp()) {
				if (Tools.getPlayer(args[0]) == null
						|| Tools.getPlayer(args[1]) == null) {
					p.sendMessage(Message.error("Player not found."));
				} else {
					target.teleport(player.getLocation());
					p.sendMessage(Message.info("You teleported " + target
							+ " to " + player.getDisplayName() + "."));
				}
			} else {
				p.sendMessage(Message.noPerm());
			}
		} else {
			if (p.hasPermission("player.tp") || p.isOp()) {
				p.sendMessage(Message
						.usage("/tp player §8or§7 /tp target player"));
			} else {
				p.sendMessage(Message.noPerm());
			}
		}

	}

	public static void tpall(Player p, String[] args) {
		if (args.length == 0) {
			if (p.hasPermission("player.tpall") || p.isOp()) {
				for (Player all : Bukkit.getOnlinePlayers()) {
					all.teleport(p.getLocation());
				}
			} else {
				p.sendMessage(Message.noPerm());
			}
		} else {
			if (p.hasPermission("player.tpall") || p.isOp()) {
				p.sendMessage(Message.usage("/tpall"));
			} else {
				p.sendMessage(Message.noPerm());
			}
		}
	}

}
