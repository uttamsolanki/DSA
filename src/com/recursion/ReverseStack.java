/**
 * Problem : You are given a stack St. You have to reverse the stack using recursion.
 * GFG Links: https://www.geeksforgeeks.org/problems/reverse-a-stack/1
 */
package com.recursion;

import java.util.Stack;

public class ReverseStack {
    static void pushlast(int ele,Stack<Integer> s)
    {
        if(s.isEmpty())
        {
            s.push(ele);
            return;
        }
        int topEle = s.pop();
        pushlast(ele,s);
        s.push(topEle);
    }
    static void reverse(Stack<Integer> s)
    {
        // add your code here
        if(s.isEmpty())
        {
            return;
        }

        int top = s.pop();
        reverse(s);
        pushlast(top,s);
    }

    public static void main(String[] args) {
        Stack<Integer> in =  new Stack<>();
        in.add(41);
        in.add(3);
        in.add(32);
        in.add(2);
        in.add(11);
        reverse(in);

        while (!in.isEmpty())
        {
            System.out.println(in.pop());
        }
    }
}
