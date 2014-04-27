package com.arrayprolc.se.command;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.arrayprolc.se.main.SPermission;
import com.arrayprolc.se.main.Status;
import com.arrayprolc.se.texthandler.Message;

public class Online {

	public static void online(Player p, String[] args) {
		if (args.length == 0) {
			if (SPermission.hook("online", p)) {
				String s = "";
				for (Player allp : Bukkit.getOnlinePlayers()) {
					if (!Status.isHidden(allp)) {
						if (s.equals("")) {
							s = "§6" + allp.getDisplayName();
						} else {
							s = "§7, §6" + allp.getDisplayName() + "";
						}
						fixCharacter(s);
					}
				}
				p.sendMessage(Message.info("Online Players ("
						+ Bukkit.getOnlinePlayers().length + ")§7:"));
				fixCharacter(s);
				p.sendMessage(s);
			}
		}

	}

	private static String fixCharacter(String str) {
		if (str.length() > 0 && str.charAt(str.length() - 1) == ',') {
			str = str.substring(0, str.length() - 1);
		}
		return str;
	}

}
