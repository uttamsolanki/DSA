package track.stack;

import java.util.Stack;

public class _6PrefixToPostfix {
    public static String prefixToPostFix(String prefix) {
        Stack<String> st = new Stack<>();

        for(int i=prefix.length()-1;i>=0;i--)
        {
            char ch = prefix.charAt(i);

            if(ch=='+' || ch=='-' || ch=='*' || ch=='/')
            {
                String s1 = st.pop();
                String s2 = st.pop();

                st.push(s1+s2+ch);
            }
            else
            {
                st.push(String.valueOf(ch));
            }
        }
        return st.pop();
    }

    public static void main(String[] args) {
        String s = "+ A / - * B C D E".replaceAll("\\s", "");
        String ans = prefixToPostFix(s);
        System.out.println(ans);
    }
}
