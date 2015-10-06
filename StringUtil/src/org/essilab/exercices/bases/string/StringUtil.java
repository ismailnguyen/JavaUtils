package org.essilab.exercices.bases.string;

import org.essilab.exercices.bases.string.interfaces.IStringUtil;

public class StringUtil implements IStringUtil {

    @Override

    public String trim(String string) {
        if(string==null){
            return null;
        }
        string = string.replaceAll("\\s+$", "");
        return string.replaceAll("\\s", "");

    }

    @Override
    public String toLowercase(String s) {
        if (s == null)
            return null;
        String retour = "";
        for (int i = 0; i < s.length(); i++){
            retour += Character.toLowerCase(s.charAt(i));
        }
        return retour;
    }

    @Override
    public String toUppercase(String s) {
        if (s == null)
            return null;
        String retour = "";
        for (int i = 0; i < s.length(); i++){
            retour += Character.toUpperCase(s.charAt(i));
        }
        return retour;
    }

    @Override
    public  String capitalize (String s) {
        if (s == null)
            return null;
        boolean flag;
        String charSpecials = ";\":? ,";
        StringBuffer buffer = new StringBuffer("");

        for (int i = 0; i < s.length(); i++) {
            flag = false;
            buffer.append(s.charAt(i));

            for (int j = 0; j < charSpecials.length(); j++) {
                if (s.charAt(i) == charSpecials.charAt(j)) {
                    flag = true;
                    break;
                }
            }

            if (flag == true) {
                if (i < s.length() - 1) {
                    i++;
                }
                buffer.append(Character.toUpperCase(s.charAt(i)));
            }
        }

        buffer.deleteCharAt(buffer.length() - 1);
        String retour = buffer.toString();
        return retour;
    }

    @Override
    public String camelizeUpper(String string) {
        if(string==null){
            return null;
        }
        string = toUppercase(string);
        String result = "";
        boolean f = true;
        for(int i=0;i<string.length();i++){
            int c = (int) string.charAt(i);
            if((c>=97 && c<=122)||(c>=65 && c<=90)){
                if(f){
                    result += (char) c;
                }else{
                    result += (char) (c+32);
                }
                f=false;
            }else{
                f=true;
            }
        }
        return result;
    }

    @Override
    public String camelizeLower(String string) {
        if(string==null){
            return null;
        }
        string = toUppercase(string);
        String result = "";
        boolean f = false;
        for(int i=0;i<string.length();i++){
            int c = (int) string.charAt(i);
            if((c>=97 && c<=122)||(c>=65 && c<=90)){
                if(f){
                    result += (char) c;
                }else{
                    result += (char) (c+32);
                }
                f=false;
            }else{
                f=true;
            }
        }
        return result;
    }

    @Override
    public String revert(String s) {
        if (s == null)
            return null;
        StringBuilder lettersBuff = new StringBuilder(s);
        String inverse = lettersBuff.reverse().toString();
        return inverse ;
    }

    @Override
    public String replace(String input, String pattern, String replacement, boolean all) {
        if (input == null)
            return null;
        if (pattern == null)
            return input;

        int nb = 0;
        int i = 0;
        boolean continuer = true;
        while (i < input.length() && continuer)
        {
            if (input.charAt(i) == pattern.charAt(0))
            {
                //Verifier si il y a le mot entier
                int complete = 0;
                if (input.substring(i, i + pattern.length()).equals(pattern))
                    complete = 1;


                if (1 == complete)
                {
                    if (replacement == null)
                        input = input.substring(0, i) + input.substring(i + pattern.length(), input.length());
                    else
                        input = input.substring(0, i) + replacement + input.substring(i + pattern.length(), input.length());

                    i += pattern.length();
                    if (!all)
                        continuer = false;
                }
            }
            i++;
        }
        return input;
    }

    @Override
    public String replace(String arg0, String arg1, IReplacementCallback arg2, boolean arg3) {
        if (arg0 == null || arg1 == null)
            return null;

        StringBuffer sb = new StringBuffer();
        String[] str = arg0.split(" ");
        boolean flag = false;
        for(String s : str)
        {
            if(s.compareTo(arg1) == 0)
            {
                if((arg3 == false && flag == false) || arg3 == true)
                    s = arg2.replace(s);
                if(flag == false)
                    flag = true;
            }
            sb.append(s + " ");
        }
        return sb.toString();
    }
}