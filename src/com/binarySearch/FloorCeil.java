package com.binarySearch;

public class FloorCeil {

    public static int ceiling(int x, int[] arr)
    {
        int n = arr.length;
        int low = 0;
        int high = n-1;
        int ans = n;

        while (low<=high)
        {
            int mid = (low + high)/2;
            if(x<=arr[mid])
            {
                ans = arr[mid];
                high = mid - 1 ;
            }
            else
            {
                low = mid + 1;
            }
        }

        return ans;
    }

    public static int floor(int x, int[] arr)
    {
        int n = arr.length;
        int low = 0;
        int high = n-1;
        int ans = -1;

        while (low<=high)
        {
            int mid = (low + high)/2;
            if(x>=arr[mid])
            {
                ans = arr[mid];
                low = mid + 1;
            }
            else
            {
                high = mid - 1 ;

            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{
                3, 4, 4, 7, 8, 10
        };
        int x = 8;
        int ceill = ceiling(x,arr);
        System.out.println(ceill);

        int floor = floor(x,arr);
        System.out.println(floor);
    }
}
