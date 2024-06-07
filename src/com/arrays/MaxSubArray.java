package com.arrays;

public class MaxSubArray {
    public static int followUP(int[] nums)
    {
        int n = nums.length;
        int sum = 0,max=Integer.MIN_VALUE;

        int ansStart,ansEnd,start;
        start = ansStart = ansEnd = -1;

        for(int i=0;i<n;i++)
        {

            if(sum == 0)
            {
                start = i;
            }
            sum += nums[i];

            if(max<sum)
            {
                max = sum;
                ansStart = start;
                ansEnd = i;
            }

            if(sum<0)
            {
                sum=0;
            }
        }

        System.out.println(ansStart+"  ----  "+ansEnd);
        return max;
    }
    public static int solution2(int[] nums)
    {
        int n = nums.length;
        int sum = 0,max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            sum += nums[i];

            if(max<sum)
            {
                max = sum;
            }

            if(sum<0)
            {
                sum=0;
            }
        }
        return max;
    }


    public static int solution1(int[] nums)
    {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            int sum = 0;
            for(int j=i;j<n;j++)
            {
                sum += nums[j];
                max = Math.max(sum,max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};

        System.out.println(followUP(nums));
    }

}
