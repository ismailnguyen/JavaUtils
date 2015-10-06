package algo.text.validator;

import algo.text.validator.interfaces.IFieldValidator;

public class Application {
	public static void main(String[] args) {
		IFieldValidator app = new FieldValidator();
		
		System.out.println("isEmpty: " + app.isEmpty(""));
		System.out.println("isBoolean: " + app.isBoolean("false"));
		System.out.println("isDate: " + app.isDate("je m'appel ismail"));
		System.out.println("isEmail: " + app.isEmail("hello wordbye"));
		System.out.println("isHttp: " + app.isHttp("www.frandroid.com/?paginated=2"));
		System.out.println("isFtp: " + app.isFtp("azerty"));
		System.out.println("isFloat: " + app.isFloat("20.00"));
		System.out.println("isInteger: " + app.isInteger("2354254"
				+ ""));
		System.out.println("isCurrency: " + app.isCurrency("azerty"));
		
		System.out.println("toDate: " + app.toDate("12-12-2023"));
		System.out.println("toInteger: " + app.toInteger("gszeg"));
		System.out.println("toFloat: " + app.toFloat("azeaze  uh jioo"));
		System.out.println("toBoolean: " + app.toBoolean("azeaze  uh jioo"));
		
		System.out.println("httpExtractGetParams: " + app.httpExtractGetParams("www.frandroid.com/?paginated=2&e&epo=nyme"));
		System.out.println("htmlRemoveScript: " + app.htmlRemoveScript("gszeg"));
		System.out.println("htmlRemoveTagAttributes: " + app.htmlRemoveTagAttributes("zegzrgre", "azeaze  uh jioo"));
		System.out.println("htmlCleanTags: " + app.htmlCleanTags("fezfez", "azeaze  uh jioo"));
	}
}

