package com.graph;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumOperation {

   static class Pair{
       int x,y;
       Pair(int a, int b)
       {
           x=a;
           y=b;
       }
   }
    public static int minimumOperations(int n, int start, int end, int []a) {
        // Write your code here

        if(start==end) return 0;

        int[] dist =  new int[100000];
        for(int i=0;i<100000;i++)
        {
            dist[i]= (int)1e9;
        }

        Queue<Pair> pq = new LinkedList<>();

        pq.add(new Pair(start,0));
        dist[start]=0;
        int mode = 100000;
        while (!pq.isEmpty())
        {
            Pair pair = pq.poll();
            int node = pair.x;
            int op = pair.y;

            for(int i=0;i<n;i++)
            {
                int multi =  (a[i]*node)%mode;
                int newOp = op+1;
                if(newOp<dist[multi] )
                {
                    dist[multi] = newOp;

                    if(multi==end) return newOp;

                    pq.add(new Pair(multi,newOp));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int start = 3;
        int end = 30;
        int n = 3;
        int[] a = new int[]{2,5,7};
        int ans =  minimumOperations(n,start,end,a);
        System.out.println(ans);
    }
}
