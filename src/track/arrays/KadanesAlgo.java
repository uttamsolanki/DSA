package track.arrays;

/**
 * problem: Given an integer array arr[]. You need to find the maximum sum of a subarray.
 * Link : https://www.geeksforgeeks.org/problems/kadanes-algorithm-1587115620/1
 */
public class KadanesAlgo {
    public static int maxSubarraySum(int[] arr) {
        int sum = 0;
        int maxSum = arr[0];
        for(int i=0;i<arr.length;i++)
        {
            sum+=arr[i];
            maxSum = Math.max(sum,maxSum);

            if(sum<0)
            {
               sum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, -8, 7, -1, 2, 3};

        int ans = maxSubarraySum(arr);
        System.out.println(ans);
    }
}
