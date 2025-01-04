package track.stack;

import java.util.Stack;

/**
 * Problem : Postfix to Infix Conversion
 * Link : https://www.geeksforgeeks.org/problems/postfix-to-infix-conversion/1?
 */
public class _3PostfixToInfix {
    public static int rank(char op)
    {
        return switch (op) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            default -> 0;
        };

    }
    //Approach - 1: Using stack
    public static String postToInfix(String exp) {
        // code here
        Stack<String> st = new Stack<>();
        for(int i=0;i<exp.length();i++)
        {
            char ch = exp.charAt(i);
            if(ch=='+' || ch=='-' || ch=='*' || ch=='/')
            {
                String s1 = st.pop();
                String s2 = st.pop();
                st.push( "("+s2 + ch + s1+")" );
            }else {
                st.push(String.valueOf(ch));
            }
        }
        return st.pop();
    }
    // Variation 2 : With minimum parenthesis
    public static String postToInfix2(String post) {
        String exp = post.replaceAll("\\s", "");
        Stack<String> st = new Stack<>();
        for(int i=0;i<exp.length();i++)
        {
            char ch = exp.charAt(i);
            if(ch=='+' || ch=='-' || ch=='*' || ch=='/')
            {

                String right = st.pop();

                String left = st.pop();

                if(ch!='+')
                {
                    if(leftOpRank(left)!=0 && leftOpRank(left)<=rank(ch))
                    {
                        left = "("+ left + ")";
                    }

                    if(rightOpRank(right)!=0 && rightOpRank(right)<=rank(ch) || (ch=='-' && right.length()>1))
                    {
                        right = "("+ right + ")";
                    }
                }

                st.push(left+ch+right);
            }else {
                st.push(String.valueOf(ch));
            }
        }
        return st.pop();
    }
    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    // Function to get precedence of operators
    private static int getPrecedence(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return -1;
        }
    }

    public static int leftOpRank(String s)
    {
        int n = s.length();
        if(n<=1) return 0;
        if(s.charAt(n-1)==')') return 0;
        return rank(s.charAt(n-2));
    }
    public static int rightOpRank(String s)
    {
        if(s.length()<=1) return 0;
        if(s.charAt(0)=='(') return 0;
        return rank(s.charAt(1));
    }

    public static void main(String[] args) {
        String s = "1 2 + 3 4 + *";
        String ans = postToInfix2(s);
        System.out.println(ans);
    }
}
