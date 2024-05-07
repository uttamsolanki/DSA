package com.DailyRandom;

import java.util.*;

public class LongestIdealString {

    public static int solve(String s, int k, int index, int prevChar,int[][] mm)
    {
        if(index>=s.length())
        {
            return 0;
        }
        if(prevChar!=-1 && mm[index][prevChar]!=-1)
        {
            return mm[index][prevChar];
        }

        int take = 0;

        if(prevChar==-1 || Math.abs(s.charAt(index) - 'a' - prevChar)<=k)
        {
            take = 1 + solve(s,k,index+1,s.charAt(index)-'a',mm);
        }

        int nottake =  solve(s,k,index+1,prevChar,mm);
        if(prevChar!=-1 )
        {
            return mm[index][prevChar] = Math.max(take,nottake);
        }
        return Math.max(take,nottake);

    }

    private static int helper(String s, int curr, int prev, int k, Map<String, Integer> dp) {
        if(curr>=s.length()) {
            return 0;
        }
        if(dp.containsKey(curr+","+prev)) {
            return dp.get(curr+","+prev);
        }

        int ans = 0;
        if(prev == -1 || Math.abs(s.charAt(curr)-s.charAt(prev))<=k) {
            ans = 1 + helper(s, curr+1, curr, k, dp);
        }
        ans = Math.max(ans, helper(s, curr+1, prev, k, dp));
        dp.put(curr+","+prev, ans);
        return ans;
    }
    public static int longestIdealString(String s, int k) {
        int n = s.length();
        // int[][] dp = new int[n+1][n+1];
        Map<String, Integer> dp = new HashMap<String, Integer>();
        // for(int i=0; i<dp.length; i++) {
        //     Arrays.fill(dp[i], -1);
        // }
        return helper(s, 0, -1,k, dp);
    }
    public static int longestIdealString1(String s, int k) {
        int[][] mm = new int[s.length()][26];
        for(int i=0;i<s.length();i++)
        {
            Arrays.fill(mm[i],-1);
        }
        return solve(s,k,0,-1,mm);
    }
    public static void main(String[] args) {
        String s = "dyyonfvzsretqxucmavxegvlnnjubqnwrhwikmnnrpzdovjxqdsatwzpdjdsneyqvtvorlwbkb";
        int k=7;

        int ans = longestIdealString(s,k);
        System.out.println(ans);
    }
}
