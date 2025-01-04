package track.stack;

import java.util.Stack;

public class _5PrefixToInfix {
    public static String prefixToInfix(String prefix) {
        prefix = new StringBuffer(prefix).reverse().toString();
        Stack<String> st = new Stack<>();
        for(int i=0;i<prefix.length();i++)
        {
            char ch = prefix.charAt(i);
            if(ch == '+' || ch == '-' || ch == '*' || ch == '/')
            {
                String s1 = st.pop();
                String s2 = st.pop();
                st.push("("+s1+ch+s2+")");
            }
            else
            {
                st.push(String.valueOf(ch));
            }
        }
        return st.pop();
    }

    public static void main(String[] args) {
        String s = "+*AB/CD";
        String ans = prefixToInfix(s);
        System.out.println(ans);
    }
}
