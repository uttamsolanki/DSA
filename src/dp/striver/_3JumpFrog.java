package dp.striver;


public class _3JumpFrog {
    public  static int f1(int n, int[] e)
    {
        if(n<0)
        {
            return Integer.MAX_VALUE;
        }
        if(n==0)
        {
            return 0;
        }

        int step1 = Math.abs( e[n] - e[n-1] ) + f1(n-1,e);

        int step2 = Integer.MAX_VALUE;

        if(n>1)
            step2= Math.abs( e[n] - e[n-2] ) + f1(n-2,e);

        return Math.min(step1,step2);
    }

    public static int f2(int[] e)
    {
        int n =  e.length;
        int[] dp = new int[n];

        dp[0] = 0;

        for(int i=1;i<n;i++)
        {
            int step1 =  Math.abs(e[i] - e[i-1]) + dp[i-1];
            int step2 = Integer.MAX_VALUE;
            if(i>1)
            step2 =  Math.abs(e[i] - e[i-2]) + dp[i-2];
            dp[i] =  Math.min(step1,step2);
        }
        return dp[n-1];
    }

    public static int minCostClimbingStairs(int[] cost)
    {
        int n =  cost.length;

        int[] dp = new int[n];
        for(int i=0;i<n;i++)
        {

            // Steps either 1 or 0 to reach top
            if(i<2) dp[i] = cost[i];

            else dp[i] = cost[i] +  Math.min(dp[i-1],dp[i-2]);
        }

        return dp[n-1];
    }

    public static void main(String[] args) {

        int[] e = new int[]{10,20,30,10};
        //System.out.println(f1(3,e));
        //System.out.println(f2(e));

        int[] cost = new int[]{10,15,20};

        System.out.println(minCostClimbingStairs(cost));
    }
}
