package track.stack;

import java.util.Map;
import java.util.Stack;

public class _10MinStack {
    Stack<Integer> main;
    Stack<Integer> min;
    public _10MinStack() {
            main = new Stack<>();
            min = new Stack<>();
    }

    public void push(int val) {
        main.push(val);
        if(min.isEmpty())
        {
            min.push(val);
        }else {
            min.push(Math.min(min.peek(),val));
        }
    }

    public void pop() {
        min.pop();
        main.pop();
    }

    public int top() {
        return  main.peek();
    }

    public int getMin() {
        return min.peek();
    }

    public static void main(String[] args) {
        _10MinStack minStack = new _10MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println( minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin()); // return -2
    }

    // TC: O(1), SC:O(n)
}
