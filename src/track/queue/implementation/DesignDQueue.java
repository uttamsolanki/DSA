package track.queue.implementation;

public class DesignDQueue {
    int f,r,n;
    int[] arr;
    DesignDQueue(int n)
    {
        this.n = n;
        arr = new int[n];
        r = -1;
        f = -1;
    }
    public boolean insertFront(int value) {
        if(isFull())
        {
            return false;
        }
        else if(isEmpty())
        {
            f=r=0;
        }
        else
        {
            f = (f-1+n) % n;
        }
        arr[f] = value;
        return true;
    }

    public boolean insertLast(int value) {
        if(isFull())
        {
            return false;
        }
        else if(isEmpty())
        {
            f=r=0;
        }
        else
        {
            r = (r+1) % n;
        }
        arr[r] = value;
        return true;
    }

    public boolean deleteFront() {
            if(isEmpty())
            {
                return false;
            }
            else if(f==r)
            {
                f=r=-1;
            }else
            {
                f = (f+1)%n;
            }
            return true;
    }

    public boolean deleteLast() {
        if(isEmpty())
        {
            return false;
        }
        else if(f==r)
        {
            f=r=-1;
        }else
        {
            r = (r-1+n)%n;
        }
        return true;
    }

    public int getFront() {
        if(isEmpty())
        {
            return -1;
        }
        return arr[f];
    }

    public int getRear() {
        if(isEmpty())
        {
            return -1;
        }
        return arr[r];
    }

    public boolean isEmpty() {
       return f==-1;
    }

    public boolean isFull() {
        return  (f-1+n)%n == r;
    }

    public static void main(String[] args) {

    }
}
