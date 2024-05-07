package com.recursion;

import java.util.ArrayList;
import java.util.Collections;

public class SubSetSumI {
    public static  void subSetSum(ArrayList<Integer> arr, int i, int sum, ArrayList<Integer> list,ArrayList<Integer> result)
    {
            if(i==arr.size())
            {
                result.add(sum);
                return;
            }
            int item = arr.get(i);
              sum += item;
              list.add(item);
              subSetSum(arr,i+1,sum,list,result);
              sum -= item;
              list.remove(list.size()-1);

            subSetSum(arr,i+1,sum,list,result);
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(3);
        arr.add(1);
        arr.add(2);
        ArrayList<Integer> ans = new ArrayList<>();

        subSetSum(arr,0,0, new ArrayList<>(), ans);
        Collections.sort(ans);
        System.out.println(ans.toString());
    }
}
