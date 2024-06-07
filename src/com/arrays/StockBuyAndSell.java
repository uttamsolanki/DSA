package com.arrays;

public class StockBuyAndSell {

    public static int solution2(int[] nums)
    {
        int n = nums.length;
        int maxProfit = Integer.MIN_VALUE;
        int min = nums[0];

        for(int i=0;i<n;i++)
        {
             min =  Math.min(min,nums[i]);
            maxProfit = Math.max(maxProfit,nums[i]-min);
        }
        return maxProfit;
    }
    public static int solution1(int[] nums)
    {
        int n=nums.length;
        int profit = Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            for(int j=i;j<n;j++)
            {
                profit = Math.max(nums[j]-nums[i],profit);
            }
        }
        return profit;
    }
    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(solution2(prices));
    }
}
