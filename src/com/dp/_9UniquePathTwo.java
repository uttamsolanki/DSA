package com.dp;

import java.util.ArrayList;
import java.util.Arrays;

public class _9UniquePathTwo {
    public static int f1(int n, int m, ArrayList<ArrayList<Integer>> mat,int[][] mm)
    {
        if(m<0 || n<0)
        {
            return 0;
        }
        if(m==0 && n==0)
        {
            return 1;
        }

        if(mm[n][m]!=-1)
        {
            return mm[n][m];
        }

        if(mat.get(n).get(m)==-1)
        {
            return 0;
        }
        return mm[n][m] = f1(n-1,m,mat,mm) + f1(n,m-1,mat,mm);
    }
    public static void main(String[] args) {

        int n=3,m=3;
        ArrayList<ArrayList<Integer>> mat = new ArrayList<>();

        ArrayList<Integer> row = new ArrayList<>();
        row.add(0);
        row.add(0);
        row.add(0);
        mat.add(row);

        row = new ArrayList<>();
        row.add(0);
        row.add(-1);
        row.add(0);
        mat.add(row);

        row = new ArrayList<>();
        row.add(0);
        row.add(0);
        row.add(0);
        mat.add(row);

        int[][] mm = new int[n][m];

        for(int i=0;i<n;i++)
        {
            Arrays.fill(mm[i],-1);
        }

        int ans = f1(n-1,m-1,mat,mm);

        System.out.println(ans);
    }
}
