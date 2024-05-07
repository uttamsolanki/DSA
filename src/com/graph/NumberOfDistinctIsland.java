package com.graph;

import java.util.ArrayList;
import java.util.HashSet;

public class NumberOfDistinctIsland {

    public static void DFS(int[][] arr, int x, int y,int a, int b,ArrayList<Integer> coordinates,int[][] vis)
    {
        vis[x][y] = 1;
        coordinates.add(x-a);
        coordinates.add(y-b);
        int n =  arr.length;
        int m = arr[0].length;
        int[] dx =new int[]{0,1,0,-1};
        int[] dy =new int[]{1,0,-1,0};

        for(int i=0;i<4;i++)
        {
            int nx =  x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && nx<n  && ny>=0 && ny<m && arr[nx][ny]==1 && vis[nx][ny] == 0)
            {
                DFS(arr,nx,ny,a,b,coordinates,vis);
            }
        }

    }
    public static int distinctIsland(int [][] arr, int n, int m)
    {
        int[][] vis = new int[n][m];

        HashSet<String> set = new HashSet<>();

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(arr[i][j]==1 && vis[i][j]==0)
                {
                    ArrayList<Integer> coordinates = new ArrayList<>();
                    DFS(arr,i,j,i,j,coordinates,vis);
                    String coStr = coordinates.toString();
                    if(!set.contains((coStr)))
                    {
                        set.add(coStr);
                    }
                }
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        int[][]  arr = new int[][]{{1,1,0,1,1},{1,0,0,0,0},{0,0,0,0,1},{1,1,0,1,1}};

        int ans = distinctIsland(arr,4,5);

        System.out.println(ans);
    }
}
