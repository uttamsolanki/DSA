package track.stack.implementation;

import java.util.ArrayList;

public class StackUsingDynamicArray<T> {
    int index;
    ArrayList<T> arr;
    StackUsingDynamicArray()
    {
        this.index = -1;
        this.arr = new ArrayList<>();
    }
    //TC: O(1)
    boolean isEmpty()
    {
        return arr.isEmpty();
    }
    //TC: O(1)
    void push(T val )
    {
        arr.add(val);
    }
    //TC: O(1)
    T pop() throws Exception {
        if(isEmpty())
        {
            throw new Exception("Stack is Empty");
        }
        T temp = arr.get(arr.size()-1);
        arr.remove(temp);
        return temp;
    }
    //TC: O(1)
    T peek() throws Exception {
        if(isEmpty())
        {
            throw new Exception("Stack is Empty");
        }
        return arr.get(arr.size()-1);
    }

    public static void main(String[] args) throws Exception {
        StackUsingDynamicArray<Integer> st = new StackUsingDynamicArray<Integer>();

        st.push(10);
        st.push(12);
        st.pop();
        System.out.println(st.pop());
    }
}
