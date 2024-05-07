package com.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraPQ {

    static class Pair{
        int a;
        int b;
        Pair(int a, int b)
        {
            this.a =a;
            this.b =b;
        }
    }
    public static List<Integer> dijkstra(int[][] edge, int vertices, int edges, int source){
        // Write your code here.
        ArrayList<ArrayList<Pair>> adjList = new ArrayList<>();

        for(int i=0;i<vertices;i++)
        {
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<edge.length;i++)
        {
            adjList.get(edge[i][0]).add(new Pair(edge[i][1],edge[i][2]));
            adjList.get(edge[i][1]).add(new Pair(edge[i][0],edge[i][2]));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y)->x.b - y.b);

        int[] dist = new int[vertices];
        for(int i=0;i<vertices;i++)
        {
            dist[i] = (int)1e9;
        }

        pq.add(new Pair(source,0));
        dist[source] = 0;

        while (!pq.isEmpty())
        {
            Pair p = pq.poll();
            int node = p.a;
            int d = p.b;

            for(Pair adjPair:adjList.get(node))
            {
                int adjnode = adjPair.a;
                int adjD = adjPair.b;

                if(d+adjD <dist[adjnode])
                {
                    dist[adjnode] = d+adjD;
                    pq.add(new Pair(adjnode,d+adjD));
                }
            }
        }

        List<Integer> ans = new ArrayList<>();

        for(int i=0;i<vertices;i++)
        {
            if(dist[i]!=1e9)
            {
                ans.add(dist[i]);
            }
        }

        return ans;

    }
    public static void main(String[] args) {
        int[][]  edge = new int[][]{{0,1,7},{0,2,1},{0,3,2},{1,2,3},{1,3,5},{1,4,1},{3,4,7}};
        int v = 5;
        int e = 7;
        List<Integer> ans =  dijkstra(edge,v,e,0);
        System.out.println(ans.toString());
    }
}
