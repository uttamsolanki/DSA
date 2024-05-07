package com.recursion;

public class Palindrome {
    public static boolean checkPalindrome(int i, String s)
    {
        int n = s.length();
        int j = n-i-1;
        if(i>j) return true;
        if(s.charAt(i)!=s.charAt(j))
        {
            return false;
        }

        return checkPalindrome(i+1,s);
    }
    public static void main(String[] args) {
        System.out.println(checkPalindrome(0,"ABCBA"));
    }
}
