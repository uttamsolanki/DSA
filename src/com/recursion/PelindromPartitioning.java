package com.recursion;

import java.util.ArrayList;
import java.util.List;

public class PelindromPartitioning {

    public static boolean isPelindrom(String s, int i, int j)
    {
        while (i<=j)
        {
            if(s.charAt(i)!=s.charAt(j))
            {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static  void solve(String s, int index, List<String> list,List<List<String>> ans)
    {
        if(s.length()==index)
        {
            ans.add(new ArrayList<>(list));
            System.out.println(list.toString());
            return;
        }

        for(int i=index;i<s.length();i++)
        {
            if(isPelindrom(s,index,i))
            {
                String sbStr = s.substring(index,i+1);
                list.add(sbStr);
                solve(s,i+1,list,ans);
                list.remove(list.size()-1);
            }
        }


    }
    public static List<List<String>> partition(String s) {

        List<List<String>> result = new ArrayList<>();

        solve(s,0,new ArrayList<>(),result);

        return  result;
    }
    public static void main(String[] args) {
        partition("aabb");
    }
}
