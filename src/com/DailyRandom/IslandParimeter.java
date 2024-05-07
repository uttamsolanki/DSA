package com.DailyRandom;

import java.util.LinkedList;
import java.util.Queue;

public class IslandParimeter {

    public static  int BFS(int[][] grid, int i, int j, int[][] vis)
    {
        class Pair{
            int first,second;
            Pair(int first, int second)
            {
                this.first = first;
                this.second = second;
            }
        }

        int n=grid.length;
        int m=grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i,j));
        vis[i][j]=1;
        int cnt=0;
        int[] dx = {1,0,-1,0};
        int[] dy = {0,-1,0,1};

        while (!q.isEmpty())
        {
            Pair pair = q.poll();
            for(int x=0;x<4;x++)
            {
                int nx = dx[x] + pair.first;
                int ny = dy[x] + pair.second;
                if(nx>=0 && nx<n && ny>=0 && ny<m)
                {
                    if(grid[nx][ny]==1)
                    {
                        if(vis[nx][ny]==0)
                        {
                            q.add(new Pair(nx,ny));
                            vis[nx][ny]=1;
                        }
                    }else {
                        cnt++;
                    }
                }
                else {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    //Using BFS
    public static int islandPerimeter(int[][] grid) {

            int n=grid.length;
            int m=grid[0].length;
            int[][] vis = new int[n][m];
            int cnt =0;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<m;j++)
                {
                    if(vis[i][j]==0 && grid[i][j]==1)
                    {
                        cnt += BFS(grid,i,j,vis);
                    }
                }
            }

            return cnt;
    }

    // Second Approach
    public static int islandPerimeter2(int[][] grid) {

        int n=grid.length;
        int m=grid[0].length;
        int cnt=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1)
                {
                   //Row edge check
                    if(i==0 || grid[i-1][j]==0) cnt++;
                    if(i == n-1 || grid[i+1][j]==0) cnt++;


                    //column edge check
                    if(j==0 || grid[i][j-1]==0) cnt++;
                    if(j==m-1 || grid[i][j+1]==0) cnt++;
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        //int[][] grid = new int[][]{{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};

        int[][] grid = new int[][]{{1,1}};

        int ans = islandPerimeter2(grid);
        System.out.println(ans);
    }
}
