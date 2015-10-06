package algo.text.html;

import algo.text.html.interfaces.WebToolsAdapter;

public class WebTools extends WebToolsAdapter {

	@Override
	public int htmlCount(String arg0) {
		int count = 0;
	
		arg0 = arg0.replaceAll("<[^>]*>", "");
		arg0 = arg0.replaceAll("(?<=&).*?(?=;)", "");

		String[] str = arg0.split(" ");
		
		for(String s : str)
			if(!s.isEmpty())
			{
				if(s.equals("&;"))
					count++;
				else
					for(int i=0; i<s.length(); i++)
						count++;

				count++;
			}
		
		return --count;
	}

	@Override
	public String htmlSubstring(String arg0, int arg1, String arg2) {
		// TODO Auto-generated method stub
		return null;
	}

}
