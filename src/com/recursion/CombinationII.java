package com.recursion;

import java.util.*;

public class CombinationII {
    public  static void combinationWithoutHash(int i, ArrayList<Integer> list, int target, int [] arr, List<List<Integer>> result)
    {

        if(target==0) {
           // System.out.println(list);
            List<Integer> nList= new ArrayList < > (list);
            result.add(nList);
        }
        if(i>=arr.length)
        {
            return;
        }
        // int taken = -1; my logic
        for(int index=i;index<arr.length;index++) {

            // why index>i because we have to make comparison
            if(index>i && arr[index]==arr[index-1]) continue;

            if (arr[index] <= target) {
               // taken = arr[index]; -> my logic
                list.add(arr[index]);
                combinationWithoutHash(index + 1, list, target - arr[index], arr, result);
                list.remove(list.size() - 1);
            }
        }

    }
    public  static void combination(int i, ArrayList<Integer> list, int target, int [] arr, HashSet<List<Integer>> result)
    {
        if(i==arr.length)
        {
            if(target==0)
            {
                List<Integer> nList= new ArrayList < > (list);
               // System.out.println(list);
                if(!result.contains(nList))
                    result.add(nList);
            }
            return;
        }
        if(arr[i]<=target)
        {
            list.add(arr[i]);
            combination(i+1,list,target-arr[i],arr,result);
            list.remove(list.size()-1);
        }

        combination(i+1,list,target,arr,result);
    }
    public static void main(String[] args) {
        int[] arr =  new int[]{10,1,2,7,6,1,5};
        Arrays.sort(arr);
        int target = 8;
//        HashSet<List<Integer>> result  = new HashSet<>();
//        combination(0,new ArrayList<>(),target,arr,result);
//        for(List<Integer> l:result)
//        {
//           System.out.println(l.toString());
//        }


        List<List<Integer>> result  = new ArrayList<>();
        combinationWithoutHash(0,new ArrayList<>(),target,arr,result);
        for(List<Integer> l:result)
        {
            System.out.println(l.toString());
        }
    }
}
