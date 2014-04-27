package com.arrayprolc.se.main;

import org.bukkit.entity.Player;

import com.arrayprolc.se.texthandler.Message;

public class SPermission {

	public static boolean testPerm(String s, Player p) {
		if (Main.essentials) {
			s = "essentials." + s;
		} else {
			s = "smooth." + s;
		}
		if (Main.op && p.isOp()) {
			return true;
		}
		return (p.hasPermission(s));
	}

	public static boolean hook(String s, Player p) {
		if (!testPerm(s, p)) {
			p.sendMessage(Message.noPerm());
		}

		return testPerm(s, p);
	}

}
