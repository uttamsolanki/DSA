package com.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class ReArrangeArray {


    //if +ve and -ve are equals
    public static int[] solution2(int[] nums)
    {
        int[] ans =  new int[nums.length];
        int k=0,l=1;
       for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>0)
            {
                ans[k] =nums[i];
                k+=2;
            }else
            {
                ans[l] =nums[i];
                l+=2;
            }

        }

        return ans;
    }
    public static int[] solution1(int[] nums)
    {
        ArrayList<Integer> pos =  new ArrayList<>();
        ArrayList<Integer> neg =  new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>0)
            {
                pos.add(nums[i]);
            }else
            {
                neg.add(nums[i]);
            }
        }

        int i=0;
        int[] ans =  new int[nums.length];
        while (i<pos.size() && i<neg.size())
        {
            ans[2*i] =pos.get(i);
            ans[2*i + 1] =neg.get(i);
            i++;
        }

        // We have filled with all equals number
        int k = Math.min(pos.size(),neg.size())*2;

        while (i<pos.size() )
        {
            ans[k++] =pos.get(i);
            i++;
        }

        while (i<neg.size())
        {
            ans[k++] =neg.get(i);
            i++;
        }


        return ans;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{3,1,-2,-5,2,-4};

        int[] ans = solution2(nums);
        System.out.println(Arrays.toString(ans));

    }
}
