package com.arrays;

import java.util.ArrayList;
import java.util.Collections;

public class LeadersInArray {

    static ArrayList<Integer> leaders(int arr[], int n){
        ArrayList<Integer> ans = new ArrayList<>();

        int lastLeader = arr[n-1] ;
        ans.add(lastLeader);
        for(int i=n-2;i>=0;i--)
        {
            if(lastLeader<=arr[i])
            {
                lastLeader = arr[i];
                ans.add(lastLeader);
            }
        }

        Collections.reverse(ans);
        return ans;

    }
    public static void main(String[] args) {

        int[] arr = new int[]{4,7,1,0};
        ArrayList<Integer> ans = leaders(arr,arr.length);
        System.out.println(ans);
    }
}
