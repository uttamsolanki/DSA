package track.arrays;

import java.util.Arrays;

/**
 * Problem : Given an array arr of distinct elements, the task is to rearrange the elements of the array in a zig-zag fashion so that the converted array should be in the below form:
 * arr[0] < arr[1]  > arr[2] < arr[3] > arr[4] < . . . . arr[n-2] < arr[n-1] > arr[n].
 * Note: Modify the given arr[] only, If your transformation is correct, the output will be "true" else the output will be "false".
 * Link : https://www.geeksforgeeks.org/problems/convert-array-into-zig-zag-fashion1638/1
 */
public class ConvertToZigZag {
    public static void swap(int[] arr, int i,int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void approach1(int[] arr) {
        int n = arr.length;
        for(int i=1;i<n;i++)
        {
            if(i%2==1)
            {
                if(arr[i-1]>arr[i])
                {
                    swap(arr,i-1,i);
                }
            }
            else
            {
                if(arr[i-1]<arr[i])
                {
                    swap(arr,i-1,i);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{
                1,2,3,4,5,6,7
        };
        approach1(arr);
        System.out.println(Arrays.toString(arr));
    }
}
