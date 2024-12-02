package com.bitmanipulate;

public class MajorityElement {
    public static int approach1(int[] arr) {

        int n=arr.length;
        int ans = 0;
        for(int bit=0;bit<32;bit++)
        {
            int count = 0;
            for(int num:arr)
            {
                if((num & (1<<bit))!=0)
                {
                    count++;
                }
            }
            if(count>n/2)
            {
                ans = ans | (1<<bit);
            }
        }
        return ans;
    }
    //Other Approach is using moore voting algorithm


    public static void main(String[] args) {
        int[] arr = new int[]{
                2,2,1,1,1,2,2
        };
        int ans = approach1(arr);
        System.out.println(ans);
    }
}
