package com.arrays;

import java.util.Arrays;
import java.util.SortedMap;

public class SetMatrixToZero {



    // remove extra space
    public static void solutions2 (int[][] matrix)
    {
        int col0 = 1;
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(matrix[i][j]==0)
                {

                    matrix[i][0]=0;

                    if(j==0)
                    {
                        col0=0;
                    }else
                    {
                        matrix[0][j]=0;
                    }
                }
            }
        }


        for(int i=1;i<n;i++)
        {
            for(int j=1;j<m;j++)
            {
                if(matrix[i][0]==0 || matrix[0][j]==0)
                {
                    matrix[i][j]=0;
                }
            }
        }

        if(matrix[0][0]==0)
        {
            for(int j=0;j<m;j++)
            {
                matrix[0][j] = 0;
            }
        }


        if(col0==0)
        {
            for(int i=0;i<n;i++)
            {
                matrix[i][0] = 0;
            }
        }
        for(int i=0;i<n;i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

    }
    public static void solutions1 (int[][] matrix)
    {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] row = new int[n];
        int[] col = new int[m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(matrix[i][j]==0)
                {
                    row[i]=1;
                    col[j]=1;
                }
            }
        }

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(row[i]==1 || col[j]==1)
                {
                    matrix[i][j] = 0;
                }
            }
        }



        for(int i=0;i<n;i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
    public static void main(String[] args) {
        int[][] matrix =  new int[][]{
                {0,1,1},
                {1,1,1},
                {1,1,1}
        };

        solutions2(matrix);

    }
}
