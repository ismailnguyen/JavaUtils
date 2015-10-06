package org.essilab.exercices.bases.string;

import org.essilab.exercices.bases.string.interfaces.IStringUtil;

public class Application {
	public static void main(String[] args) {
		IStringUtil app = new StringUtil();
		
		System.out.println("camelizeLower: " + app.camelizeLower("ze_zg o zieg"));
		System.out.println("camelizeUpper: " + app.camelizeUpper("ze_zg o zieg"));
		System.out.println("capitalize: " + app.capitalize("je m'appel ismail"));
		System.out.println("replace: " + app.replace("hello world, hello", "hello", "goodbye", true));
		System.out.println("replace: " + app.replace("hello india, hello", "hello", "bye bye", false));
		System.out.println("revert: " + app.revert("azerty"));
		System.out.println("toLowercase: " + app.toLowercase("GREOergjreogerjg3G"));
		System.out.println("toUppercase: " + app.toUppercase("gszeg"));
		System.out.println("trim: " + app.trim("azeaze  uh jioo"));
	}
}
