package com.graph;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInMaze {
   static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Pair
    {
        int d;
        int x;
        int y;

        Pair(int d,int x,int y)
        {
            this.d = d;
            this.x = x;
            this.y = y;
        }
    }
    public static int shortestPathBinaryMatrix(int[][] matrix, Point src, Point dest) {

        // Write your code here
        //Edge cases
        if(src.x == dest.x && src.y == dest.y && matrix[0][0]==0) return -1;
        if(src.x == dest.x && src.y == dest.y && matrix[0][0]==1) return 0;
        if(matrix[src.x][src.y]==0) return -1;

        int n = matrix.length;
        int m =  matrix[0].length;

        int[][] dist =  new int[n][m];

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                dist[i][j] = (int)1e9;
            }
        }

        Queue<Pair> q = new LinkedList<Pair>();

        q.add(new Pair(0,src.x,src.y));
        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy =  new int[]{0, 1, 0, -1};
        dist[src.x][src.y]=0;
        while(!q.isEmpty())
        {
            Pair p = q.poll();
            int d = p.d;
            int x = p.x;
            int y = p.y;

            for(int i=0;i<4;i++)
            {
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx>=0 && nx<n && ny>=0 && ny<m && matrix[nx][ny]==1 && dist[nx][ny]> d+1)
                {
                    dist[nx][ny] = d+1;
                    if(nx==dest.x && ny==dest.y)
                    {
                        return d+1;
                    }
                    q.add(new Pair(d+1,nx,ny));
                }

            }

        }

        return -1;
    }

    public static void main(String[] args) {
        int[][] marix = new int[][]{{0,0,0,0},{1,1,0}};
        int n=2,m=3;

        int ans = shortestPathBinaryMatrix(marix, new Point(1,0),new Point(1,1));
        System.out.println(ans);

    }
}
