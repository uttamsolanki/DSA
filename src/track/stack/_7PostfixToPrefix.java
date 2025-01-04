package track.stack;

import java.util.Stack;

public class _7PostfixToPrefix {
    public static String postfixToPrefix(String postfix) {
        Stack<String> st = new Stack<>();

        for(int i=0;i<postfix.length();i++)
        {
            char ch = postfix.charAt(i);

            if(ch=='+' || ch=='-' || ch=='*' || ch=='/')
            {
                String s1 = st.pop();
                String s2 = st.pop();

                st.push(ch+s2+s1);
            }
            else
            {
                st.push(String.valueOf(ch));
            }
        }
        return st.pop();
    }

    public static void main(String[] args) {
        String s = "A B C * D - E / +".replaceAll("\\s", "");
        String ans = postfixToPrefix(s);
        System.out.println(ans);
    }
}
