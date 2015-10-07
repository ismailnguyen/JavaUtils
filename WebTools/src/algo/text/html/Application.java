package algo.text.html;

import java.util.Iterator;

import algo.stack.LinkedStack;
import algo.linkedlist.nodes.LinkSimple;
import algo.text.html.interfaces.IWebTools;

public class Application {

	public static void main(String[] args) {
		IWebTools app = new WebTools();

		//System.out.println(app.htmlCount("Benjax"));
		
		/*
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
		*/
		
		String b = "<div>"
				   + "<h2>"
					  + "<a href=\"\">Lorem <strong>ipsum dolor</strong>  sit amet, "
					 +    " consectetur adipiscing elit. Phasellus accumsan sagittis convallis. Vestibulum "
		   		    +       "   at enim risus, id tempor orci. Nullam nunc mauris, auctor nec cursus vitae"
				   +        "</a>"
				  +  "</h2>"
			+    "</div>";
		
		System.out.println(app.htmlSubstring(b.trim(), 20, "..."));

	}
}
