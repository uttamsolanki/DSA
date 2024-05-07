package com.graph;

import java.util.Arrays;

public class FindCityWithSmallestNeighbor {

    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {

        int[][] dist = new int[n][n];

        for(int[] a:dist) Arrays.fill(a,(int)1e9);

        for(int[] edge:edges)
        {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            dist[u][v]=w;
            dist[v][u]=w;
            dist[u][u]=0;
            dist[v][v]=0;
        }

        for(int k=0;k<n;k++)
        {
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    dist[i][j] = Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                }
            }
        }

        int city = -1;
        int nbrCount = Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            int cnt=0;
            for(int j=0;j<n;j++)
            {
                if(i==j) continue;;
                if(dist[i][j]<=distanceThreshold) cnt++;
            }
            if(cnt<=nbrCount)
            {
                nbrCount=cnt;
                city=i;
            }
            //System.out.println(Arrays.toString(dist[i]));
        }


        return city;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] edges = new int[][]{{0,1,3},{1,2,1},{1,3,4},{2,3,1}};
        int distanceThreshold = 4;

        int ans = findTheCity(n,edges,distanceThreshold);
        System.out.println(ans);
    }
}
