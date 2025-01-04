package track.stack;

import java.util.Stack;

/**
 * Problem : Pairwise Consecutive Elements
 * Link : https://www.geeksforgeeks.org/problems/pairwise-consecutive-elements/1?
 */
public class _16PairWiseConsecutive {
    // Apprach 1: Using Another stack
    public static boolean pairWiseConsecutive(Stack<Integer> st) {
        // Your code here
        Stack<Integer> nst = new Stack<>();

        while(!st.isEmpty())
        {
            nst.push(st.pop());
        }

        // check for one element

        int temp = nst.pop();

        if(nst.isEmpty())
        {
            return true;
        }


        if(temp+1==nst.peek())
        {
            nst.pop();

            while(!nst.isEmpty())
            {
                temp = nst.pop();

                if(nst.isEmpty())
                {
                    return true;
                }
                else if(temp+1!=nst.peek())
                {
                    return false;
                }
                nst.pop();

            }
        }
        else if(temp==nst.peek()+1)
        {
            nst.pop();

            while(!nst.isEmpty())
            {
                temp = nst.pop();

                if(nst.isEmpty())
                {
                    return true;
                }
                else if(temp!=nst.peek()+1)
                {
                    return false;
                }
                nst.pop();

            }
        }
        else
        {
            return false;
        }

        return true;
    }
    //TC: O(n), SC:O(n)

    // Approach-2: Optimized if and else condition
    public static boolean pairWiseConsecutive2(Stack<Integer> st) {
        Stack<Integer> nst = new Stack<>();

        while(!st.isEmpty())
        {
            nst.push(st.pop());
        }

        int prev = nst.pop();
        while (!nst.isEmpty())
        {
            int curr = nst.pop();

            if(Math.abs(curr-prev)!=1)
            {
                return false;
            }

            if(!nst.isEmpty())
            {
                prev = nst.pop();
            }
        }

        return true;
    }


    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(88);
        st.push(89);
        st.push(29);
        st.push(63);
        st.push(52);
        st.push(84);
        st.push(19);
        boolean ans = pairWiseConsecutive2(st);
        System.out.println(ans);
    }
}
