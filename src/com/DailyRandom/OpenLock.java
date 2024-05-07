package com.DailyRandom;

import java.util.*;

public class OpenLock {

    static class Pair{
        String lock;
        int turn;
        Pair(String a, int b)
        {
            lock = a;
            turn = b;
        }
    }

    public static int openLock(String[] deadends, String target) {

        HashSet<String> set =  new HashSet<>();

        for(int i=0;i<deadends.length;i++)
        {
            set.add(deadends[i]);
        }

        if(set.contains("0000")) return -1;

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair("0000",0));
        set.add("0000");

        while(!q.isEmpty())
        {
            Pair p = q.poll();

            if(p.lock.equals(target)) return p.turn;

            char[] temp = p.lock.toCharArray();

            for(int i=0;i<4;i++)
            {
                int intval = (((int) temp[i]) - '0');
                int inc =  (intval +1)%10;
                temp[i] = (char) (inc + '0');
                String incStr = new String(temp);
                if(!set.contains(incStr))
                {
                    q.add(new Pair(incStr,p.turn + 1));
                    set.add(incStr);
                }

                int dec = (intval -1 + 10)%10;
                temp[i] = (char) (dec+'0');
                String decStr = new String(temp);
                if(!set.contains(decStr))
                {
                    q.add(new Pair(decStr,p.turn + 1));
                    set.add(decStr);
                }
                temp[i] = (char) (intval + '0');
            }


        }


        return -1;

    }

    public static void main(String[] args) {
        String[] deadends =  new String[]{"0201","0101","0102","1212","2002"};
        //String[] deadends =  new String[]{"8888"};
        String target = "0202";
        int ans = openLock(deadends,target);
        System.out.println(ans);
    }
}
