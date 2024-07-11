package com.DailyRandom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MinimumAbsDifference {


    // Using HashSet
    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;

        HashMap<Integer,List<List<Integer>>> map = new HashMap<>();

        for(int i=1;i<arr.length;i++)
        {
            int diff = Math.abs(arr[i-1] - arr[i]);
            List<List<Integer>> ans;
            if(map.containsKey(diff))
            {
                ans = map.get(diff);

            }else
            {
                ans = new ArrayList<>();
            }
            min = Math.min(min,diff);
            ans.add(Arrays.asList(arr[i-1] , arr[i]));
            map.put(diff,ans);
        }

        return map.get(min);
    }

    //Without hashset
    public static List<List<Integer>> minimumAbsDifference1(int[] arr) {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=1;i<arr.length;i++)
        {
            int diff = Math.abs(arr[i-1] - arr[i]);

            if(min>diff)
            {
                min = diff;
                ans.clear();
                ans.add(Arrays.asList(arr[i-1] , arr[i]));
            }
            else if(diff==min)
            {
                ans.add(Arrays.asList(arr[i-1] , arr[i]));
            }

        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,8,-10,23,19,-4,-14,27};
        List<List<Integer>> ans = minimumAbsDifference1(arr);

        for (int i=0;i<ans.size();i++)
        {
            System.out.println(ans.get(i));
        }
    }
}
