package com.graph;

public class DisjointAlgoCheck {
    public static void main(String[] args) {
        int n = 8;
        DisjointSet ds = new DisjointSet(n);
        ds.unionByRank(1,2);
        ds.unionByRank(2,3);
        ds.unionByRank(4,5);
        ds.unionByRank(6,7);
        ds.unionByRank(5,6);

        if(ds.findParent(3)==ds.findParent(7))
        {
            System.out.println("Same");
        }
        else {
            System.out.println("Not same");
        }

        ds.unionByRank(3,7);

        if(ds.findParent(3)==ds.findParent(7))
        {
            System.out.println("Same");
        }
        else {
            System.out.println("Not same");
        }
    }
}
