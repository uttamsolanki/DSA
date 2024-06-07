package com.arrays;

import java.util.Arrays;

public class LargestLocalValueMatrix {

    public static int getMax(int[][] grid, int r, int c)
    {

        int max = Integer.MIN_VALUE;

        for(int i=r;i<r+3;i++)
        {
            for(int j=c;j<c+3;j++){
                max = Math.max(grid[i][j],max);
            }
        }
        return max;
    }
    public static int[][] largestLocal(int[][] grid) {

        int n = grid.length;

        int[][] ans = new int[n-2][n-2];

            for(int i=0;i<n-2;i++)
            {
                for(int j=0;j<n-2;j++)
                {
                    ans[i][j] = getMax(grid,i,j);
                }
            }

        return ans;

    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {9,9,8,1},
                {5,6,2,6},
                {8,2,6,4},
                {6,2,2,2}
        };
        int[][] ans  = largestLocal(grid);
        System.out.println(Arrays.toString(ans[1]));
    }
}
