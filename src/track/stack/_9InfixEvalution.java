package track.stack;

import java.util.Stack;

public class _9InfixEvalution {

    public static int rank(char op)
    {
        return switch (op) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            default -> 0;
        };

    }
    public static int infixEvalution(String s) {
        Stack<String> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();
        int n = s.length();

        for(int i=0;i<n;i++)
        {
            char ch = s.charAt(i);
            if(ch=='+' || ch=='-' || ch=='*' || ch=='/')
            {
                while (!operators.isEmpty() && rank(ch)<=rank(operators.peek()))
                {
                    int ans = performOperations(operands,operators);
                    operands.push(String.valueOf(ans));
                }
                operators.push(ch);
            }
            else if(ch == '(')
            {
                operators.push(ch);
            }
            else if(ch == ')')
            {
                while (!operators.isEmpty() && operators.peek() != '(')
                {
                   int ans = performOperations(operands,operators);
                    operands.push(String.valueOf(ans));
                }
                operators.pop();

            }
            else
            {
                int j =i;
                StringBuffer sb = new StringBuffer();
                while (j<n && s.charAt(j)>='0' && s.charAt(j)<='9')
                {
                    sb.append(s.charAt(j));
                    j++;
                }
                operands.push(sb.toString());
                i=j-1;
            }
        }

        while (!operators.isEmpty() && operators.peek() != '(')
        {
            int ans = performOperations(operands,operators);
            operands.push(String.valueOf(ans));
        }

        return Integer.parseInt(operands.pop());
    }

    public static int performOperations(Stack<String>  operands, Stack<Character> operators)
    {
        int n2 = Integer.parseInt(operands.pop());
        int n1 = Integer.parseInt(operands.pop());
        char ch = operators.pop();
        int ans =0;
        switch (ch)
        {
            case '+':
                ans = n1 + n2;
                break;
            case '-':
                ans = n1 - n2;
                break;
            case '*':
                ans = n1 * n2;
                break;
            case '/':
                ans = n1 / n2;
                break;
        }
        return ans;
    }

    public static void main(String[] args) {
        String s ="20 - (3 + 2) * 4 + 10".replaceAll("\\s", "");
        int ans = infixEvalution(s);
        System.out.println(ans);
    }
}
