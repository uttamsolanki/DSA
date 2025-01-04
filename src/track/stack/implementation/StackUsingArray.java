package track.stack.implementation;

public class StackUsingArray<T> {
    int capacity;
    int top;
    T[] arr;
    StackUsingArray()
    {
        this.capacity = 10;
        this.top = -1;
        this.arr = (T[]) new Object[this.capacity];
    }
    //TC: O(1)
    boolean isEmpty()
    {
        return this.top == -1;
    }
    //TC: O(1)
    boolean isFull()
    {
        return this.top==this.capacity-1;
    }
    // This is doubling technique when array get full
    //TC: O(n)
    void updateCapacity()
    {
        T[] temp =  (T[]) new Object[this.capacity*2];
        for(int i=0;i<this.capacity;i++)
        {
            temp[i] = arr[i];
        }
        this.capacity*=2;
        arr = temp;
    }
    //TC: O(1)
    void push(T val ) throws Exception {
        // We can use doubling technique if array get full
        if(isFull())
        {
            throw new Exception("Stack is full");
        }
        arr[++top] = val;
    }
    //TC: O(1)
    T pop() throws Exception {
        if(isEmpty())
        {
            throw new Exception("Stack is Empty");
        }
        return arr[top--];
    }
    //TC: O(1)
    T peek() throws Exception {
        if(isEmpty())
        {
            throw new Exception("Stack is Empty");
        }
        return arr[top];
    }


    public static void main(String[] args) throws Exception {
        StackUsingArray<Integer> st = new StackUsingArray<Integer>();
        st.push(10);
        st.push(12);
        st.pop();
        st.peek();
        System.out.println(st.pop());
    }
}
