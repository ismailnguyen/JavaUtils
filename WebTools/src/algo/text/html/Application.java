package algo.text.html;

import algo.text.html.interfaces.IWebTools;

public class Application {

	public static void main(String[] args) {
		IWebTools app = new WebTools();

		System.out.println(app.htmlCount("<a href=\"mon_lien\"> &raquo; un lien </a>"));

	}

}
