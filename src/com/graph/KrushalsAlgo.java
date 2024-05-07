package com.graph;

import java.util.PriorityQueue;

public class KrushalsAlgo {

    static class Tuple{
        int x,y,z;
        Tuple(int x,int y, int z)
        {
            this.x=x;
            this.y=y;
            this.z=z;
        }
    }
    public static int kruskalMST(int n,int [][]edges) {
        //Write your code here

        //sort all edges by edges weight
        PriorityQueue<Tuple> pq = new PriorityQueue<>((x,y)->x.z-y.z);

        //Apply DisJoin
        DisjointSet ds = new DisjointSet(n+1); // n+1 because 1-base index

        int ans = 0;
        for(int[] edge:edges)
        {
            pq.add(new Tuple(edge[0],edge[1],edge[2]));
        }

        while (!pq.isEmpty())
        {
            Tuple t = pq.poll();
            int u =  t.x;
            int v =  t.y;
            int w =  t.z;
            if(ds.findParent(u)!=ds.findParent(v))
            {
                ds.unionByRank(u,v);
                ans+=w;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] edges = new int[][]{
                {1, 2, 6},
                {2, 3, 5},
                {3, 4, 4},
                {1, 4, 1},
                {1, 3, 2},
                {3, 5, 3}
        };
        int ans =  kruskalMST(n,edges);
        System.out.println(ans);
    }
}
