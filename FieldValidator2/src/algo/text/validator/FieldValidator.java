package algo.text.validator;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import algo.text.validator.interfaces.IFieldValidator;

public class FieldValidator implements IFieldValidator {

	@Override
	public String htmlCleanTags(String arg0, String arg1) {
		if(arg0 == null) return new String();
		
		Pattern p = Pattern.compile("<.+?>");
		Matcher m = p.matcher(arg0);
		return m.replaceAll("");
	}

	@Override
	public String htmlRemoveScript(String arg0) {
		if(arg0 == null) return new String();
		
		Pattern regex = Pattern.compile("<script.*</script>", Pattern.MULTILINE | Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
		Matcher match = regex.matcher(arg0);
		String result = match.replaceAll("");
		return result;
	}

	@Override
	public String htmlRemoveTagAttributes(String arg0, String arg1) {
		if(arg0 == null) return new String();
		
		for(String t : arg1.split("|"))
			arg0.replace(t, "");
		
		return arg0;
	}

	@Override
	public Map<String, String> httpExtractGetParams(String arg0) {
		if(arg0 == null) return new HashMap<String, String>();
		
		Map<String, String> map = new HashMap<String, String>();
		
		if(arg0.contains("?"))
		{
			String s = arg0.substring(arg0.indexOf("?")+1);
			
			String[] params = s.split("&");
			
			for(String p : params)
			{
				if(p.contains("="))
				{
					String[] param = p.split("=");
					
					map.put(param[0], param[1]);
				}
				else
				{
					map.put(p, null);
				}
			}
		}
		
		return map;
	}

	@Override
	public boolean isBoolean(String arg0) {
		if(arg0 == null) return false;
		
		if(arg0.equals("true")
			|| arg0.equals("false")
			|| arg0.equals("1")
			|| arg0.equals("0"))
			return true;
		
		return false;
	}

	@Override
	public boolean isCurrency(String arg0) {
		if(arg0 == null) return false;
		
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDate(String arg0) {
		if(arg0 == null) return false;
		
		return arg0.matches("\\d{4}-\\d{2}-\\d{2}") || arg0.matches("\\d{2}-\\d{2}-\\d{4}");
	}

	@Override
	public boolean isEmail(String arg0) {
		if(arg0 == null) return false;
		
		return arg0.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	}

	@Override
	public boolean isEmpty(String arg0) {
		if(arg0 == null) return false;
		
		return arg0.equals("") || arg0.equals(" ");
	}

	@Override
	public boolean isFloat(String arg0) {
		if(arg0 == null) return false;
		
		return arg0.matches("([0-9]*)\\.([0-9]*)");
	}

	@Override
	public boolean isFtp(String arg0) {
		if(arg0 == null) return false;
		
		return arg0.startsWith("ftp://");
	}

	@Override
	public boolean isHttp(String arg0) {
		if(arg0 == null) return false;
		
		return arg0.startsWith("http://") || arg0.startsWith("https://");
	}

	@Override
	public boolean isInteger(String arg0) {
		if(arg0 == null) return false;
		
		return arg0.matches("^-?\\d+$");
	}

	@Override
	public Boolean toBoolean(String arg0) {
		if(arg0 == null) return false;
		
		return arg0.equals("true") ? true : false;
	}

	@Override
	public Date toDate(String arg0) {
		if(arg0 == null) return new Date();
		
		String[] str = arg0.split("-");
		
		Date d = new Date();
		d.setDate(this.toInteger(str[0]));
		d.setMonth(this.toInteger(str[1]));
		d.setYear(this.toInteger(str[2]));
		
		return d;
	}

	@Override
	public Float toFloat(String arg0) {
		if(arg0 == null) return 0.0f;
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer toInteger(String arg0) {
		if(arg0 == null) return 0;
		
		// TODO Auto-generated method stub
		return 1;
	}

}
