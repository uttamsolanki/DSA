package com.arrays;

public class ThreeSumMulti {
    public static int approach1(int[] arr, int target) {


        int count = 0;
        int mod = 1000_000_007;

        int n =  arr.length;
        for(int i=0;i<n-2;i++)
        {
            int j = i+1;
            int k = n-1;
            int T = target - arr[i];
            while(j<k)
            {
                int currSum = arr[j] + arr[k];
                if(T == currSum)
                {
                    if(arr[j]==arr[k])
                    {
                        int w= k-j;
                        count =  (count + (( w * (w+1)/2 ) % mod) ) % mod;
                        break;
                    }
                    else
                    {
                        int l=1,r=1;
                        while (j+1<k && arr[j] == arr[j+1])
                        {
                            j++;
                            l++;
                        }

                        while (k-1>=j && arr[k] == arr[k-1])
                        {
                            k--;
                            r++;
                        }
                        count += (l*r) % mod;
                        j++;
                        k--;
                    }

                }else if(currSum<T)
                {
                    j++;
                }else
                {
                    k--;
                }
            }
        }
        return count;


    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2,2,2,2};
        int target = 5;
        int ans = approach1(arr,target);
        System.out.println(ans);
    }
}
