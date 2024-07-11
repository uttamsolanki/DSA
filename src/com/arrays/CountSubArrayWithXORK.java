package com.arrays;

import java.util.HashMap;

public class CountSubArrayWithXORK {

    public static int Approach1(int[] nums,int k)
    {
        int n =  nums.length;
        int cnt =0;
        for(int i=0;i<n;i++)
        {
            int xor = 0;
            for(int j=i;j<n;j++)
            {
                xor^=nums[j];
                if(xor==k)
                {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public static int Approach2(int[] nums, int k)
    {
        int cnt =0;
        int n= nums.length;

        int xor = 0;
        HashMap<Integer,Integer> map =  new HashMap<>();
        map.put(0,1);
        for(int i=0;i<n;i++)
        {
            xor^=nums[i];

            int remainPart = xor^k;

            if(map.containsKey(remainPart))
            {
                cnt+=map.get(remainPart);
            }

            map.put(xor,map.getOrDefault(xor,0)+1);

        }
        return cnt;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{
                4, 2, 2, 6, 4
        };

        int ans = Approach2(nums,6);

        System.out.println(ans);
    }
}
