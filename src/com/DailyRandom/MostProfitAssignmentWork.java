package com.DailyRandom;

import java.util.Arrays;
import java.util.Comparator;

public class MostProfitAssignmentWork {

  private static class Pair{
        int d;
        int p;
        Pair(int d,int p)
        {
            this.d = d;
            this.p = p;
        }
    }
    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {

        Pair[] pair = new Pair[difficulty.length];

        for(int i=0;i<difficulty.length;i++)
        {
            pair[i] = new Pair(difficulty[i],profit[i]);
        }

        Arrays.sort(pair, new Comparator<Pair>() {
            public int compare(Pair p1, Pair p2) {
                return p2.p - p1.p;
            }
        });


        Arrays.sort(worker);

        int fast = worker.length-1;

        int maxProfit = 0;
        for(int i=0;i<difficulty.length;i++){

            int diff = pair[i].d;

            while (fast>=0 && worker[fast]>=diff )
            {
                maxProfit += pair[i].p;
                fast--;
            }

            if(fast == -1)
            {
                break;
            }

        }
        System.out.println(maxProfit);



        return maxProfit;

    }
    public static void main(String[] args) {
        int[] difficutly = new int[]{85,47,5,10};
        int[] profit = new int[]{24,66,99,100};
        int[] worker = new int[]{40,25,25};

        int ans = maxProfitAssignment(difficutly,profit,worker);
       // System.out.println(ans);

    }
}
