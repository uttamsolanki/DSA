package com.graph;

import java.util.HashSet;

public class NumberOfProvince {
    public static int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;
        DisjointSet ds = new DisjointSet(n);

        for(int i=0;i<isConnected.length;i++)
        {
            for(int j=0;j<isConnected[i].length;j++)
            {
                if(isConnected[i][j]==1)
                {
                    ds.unionByRank(i,j);
                }
            }
        }

//        HashSet<Integer> set = new HashSet<>();
//        for(int i=0;i<n;i++)
//        {
//            int parent = ds.findParent(i);
//            if(!set.contains(parent)) set.add(parent);
//        }
//
//        return set.size();

        int count = 0;
        for(int i=0;i<n;i++)
        {
            int parent = ds.findParent(i);
            if(parent==i) count++;
        }

        return count;
    }
    public static void main(String[] args) {
        int[][] isConnected = new int[][]{
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };

        int ans =  findCircleNum(isConnected);
        System.out.println(ans);

    }
}
