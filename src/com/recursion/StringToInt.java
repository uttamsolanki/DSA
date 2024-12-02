/**
 * Problem : LC-8: String to Integer (atoi)
 */

package com.recursion;

public class StringToInt {
    public static  int myAtoi(String s, int signIndicate,int index, long num) {

        if(signIndicate>-1)
        {
            if(num>Integer.MAX_VALUE)
            {
                return Integer.MAX_VALUE;
            }
        }
        else
        {
            if(-num<Integer.MIN_VALUE)
            {
                return Integer.MIN_VALUE;
            }

        }

        if(s.length()==0 || index>=s.length())
        {
            if(num==-1)
            {
                return 0;
            }
            return (int)(signIndicate==-1? -num:num);
        }

        char ch = s.charAt(index);

        // Sign is not detected and skipping white space until get sign
        if (signIndicate==0 && (ch == ' ' || ch == '-' || ch == '+') )
        {
            if(ch == ' ')
            {
                return myAtoi(s,signIndicate,index+1,num);
            }
            else if(ch == '-')
            {
                return myAtoi(s,-1,index+1,num);
            }
            else if(ch == '+')
            {
                return myAtoi(s,1,index+1,num);
            }
        }
        //if we detect number first after space then consider positive sign
        else if( ch >= '0' && ch <='9')
        {
            if(signIndicate==0)
            {
                signIndicate=1;
            }
            num = (num*10 + (ch - '0'));
            return myAtoi(s,signIndicate,index+1,num);
        }
        return  (int)(signIndicate==-1? -num:num);
    }

    public static void main(String[] args) {
        String s = "  -0012a42";
        int ans = myAtoi(s,0,0,0);
        System.out.println(ans);
    }
}
