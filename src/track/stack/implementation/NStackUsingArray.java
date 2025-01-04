package track.stack.implementation;

import java.util.Arrays;

public class NStackUsingArray {
    private int[] arr;
    private  int[] next;
    private int freeSpot;
    private int[] top;
    NStackUsingArray(int n,int s)
    {
        arr = new int[n];
        next = new int[n];
        top = new int[s];
        freeSpot = 0;

        Arrays.fill(top,-1);

        for(int i=0;i<n-1;i++)
        {
            next[i] = i+1;
        }
        next[n-1] = -1;
    }

    void push(int x, int sn)
    {
        // stack is full
        if(freeSpot == -1)
        {
            return;
        }
        // Current free spot
        int index = freeSpot;

        // Update free spot
        freeSpot = next[index];

        //Insert Item into arr
        arr[index] = x;

        //Update current index of spot as we have filled items
        //Update item with top of stack element
        next[index] = top[sn-1];

        // Update top of current stack
        top[sn-1] = index;
    }
    int pop(int sn)
    {
        int index = top[sn-1];
        if(index==-1)
        {
            return  -1;
        }
        int x = arr[index];
        top[sn-1] = next[index];
        next[index] = freeSpot;
        freeSpot = index;

        return x;
    }
    public static void main(String[] args) {
        NStackUsingArray nStack = new NStackUsingArray(20,3);
        nStack.push(10,1);
        nStack.push(20,1);
        System.out.println(nStack.pop(1));
        nStack.push(30,1);
        System.out.println();
    }
}
