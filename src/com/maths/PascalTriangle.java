package com.maths;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    // Using matrix method
    public static List<List<Integer>> approach1(int n) {

        List<List<Integer>> row  = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            List<Integer> col = new ArrayList<>();
            for(int j=0;j<=i;j++)
            {
                if(i==j)
                {
                    col.add(1);
                }
                else if(j==0)
                {
                    col.add(1);
                }
                else
                {
                    int prev1 = (row.get(i-1)).get(j-1);
                    int prev2 = (row.get(i-1)).get(j);
                    col.add( prev1 + prev2 );
                }

            }
            row.add(col);
        }

        return row;
    }

    public static List<List<Integer>> approach2(int n) {
        List<List<Integer>> row = new ArrayList<>();

        for(int i=0;i<n;i++) {
            List<Integer> col = new ArrayList<>();
            int res = 1;
            col.add(res);
            for (int j = 0; j <i; j++) {
                res*=(i-j);
                res/=(j+1);
                col.add(res);
            }
            row.add(col);
        }
        return row;
    }

    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> ans = approach2(n);
        for(int i=0;i<n;i++)
        {
            System.out.println(ans.get(i).toString());
        }

    }
}
