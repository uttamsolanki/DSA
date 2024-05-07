package com.graph;

import java.util.PriorityQueue;

public class PathWithMinimumEffort {

    static  class Pair{
        int d,x,y;
        Pair(int d,int x, int y)
        {
            this.d = d;
            this.x = x;
            this.y = y;
        }
    }
    public static int minimumTimeTakingPath(int[][] heights){
        // Write your code here.
        int n = heights.length;
        int m = heights[0].length;

        int[][] dist = new int[n][m];

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                dist[i][j] = (int)1e9;
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y)->x.d-y.d);
        pq.add(new Pair(0,0,0));

        dist[0][0] = 0;

        int[] dx = new int[]{-1,0,1,0};
        int[] dy = new int[]{0,1,0,-1};
        while (!pq.isEmpty())
        {
            Pair p = pq.poll();
            int d = p.d;
            int x = p.x;
            int y = p.y;

            if(x == n-1 && y == m-1)
            {
                return d;
            }

            for(int i=0;i<4;i++)
            {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m)
                {
                    int max = Math.max(Math.abs(heights[x][y]-heights[nx][ny]),d);
                    if(max<dist[nx][ny])
                    {
                        dist[nx][ny]= max;
                        pq.add(new Pair(max,nx,ny));
                    }
                }
            }

        }
        return 0;

    }
    public static void main(String[] args) {
        int[][] heights = new int[][]{{1,3,1},{9,9,3},{9,9,1}};
        int ans =  minimumTimeTakingPath(heights);
        System.out.println(ans);
    }
}
