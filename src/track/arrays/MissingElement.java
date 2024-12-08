package track.arrays;

import java.util.Arrays;

/**
 * Problem : You are given an array arr of size n - 1 that contains distinct integers in the range from 1 to n (inclusive).
 * This array represents a permutation of the integers from 1 to n with one element missing. Your task is to identify and return the missing element.
 * Link: https://www.geeksforgeeks.org/problems/missing-number-in-array1416/1
 */
public class MissingElement {

    // Using for loop, match index with value
    // if array is  not sorted then sort it
    public static int approach1(int[] arr) {
        Arrays.sort(arr);
        for(int i=1;i<=arr.length;i++)
        {
            if(i!=arr[i-1])
            {
                return i;
            }
        }
        return 0;
    }

    // Using sum
    public  static int approach2(int[] arr)
    {
        int n = arr.length;
        // Get sum of all elements
        long sum = 0;
        for(int i=0;i<n;i++)
        {
            sum += arr[i];
        }
        // total number including missing
        n += 1;
        // if we have n number then total sum of number is n*(n+1)/2
        long nSum = n*(n+1)/2;
        return (int)(nSum - sum);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 5};
        int ans = approach2(arr);
        System.out.println(ans);
    }
}
