package com.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class AlienDictionary {

    public static void difference(String s1, String s2, ArrayList<ArrayList<Integer>> adjList)
    {
        int n = Math.min(s1.length(),s2.length());
        int i=0;
        while (i<n)
        {
            if(s1.charAt(i)!=s2.charAt(i))
            {
                adjList.get(s1.charAt(i)-'a').add(s2.charAt(i)-'a');
                break;
            }
            i++;
        }
    }
    public static String getAlienLanguage(String []dictionary, int k) {

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for(int i=0;i<k;i++)
        {
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<dictionary.length-1;i++)
        {
            difference(dictionary[i],dictionary[i+1],adjList);
        }

        for(int i=0;i<k;i++)
        {
            System.out.println(adjList.get(i).toString());
        }

        int[] indegree =  new int[k];

        for(int i=0;i<k;i++)
        {
            for(int adjNode:adjList.get(i))
            {
                indegree[adjNode]++;
            }
        }

        Queue<Integer> q =  new LinkedList<>();

        for(int i=0;i<k;i++)
        {
            if(indegree[i]==0)
            {
                q.add(i);
            }
        }

        StringBuilder builder = new StringBuilder();

        while (!q.isEmpty())
        {
            int node = q.poll();
            builder.append((char)(node+'a'));

            for(int adjNode:adjList.get(node))
            {
                indegree[adjNode]--;
                if(indegree[adjNode]==0)
                {
                    q.add(adjNode);
                }
            }

        }
      //  System.out.println(topoSort.toString());

        return builder.toString();
    }

    public static void main(String[] args) {

        String[] dict = new String[]{"ccacacc", "babaaccb", "baacaaba","aaabcbaabb"};
        String ans = getAlienLanguage(dict,3);

        System.out.println(ans);

    }
}
