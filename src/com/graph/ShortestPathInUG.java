package com.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInUG {

    static class Pair{
        int to;
        int wt;
        Pair(int to, int wt)
        {
            this.to = to;
            this.wt = wt;
        }
    }
    public static void BFS(ArrayList<ArrayList<Integer>> adjList, int[] dist,int src)
    {
        dist[src]=0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src,0));
        while(!q.isEmpty())
        {
            Pair pair = q.poll();
            int node = pair.to;
            int wt = pair.wt;
            for(int adjNode:adjList.get(node))
            {
                if(dist[adjNode]==1e9)
                {
                    q.add(new Pair(adjNode,wt+1));
                }
                if(pair.wt+1<dist[adjNode])
                {
                    dist[adjNode]=pair.wt+1;
                }
            }
        }
    }

    public static int[] shortestPath(int n, int [][]edges, int src) {
        // Write your code here.

        int[] dist = new int[n];
        ArrayList<ArrayList<Integer>> adjList =new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            dist[i] = (int)1e9;
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++)
        {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }

        BFS(adjList,dist,src);

        for(int i=0;i<n;i++)
        {
            if(dist[i]==1e9) dist[i]=-1;
        }
        return dist;
    }

    public static void main(String[] args) {

        //int[][] edges = new int[][]{{0, 1}, {1, 4}, {2, 3}, {2, 4}, {3, 4}};
        int[][] edges = new int[][]{{0, 1}, {0, 3}, {2, 3}};
        int[] ans = shortestPath(4,edges,0);
        System.out.println(Arrays.toString(ans));
    }
}
