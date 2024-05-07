package com.recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationI {


    public  static void combination(int i, ArrayList<Integer> list, int target,int [] arr, List<List<Integer>> result)
    {
        if(i==arr.length)
        {
            if(target==0)
            {
                result.add(new ArrayList < > (list));
            }
            return;
        }
        if(arr[i]<=target)
        {
            list.add(arr[i]);
            combination(i,list,target-arr[i],arr,result);
            list.remove(list.size()-1);
        }

        combination(i+1,list,target,arr,result);
    }
    public static void main(String[] args) {
        int[] arr =  new int[]{2,3,6,7};
        int target = 7;
        List<List<Integer>> result  = new ArrayList<>();
        combination(0,new ArrayList<>(),target,arr,result);
        for(int i=0;i<result.size();i++)
        {
            System.out.println(result.get(i).toString());
        }
    }
}
