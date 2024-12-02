package com.binarySearch;

public class LastOccurance {

    public static  int FirstOccurrence(int x, int[] arr)
    {
        int ans = -1;
        int n =  arr.length;
        int low = 0;
        int high = n-1;

        while (low<=high)
        {
            int mid =  (low + high)/2;
            if(arr[mid] == x)
            {
                ans = mid;
                high =  mid - 1;
            }
            else if(arr[mid] < x)
            {
                low =  mid + 1;
            }
            else
            {
                high  =  mid - 1 ;
            }
        }
        return ans;
    }
    public static  int LastOccurrence(int x, int[] arr)
    {
        int ans = -1;
        int n =  arr.length;
        int low = 0;
        int high = n-1;

        while (low<=high)
        {
            int mid =  (low + high)/2;
            if(arr[mid] == x)
            {
                ans = mid;
                low =  mid + 1;
            }
            else if(arr[mid] < x)
            {
                low =  mid + 1;
            }
            else
            {
                high  =  mid - 1 ;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{
                3,4,13,13,13,20,40
        };
        int x = 13;

        int first =  FirstOccurrence(x,arr);
        System.out.println(first);

        int last =  LastOccurrence(x,arr);
        System.out.println(last);

    }
}
