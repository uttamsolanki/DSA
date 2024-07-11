package com.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class _3sum {
    public static void Approach1(int[] nums) {
        HashSet<List<Integer>> set = new HashSet<>();
        int n = nums.length;
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                for(int k=j+1;k<n;k++)
                {
                    if(nums[i]+nums[j]+nums[k] == 0)
                    {
                        List<Integer> triplet =  new ArrayList<>();
                        triplet.add(nums[i]);
                        triplet.add(nums[j]);
                        triplet.add(nums[k]);
                        triplet.sort(null);
                        set.add(triplet);
                    }
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>(set);
        for(int i=0;i<ans.size();i++)
        {
            System.out.println(ans.get(i));
        }

    }

    public static void Approach2(int[] nums) {

        HashSet<List<Integer>> set = new HashSet<>();
        int n = nums.length;
        for(int i=0;i<n;i++)
        {
            // this will store value between 1 and j
            // we will check k value between i and j
            // in previous we were checking K from j+1 to n
            HashSet<Integer> inner = new HashSet<>();
            for(int j=i+1;j<n;j++)
            {
                    int third = -(nums[i]+nums[j]);
                    if(inner.contains(third))
                    {
                        List<Integer> triplet =  new ArrayList<>();
                        triplet.add(nums[i]);
                        triplet.add(nums[j]);
                        triplet.add(third);
                        triplet.sort(null);
                        set.add(triplet);
                    }
                    inner.add(nums[j]);
            }
        }

        List<List<Integer>> ans = new ArrayList<>(set);
        for(int i=0;i<ans.size();i++)
        {
            System.out.println(ans.get(i));
        }

    }

    public static void Approach3(int[] nums)
    {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            //skip duplicate
            if(i!=0 && nums[i-1]==nums[i]) continue;

            int j = i+1;
            int k = nums.length-1;

            while (j<k)
            {
                int sum = nums[i] + nums[j] + nums[k];

                if(sum<0)
                {
                    j++;
                }
                else if(sum>0)
                {
                    k--;
                }else
                {
                    List<Integer> triplet =  new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(nums[k]);
                    ans.add(triplet);

                    j++;
                    k--;

                    //skip duplicate
                    while (j<k && nums[j-1] == nums[j]) j++;
                    while (j<k && nums[k] == nums[k+1]) k--;
                }
            }
        }

        for(int i=0;i<ans.size();i++)
        {
            System.out.println(ans.get(i));
        }
    }
    public static void main(String[] args) {
        int[] nums =  new int[]{
                -1,0,1,2,-1,-4
        };

        //Approach1(nums);
        //Approach2(nums);
        Approach3(nums);
    }
}
