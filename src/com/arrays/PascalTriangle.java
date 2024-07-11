package com.arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    // We can use nCr formula
    // Simplified formula is (n/1) * (n/2) * (n/3) *....*((n-r+1))/r
    // Variation 1: Given row number r and column number c. Print the element at position (r, c) in Pascal’s triangle.
    //

    public static void variation1(int c, int r){

        int ans =1;
        for(int i=0;i<r;i++)
        {
           // ans *= ( (c-i)/(i+1));
            ans *= (c-i);
            ans /= (i+1);
        }

        System.out.println(ans);
    }

    //Given the row number n. Print the n-th row of Pascal’s triangle.
    public static void variation2(int n)
    {
        int ans =1;
        System.out.print(ans +" " );
        for(int i=0;i<n;i++)
        {
            ans *= (n-i);
            ans /= (i+1);

            System.out.print(ans +" " );
        }
    }

    //Given the number of rows n. Print the first n rows of Pascal’s triangle.
    public static void  variation3(int n)
    {
        for(int j=0;j<n;j++)
        {
            int ans =1;
            System.out.print(ans +" " );
            for(int i=0;i<j;i++)
            {
                ans *= (j-i);
                ans /= (i+1);
                System.out.print(ans +" " );
            }

            System.out.println();
        }

    }
    public static List<List<Integer>> generate(int numRows){
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<numRows;i++)
        {
            ans.add(new ArrayList<>());
        }
        ans.get(0).add(1);
        for(int i=1;i<numRows;i++)
        {
            ans.get(i).add(1);
            for(int j=0;j<ans.get(i-1).size()-1;j++)
            {
                int sum =  ans.get(i-1).get(j) + ans.get(i-1).get(j+1);
                ans.get(i).add(sum);
            }
            ans.get(i).add(1);
        }

        for(int i=0;i<ans.size();i++)
        {
           System.out.println(ans.get(i).toString());
        }

        return ans;
    }
    public static void main(String[] args) {
        int n= 5;
       // generate(n);
        // for n pass n-1 and  r pass r=r-1
        //variation1(5,2);

        variation3(n);
    }
}
