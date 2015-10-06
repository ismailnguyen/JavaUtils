package algo.text.html;

import java.util.Iterator;

import algo.stack.LinkedStack;
import algo.linkedlist.nodes.LinkSimple;
import algo.text.html.interfaces.IWebTools;

public class Application {

	public static void main(String[] args) {
		IWebTools app = new WebTools();

		//System.out.println(app.htmlCount("<a href=\"mon_lien\"> &raquo;&raquo;&raquo; un lien </a>"));
		
		LinkedStack<LinkSimple<String>> stack = new LinkedStack<LinkSimple<String>>();
		
		LinkSimple<String> ls1 = new LinkSimple<String>();
		LinkSimple<String> ls2 = new LinkSimple<String>();
		ls1.setValue("blablabla");
		ls2.setValue("kikiki");
		
		stack.push(ls1);
		stack.push(ls2);
		
		Iterator<LinkSimple<String>> it = stack.iterator();
		while(it.hasNext())
			System.out.println(it.next().getValue());

	}
}
