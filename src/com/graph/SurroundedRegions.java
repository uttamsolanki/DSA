package com.graph;

import java.util.Arrays;

public class SurroundedRegions {

    static class Solution {
        public void DFS(char[][] board, int[][] vis,int i,int j, int n, int m)
        {
            vis[i][j]=1;

            int[] dx =  new int[]{0,-1,0,1};
            int[] dy = new int[]{-1,0,1,0};

            for(int k=0;k<4;k++)
            {
                int nx =  i + dx[k];
                int ny =  j + dy[k];
                if(nx>=0 && nx<n && ny>=0 && ny<m && vis[nx][ny]==0 && board[nx][ny]=='O')
                {
                    DFS(board,vis,nx,ny,n,m);
                }
            }

        }
        public void solve(char[][] board) {
            int n =  board.length;
            int m= board[0].length;

            int[][] vis = new int[n][m];

            for(int i=0;i<n;i++)
            {
                for(int j=0;j<m;j++)
                {
                    if(i!=0 && i != n-1 && j!=0 && j != m-1)
                    {
                        continue;
                    }
                    if(board[i][j]=='O')
                    {
                        DFS(board,vis,i,j,n,m);
                    }
                }
            }

            for(int i=0;i<n;i++)
            {
                for(int j=0;j<m;j++)
                {
                    if(board[i][j]=='O' && vis[i][j]==0)
                    {
                        board[i][j] = 'X';
                    }
                }
            }
        }
    }
    public static void main(String[] args) {

        char[][] board = new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};

        (new Solution()).solve(board);

        for(int i=0;i<board.length;i++)
        {
            System.out.println(Arrays.toString(board[i]));
        }

    }
}
