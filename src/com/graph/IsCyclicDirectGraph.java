package com.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class IsCyclicDirectGraph {

    public static  boolean BFS(ArrayList<ArrayList<Integer>> adjList,int n)
    {
        int[] indegree = new int[n+1];

        for(int i=1;i<=n;i++)
        {
            for(int adjNode:adjList.get(i))
            {
                indegree[adjNode]++;
            }
        }

        List<Integer> top= new ArrayList<>();

        Queue<Integer> q = new LinkedList<>();

        for(int i=1;i<=n;i++)
        {
            if(indegree[i]==0)
            {
                q.add(i);
            }
        }


        while (!q.isEmpty())
        {
            int node = q.poll();
            top.add(node);
            for(int adjNode:adjList.get(node))
            {
                indegree[adjNode]--;
                if(indegree[adjNode]==0)
                {
                    q.add(adjNode);
                }
            }
        }
        return top.size() == n? false:true;

    }
    public static boolean DFS(ArrayList<ArrayList<Integer>> adjList,int node,int[] vis, int[] path){
        vis[node] = 1;
        path[node] = 1;

        for(int adjNode:adjList.get(node))
        {
            if(vis[adjNode]==0)
            {
                if (DFS(adjList,adjNode, vis, path) == true) return true;
            }else if(path[adjNode]==1)
            {
                return true;
            }
        }
        path[node]=0;
        return false;
    }
    public static Boolean isCyclic(int[][] edges, int v, int e)
    {
        int[] vis = new int[v];
        int[] path = new int[v];

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<v;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<e;i++)
        {
            adj.get(edges[i][0]).add(edges[i][1]);
        }

        for(int i=0;i<v;i++)
        {
            if(vis[i]==0) {
                if (DFS(adj,i, vis, path) == true) return true;
            }
        }

    //    if(BFS(adj,v)==true) return true;

        return false;
    }

    public static void main(String[] args) {
        int[][] edges = new int[][]{{1,0},{1,2},{0,2}};

        boolean ans = isCyclic(edges,3,3);

        System.out.println(ans);
    }
}
