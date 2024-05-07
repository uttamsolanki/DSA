package com.DailyRandom;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ValidPath {


    public static boolean validPath(int n, int[][] edges, int source, int destination) {

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        if(n==1) return true;

        for(int i=0;i<n;i++)
        {
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++)
        {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }

        int[] vis = new int[n];

        vis[source] = 1;

        Queue<Integer>  q = new LinkedList<>();

        q.add(source);
        while(!q.isEmpty())
        {
            int node = q.poll();

            for(int adjNode:adjList.get(node))
            {
                if(adjNode == destination)
                {
                    return true;
                }

                if(vis[adjNode]==0)
                {
                    vis[adjNode] =1;
                    q.add(adjNode);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] edges = new int[][]{
                {0,1},
                {1,2},
                {2,0}
        };

        boolean ans =  validPath(3,edges,0,2);
        System.out.println(ans);
    }
}
