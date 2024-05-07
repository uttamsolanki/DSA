package com.graph;

import java.util.*;

public class CheapestWithKstop {
    static  class Pair{
        int a;
        int b;
        Pair(int a, int b)
        {
            this.a =a;
            this.b =b;
        }
    }

    static  class PairQ{
        int s;
        int node;
        int dis;
        PairQ(int s, int x,int y)
        {
            this.s =s;
            this.node =x;
            this.dis =y;
        }
    }
    public static int savingMoney(int n, int source, int destination, int k, List<List<Integer>> trains) {
        // Write your code here.
        ArrayList<ArrayList<Pair>> adjList = new ArrayList<>();
        int[] dist =  new int[n];

        for(int i=0;i<n;i++)
        {
            adjList.add(new ArrayList<>());
            dist[i] = (int)1e9;
        }

        for(int i=0;i<trains.size();i++)
        {
            List<Integer> innerList =  trains.get(i);
            adjList.get(innerList.get(0)).add(new Pair(innerList.get(1),innerList.get(2)));
        }



        Queue<PairQ> q =  new LinkedList<>();
        q.add(new PairQ(0,source,0));

        dist[source] = 0;

        while (!q.isEmpty())
        {
            PairQ p = q.poll();
            int node = p.node;
            int dis = p.dis;
            int s =p.s;

            if(s>k) continue;

            for(Pair adjPair:adjList.get(node))
            {
                int adjNode = adjPair.a;
                int adjw = adjPair.b;
                if(dis + adjw <dist[adjNode] && s <= k)
                {
                    dist[adjNode] = dis + adjw;
                    q.add(new PairQ(s+1,adjNode,dis+adjw));
                }

            }

        }

        return dist[destination]==1e9? -1: dist[destination];
    }

    public static void main(String[] args) {
       int[][] trainsArr = new int[][]{{2,0,2},{1,2,2}};

       List<List<Integer>> trains = new ArrayList<>();

        for (int[] row : trainsArr) {
            List<Integer> tempList = new ArrayList<>();
            for (int num : row) {
                tempList.add(num);
            }
            trains.add(tempList);
        }

        int ans = savingMoney(3,0,2,2,trains);
        System.out.println(ans);

    }
}
