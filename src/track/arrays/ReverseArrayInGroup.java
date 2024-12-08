package track.arrays;

import java.util.ArrayList;

/**
 * Problem: Given an array arr of positive integers. Reverse every sub-array group of size k.
 * Note: If at any instance, k is greater or equal to the array size, then reverse the entire array.
 * You shouldn't return any array, modify the given array in place.
 * Link: https://www.geeksforgeeks.org/problems/reverse-array-in-groups0255/1
 */
public class ReverseArrayInGroup {
    public static  void reverse(ArrayList<Long> arr, int i , int j)
    {
        while (i<j)
        {
            long temp = arr.get(i);
            arr.set(i,arr.get(j));
            arr.set(j,temp);
            i++;
            j--;
        }
    }
    public static void approach1(ArrayList<Long> arr, int k) {
        int n=arr.size();
        if(k<n)
        {
            int i=0;
            int j = k;
            while (j<n)
            {
                reverse(arr,i,j-1);
                i=j;
                j+=k;
            }
            reverse(arr,i,n-1);
        }
        else
        {
            reverse(arr,0,n-1);
        }

    }

    public static void main(String[] args) {
        ArrayList<Long> arr = new ArrayList<>();
        arr.add((long) 1);
        arr.add((long) 2);
        arr.add((long) 3);
        arr.add((long) 4);
        arr.add((long) 5);
        approach1(arr,5);
        System.out.println(arr);
       // 13
        //36 93 64 48 96 55 70 0 82 30 16 22 38 53 19 50 91 43 70 88 10 57 14 94 13 36 59 32 54 58 18 82 67
    }
}
