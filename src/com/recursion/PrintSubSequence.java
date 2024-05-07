package com.recursion;

import java.util.ArrayList;

public class PrintSubSequence {

    public static  void  subSequence(int i,int[] arr, ArrayList<Integer> list)
    {
        if(i>=arr.length)
        {
            System.out.println(list.toString());
            return;
        }
        list.add(arr[i]);
        subSequence(i+1,arr,list);
        list.remove(list.size()-1);
        subSequence(i+1,arr,list);

    }
    public static void main(String[] args) {

        int[] arr = new int[]{3,1,2};
        ArrayList<Integer> list = new ArrayList<>();
        subSequence(0,arr,list);
    }
}
