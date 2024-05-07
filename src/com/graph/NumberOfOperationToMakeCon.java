package com.graph;

import java.util.ArrayList;

class DisjointSetAl{

    ArrayList<Integer> rank,parent;
    DisjointSetAl(int n)
    {
        rank = new ArrayList<>();
        parent = new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            rank.add(0);
            parent.add(i);
        }
    }

    public  int findParent(int node)
    {
        int cParent =  parent.get(node);
        if(cParent==node) return node;
        int nextParent =  findParent(cParent);
        parent.set(node,nextParent);
        return nextParent;
    }

    public void union(int u,int v)
    {
        int alp_u = findParent(u);
        int alp_v =  findParent(v);

        if(alp_u==alp_v) return;

        int rank_u =  rank.get(alp_u);
        int rank_v = rank.get(alp_v);

        if(rank_u<rank_v)
        {
            parent.set(alp_u,alp_v);
        }
        else if(rank_v<rank_u)
        {
            parent.set(alp_v,alp_u);
        }
        else {
            parent.set(alp_v,alp_u);
            rank.set(alp_u,rank_u+1);
        }

    }
}
public class NumberOfOperationToMakeCon {
    public static int makeConnected(int n, int[][] connections) {

        DisjointSetAl ds = new DisjointSetAl(n);

        int extraEdges = 0;
        for(int i=0;i<connections.length;i++)
        {
            if(ds.findParent(connections[i][0])==ds.findParent(connections[i][1]))
            {
                extraEdges++;
            }else {
                ds.union(connections[i][0],connections[i][1]);
            }

        }
        //total component count
        int count=0;
        for(int i=0;i<n;i++)
        {
            if(i==ds.findParent(i)) count++;
        }

        //Minimum edge required to connect component
        int requiredEdge = count-1;

        if(extraEdges>=requiredEdge)
        {
            return requiredEdge;
        }
        return -1;
    }
    public static void main(String[] args) {
        int n =6;
        int[][] connections = new int[][]{
                {0,1},{0,2},{0,3},{1,2},{1,3}
        };

        int ans = makeConnected(n,connections);
        System.out.println(ans);
    }
}
