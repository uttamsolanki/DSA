package dp.striver;

import java.util.Arrays;

public class _8UniquePath {

    public static int f1(int m, int n, int[][] mm)
    {
        if(m<0 || n<0)
        {
            return 0;
        }
        if(m==0 && n==0)
        {
            return 1;
        }
        if(mm[m][n]!=-1)
        {
            return mm[m][n];
        }
        return mm[m][n] = f1(m-1,n,mm) + f1(m,n-1,mm);
    }

    public static int f2(int m, int n)
    {
        int[][] dp = new int[m][n];

        for(int i=0;i<m;i++)
        {
            dp[i][0] =1;
        }

        for(int i=0;i<n;i++)
        {
            dp[0][i] =1;
        }

        for(int i=1;i<m;i++)
        {
            for(int j=1;j<n;j++)
            {
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {

        int m=3,n=2;
        int[][] mm =  new int[m][n];
        for(int i=0;i<m;i++)
        {
            Arrays.fill(mm[i],-1);
        }
        //System.out.println( f1(m-1,n-1,mm) );

        System.out.println( f2(m,n) );
    }
}
