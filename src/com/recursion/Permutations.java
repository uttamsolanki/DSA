package com.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Permutations {

    public static void swap(int[] nums,int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] =temp;
    }
    public static void permutation2(int[] nums, int i, List<List<Integer>> result)
    {
        if(i == nums.length)
        {
            List<Integer> items = new ArrayList<>();
            for (Integer item: nums) {
                items.add(item);
            }
            result.add(items);
            return;
        }

        for(int index=i;index<nums.length;index++)
        {
            swap(nums,i,index);
            permutation2(nums,i+1,result);
            swap(nums,i,index);
        }
    }
    public static void permutation(int[] nums, HashSet<Integer> set, List<Integer> list, List<List<Integer>> result)
    {
       // System.out.println(list);
        if(list.size() == nums.length)
        {

            result.add(new ArrayList<>(list));
            return;
        }
        for(int index=0;index<nums.length;index++)
        {
            if(set.contains(index)) continue;
            set.add(index);
            list.add(nums[index]);
            permutation(nums,set,list,result);
            set.remove(index);
            list.remove(list.size()-1);
        }

    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        List<List<Integer>> result = new ArrayList<>();
        //permutation(arr,new HashSet<>(),new ArrayList<>(),result);

        permutation2(arr,0,result);

        for(List<Integer> l:result)
        {
            System.out.println(l.toString());
        }
    }
}
