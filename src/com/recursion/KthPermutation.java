package com.recursion;

import java.util.ArrayList;
import java.util.List;

public class KthPermutation {

    public static String getPermutation(int n, int k) {

        int fact = 1;
        List<Integer> number = new ArrayList<>();
        for(int i=1;i<=n;i++)
        {
            fact = fact*i;
            number.add(i);
        }
        String ans ="";
        k--;
        while (true)
        {
            // N number means 1...n  can have first place
            // So each possibility can have n!/n;
            fact = fact/number.size();

            int nIndex = k/fact;
            ans = ans + number.get(nIndex);
            number.remove(nIndex);
            k = k%fact;
            if(number.size()==0)
            {
                break;
            }

        }
        System.out.println(ans);
        return ans;
    }

    public static void main(String[] args) {
        getPermutation(4,9);
    }
}
