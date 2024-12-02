package com.recursion;
import java.util.*;
public class CombinationIII {
     static List<List<Integer>> result = new ArrayList<>();
    public static void  getCombination(List<Integer> list, int currSum,int k, int sum, int start){
        if(start>9 | list.size()>k)
        {
            return;
        }
        if(currSum==sum)
        {
            if(list.size()==k)
            {
                List<Integer> nlist = new ArrayList<>(list);
                result.add(nlist);
            }
        }
        for(int i=start;i<10;i++)
        {


            list.add(i);
            getCombination(list, currSum+i, k, sum, i+1);
            list.remove(list.size()-1);
            //getCombination(list, currSum, k, sum, start+1);
        }
    }
    public static  List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> list = new ArrayList<>();
        getCombination(list,0,k,n,1);
        return result;
    }

    public static void main(String[] args) {
        combinationSum3(9,45);
       // System.out.println(ans);
    }
}
