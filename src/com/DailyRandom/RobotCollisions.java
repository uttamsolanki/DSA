package com.DailyRandom;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class RobotCollisions {
   static class Pair{
        int pos,index;
        Pair(int pos,int index)
        {
            this.pos = pos;
            this.index = index;
        }
    }

    public static List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        PriorityQueue<Pair> queue = new PriorityQueue<>((Pair a,Pair b) -> a.pos -b.pos);

        for(int i=0;i<positions.length;i++)
        {
            queue.add(new Pair(positions[i],i));
        }

        Stack<Integer> st = new Stack<>();
        while(!queue.isEmpty())
        {
            Pair  pair = queue.poll();
            int index = pair.index;
            int pos = pair.pos;
            char ch  =  directions.charAt(index);
            if(st.isEmpty())
            {
                st.push(index);
            }else
            {
                while(!st.isEmpty())
                {
                    int topIndex = st.pop();
                    int ch1 = directions.charAt(topIndex);
                    if((ch1 == 'R' && ch == 'L'))
                    {

                        if(healths[index]>healths[topIndex])
                        {
                            healths[index]--;
                            healths[topIndex] = -1;
                        }
                        else if(healths[index]<healths[topIndex])
                        {
                            healths[topIndex]--;
                            healths[index] = -1;
                            index = topIndex;
                        }
                        else
                        {
                            healths[topIndex] = -1;
                            healths[index] = -1;
                            break;
                        }
                    }
                    else
                    {

                        st.push(topIndex);
                        st.push(index);
                        break;
                    }
                }
            }

        }

        List<Integer> ans =  new ArrayList<>();
        for(int i=0;i<healths.length;i++)
        {
            if(healths[i]>0)
            {
                ans.add(healths[i]);
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] positions = new int[]{3,47};
        int[] healths =  new int[]{46,26};
        String directions ="LR";
        survivedRobotsHealths(positions,healths,directions);
    }
}
