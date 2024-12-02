/**
 * Problem: Given a stack, the task is to sort it such that the top of the stack has the greatest element.
 * GFG: https://www.geeksforgeeks.org/problems/sort-a-stack/1
 */
package com.recursion;

import java.util.Stack;

public class SortStack {
    public static void findAndInsert(int topElement,Stack<Integer> st)
    {
        if(st.isEmpty() || topElement>= st.peek())
        {
            st.push(topElement);
            return;
        }

        int ele = st.pop();
        findAndInsert(topElement,st);
        st.push(ele);

    }
    public static Stack<Integer> sort(Stack<Integer> s) {
        // add code here.
        if(s.empty()) return s;
        int ele = s.pop();
        sort(s);
        findAndInsert(ele,s);
        return s;
    }

    public static void main(String[] args) {
        Stack<Integer> in =  new Stack<>();
        in.add(41);
        in.add(3);
        in.add(32);
        in.add(2);
        in.add(11);
        Stack<Integer>  ans = sort(in);
       while (!ans.isEmpty())
       {
           System.out.println(ans.pop());
       }

    }
}
