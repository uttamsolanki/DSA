package track.stack;

import java.util.Stack;

/**
 * Problem: Valid Parentheses
 * Link : https://leetcode.com/problems/valid-parentheses/description/
 */
public class _1ValidParantheses {
    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(ch=='(' || ch=='{' || ch=='[')
            {
                st.push(ch);
            }
            else if (ch == ')' || ch=='}' || ch==']'){
                if(st.isEmpty())
                {
                    return false;
                }
                char top =  st.peek();
                if( (top=='(' && ch==')' ) || (top=='{' && ch=='}') || (top=='[' && ch==']') )
                {
                    st.pop();
                }
                else
                {
                    return  false;
                }
            }
        }

        return st.isEmpty();
    }

    // TC:O(n) , SC:O(n)
    public static void main(String[] args) {
        boolean ans = isValid("()");
        System.out.println(ans);
    }
}
