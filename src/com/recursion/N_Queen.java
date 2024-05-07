package com.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class N_Queen {

    public static boolean canPlace(char[][] board,int r, int c, int[] rows, int[] cols, int n)
    {
        //if(r>=n || r<0 || c<0 || c<n) return false;

        if(rows[r]==1 || cols[c]==1 ) return false;

        int j1 = r, j2 = r;
        for(int i=c;i>=0;i--)
        {
            //upper diagonal
            if(i>=0 && j1>=0 && board[j1--][i]=='Q')
            {
                return false;
            }

            //Lower diagonal
            if(i>=0 && j2<n && board[j2++][i]=='Q')
            {
                return false;
            }

        }
        return true;
    }
    public static void solve(char[][] board, int c, int[] rows, int[] cols, int n, List<List<String>> ans)
    {
        if(c==n)
        {
            List<String> list = new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                String string = new String(board[i]);
                list.add(string);
            }
            ans.add(list);
            return;
        }

        for(int r=0;r<n;r++)
        {
            if(canPlace(board,r,c,rows,cols,n))
            {
                board[r][c] = 'Q';
                rows[r] = 1;
                cols[c] = 1;
                solve(board,c+1,rows,cols,n,ans);
                board[r][c] = '.';
                rows[r] = 0;
                cols[c] = 0;
            }
        }
    }
    public static  List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        int[] rows = new int[n];
        int[] cols = new int[n];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(board[i],'.');
        }

        List<List<String>> ans = new ArrayList<>();

        solve(board,0,rows,cols,n,ans);

        HashSet<List<String>> set = new HashSet<>();
        for(List<String> s:ans)
        {
            if(!set.contains(s))
            {
                set.add(s);
                System.out.println(s.toString());
            }


        }
        return ans;
    }
    public static void main(String[] args) {
        solveNQueens(5);
    }
}
