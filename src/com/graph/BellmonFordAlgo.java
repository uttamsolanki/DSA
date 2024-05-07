package com.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BellmonFordAlgo {
    public static int[] bellmonFord(int n, int m, int src, List<List<Integer>> edges) {
        int[] dist = new int[n+1];

        for(int i=1;i<=n;i++)
        {
            dist[i] = (int)1e8;
        }
        dist[src]=0;
        for(int i=0;i<n-1;i++)
        {
            for(List<Integer> edge:edges)
            {
                int u = edge.get(0);
                int v = edge.get(1);
                int wt = edge.get(2);
                if(dist[u]+wt<dist[v])
                {
                    dist[v] = dist[u]+wt;
                }
            }

        }

        int[] ans =  new int[n];
        for(int i=0;i<n;i++)
        {
            ans[i]=dist[i+1];
        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] edgesArr =  new int[][]{{1,2,4},{1,3,3},{2,4,7},{3,4,-2}};
        int n=4,m=4,src=1;
        List<List<Integer>> edges =  new ArrayList<>();

        for(int i=0;i<m;i++)
        {
            List<Integer> edge = new ArrayList<>();
            for(int j=0;j<3;j++)
            {
                edge.add(edgesArr[i][j]);
            }
            edges.add(edge);
        }


        int[] ans = bellmonFord(n,m,src,edges);

        System.out.println(Arrays.toString(ans));

    }
}
