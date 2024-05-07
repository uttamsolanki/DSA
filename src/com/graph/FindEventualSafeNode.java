package com.graph;

import java.util.*;

public class FindEventualSafeNode {

    public static List<Integer> BFS(ArrayList<ArrayList<Integer>> adjList)
    {
        int n = adjList.size();
        ArrayList<ArrayList<Integer>> reverseList = new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            reverseList.add(new ArrayList());
        }
        int[] indegree = new int[n];
        for(int i=0;i<n;i++)
        {
            for(int adjNode:adjList.get(i))
            {
                reverseList.get(adjNode).add(i);
                indegree[i]++;
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

        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty())
        {
            int node = q.poll();
            ans.add(node);

            for(int adjNode:reverseList.get(node))
            {
                indegree[adjNode]--;
                if(indegree[adjNode]==0)
                {
                    q.add(adjNode);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
    public static boolean DFS(ArrayList<ArrayList<Integer>> adjList,int node,int[] vis,int[] path ,int[] check)
    {
        vis[node] = 1;
        path[node]=1;
        for(int adjNode: adjList.get(node))
        {
            if(vis[adjNode]==0)
            {
                if(DFS(adjList,adjNode,vis,path,check)==true) return true;
            }
            else if(path[adjNode]==1)
            {
                return true;
            }
        }

        path[node]=0;
        check[node]=1;
        return false;
    }
    public static List<Integer>  eventualSafeNodes(int[][] graph) {


        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        int n = graph.length;

        for(int i=0;i<n;i++)
        {
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<graph[i].length;j++)
            {
                adjList.get(i).add(graph[i][j]);
            }
        }

//        int[] vis = new int[n];
//        int[] check = new int[n];
//        int[] path = new int[n];
//        for(int i=0;i<n;i++)
//        {
//            if(vis[i]==0)
//                DFS(adjList,i,vis,path,check);
//        }

//        List<Integer> ans = new ArrayList<>();
//
//        for(int i=0;i<n;i++)
//        {
//            if(check[i]==1) {
//                ans.add(i);
//            }
//        }
//        return ans;

        return  BFS(adjList);
    }

    public static void main(String[] args) {
        int[][] graphs = new int[][]{{1,2},{2,3},{5},{0},{5},{},{}};
        List<Integer> ans = eventualSafeNodes(graphs);
        System.out.println(ans.toString());
    }
}
