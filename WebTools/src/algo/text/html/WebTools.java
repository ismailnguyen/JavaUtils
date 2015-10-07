package algo.text.html;

import java.util.ArrayList;
import algo.text.html.interfaces.WebToolsAdapter;

public class WebTools extends WebToolsAdapter {

	@Override
	public int htmlCount(String arg0) {

		return arg0 == null ? 0 : ((arg0.replaceAll("<[^>]*>", "").replaceAll("&.+;", "a")).trim()).length();
	}

	@Override
	public String htmlSubstring(String arg0, int arg1, String arg2) {
		if(arg0 == null) return null;
		
		StringBuffer sb = new StringBuffer();
		
		ArrayList<String> openTagStack = new ArrayList<String>();
		ArrayList<String> closeTagStack = new ArrayList<String>();
		
		int startTag = -1;
		int endTag = -1;
		String txt = new String();
		StringBuffer a = new StringBuffer();
		
		for(int i=0; i<arg0.length(); i++)
		{
			if(arg0.charAt(i) == '<') startTag = i;
			if(arg0.charAt(i) == '>') endTag = i+1;
			
			if(startTag != -1 && endTag != -1)
			{
				txt = arg0.substring(startTag, endTag);
				endTag = -1;
				startTag = -1;
				
				if(txt.charAt(1) == '/') closeTagStack.add(txt);
				else openTagStack.add(txt);
			}
			else
				a.append(arg0.charAt(i));	
		}
		
		for(String open : openTagStack)
			sb.append(open);
		
		sb.append((arg0.replaceAll("<[^>]*>", "")).substring(0, arg1));
		if(arg2 != null)
			sb.append(arg2);
		
		for(String close : closeTagStack)
			sb.append(close);
  		
		return sb.toString();
	}
}
