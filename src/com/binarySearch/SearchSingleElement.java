package com.binarySearch;

public class SearchSingleElement {

    //Approach - 1 : Using for loop
    //Approach - 2 : HashSet
    //Approach - 3 : XOR
    //Approach - 4
    public static int solve1(int[] arr)
    {
        int n = arr.length;
        int low = 1;
        int high = n - 2;

        if(arr.length == 1 )
        {
            return arr[0];
        }
        if(arr[0]!=arr[1])
        {
            return arr[0];
        }
        if(arr[n-1]!=arr[n-2])
        {
            return arr[n-1];
        }
        while (low<=high)
        {
            int mid  =  (low + high) / 2 ;

            if(arr[mid] != arr[mid+1] && arr[mid] != arr[mid-1])
            {
                return arr[mid];
            }
            //even
            if((mid % 2 == 0 && arr[mid] == arr[mid+1]) || (mid % 2 == 1 && arr[mid] == arr[mid-1]) )
            {
                low =  mid +1;
            }
            else
            {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{
                1,1,2,2,3,3,4,5,5,6,6
        };
        int ans = solve1(arr);
        System.out.println(ans);
    }
}
