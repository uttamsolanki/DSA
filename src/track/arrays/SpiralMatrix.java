package track.arrays;

import java.util.ArrayList;

/**
 * Problem: You are given a rectangular matrix, and your task is to return an array while traversing the matrix in spiral form.
 * Link: https://www.geeksforgeeks.org/problems/spirally-traversing-a-matrix-1587115621/1
 */
public class SpiralMatrix {
    public static ArrayList<Integer> approach1(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int left =0, top=0;
        int bottom = n-1, right = m-1;

        ArrayList<Integer> list = new ArrayList<>();

        while (true)
        {

            if(left>right) break;
            // left to right to read row from top
            for(int i=left;i<=right;i++)
            {
                list.add(mat[top][i]);
            }
            top++;

            if(top>bottom) break;
            //top to bottom to read column from right
            for(int i=top;i<=bottom;i++)
            {
                list.add(mat[i][right]);
            }
            right--;

            if(left>right) break;
            //right to left to read row from bottom
            for(int i=right;i>=left;i--)
            {
                list.add(mat[bottom][i]);
            }
            bottom--;
            // Bottom to top to read column from left
            if(top>bottom) break;
            for(int i=bottom;i>=top;i--)
            {
                list.add(mat[i][left]);
            }
            left++;

        }

        return list;
    }

    public static void main(String[] args) {
//        int[][] mat = new int[][]{
//                {32,44,27,23},
//                {54,28,50,62}
//        };
//
        int[][] mat = new int[][]{
                {1, 2, 3,4},
                {5, 6, 7,8},
                {9,10,11,12}
        };
        ArrayList<Integer> ans = approach1(mat);
        System.out.println(ans);
    }
}
