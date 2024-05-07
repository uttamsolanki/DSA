package com.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {



    public static boolean DFS(ArrayList<ArrayList<Integer>> adj,int node,int[] nodeColor,int color)
    {
        nodeColor[node] = color;

        for(int adjNode:adj.get(node))
        {
            if(nodeColor[adjNode]==-1)
            {
                if(DFS(adj,adjNode,nodeColor,color^1)==false) return  false;
            }
            else if(nodeColor[adjNode]==color){
                return false;
            }
        }
        return true;
    }
    public static boolean BFS(ArrayList<ArrayList<Integer>> adj,int i,int[] color){

        Queue<Integer> q = new LinkedList<>();

        q.add(i);
        color[i] = 0;
        while (!q.isEmpty())
        {
            int node = q.poll();
            for(int adjNode:adj.get(node))
            {
                if(color[adjNode]==-1)
                {
                    q.add(adjNode);
                    color[adjNode] = color[node]^1;
                }
                else if(color[adjNode] == color[node])
                {
                    return  false;
                }
            }
        }
        return true;
    }
    public static boolean isBipartite(int[][] graph) {
        ArrayList<ArrayList<Integer>> adjList =  new ArrayList<>();
        int[] vis = new int[graph.length];

        for(int i=0;i<graph.length;i++)
        {
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<graph.length;i++)
        {
            for(int j=0;j<graph[i].length;j++)
            {
                adjList.get(i).add(graph[i][j]);
                adjList.get(graph[i][j]).add(i);
            }
        }

        for(int i=0;i<graph.length;i++)
        {
            vis[i] = -1;
        }
//        for(int i=0;i<graph.length;i++)
//        {
//           if(vis[i]==-1)
//           {
//               if(BFS(adjList,i,vis)==false) return false;
//           }
//        }

        for(int i=0;i<graph.length;i++)
        {
            if(vis[i]==-1)
            {
                if(DFS(adjList,i,vis,0)==false) return false;
            }
        }


        return true;
    }

    public static void main(String[] args) {
        int[][] graph = new int[][]{{1,3},{0,2},{1,3},{0,2}};
        boolean ans =  isBipartite(graph);
        System.out.println(ans);
    }
}
