package com.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class FloydWarshall {
    static int floydWarshall(int n, int m, int src, int dest, ArrayList<ArrayList<Integer>> edges) {
        // Write your code here.
        int[][] adjMatrix = new int[n+1][n+1];

        for(int[] a:adjMatrix){
            Arrays.fill(a,(int)1e9);
        }

        for(ArrayList<Integer> edge:edges)
        {
            int u = edge.get(0);
            int v = edge.get(1);
            int w = edge.get(2);
            adjMatrix[u][v]=w;
            adjMatrix[u][u]=0;
            adjMatrix[v][v]=0;
        }

        for(int k=1;k<=n;k++)
        {
            for(int i=1;i<=n;i++)
            {
                for(int j=1;j<=n;j++)
                {
                    if(adjMatrix[i][k]!=(int)1e9 && adjMatrix[k][j]!=(int)1e9)
                    {
                        adjMatrix[i][j] = Math.min(adjMatrix[i][j],adjMatrix[i][k]+adjMatrix[k][j]);
                    }
                }
            }
        }

        for(int i=0;i<=n;i++)
        {
            System.out.println(Arrays.toString(adjMatrix[i]));
        }

        return adjMatrix[src][dest];
    }

    public static void main(String[] args) {
        int[][] edgesArr =  new int[][]{{1,2,2},{1,3,2},{2,3,-1}};
        int n=3,m=3,src=1,dest=3;
        ArrayList<ArrayList<Integer>> edges =  new ArrayList<>();

        for(int i=0;i<m;i++)
        {
            ArrayList<Integer> edge = new ArrayList<>();
            for(int j=0;j<3;j++)
            {
                edge.add(edgesArr[i][j]);
            }
            edges.add(edge);
        }


        int ans = floydWarshall(n,m,src,dest,edges);

        System.out.println(ans);
    }
}
