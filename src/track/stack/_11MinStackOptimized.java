package track.stack;

import java.util.Objects;
import java.util.Stack;

// Previously we are adding duplicate item in min stack
// So, now we need to avoid that
public class _11MinStackOptimized {
    Stack<Integer> main;
    Stack<Integer> min;
    public _11MinStackOptimized() {
        main = new Stack<>();
        min = new Stack<>();
    }

    public void push(int val) {
        main.push(val);
        if(min.isEmpty() || val<=min.peek())
        {
            min.push(val);
        }
    }

    public void pop() {
        if(Objects.equals(min.peek(), main.peek()))
        {
            min.pop();
        }
        main.pop();
    }

    public int top() {
        return  main.peek();
    }

    public int getMin() {
        return min.peek();
    }

    public static void main(String[] args) {
        _11MinStackOptimized minStack = new _11MinStackOptimized();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        minStack.pop();
        System.out.println( minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.getMin()); // return -2
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
