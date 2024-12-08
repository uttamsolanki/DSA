package track.arrays;

import java.util.Arrays;

public class ReArrangeArray {
    public static void approach1(int[] arr) {

        int n = arr.length;
        if(n <= 1)
        {
            return;
        }
        int minVal = arr[0];
        int maxValue = arr[n-1];
        for(int i=0;i<n;i++)
        {
            if(i%2==0)
            {
                maxValue^=arr[i];
                arr[i]^=maxValue;
                maxValue^=arr[i];
            }
            else
            {
                minVal^=arr[i];
                arr[i]^=minVal;
                minVal^=arr[i];
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6};
        approach1(arr);
        System.out.println(Arrays.toString(arr));
    }
}
