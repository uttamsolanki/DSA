package track.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class PythagoareanTriplet {
    //Brute force Approach
    public static boolean approach1(int[] arr) {
        int  n = arr.length;

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==j) continue;

                for(int k=0;k<n;k++)
                {
                    if(k==i || k==j) continue;

                    if((arr[i]*arr[i])+ (arr[j]*arr[j])==(arr[k]*arr[k]))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    // Using HashMap, lookup third element
    public static boolean approach2(int[] arr) {
        int n = arr.length;
        HashMap<Integer,HashSet<Integer>> map = new HashMap<>();

        for(int i=0;i<n;i++)
        {
            int key =  arr[i]*arr[i];
            HashSet<Integer> set = new HashSet<>();
            if(map.containsKey(key))
            {
               set = map.get(key);
            }
            set.add(i);
            map.put(key,set);
        }
        for(int i=0;i<n;i++) {
            for (int j = 0; j < n; j++) {
                int total = (arr[i]*arr[i])+ (arr[j]*arr[j]);
                if(map.containsKey(total))
                {
                    if(!map.get(total).contains(i) && ! map.get(total).contains(j))
                    {
                        return  true;
                    }
                }
            }
        }
        return false;
    }

    public static int approach3(int[] arr)
    {
        int n = arr.length;
        Arrays.sort(arr);

        return 0;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 4, 6, 5};

        boolean ans = approach2(arr);
        System.out.println(ans);
    }
}
