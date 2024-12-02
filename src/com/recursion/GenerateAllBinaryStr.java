/**
 * Poblems: Generate all the strings of n bits. Assume A[0..n – 1] is an array of size n.
 * Similar Question: https://www.geeksforgeeks.org/problems/generate-all-binary-string
 */


package com.recursion;
import java.util.*;
public class GenerateAllBinaryStr {

    public static void generatePairs(char[] ch,List<String> list,int index, int N)
    {
        if(index==N)
        {
            list.add(String.valueOf(ch));
            return;
        }


        if(ch[index-1]=='0')
        {
            ch[index] = '0';
            generatePairs(ch,list,index+1,N);

            ch[index] = '1';
            generatePairs(ch,list,index+1,N);
        }
        if(ch[index-1]=='1')
        {
            ch[index] = '0';
            generatePairs(ch,list,index+1,N);
        }
    }

    public static List< String > generateString(int N) {
        // Write your code here.

        List<String> list = new ArrayList<>();

        if(N<=0)
        {
            return list;
        }

        char[] ch = new char[N];

        ch[0] = '0';
        generatePairs(ch,list,1, N);

        ch[0] = '1';
        generatePairs(ch,list,1, N);
        return list;
    }

    public static void solve(String s,int n, List<String> list)
    {
        if(s.length()==n)
        {
            list.add(s);
            return;
        }
        solve(s+'0',n,list);
        // When consecutive 1 is not required
        if(s.length() ==0 || (s.length()>0 && s.charAt(s.length()-1) != '1'))
        solve(s+'1',n,list);
    }
    public static List<String> generateBinaryStrings(int n) {
        // code here
        List<String> list =  new ArrayList<>();
        solve("",n,list);

        return list;
    }

    public static void main(String[] args) {
        generateBinaryStrings(3);
      //  System.out.println(ans);
    }
}
