package com.DailyRandom;

import java.util.*;

public class FindMinHeightTrees {

    static class Pair{
        int first;
        int second;

        Pair(int first, int second)
        {
            this.first = first;
            this.second = second;
        }

    }
    public static int BFS(int node,int[] vis,ArrayList<ArrayList<Integer>> adjList)
    {

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(node,0));
        vis[node] = 1;
        int maxH = Integer.MIN_VALUE;

        while (!q.isEmpty())
        {
            Pair pair = q.poll();

            maxH = Math.max(maxH,pair.second);

            for(int adjNode:adjList.get(pair.first))
            {
                if(vis[adjNode]==0)
                {
                    q.add(new Pair(adjNode, pair.second+1));
                    vis[adjNode] =1;
                }
            }
        }

        return maxH;
    }
    public static  List<Integer> findMinHeightTrees1(int n, int[][] edges) {

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++)
        {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }

        List<Integer> ans = new ArrayList<>();
        HashMap<Integer,List<Integer>> map = new HashMap<>();

        for(int i=0;i<n;i++)
        {
            int[] vis =  new int[n];
            int h = BFS(i,vis,adjList);
            List<Integer> list=map.getOrDefault(h,new ArrayList<>());
            list.add(i);
            map.put(h,list);
        }

        for(Map.Entry<Integer,List<Integer>> set:map.entrySet())
        {
            return set.getValue();
        }
        return ans;
    }

    public static  List<Integer> findMinHeightTrees(int n, int[][] edges) {

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++)
        {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }

        int[]  edge_cnt =  new int[n];
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            if(adjList.get(i).size()==1)
            {
                q.add(i);
            }
            edge_cnt[i] = adjList.get(i).size();
        }


        while (!q.isEmpty())
        {
            int size = q.size();
            if(n<=2) {
                break;
            }
            for(int i=0;i<size;i++)
            {
                int node = q.poll();
                n--;
                for(int adjNode:adjList.get(node))
                {
                    edge_cnt[adjNode]-=1;
                    if(edge_cnt[adjNode]==1)
                    {
                        q.add(adjNode);
                    }
                }
            }
        }
        List<Integer> ans = new ArrayList<>();

        if(n==1){
            ans.add(0);
            return ans;
        }
        while (!q.isEmpty())
        {
            ans.add(q.poll());
        }

        return ans;
    }
    public static void main(String[] args) {
        int n = 6;
        int[][] edges = new int[][]{ {3,0},{3,1},{3,2},{3,4},{5,4} };

        List<Integer> ans = findMinHeightTrees(n,edges);

        System.out.println(ans.toString());
    }
}
