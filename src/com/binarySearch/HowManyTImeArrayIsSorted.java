package com.binarySearch;

public class HowManyTImeArrayIsSorted {
    public static int solve(int[] arr)
    {
        int low = 0;
        int high = arr.length - 1;
        int ans = Integer.MAX_VALUE;
        int index = 0;
        while (low<high)
        {
            int mid = (low + high)/2;

            if(arr[low]<arr[high])
            {
                if(arr[low]<ans)
                {
                    index = low;
                }
                break;
            }

            if(arr[low]<arr[mid])
            {
                if(arr[low]<ans)
                {
                    index = low;
                    ans = arr[low];
                }
                low = mid +1;
            }else
            {
                if(arr[mid]<ans)
                {
                    index = mid;
                    ans = arr[mid];
                }
                high = mid - 1;
            }
        }
        return index;
    }
    public static void main(String[] args) {
        int[] arr =  new int[]{
                3,4,5,1,2
        };

        int ans  = solve(arr);
        System.out.println(ans);
    }
}
