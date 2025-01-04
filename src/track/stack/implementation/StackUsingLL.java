package track.stack.implementation;

class Node<T>
{
    T val;
    Node<T> next;
    Node(T val)
    {
        this.val = val;
        this.next = null;
    }
}

public class StackUsingLL<T> {
    Node<T> head;

    StackUsingLL() {
        this.head = null;
    }

    boolean isEmpty()
    {
        return this.head==null;
    }

    void push(T val)
    {
        Node<T> newNode = new Node<>(val);
        newNode.next = this.head;
        this.head = newNode;
    }

    T pop() throws Exception {
        if(isEmpty())
        {
            throw new Exception("Stack is Empty");
        }

        T val = this.head.val;
        this.head = this.head.next;
        return val;
    }

    T peek() throws Exception {
        if(isEmpty())
        {
            throw new Exception("Stack is Empty");
        }
        return this.head.val;
    }


    public static void main(String[] args) throws Exception {
        StackUsingLL<Integer> ss = new StackUsingLL<>();
        ss.push(10);
        ss.push(12);
        ss.pop();
        System.out.println(ss.peek());
        System.out.println(ss.pop());
    }
}
