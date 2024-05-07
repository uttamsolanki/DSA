package com.graph;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class _01_Matrix {
   static class Solution {
        class Pair{
            int x;
            int y;
            int d;
            Pair(int x, int y,int d)
            {
                this.x = x;
                this.y = y;
                this.d = d;
            }
        }
        public int[][] updateMatrix(int[][] mat) {

            int n = mat.length;
            int m = mat[0].length;
            int[][] ans = new int[n][m];
            int[][] vis = new int[n][m];

            Queue<Pair> q = new LinkedList<>();
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<m;j++)
                {
                    if(mat[i][j]==0)
                    {
                        q.add(new Pair(i,j,0));
                        ans[i][j] = 0;
                        vis[i][j] = 1;
                    }
                }
            }

            int[] dx =  new int[]{0,-1,0,1};
            int[] dy = new int[]{-1,0,1,0};
            while (!q.isEmpty())
            {
                Pair node =  q.poll();
                int x = node.x;
                int y = node.y;
                int d = node.d;

                for(int i=0;i<4;i++)
                {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if(nx>=0 && nx<n && ny>=0 && ny<m && vis[nx][ny]==0)
                    {
                        ans[nx][ny] = d+1;
                        vis[nx][ny] = 1;
                        q.add(new Pair(nx,ny,d+1));
                    }
                }

            }


            return ans;
        }
    }
    public static void main(String[] args) {

        //int[][] mat =  new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        int[][] mat =  new int[][]{{0,0,0},{0,1,0},{1,1,1}};
        int[][] ans =  (new Solution()).updateMatrix(mat);

        for(int i=0;i<ans.length;i++)
        {
            System.out.println(Arrays.toString(ans[i]));
        }
    }
}
