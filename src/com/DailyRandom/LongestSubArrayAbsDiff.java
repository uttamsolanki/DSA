package com.DailyRandom;

import java.util.Comparator;
import java.util.PriorityQueue;
// DO AGAIN
public class LongestSubArrayAbsDiff {

    static class Pair{
        int value;
        int index;

       Pair(int a, int b){
           this.value = a;
           this.index = b;
       }

    }
    public static int longestSubarray(int[] nums,int limit)
    {
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((Pair a, Pair b)-> b.value-a.value);
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(Comparator.comparingInt((Pair a) -> a.value));

        int n = nums.length, left=0;

        int maxLength = 0;

        for(int right =0;right<n;++right)
        {
            maxHeap.add(new Pair(nums[right],right));
            minHeap.add(new Pair(nums[right],right));


            while (maxHeap.peek().value - minHeap.peek().value > limit)
            {
               left = Math.min(minHeap.peek().index,maxHeap.peek().index) +1;

               while (maxHeap.peek().index<left)
               {
                   maxHeap.poll();
               }

                while (minHeap.peek().index<left)
                {
                    minHeap.poll();
                }

            }

            maxLength = Math.max(maxLength,right-left);

        }
       // maxLength = Math.max(maxLength,right-left);
        return maxLength;
    }
    public static void main(String[] args) {
        int[] nums =  new int[]{
                10,1,2,4,7,2
        };
        int limit = 5;
        System.out.println(longestSubarray(nums,limit));
    }
}
