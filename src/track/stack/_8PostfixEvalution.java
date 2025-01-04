package track.stack;

import java.util.Objects;
import java.util.Stack;

public class _8PostfixEvalution {
    public static int evalRPN(String[] tokens) {

        Stack<Integer> st = new Stack<>();

        for(int i=0;i<tokens.length;i++)
        {
            String ch = tokens[i];
            if(ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/"))
            {
                int temp2 = st.pop();
                int temp1 = st.pop();
                int ans = 0;
                switch(ch)
                {
                    case "+":
                        ans = temp1+temp2;
                        break;
                    case "-":
                        ans = temp1-temp2;
                        break;
                    case "*":
                        ans = temp1*temp2;
                        break;
                    case "/":
                        ans = temp1/temp2;
                        break;
                }
                st.push(ans);
            }
            else
            {
                st.push(Integer.valueOf(ch));
            }
        }
        return st.pop();

    }

    public static void main(String[] args) {
        String[] s = new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        int ans = evalRPN(s);
        System.out.println(ans);
    }
}
