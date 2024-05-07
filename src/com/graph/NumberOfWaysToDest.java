package com.graph;

import java.util.*;

public class NumberOfWaysToDest {

    static class Pair{
        int x;
        long y;
        Pair(int x,long y)
        {
            this.x = x;
            this.y = y;
        }
    }
    public static int countPaths(int n, int[][] roads) {

        ArrayList<ArrayList<Pair>> adjList = new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            adjList.add(new ArrayList<>());
        }

        for(int[] road:roads)
        {
            adjList.get(road[0]).add(new Pair(road[1],road[2]));
            adjList.get(road[1]).add(new Pair(road[0],road[2]));
        }

        int[] ways = new int[n];
        long[] dist = new long[n];
        for(int i=0;i<n;i++)
        {
            dist[i] = Long.MAX_VALUE/2;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)-> Math.toIntExact(x.y - y.y));

        pq.add(new Pair(0,0));
        ways[0]=1;
        dist[0]=0;
        int mod = (int)(1e9 + 7);
        while (!pq.isEmpty())
        {
            Pair pair = pq.poll();
            int node = pair.x;
            long d = pair.y;
            for(Pair adjPair:adjList.get(node))
            {
                int adjNode = adjPair.x;
                long adjDist = adjPair.y;
                if(adjDist + d < dist[adjNode])
                {
                    ways[adjNode]=ways[node];
                    dist[adjNode]=adjDist + d;
                    pq.add(new Pair(adjNode,adjDist + d));
                }else if(adjDist + d == dist[adjNode])
                {
                    ways[adjNode]=  (ways[adjNode] + ways[node])%mod;
                }
            }
        }

        return ways[n-1]%mod;
    }
    public static void main(String[] args) {
        //int[][] roads = new int[][]{{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}};

        int[][] roads = new int[][]{{0,1,1000000000},{0,3,1000000000},{1,3,1000000000},{1,2,1000000000},{1,5,1000000000},{3,4,1000000000},{4,5,1000000000},{2,5,1000000000}};
        int ans = countPaths(6,roads);
        System.out.println(ans);

    }
}
