package com.arrays;

import java.util.Arrays;

public class RotateMatrix90 {

    public static void solution2(int[][] matrix)
    {
        int n= matrix.length;
        int m = matrix[0].length;

        //transpose Matrix
        for(int i=0;i<n;i++)
        {
            for(int j=i;j<m;j++)
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }


        // Reverse row
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m/2;j++)
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][m-j-1];
                matrix[i][m-j-1] = temp;
            }
        }

        for(int i=0;i<n;i++)
        {
            System.out.println(Arrays.toString(matrix[i]));
        }

    }
    public static void solution1(int[][] matrix)
    {
        int n= matrix.length;
        int m = matrix[0].length;
        int[][] ans = new int[n][m];


        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m/2;j++)
            {
                ans[i][j] = matrix[n-i-1][j];
            }
        }

        for(int i=0;i<n;i++)
        {
            System.out.println(Arrays.toString(matrix[i]));
        }

    }
    public static void main(String[] args) {
        int[][] matrix =  new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        solution2(matrix);
    }
}
