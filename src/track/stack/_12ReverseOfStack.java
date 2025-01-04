package track.stack;

import java.util.Stack;

/**
 * Problem: Given a stack, how to reverse the elements of the stack using only stack operations
 */
public class _12ReverseOfStack {

    /**
     * Approach : 1  Using 2 Stack
     */
    public static void reverseStack(Stack<Integer> st) {
        Stack<Integer> st1 = new Stack<>();

        while (!st.isEmpty())
        {
            st1.push(st.pop());
        }

        Stack<Integer> st2 = new Stack<>();

        while (!st1.isEmpty())
        {
            st2.push(st1.pop());
        }

        while (!st2.isEmpty())
        {
            st.push(st2.pop());
        }

    }
    // TC: O(3n),SC:O(n);

    /**
     * Approach 2: Using recursion
     */
    public static void reverseStack2(Stack<Integer> st) {
        if(st.isEmpty())
        {
            return;
        }
        int data = st.pop();
        reverseStack2(st);
        insertAtBottom(st,data);
    }
    // TC: O(n2) b'coz, every data pop up first to push lower data at bottom of the stack
    // TC: O(n), 2 Auxilary recursive stack

    public static void insertAtBottom(Stack<Integer> st, int data) {
        if(st.isEmpty())
        {
            st.push(data);
            return;
        }
        int temp  = st.pop();
        insertAtBottom(st,data);
        st.push(temp);
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        reverseStack2(st);
        while (!st.isEmpty())
        {
            System.out.println(st.pop());
        }

    }
}
