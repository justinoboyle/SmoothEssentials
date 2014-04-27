package com.arrayprolc.se.texthandler;

public class StringList {
	String s = "";

	public StringList() {

	}

	public void add(String string) {
		if (s.equals("")) {
			s = "§6" + string + "§7,";
		} else {
			s = " §6" + string + "§7,";
		}
		fixCharacter(string);
	}

	public String print() {
		return s;
	}

	private String fixCharacter(String str) {
		if (str.length() > 0 && str.charAt(str.length() - 1) == ',') {
			str = str.substring(0, str.length() - 1);
		}
		return str;
	}

}
