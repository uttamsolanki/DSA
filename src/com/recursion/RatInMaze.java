package com.recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class RatInMaze {

    public static boolean valid(int[][] m,int n, int i, int j,int[][] vis)
    {
        if(i>=0 && i<n && j>=0 && j<n && m[i][j]==1 && vis[i][j]==0) return true;
        return false;
    }
    public static void solve(int[][] m, int n, int x, int y, String dir,ArrayList<String> ans, int[][] vis)
    {
        if(x==n-1 &&y==n-1)
        {
            // System.out.println(dir);
            ans.add(dir);
        }

        if(m[x][y]==0)
        {
            return;
        }
        //LEFT, UP, RIGHT, BOTTOM
        int[] dx = {1,0,0,-1};
        int[] dy = {0,-1,1,0};
        char[] direction = new char[]{'D','L','R','U'};
        for(int i=0;i<4;i++)
        {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if(valid(m,n,nx,ny,vis))
            {
                String newDir = dir+direction[i];
                vis[x][y] = 1;
                solve(m,n,nx,ny,newDir,ans,vis);
                vis[x][y] = 0;
            }
        }

    }
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        int[][] vis = new int[n][n];
        ArrayList<String> ans = new ArrayList<>();
        solve(m,n,0,0,"",ans,vis);
        System.out.println(ans.toString());
        return ans;
    }

    public static void main(String[] args) {
//        int[][] m =  new int[][]
//                {
//                        {1, 0, 0, 0},
//                        {1, 1, 0, 1},
//                        {1, 1, 0, 0},
//                        {0, 1, 1, 1}
//                };

        int[][] m =  new int[][]
                {
                        {1,1},
                        {1,1}
                };
        int n=2;
        findPath(m,n);
    }
}