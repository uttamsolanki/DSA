package com.DailyRandom;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class maximumImportance {

    public static long maximumImportance(int n, int[][] roads) {

        int[] degree = new int[n];

        for(int i=0;i<roads.length;i++)
        {
            degree[roads[i][0]]++;
            degree[roads[i][1]]++;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[0]-a[0]);

        for(int i=0;i<n;i++)
        {
            pq.add(new int[]{degree[i],i});
        }
        while (!pq.isEmpty())
        {
            int[] item = pq.poll();
            degree[item[1]] = n;
            n--;
        }



        long sum =0;

        for(int i=0;i<roads.length;i++)
        {
           sum += (degree[roads[i][0]]+degree[roads[i][1]]);
        }

        return sum;
    }

    public static void main(String[] args) {
//        int[][] edges = new int[][]{
//                {0,1},{1,2},{2,3},{0,2},{1,3},{2,4}
//        };
        int[][] edges = new int[][]{
                {0,3},{2,4},{1,3}
        };
        int n =5;
        long ans = maximumImportance(n,edges);
        System.out.println(ans);
    }
}
