package com.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeOverLappingSubIntervals {

    public static void Approach1(int[][] intervals)
    {
        Arrays.sort(intervals,(a,b)-> {
            if(a[0]==b[0])
            {
                return a[1] - b[1];
            }
            return a[0]-b[0];
        });

        ArrayList<int[]> ans = new ArrayList<>();

        for(int i=0;i<intervals.length;i++)
        {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if(ans.size()>0 && end<=ans.get(ans.size()-1)[1])
            {
                continue;
            }
            for(int j=i+1;j<intervals.length;j++)
            {
                if(intervals[j][0]<=end)
                {
                    end = Math.max(end,intervals[j][1]);
                }
                else {
                    break;
                }
            }
            ans.add(new int[]{start,end});
        }

        for(int i=0;i<ans.size();i++)
        {
            System.out.println(Arrays.toString(ans.get(i)));
        }
        //System.out.println(ans);

    }

    public static void Approach2(int[][] intervals)
    {
        Arrays.sort(intervals,(a,b)-> {
            if(a[0]==b[0])
            {
                return a[1] - b[1];
            }
            return a[0]-b[0];
        });

        ArrayList<int[]> ans = new ArrayList<>();

        for(int i=0;i<intervals.length;i++)
        {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if(ans.size()==0 || start>ans.get(ans.size()-1)[1])
            {
                ans.add(new int[]{start,end});
            }
            else
            {
                ans.get(ans.size()-1)[1] = Math.max(end,ans.get(ans.size()-1)[1]);
            }
        }

        for(int i=0;i<ans.size();i++)
        {
            System.out.println(Arrays.toString(ans.get(i)));
        }
        //System.out.println(ans);

    }
    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                {1,3},{2,6},{8,10},{8,9},{15,18}
        };

        Approach2(intervals);
    }
}
