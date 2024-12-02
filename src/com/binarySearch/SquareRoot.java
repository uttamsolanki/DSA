package com.binarySearch;

public class SquareRoot {
    public static int solve(int n)
    {
        int low  = 1;
        int high = n;
        while (low<=high)
        {
            int mid = low + (high - low)/2;
            if(mid*mid<=n)
            {
                low = mid + 1;
            }else
            {
                high = mid - 1;
            }
        }
        return high;
    }
    public static void main(String[] args) {
        int ans =  solve(36);
        System.out.println(ans);
    }
}
