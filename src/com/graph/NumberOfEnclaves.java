package com.graph;

import java.util.Arrays;

public class NumberOfEnclaves {
    static class Solution {
        public void DFS(int[][] grid, int[][] vis,int i,int j, int n, int m)
        {
            vis[i][j]=1;

            int[] dx =  new int[]{0,-1,0,1};
            int[] dy = new int[]{-1,0,1,0};

            for(int k=0;k<4;k++)
            {
                int nx =  i + dx[k];
                int ny =  j + dy[k];
                if(nx>=0 && nx<n && ny>=0 && ny<m && vis[nx][ny]==0 && grid[nx][ny]==1)
                {
                    DFS(grid,vis,nx,ny,n,m);
                }
            }

        }
        public int numEnclaves(int[][] grid) {
            int n =  grid.length;
            int m= grid[0].length;

            int[][] vis = new int[n][m];

            for(int i=0;i<n;i++)
            {
                for(int j=0;j<m;j++)
                {
                    if(i!=0 && i != n-1 && j!=0 && j != m-1)
                    {
                        continue;
                    }
                    if(grid[i][j]==1)
                    {
                        DFS(grid,vis,i,j,n,m);
                    }
                }
            }


            for(int i=0;i<grid.length;i++)
            {
                System.out.println(Arrays.toString(grid[i]));
            }
            System.out.println("");
            for(int i=0;i<vis.length;i++)
            {
                System.out.println(Arrays.toString(vis[i]));
            }

            int count = 0;

            for(int i=0;i<n;i++)
            {
                for(int j=0;j<m;j++)
                {
                    if(grid[i][j]==1 && vis[i][j]==0)
                    {
                        count++;
                    }
                }
            }

            return count;
        }
    }
    public static void main(String[] args) {
        int[][] grid = new int[][]{{0,1,1,0},{0,0,1,0},{0,0,1,0},{0,0,0,0}};

        int ans = (new NumberOfEnclaves.Solution()).numEnclaves(grid);

//        for(int i=0;i<grid.length;i++)
//        {
//            System.out.println(Arrays.toString(grid[i]));
//        }
       System.out.println(ans);
    }
}
