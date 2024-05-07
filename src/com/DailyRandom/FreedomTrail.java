package com.DailyRandom;

import java.util.ArrayList;
import java.util.List;

public class FreedomTrail {

    public static int solve(int rIndex, int kIndex, String key, char[] ring,ArrayList<Integer>[] pos)
    {
        if(kIndex>=key.length()) return 0;


        int ans = Integer.MAX_VALUE;

        for(int p:pos[key.charAt(kIndex)-'a'])
        {
            int tempMin;
                if(p>=rIndex)
                {
                    tempMin = Math.min(p-rIndex,ring.length+rIndex-p);
                }
        }

        return 0;
    }
    public static int findRotateSteps(String ring, String key) {
        char[] charArr = ring.toCharArray();
        List<Integer>[] pos = new List[26];
        for(int i=0;i<ring.length();i++)
        {
            int currCh = charArr[i] - 'a';
            if(pos[currCh]==null)
            {
                pos[currCh] = new ArrayList<>();

            }
            pos[currCh].add(i);
        }

        return 0;
        //return solve(0,key,charArr);
    }
    public static void main(String[] args) {
        int ans = findRotateSteps("godding", "godding");
        System.out.println(ans);
    }
}
