package algo.text.html;

import algo.stack.LinkedStack;
import algo.linkedlist.nodes.LinkSimple;
import algo.text.html.interfaces.IWebTools;

public class Application {

	public static void main(String[] args) {
		IWebTools app = new WebTools();

		System.out.println(app.htmlCount("<a href=\"mon_lien\"> &raquo; &raquo; &raquo; un lien </a>"));
		
		LinkedStack<LinkSimple<String>> stack = new LinkedStack<LinkSimple<String>>();
		LinkSimple<String> ls1 = new LinkSimple<String>();
		ls1.setValue("blablabla");
	}
}
