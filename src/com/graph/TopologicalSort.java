package com.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {

    public static void DFS(ArrayList<ArrayList<Integer>> adjList, int node,int[] vis, Stack<Integer> st)
    {
        vis[node] =1;

        for(int adjNode:adjList.get(node))
        {
            if(vis[adjNode]==0)
            {
                DFS(adjList,adjNode,vis,st);
            }
        }
        st.add(node);
    }
    public static List<Integer> topologicalSort(int[][] edges, int e, int v) {
        // Write your code here!

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for(int i=0;i<v;i++)
        {
            adjList.add(new ArrayList<>());
        }

        for(int j=0;j<e;j++)
        {
            adjList.get(edges[j][0]).add(edges[j][1]);
        }

        int[] vis = new int[v];
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<v;i++)
        {
            if(vis[i]==0)
                DFS(adjList,i,vis,st);
        }

        List<Integer> ans = new ArrayList<>();

        while (!st.isEmpty())
        {
            ans.add(st.pop());
        }


        return  ans;
    }

    public static void main(String[] args) {
        int[][] edges = new int[][]{{3,0},{3,1},{3,2},{3,4},{5,4}};
        List<Integer> ans = topologicalSort(edges,5,6);
        System.out.println(ans.toString());
    }
}
