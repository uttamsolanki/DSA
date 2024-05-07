package com.recursion;

public class McoloringProblem {

    public static boolean possible(int node,boolean[][] graph,int[] colors,int color)
    {
        for(int adj=0;adj<graph[node].length;adj++)
        {
            if(graph[node][adj]==true && colors[adj]==color)
            {
                return false;
            }
        }
        return true;
    }
    public static boolean solve(int node,boolean[][] graph,int[] colors,int m,int n)
    {
        if(node==n)
        {
            return true;
        }
        for(int color=1;color<=m;color++)
        {
            if(possible(node,graph,colors,color)==true)
            {
                colors[node]=color;
                if(solve(node+1,graph,colors,m,n))
                {
                    return true;
                }
                colors[node] = 0;
            }
        }
        return false;
    }
    public static boolean graphColoring(boolean graph[][], int m, int n) {
        // Your code here

        int[] colors = new int[n];

        return solve(0,graph,colors,m,n);
    }
    public static void main(String[] args) {
        int[][] edges = new int[][]{{0,1},{1,2},{2,3},{3,0},{0,2}};

        int n =4;
        int m=3;

        boolean[][] graph = new boolean[n][n];

        for(int i=0;i<edges.length;i++)
        {
            graph[edges[i][0]][edges[i][1]] =true;
            graph[edges[i][1]][edges[i][0]] =true;
        }
        boolean ans = graphColoring(graph,m,n);
        System.out.println(ans);
    }
}
