package com.DailyRandom;

import java.util.ArrayList;
import java.util.Arrays;

public class FindFarmland {


        public static void DFS(int[][]  land, int i, int j , int[] ans,int[][] vis)
        {
            int n =  land.length;
            int m = land[0].length;

            if(i<0 || i>=n || j<0 || j>=m)
            {
                return;
            }

            if(ans[2]<i)
            {
                ans[2] = i;
            }


            if(ans[3]<j)
            {
                ans[3] = j;
            }


            int[] dx =  new int[]{0,1};
            int[] dy =  new int[]{1,0};
            vis[i][j] =1;
            for(int k=0;k<2;k++)
            {
                int nx = dx[k] + i;
                int ny = dy[k] + j;

                if(nx>=0 && nx<n && ny>=0 && ny<m)
                {
                    if(vis[nx][ny]==0 && land[nx][ny]==1)
                    {
                        DFS(land,nx,ny,ans,vis);
                    }
                }
            }


        }
        public static int[][] findFarmland(int[][] land) {
            ArrayList<int[]> ans =  new ArrayList<>();


            int[][] vis = new int[land.length][land[0].length];
            for(int i=0;i<land.length;i++)
            {
                for(int j=0;j<land[0].length;j++)
                {
                    if(land[i][j]==1 && vis[i][j]==0)
                    {
                        int[] list = new int[4];
                        list[0] =i;
                        list[1] =j;
                        list[2] = i;
                        list[3] = j;
                        DFS(land,i,j,list,vis);
                        ans.add(list);
                    }
                }
            }

            int[][] result = new int[ans.size()][4];

            for(int i=0;i<ans.size();i++)
            {
                result[i] = ans.get(i);
            }

            return result;
        }

    public static void main(String[] args) {
            int[][] land = new int[][]{{0,1},{1,0}};
        int[][] ans = findFarmland(land);
        System.out.println(Arrays.toString(ans));
    }

}
