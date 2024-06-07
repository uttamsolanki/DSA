package com.arrays;

import java.util.HashMap;
import java.util.Map;

public class MajorityElementNby2 {

    public static void approach2(int[] arr, int n)
    {
        int cnt = 0;
        int el = 0;

        for(int i=0;i<n;i++)
        {
            if(cnt==0)
            {
                cnt = 1;
                el = arr[i];
            }else if(el == arr[i])
            {
                    cnt++;
            }else
            {
                cnt--;
            }
        }

        int ncnt = 0;

        for(int i=0;i<n;i++)
        {
            if(arr[i] == el)
            {
                ncnt++;
            }
        }
        if(ncnt>n/2)
        {
            System.out.println(el);
        }
    }
    public static void approach1(int[] arr,int n)
    {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }

        for(Map.Entry<Integer,Integer> item:map.entrySet())
        {
            int numberItem = item.getValue();
            if(numberItem>n/2)
            {
                System.out.println(item.getKey());
            }

        }
    }
    public static void main(String[] args) {
        int n=10;
        int[] arr = new int[]{4,4,2,4,3,4,4,3,2,4};
        //approach1(arr,n);
        approach2(arr,n);
    }
}
