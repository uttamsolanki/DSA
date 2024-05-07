package com.recursion;

import java.util.ArrayList;

public class SubSequenceSumK {

    // count the number of sub sequence

    public static  int countSub(int[] arr, int sum , int i, int n, int k)
    {
        if(i==n)
        {
            if(sum==k) {
                return 1;
            }
            return 0;
        }

        return countSub(arr,sum,i+1,n,k) + countSub(arr,sum+arr[i],i+1,n,k);
    }
    // This is printing only one subsequence
    public static  boolean sumk2(int[] arr, int sum, int k, int i, ArrayList<Integer> list, int n)
    {
        //if(i>=arr.length || sum>k) return;
        if(i==n)
        {
            if(sum==k)
            {
                System.out.println(list.toString());
                return true;
            }
            return false;
        }

        sum += arr[i];
        list.add(arr[i]);
        if(sumk2(arr,sum,k,i+1,list,n)== true) return true;
        list.remove(list.size()-1);
        sum-=arr[i];
        if(sumk2(arr,sum,k,i+1,list,n) == true) return  true;
        return false;

    }
    // This condition for printing all sub sequences
    public static  void sumk(int[] arr, int sum, int k, int i, ArrayList<Integer> list, int n)
    {
        if(i==n)
        {
            if(sum==k)
            {
                System.out.println(list.toString());
            }
            return;
        }

        sum += arr[i];
        list.add(arr[i]);
        sumk(arr,sum,k,i+1,list,n);
        list.remove(list.size()-1);
        sum-=arr[i];
        sumk(arr,sum,k,i+1,list,n);

    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,1};
      //  sumk(arr,0,2,0,new ArrayList<>(),3);
        System.out.println(countSub(arr,0,0,3,2));
    }
}
