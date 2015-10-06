package algo.text.html;

import algo.text.html.interfaces.WebToolsAdapter;

public class WebTools extends WebToolsAdapter {

	@Override
	public int htmlCount(String arg0) {
		return arg0 == null ? null : ((arg0.replaceAll("<[^>]*>", "").replaceAll("&.*;", "a")).trim()).length();
	}

	@Override
	public String htmlSubstring(String arg0, int arg1, String arg2) {
		// TODO Auto-generated method stub
		return null;
	}

}
