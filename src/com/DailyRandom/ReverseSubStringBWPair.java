package com.DailyRandom;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseSubStringBWPair {
    public static String reverseParentheses(String s) {

        Queue<Character> q = new LinkedList<>();
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);

            if(ch == ')')
            {
                while(!st.isEmpty())
                {
                    char ch1 = st.pop();
                    if(ch1 == '(')
                    {
                        break;
                    }
                    q.add(ch1);
                }

                while(!q.isEmpty())
                {
                    st.push(q.poll());
                }
            }else
            {
                st.push(ch);
            }
        }

        while (!st.isEmpty())
        {
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
            String ans = reverseParentheses("a(bcdefghijkl(mno)p)q");
    }
}
