package com.recursion;

public class TOH {

    /**
     * @param n : No of disk
     * @param A : From
     * @param B : Auxiliary rod
     * @param C : To
     */
    public static void TOH(int n,char A, char B, char C) {

        if(n>0)
        {
            TOH(n-1,A,C,B);
            System.out.println("Move a disk from "+A+" to "+C);
            TOH(n-1,B,A,C);
        }
    }

    public static void main(String[] args) {
        TOH(3,'A', 'B', 'C');
    }
}
