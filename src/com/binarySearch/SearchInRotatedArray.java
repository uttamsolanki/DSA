package com.binarySearch;

public class SearchInRotatedArray {

    //Without duplicate
    public static  int solve(int x, int[] arr)
    {
        int low = 0;
        int high = arr.length-1;

        while (low<=high)
        {
            int mid =  (low + high) / 2;

            if(arr[mid] == x)
            {
                return mid;
            }
            if(arr[low]<=arr[mid])
            {
                if(arr[low]<= x && x <=arr[mid])
                {
                    high =  mid - 1;
                }
                else
                {
                    low =  mid + 1;
                }
            }else
            {
                if(arr[mid] <= x && x <= arr[high])
                {
                    low = mid + 1;
                }
                else
                {
                    high =  mid - 1;
                }
            }
        }

        return -1;
    }

    //when array has some duplicate value
    public static boolean solve2(int x, int[] arr)
    {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high)
        {
            int mid =  (low + high) /2;
            if(arr[mid] == x)
            {
                return true;
            }
            if(arr[low]==arr[mid] && arr[mid]==arr[high])
            {
                low++;
                high --;

                continue;
            }

            if(arr[low]<=arr[mid])
            {
                if(arr[low]<=x && x <=arr[mid])
                {
                    high = mid - 1;
                }
                else
                {
                    low =  mid + 1;
                }
            }
            else
            {
                if(arr[mid]<=x && x<=arr[high])
                {
                    low =  mid +1;
                }
                else
                {
                    high = mid - 1;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{
                7, 8, 1, 2, 3, 3, 3, 4, 5, 6
        };
        int x = 10;
        //int ans =  solve(x,arr);
        boolean ans =  solve2(x,arr);
        System.out.println(ans);

    }
}
