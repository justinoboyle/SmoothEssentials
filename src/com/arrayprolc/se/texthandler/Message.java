package com.arrayprolc.se.texthandler;

public class Message {

	public static String send(String topic, String msg) {
		return ("§e" + topic + " > §7 " + msg);
	}

	public static String info(String msg) {
		return ("§eInfo > §7 " + msg);
	}

	public static String noPerm() {
		return ("§cPermission > §7You do not have permission to do that.");
	}

	public static String usage(String usage) {
		return ("§eUsage > §7 " + usage);
	}

	public static String error(String usage) {
		return ("§cError > §7 " + usage);
	}

}
