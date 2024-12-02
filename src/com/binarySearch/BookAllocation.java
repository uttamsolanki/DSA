package com.binarySearch;

public class BookAllocation {

    public static int countBookAllocation(int[] arr,int page)
    {
        int noOfStudent = 1;
        int currCount = 0;
        for(int i=0;i<arr.length;i++)
        {
            if(currCount + arr[i]<=page)
            {
                currCount +=arr[i];
            }
            else
            {
                noOfStudent ++;
                currCount =  arr[i];
            }
        }
        return noOfStudent;
    }
    public static int approach1(int[] arr, int m) {
        if(m>arr.length) return  -1;
        // if we allocate each book to each student then ans would be max(arr)
        // if we allocate all books to one student then ans would be sum(arr)
        int max = 0;
        int sum = 0;
        for(int i=0;i<arr.length;i++)
        {
            max = Math.max(max,arr[i]);
            sum += arr[i];
        }

        System.out.println(max);
        System.out.println(sum);
        int low = max;
        int high = sum;
        while (low<=high)
        {
            int mid = low + (high - low)/2;
            int noOfstudent = countBookAllocation(arr,mid);
            if(noOfstudent<=m)
            {
                high = mid -1;
            }else
            {
                low =  mid + 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{
                25, 46, 28, 49, 24
        };
        int m = 4;
        int ans = approach1(arr, m);
        System.out.println(ans);
    }
}
