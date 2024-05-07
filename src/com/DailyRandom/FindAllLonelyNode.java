package com.DailyRandom;


import java.util.ArrayList;
import java.util.Collections;

class Tree
{
    class Node
    {
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }
    public void DFS1(Node node,ArrayList<Integer> ans)
    {
        if(node==null) return;

        if(node.left==null && node.right==null )
        {
            return;
        }

        if(node.left ==null){

            ans.add(node.right.data);
            //System.out.println(node.right.data);
        }

        if(node.right ==null){

            ans.add(node.left.data);
            //System.out.println(node.left.data);
        }


        DFS(node.left,ans);

        DFS(node.right,ans);

    }

    public void DFS(Node node,ArrayList<Integer> ans)
    {
        if(node==null) return;

        if(node.left!=null && node.right!=null )
        {

            DFS(node.left,ans);

            DFS(node.right,ans);
        }

        else if(node.left !=null){

            ans.add(node.left.data);
            DFS(node.left,ans);
        }

        else if(node.right !=null){

            ans.add(node.right.data);
            DFS(node.right,ans);
        }

    }
    ArrayList<Integer> noSibling(Node node)
    {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        DFS(node,ans);
        if(ans.size()==0)
        {
            ans.add(-1);
        }
        Collections.sort(ans);
        return ans;
    }
}
public class FindAllLonelyNode {

    public static void main(String[] args) {
        System.out.println("Print only lonely node");
    }
}
