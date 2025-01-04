package track.stack;

import java.util.Stack;

/**
 * Problem : Convert Infix To Prefix Notation
 */
public class _4InfixToPrefix {
    public static int rank(char op)
    {
        return switch (op) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            default -> 0;
        };

    }
    public static String infixToPrefix(String infix) {

        infix = new StringBuffer(infix).reverse().toString();

        StringBuffer sb = new StringBuffer();
        Stack<Character> st = new Stack<>();

        for(int i=0;i<infix.length();i++)
        {
            char ch = infix.charAt(i);

            if(ch=='+' || ch=='-' || ch=='*' || ch=='/')
            {
                if(!st.isEmpty() && rank(ch)<=rank(st.peek()))
                {
                    sb.append(st.pop());
                }
                st.push(ch);
            }
            else if(ch==')')
            {
                st.push(ch);
            }else if(ch=='(')
            {
                while (!st.isEmpty())
                {
                    char temp =st.pop();
                    if(temp == ')')
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

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "D/C+B*A".replaceAll("\\s", "");
        String ans = infixToPrefix(s);
        System.out.println(ans);
    }
}
