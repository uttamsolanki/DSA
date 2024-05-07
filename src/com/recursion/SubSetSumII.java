package com.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetSumII {
    public static void subsetsWith(int[] nums, int i,List<Integer> list,List<List<Integer>> result ) {
        List<Integer> nlist = new ArrayList<>(list);
        result.add(nlist);
        if(i>=nums.length)
        {
            return;
        }
        for(int index=i;index<nums.length;index++)
        {
            if(index>i && nums[index-1]==nums[index]) continue;
            list.add(nums[index]);
            subsetsWith(nums,index+1,list,result);
            list.remove(list.size()-1);
        }

    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,2};
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        subsetsWith(arr,0,new ArrayList<>(),result);
        for(List<Integer> ls:result)
        {
            System.out.println(ls.toString());
        }
    }
}
