package com.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ShortedPathInDAG {

   static class Pair{
       int to;
       int d;
       Pair(int to, int d){
           this.to =to;
           this.d =d;
       }
   }
    public  static void DFS(ArrayList<ArrayList<Pair>> adjList,int node, int[] vis,Stack<Integer> st)
    {
        vis[node] = 1;

        for(Pair ajdNode:adjList.get(node))
        {
            if(vis[ajdNode.to]==0) {
                DFS(adjList, ajdNode.to, vis, st);
            }
        }
        st.add(node);
    }
    public static int[] shortestPathInDAG(int n, int m, int [][]edges) {

        ArrayList<ArrayList<Pair>> adjList= new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++)
        {
            adjList.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
        }

        Stack<Integer> st = new Stack<>();
        int[] vis = new int[n];

        for(int i=0;i<n;i++)
        {
            if(vis[i]==0)
            {
                DFS(adjList,i,vis,st);
            }
        }

        int[] dist = new int[n];

        for(int i=0;i<n;i++)
        {
            dist[i]=(int)1e9;
        }

        dist[0]=0;
        while (!st.isEmpty())
        {
            int node =st.pop();
            for(Pair adjNode:adjList.get(node))
            {
                int d = adjNode.d;
                if(dist[adjNode.to]>dist[node]+d)
                {
                    dist[adjNode.to] = dist[node]+d;
                }

            }
        }

        for(int i=0;i<n;i++)
        {
            if(dist[i]==1e9)
                dist[i]=-1;
        }
        return dist;

    }

    public static void main(String[] args) {
    //'N' = 3, 'M' = 3, 'edges' = [0, 1, 2], [1, 2, 3], [0, 2, 6]].

        int[][] edges = new int[][]{{2,0,4},{0,1,3},{2,1,2}};
        int n=3,m=3;
        int[] ans =  shortestPathInDAG(n,m,edges);

        System.out.println(Arrays.toString(ans));

    }
}
