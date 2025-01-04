package track.stack.implementation;

/**
 * Design 2 stack using array
 */
public class TwoStackUsingArray {
    int[] arr;
    int top1;
    int top2;
    TwoStackUsingArray() {
        arr = new int[100];
        top1 = -1;
        top2 = arr.length;
    }
    void push1(int x) {
        if(top1>=-1 && top2<=arr.length && top1!=top2-1)
        {
            arr[++top1] = x;
        }
    }

    // Function to push an integer into the stack2.
    void push2(int x) {
        if(top1>=-1 && top2<=arr.length && top1!=top2-1)
        {
            arr[--top2] = x;
        }
    }

    // Function to remove an element from top of the stack1.
    int pop1() {
        if(top1==-1)
        {
            return -1;
        }
        return arr[top1--];
    }

    // Function to remove an element from top of the stack2.
    int pop2() {
        if(top2==arr.length)
        {
            return -1;
        }
        return arr[top2++];
    }

    public static void main(String[] args) {
        TwoStackUsingArray twoStack = new TwoStackUsingArray();

        twoStack.push1(1);
        twoStack.push1(2);
        twoStack.push1(3);
        twoStack.push1(4);
        twoStack.push1(5);


        twoStack.push2(9);
        twoStack.push2(8);
        twoStack.push2(7);
        twoStack.push2(6);
        twoStack.push2(5);
        twoStack.push2(10);

        System.out.println(twoStack.pop2());



    }
}
