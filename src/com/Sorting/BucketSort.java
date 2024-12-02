package com.Sorting;

import java.util.*;

public class BucketSort {

    public static void sort(int[] nums,int K) {
        // k => Bucket numbers
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        // No . of bucket
        List<Integer>[] buckets = new ArrayList[K];

        for (int i = 0; i < K; i++) {
            buckets[i] = new ArrayList<>();
        }

        for(int i=0;i<nums.length;i++)
        {
            max = Math.max(nums[i],max);
            min = Math.min(nums[i],min);
        }

        max =  max-min;
        // Bucket Size, it should be double so we get exact index value
        double size = (double) max/K;

        if(size<1)
        {
            size =1;
        }
        // Place item into bucket
        for(int ele:nums)
        {
            int index = (int) ((int) (ele-min)/ size);

            if(index==K)
            {
                buckets[K-1].add(ele);
            }else
            {
                buckets[index].add(ele);
            }
        }

        // Sort each bucket
        for(int i=0;i<K;i++)
        {
            Collections.sort(buckets[i]);
        }

        // Merge sorted bucket
        List<Integer> sortedList =  new ArrayList<>();
        for(List<Integer> bucket:buckets)
        {
            sortedList.addAll(bucket);
        }
        // Replace original array with sorted element
        for(int i=0;i<nums.length;i++)
        {
            nums[i] = sortedList.get(i);
        }

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        sort(nums,2);
        System.out.println(Arrays.toString(nums));
    }
}
