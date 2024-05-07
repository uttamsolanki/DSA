package com.graph;

import java.util.*;

public class KahnAlgo {

    public static List<Integer> topologicalSort(int[][] edges, int e, int v) {
        // Write your code here!

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for(int i=0;i<v;i++)
        {
            adjList.add(new ArrayList<>());
        }
        int[] indegree =  new int[v];
        for(int j=0;j<e;j++)
        {
            adjList.get(edges[j][0]).add(edges[j][1]);
            indegree[edges[j][1]]++;
        }



        int[] vis = new int[v];

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<v;i++)
        {
            if(indegree[i]==0)
                q.add(i);
        }
        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty())
        {
            int node = q.poll();
            ans.add(node);

            for(int adjNode:adjList.get(node))
            {
                indegree[adjNode]--;
                if(indegree[adjNode]==0)
                {
                    q.add(adjNode);
                }
            }
        }



        return  ans;
    }

    public static void main(String[] args) {
        int[][] edges = new int[][]{{0,2},{1,2},{3,1},{0,4}};
        List<Integer> ans = topologicalSort(edges,4,5);
        System.out.println(ans.toString());
    }
}
