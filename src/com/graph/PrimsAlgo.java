package com.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class PrimsAlgo {

    static  class Pair{
        int a,b;
        Pair(int a, int b)
        {
            this.a = a;
            this.b = b;
        }
    }

    static  class Tuple{
        int x,y,z;
        Tuple(int x,int y,int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    public static int minimumSpanningTree(ArrayList<ArrayList<Integer>> edges, int n) {
        //Your code goes here
        ArrayList<ArrayList<Pair>> adjList = new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            adjList.add(new ArrayList<>());
        }

        for(ArrayList<Integer> edge:edges)
        {
            int u = edge.get(0);
            int v = edge.get(1);
            int w = edge.get(2);
            adjList.get(u).add(new Pair(v,w));
            adjList.get(v).add(new Pair(u,w));
        }

        PriorityQueue<Tuple> pq = new PriorityQueue<>((x,y)->x.x-y.x);

        int[] vis =  new int[n];
      //  int[] parent = new int[n];
        //ArrayList<Pair> mst = new ArrayList<>();
        int pathSum = 0;

        //parent[0] =-1;
        pq.add(new Tuple(0,0,-1));

        // E log E + E log E = E log E
        while (!pq.isEmpty())
        {
            //log E
            Tuple tuple = pq.poll();
            int dist = tuple.x;
            int node = tuple.y;
            int parentNode = tuple.z;

           // if(parent[node]==-1) continue;
            if(vis[node]==1) continue;

            pathSum+=dist;
            //parent[node] =parentNode;
            vis[node] = 1;

            //mst.add(new Pair(parentNode,node));
            // E log E putting into pq
            for(Pair adjPar:adjList.get(node))
            {
                int adjNode = adjPar.a;
                int adjDist = adjPar.b;
                pq.add(new Tuple(adjDist,adjNode,node));
            }


        }

        return pathSum;
    }
    public static void main(String[] args) {
        Integer[][] edgesArr =  new Integer[][]{
                {0,1,3},
                {0,3,5},
                {1,2,1},
                {2,3,8}
        };

        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        for(Integer[] edge : edgesArr)
        {
            ArrayList<Integer> list = new ArrayList<>(Arrays.asList(edge));
            edges.add(list);
        }

        int ans = minimumSpanningTree(edges,4);
        System.out.println(ans);
    }
}
