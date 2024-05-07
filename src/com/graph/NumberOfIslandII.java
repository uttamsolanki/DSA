package com.graph;

import java.util.Arrays;

public class NumberOfIslandII {
    public static int[] numberOfIslandII(int n, int m, int [][]queries, int q) {
        // Write your code here.

        return new int[]{1,2};
    }

    public static void main(String[] args) {
        int n=3;
        int m=4;
        int[][] query = new int[][]{
                {1,1},
                {1,2},
                {2,3}
        };
        int q = 3;
        int[] ans = numberOfIslandII(n,m,query,q);
        System.out.println(Arrays.toString(ans));
    }
}
