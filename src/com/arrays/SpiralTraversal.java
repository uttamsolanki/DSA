package com.arrays;

public class SpiralTraversal {

    public static void solution1(int[][] matrix)
    {
        int top=0,left =0;
        int bottom = matrix.length-1,right =  matrix[0].length-1;

        while ( top<=bottom && left<=right)
        {
            // Top
            for(int i=left;i<=right;i++)
            {
                System.out.println(matrix[top][i]);
            }
            top++;

            // Right

            for(int i=top;i<=bottom;i++)
            {
                System.out.println(matrix[i][right]);
            }
            right--;

            // Bottom
            if(top<=bottom)
            {
                for(int i=right;i>=left;i--)
                {
                    System.out.println(matrix[bottom][i]);
                }
                bottom--;
            }

            // Left
            if(left<=right)
            {
                for(int i=bottom;i>=top;i--)
                {
                    System.out.println(matrix[i][left]);
                }
                left++;
            }

        }
    }
    public static void main(String[] args) {
        int[][] matrix =  new int[][]{
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 }
        };

        solution1(matrix);
    }
}
