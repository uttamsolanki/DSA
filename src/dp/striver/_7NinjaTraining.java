package dp.striver;

import java.util.Arrays;

public class _7NinjaTraining {

    public static  int f1(int[][] grid,int i, int lastIndex,int[][] dp)
    {
        if(i==0)
        {
            int max = 0;

            for(int c=0;c<3;c++)
            {
                // Avoid consecutive events
                if(c!= lastIndex)
                    max = Math.max(max, grid[i][c] );
            }
            return  max;
        }

        if(dp[i][lastIndex] != -1)
        {
            return dp[i][lastIndex];
        }
        int max = Integer.MIN_VALUE;

        for(int c=0;c<3;c++)
        {
            // Avoid consecutive events
            if(c!= lastIndex)
                max = Math.max(max, f1(grid,i-1,c,dp) + grid[i][c] );
        }
        return dp[i][lastIndex]=max;
    }

    // SC: O(N) + O(N*4)
    public static int f2(int[][] grid)
    {
        int n =  grid.length;
        int[][] dp =  new int[n][4];

        // Consider for 1 row data

        dp[0][0] = Math.max(grid[0][1],grid[0][2]);
        dp[0][1] = Math.max(grid[0][0],grid[0][2]);
        dp[0][2] = Math.max(grid[0][0],grid[0][1]);

        // Let assume did not pic any task previously
        dp[0][3] = Math.max(grid[0][0],Math.max(grid[0][1],grid[0][2]) );

        for(int day=1;day<n;day++)
        {
            for(int ac=0;ac<4;ac++)
            {
                dp[day][ac] = 0;
                for(int c=0;c<3;c++)
                {
                    // Avoid consecutive events
                    if(c!= ac)
                        dp[day][ac] = Math.max(dp[day][ac],dp[day-1][c] + grid[day][c]);
                }
            }
            System.out.println(Arrays.toString(dp[day]));

        }
        return dp[n-1][3];
    }

    // Space Optimization
    public static int f3(int[][] grid)
    {

        int[] prev =  new int[grid[0].length+1];
        for(int i=1;i<=grid.length;i++)
        {
            int[] curr =  new int[grid[0].length+1];
            for(int j=0;j<=grid[0].length;j++)
            {
                int max = Integer.MIN_VALUE;
                for(int c=1;c<=grid[0].length;c++)
                {
                    // Avoid consecutive events
                    if(c!= j)
                        max = Math.max(max,prev[c-1] + grid[i-1][c-1]);
                }
                curr[j]=max;
            }
            prev =  curr;
        }

        return prev[grid[0].length-1];
    }
    public static void main(String[] args) {
        int[][] grid =  new int[][]{{10,40,70}, {20,50,80},{30,60,90}};

        int n = grid.length;

        int[][] mm =  new int[n][4];

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<4;j++)
            {
                mm[i][j] = -1;
            }
        }
       // int ans =f1(grid,grid.length-1,3,mm);

        int ans =f2(grid);
        System.out.println(ans);
    }
}
