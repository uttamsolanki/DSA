package track.stack;

import java.util.Stack;

//! Clarify time cpmplexity

/**
 * Problem: Recursively Remove Adjacent Duplicates
 * Link-1: https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/description/
 * Link-2: https://www.geeksforgeeks.org/problems/recursively-remove-all-adjacent-duplicates0744/1?
 */
public class _17RemoveAdjustDuplicate {

    /**
     * Approach - 1: Using Stack
     */
    public static String removeAdjustDuplicate(String s) {

        Stack<Character> st = new Stack<>();

        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(!st.isEmpty() && st.peek()==ch)
            {
                st.pop();
            }
            else st.push(ch);
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty())
        {
            sb.append(st.pop());
        }
        sb.reverse();
        return sb.toString();
    }
    //TC: O(n), SC:O(1)

    // Approach-2: Solve using recursive call
    public static String removeAdjustDuplicate2(String s) {
        if(s.length()<=1)
        {
            return s;
        }
        String firstChar = s.substring(0,1);
        String str = removeAdjustDuplicate2(s.substring(1));
        if(!str.isEmpty() && firstChar.charAt(0)==str.charAt(0))
        {
            return str.substring(1);
        }
        return firstChar+str;

    }

    public static void main(String[] args) {
        String s = "mississippi";
        String ans = removeAdjustDuplicate2(s);
        System.out.println(ans);
    }
}
