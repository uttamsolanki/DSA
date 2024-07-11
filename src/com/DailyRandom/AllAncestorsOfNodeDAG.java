package com.DailyRandom;

import java.util.ArrayList;
import java.util.List;

public class AllAncestorsOfNodeDAG {

    public static List<List<Integer>> getAncestors(int n, int[][] edges) {


        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++)
        {
            adjList.get(edges[i][1]).add(edges[i][0]);
        }

        return adjList;


    }
    public static void main(String[] args) {
        int n = 8;
        int[][] edges = new int[][]{
                {0,3},{0,4},{1,3},{2,4},{2,7},{3,5},{3,6},{3,7},{4,6}
        };

        List<List<Integer>> ans = getAncestors(n,edges);

        for(int i=0;i<ans.size();i++)
        {
            System.out.println(ans.get(i));
        }
    }
}
