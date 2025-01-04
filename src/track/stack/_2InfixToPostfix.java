package track.stack;

import java.util.HashMap;
import java.util.Stack;

/**
 * Problem : Infix to Postfix
 * Link: https://www.geeksforgeeks.org/problems/infix-to-postfix-1587115620/1
 */
public class _2InfixToPostfix {

    public static String infixToPostfix(String s) {
        // Your code here
        HashMap<Character,Integer> precedence = new HashMap<>();
        precedence.put('^',3);
        precedence.put('*',2);
        precedence.put('/',2);
        precedence.put('+',1);
        precedence.put('-',1);

        Stack<Character> st = new Stack<>();
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(ch=='*' || ch=='/' || ch=='+' || ch=='-' || ch=='^' )
            {
                while (!st.isEmpty() && (precedence.containsKey(ch) && precedence.containsKey(st.peek()) && precedence.get(ch)<=precedence.get(st.peek())))
                {
                    sb.append(st.pop());
                }
                st.push(ch);
            }
            else if(ch=='(')
            {
                st.push(ch);
            }else if(ch==')')
            {
                while (!st.isEmpty())
                {
                    char temp =st.pop();
                    if(temp == '(')
                    {
                        break;
                    }
                    sb.append(temp);
                }
            }
            else
            {
                sb.append(ch);
            }
        }
        while (!st.isEmpty())
        {
            sb.append(st.pop());
        }
        return sb.toString();
    }
    //TC: O(n),SC: O(n)

    public static void main(String[] args) {
        String s = "D/C+B*A";
        String ans = infixToPostfix(s);
        System.out.println(ans);
    }
}
