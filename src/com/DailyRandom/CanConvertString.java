package com.DailyRandom;

public class CanConvertString {

    public static boolean canConvertString(String s, String t, int k) {

        if(s.length()!=t.length())
        {
            return false;
        }

        int i=1;
        for(int j=0;j<s.length();j++)
        {
            int sChar = s.charAt(j) - 'a';
            int tChar = t.charAt(j) - 'a';
            if(sChar<tChar)
            {

                if(i>k) return false;

                int diff = tChar - sChar;
                if(diff>=i)
                {
                    i = diff;
                    i++;
                }
                else if(diff+26 <=k)
                {
                    i = diff +26;
                    i++;
                }
                else
                {
                    return false;
                }
            }else if(sChar>tChar)
            {
                int diff = 26-(sChar - tChar);
                if(diff<=k)
                {
                    i=diff;
                    i++;
                }
                else
                {
                    return false;
                }
            }

        }


        return true;

    }

    public static void main(String[] args) {
        int  k =10;
        boolean ans = canConvertString("input", "ouput",9);
        System.out.println(ans);
    }
}
