package com.graph;

import java.util.ArrayList;

public class DisjointSet {
    protected  ArrayList<Integer> rank,parent,size;
    DisjointSet(int n)
    {
        // this will be used for rank
        rank = new ArrayList<>();
        // this will be used to parent that will be utilized to find Parent
        parent = new ArrayList<>();
        // this will be used for union by size algo
        size = new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            // Rank will assign later as they join
            rank.add(0);
            // Node will be their own parent
            parent.add(i);
            // consider node itself at Initial level
            size.add(1);
        }
    }
    public int findParent(int node){
        int cParent = parent.get(node);

        if(cParent==node) return node;

        int nextParent =  findParent(cParent);
        parent.set(node,nextParent);
        return nextParent;
    }

    public void unionByRank(int u, int v)
    {
        int alp_u = findParent(u);
        int alp_v = findParent(v);

        //if parent are same then its in same group
        if(alp_u == alp_v) return;

        int rank_u = rank.get(alp_u);
        int rank_v = rank.get(alp_v);


        if(rank_u<rank_v)
        {
            parent.set(alp_u,alp_v);
        }
        else if(rank_u>rank_v)
        {
            parent.set(alp_v,alp_u);
        }
        else
        {
            //if rank is same then either join one to another and increase new parent rank
            parent.set(alp_v,alp_u);
            rank.set(alp_u,rank_u+1);
        }
    }

    public void unionBySize(int u, int v)
    {
        int alp_u = findParent(u);
        int alp_v = findParent(v);

        //if parent are same then its in same group
        if(alp_u == alp_v) return;

        int size_u =  size.get(alp_u);
        int size_v =  size.get(alp_v);

       if(size_u<size_v)
        {
            parent.set(alp_u,alp_v);
            size.set(alp_v,size_u+size_v);
        }
        else
        {
            parent.set(alp_v,alp_u);
            size.set(alp_u,size_u+size_v);
        }
    }
}
