package com.binarySearch;

public class CountOccurence {
    public static int lastOccernce(int x, int[] arr)
    {
        int n = arr.length;
        int ans = n;
        int low = 0;
        int high = n -1;

        while (low<=high)
        {
            int mid = (low + high)/2;

            if(arr[mid] == x)
            {
                ans =  mid;
                low = mid +1;
            }
            else if(x > arr[mid])
            {
                low =  mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }
        return ans;
    }

    public static int firstOccernce(int x, int[] arr)
    {
        int n = arr.length;
        int ans = -1;
        int low = 0;
        int high = n -1;

        while (low<=high)
        {
            int mid = (low +  high)/2;

            if(arr[mid] == x)
            {
                ans = mid;
                high = mid - 1;
            }
            else if(x > arr[mid])
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }

        return ans;
    }

    public static int solve(int x, int[] arr)
    {
        int first = firstOccernce(x, arr);
        int last =  lastOccernce(x, arr);
        if(first == -1)
        {
            return 0;
        }
        return last -first + 1;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{
               3 , 3 , 3 , 3 , 4
        };
        int x = 3;
        solve(x,arr);
    }
}
