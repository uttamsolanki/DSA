package com.DailyRandom;

public class MinimumFallingPathSum {
    public static int solve1(int i, int last, int[][] grid, int[][] dp)
    {
        //Base condition
        if(i==0)
        {
            int ans = Integer.MAX_VALUE;
            for(int j=0;j<grid.length;j++)
            {
                if(j!=last)
                    ans = Math.min(ans,grid[i][j]);
            }
            return ans;
        }
        if(dp[i][last]!=-1)
        {
            return dp[i][last];
        }
        int ans = Integer.MAX_VALUE;
        for(int j=0;j<grid[i].length;j++)
        {
            if(j!=last)
            {
                ans= Math.min(ans, grid[i][j] + solve1(i-1,j,grid,dp));
            }
        }
        return dp[i][last]=ans;

    }


    public static int solve2(int[][] grid)
    {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n][m+1];

        for(int i=0;i<n;i++)
        {
            for(int last=0;last<=m;last++)
            {
                dp[i][last] = Integer.MAX_VALUE;

                for(int j=0;j<m;j++)
                {
                    if(j!=last)
                    {
                        if(i==0)
                        {
                            dp[i][last]= Math.min( dp[i][last], grid[i][j]);
                        }
                        else
                        {
                            dp[i][last]= Math.min( dp[i][last], grid[i][j] + dp[i-1][j]);
                        }

                    }
                }
            }

        }
        return dp[n-1][3];

    }

    public static int minFallingPathSum(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        int[][] mm = new int[n][m+1];

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<=m;j++)
            {
                mm[i][j]=-1;
            }
        }
       // mm[0][0] = 0;
//        return solve1(n-1,m,grid,mm);
        return solve2(grid);
    }
    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        //int[][] grid = new int[][]{{2,2,1,2,2},{2,2,1,2,2},{2,2,1,2,2},{2,2,1,2,2},{2,2,1,2,2}};
        int ans = minFallingPathSum(grid);
       System.out.println(ans);
    }
}
