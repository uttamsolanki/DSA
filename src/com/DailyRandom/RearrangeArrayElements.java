package com.DailyRandom;

import java.util.Arrays;

public class RearrangeArrayElements {


    public static int[] rearrangeArray(int[] nums) {


        int[] ans = new int[nums.length];
        int i=0;
        int j=1;
        int k=0;
        while (k<nums.length)
        {
            if(nums[k]>0)
            {
                ans[i] = nums[k++];
                i+=2;
            }
            else
            {
                ans[j] = nums[k++];
                j+=2;
            }


        }

        System.out.println(Arrays.toString(ans));
        return ans;

    }
    public static void main(String[] args) {
        int[] nums = new int[]{3,1,-2,-5,2,-4};
        rearrangeArray(nums);
    }
}
