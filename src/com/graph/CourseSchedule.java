package com.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {


    public  static boolean BFS(ArrayList<ArrayList<Integer>> adjList,int n)
    {
        int[] indegree =  new int[n];

        for(int i=0;i<n;i++)
        {
            for(int adjNode:adjList.get(i))
            {
                indegree[adjNode]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<n;i++)
        {
            if(indegree[i]==0)
            {
                q.add(i);
            }
        }

        List<Integer> topoSort = new ArrayList<>();
        while (!q.isEmpty())
        {
            int node  = q.poll();

            topoSort.add(node);

            for(int adjNode:adjList.get(node))
            {
                indegree[adjNode]--;
                if(indegree[adjNode]==0)
                {
                    q.add(adjNode);
                }
            }
        }

        if(topoSort.size()==n) return true;
        return false;


    }
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for(int i=0;i<numCourses;i++)
        {
            adjList.add(new ArrayList<>());
        }

        for(int[] edge:prerequisites)
        {
            adjList.get(edge[0]).add(edge[1]);
        }

        return BFS(adjList,numCourses);

    }
    public static void main(String[] args) {
        int n = 2;
        int[][] preReq =  new int[][]{{1,0},{0,1}};

        boolean ans =  canFinish(n,preReq);
        System.out.println(ans);
    }
}
