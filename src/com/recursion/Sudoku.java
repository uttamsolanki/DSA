package com.recursion;

import java.util.Arrays;

public class Sudoku {


    public static boolean canPlace(char[][] board,char ch,int r,int c)
    {
        // Check rows and cols
        for(int i=0;i<9;i++)
        {
            if(board[i][c]==ch || board[r][i]==ch)
            {
                return false;
            }

            //Check 3X3 grid
            int nRow = 3*(r/3) + i/3 ;
            int nCol = 3*(c/3) + i%3;
            if(board[nRow][nCol]==ch)
            {
                return false;
            }
        }


        return true;
    }
    public static boolean solveSudoku(char[][] board) {

        for(int r=0;r<9;r++)
        {
            for(int c=0;c<9;c++)
            {
                if(board[r][c]=='.') {
                    for (char ch = '1'; ch <= '9'; ch++) {
                        if (canPlace(board, ch, r, c)) {
                            board[r][c] = ch;

                            if (solveSudoku(board)) {
                                return true;
                            } else {
                                board[r][c] = '.';
                            }

                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        char[][] board = new char[][]{{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        solveSudoku(board);
        for(char[] c:board)
        {
            System.out.println(Arrays.toString(c));
        }
    }
}
