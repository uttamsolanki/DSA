package com.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class DetectCycle {

    static  class  Solution {

        public boolean DFS(ArrayList<ArrayList<Integer>> adjlist,int node, int[] vis,int parent)
        {
            vis[node] = 1;
            for(int adjnode:adjlist.get(node))
            {

                if(vis[adjnode]==0)
                {
                    if (DFS(adjlist,adjnode,vis,node)) return true;
                }
                else if(adjnode!=parent)
                {
                    return true;
                }
            }

            return false;
        }
        public boolean BFS(ArrayList<ArrayList<Integer>> adjlist,int currentNode,int[] vis)
        {
            class Pair{
                int node;
                int parent;
                Pair(int node, int parent)
                {
                    this.node = node;
                    this.parent = parent;
                }
            }
            Queue<Pair> q = new LinkedList<>();

            q.add(new Pair(currentNode,-1));
            vis[currentNode]=1;
            while (!q.isEmpty())
            {
                Pair pair = q.poll();
                int node= pair.node;
                int parent = pair.parent;

                for(int adjnode: adjlist.get(node))
                {
                    if(vis[adjnode]==0)
                    {
                        vis[adjnode]=1;
                        q.add(new Pair(adjnode,node));
                    }
                    else if(adjnode!=parent)
                    {
                        return true;
                    }
                }



            }

            return false;
        }
        public  String cycleDetection(int[][] edges, int n, int m) {

            ArrayList<ArrayList<Integer>> adjlist = new ArrayList<>();

            for(int i=0;i<=n;i++)
            {
                adjlist.add(new ArrayList<>());
            }

            for(int i=0;i<m;i++)
            {
                adjlist.get(edges[i][0]).add(edges[i][1]);
                adjlist.get(edges[i][1]).add(edges[i][0]);
            }

            for(int i=1;i<=n;i++)
            {
                System.out.println(adjlist.get(i).toString());
            }

            // Algo start here
            int[] vis = new int[n+1];

//        for(int i=1;i<=n;i++)
//        {
//            if(vis[i]==1) continue;
//            if(BFS(adjlist, i, vis))
//            {
//               return "Yes";
//            }
//        }

            for(int i=1;i<=n;i++)
            {
                if(vis[i]==1) continue;
                if(DFS(adjlist, i, vis,-1))
                {
                    return "Yes";
                }
            }

            return "No";
        }

    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] edges = new int[][]{{2,1},{3,1}};
        String ans=  s.cycleDetection(edges,3,2);
        System.out.println(ans);
    }
}
