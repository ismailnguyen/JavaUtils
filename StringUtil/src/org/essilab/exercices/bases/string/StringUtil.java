package org.essilab.exercices.bases.string;

import org.essilab.exercices.bases.string.interfaces.IStringUtil;

public class StringUtil implements IStringUtil {
    public String trim(String string) {
        if(string==null){
            return null;
        }
        string = string.replaceAll("\\s+$", "");
        return string.replaceAll("\\s", "");

    }

    public String toLowercase(String s) {
        if (s == null)
            return null;

        String retour = "";

        for (int i = 0; i < s.length(); i++)
        {
            retour += Character.toLowerCase(s.charAt(i));
        }

        return retour;
    }

    public String toUppercase(String s) {
        if (s == null)
            return null;

        if (s == null)
            return null;

        String retour = "";

        for (int i = 0; i < s.length(); i++)
        {
            retour += Character.toUpperCase(s.charAt(i));
        }

        return retour;
    }

    public String capitalize(String s) {
        if (s == null)
            return null;


        boolean isnewmot = true;
        String retour = "";
        for (int i = 0; i < s.length(); i++)
        {
            if (Character.isLetter(s.charAt(i)))
            {
                if (isnewmot){
                    retour += Character.toUpperCase(s.charAt(i));
                } else {
                    retour += Character.toLowerCase(s.charAt(i));
                }
                isnewmot = false;
            } else {
                if (!Character.isLetterOrDigit(s.charAt(i)))
                    isnewmot = true;
                retour += "" + s.charAt(i);
            }
        }

        return retour;
    }

    public String camelizeUpper(String s) {
        if (s == null)
            return null;

        String retour = this.capitalize(this.trim(s));
        retour = this.capitalize(retour);
        boolean isnewmot = true;
        String retour2 = "";
        for (int i = 0; i < retour.length(); i++)
        {
            if (Character.isLetterOrDigit(retour.charAt(i)))
            {
                retour2+= retour.charAt(i);
            }
        }
        return retour2;
    }

    public String camelizeLower(String s) {
        if (s == null)
            return null;

        String retour = this.capitalize(this.trim(s));
        retour = this.capitalize(retour);
        boolean isnewmot = true;
        String retour2 = "";
        for (int i = 0; i < retour.length(); i++)
        {
            if (Character.isLetterOrDigit(retour.charAt(i)))
            {
                if (retour2.equals(""))
                    retour2 += Character.toLowerCase(retour.charAt(i));
                else
                    retour2+= retour.charAt(i);
            }
        }

        return retour2;
    }

    public String revert(String s) {
        if (s == null)
            return null;

        String retour = "";
        int i = s.length() - 1;
        while (i > -1)
        {
            retour += s.charAt(i);
            i--;
        }
        return retour;
    }

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