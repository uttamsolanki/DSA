/**
 * Problem: Generate all the strings of length n drawn from 0... k – 1
 * Similar :
 * 1. Print all possible strings of length k that can be formed from a set of n characters
 */

package com.recursion;

import java.util.Arrays;

public class GenerateStringWithLength {
    public static void generateStringWithLengthN(int n, int k, int[] s) {
        if(n<1)
        {
            System.out.println(Arrays.toString(s));
            return;
        }
        for(int i=0;i<k;i++)
        {
            s[n-1] = i;
            generateStringWithLengthN(n-1,k,s);
        }
    }
    // T(N) =  kT(n-1) + d => O(k^n)

    public static void generateStringWithLengthKFromSet(char[] set, int k, String s) {
        if(k<1)
        {
            System.out.println(s);
            return;
        }
        for(int i=0;i<set.length;i++)
        {
            generateStringWithLengthKFromSet(set,k-1,s+set[i]);
        }

    }
    // T(N) =  (set length(k) )T(n-1) + d => O(k^n)

    public static void main(String[] args) {

        int n=3;
        int k=2;
        int[] arr =  new int[n];
        generateStringWithLengthN(n,k,arr);


//        char[] set  = new char[]{'a','b'};
//        int k = 3;
//        generateStringWithLengthKFromSet(set,k,"");

    }
}
