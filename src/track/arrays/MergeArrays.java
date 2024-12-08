package track.arrays;

import java.util.Arrays;

/**
 * Problem :  Given two sorted arrays a[] and b[] in non-decreasing order. Merge them in sorted order without using any extra space.
 * Modify a so that it contains the first n elements and modify b so that it contains the last m elements.
 * Link: https://www.geeksforgeeks.org/problems/merge-two-sorted-arrays-1587115620/1
 */
public class MergeArrays {

    // Using external space
    public static void approach1(int a[],int b[]) {

        int n = a.length;
        int m = b.length;

        int[] temp =  new int[n+m];

        int i=0,j=0,k=0;

        while (i<n && j<m)
        {
            if(a[i]<b[j])
            {
                temp[k++] = a[i++];
            }else {
                temp[k++] = b[j++];
            }
        }
        while (i<n)
        {
            temp[k++] = a[i++];
        }

        while (j<m)
        {
            temp[k++] = b[j++];
        }
        i=0;
        j=0;
        k=0;
        while (i<n)
        {
            a[i++] = temp[k++];
        }
        while (j<m)
        {
            b[j++] = temp[k++];
        }

    }
    // Without using external space
    // similar intuition of merge sort
    public  static void approach2(int[] a, int[] b)
    {
        int i=0,j=0;
        int n = a.length;
        int m = b.length;

        while (i<n && j<m)
        {
            if(a[i]>b[j])
            {
                a[i]^=b[j];
                b[j]^=a[i];
                a[i]^=b[j];
                int  k = j+1;
                while (k<m)
                {
                    if(b[k-1]>b[k])
                    {
                        b[k-1]^=b[k];
                        b[k]^=b[k-1];
                        b[k-1]^=b[k];
                        k++;
                    }
                    else {
                        break;
                    }
                }
            }
           i++;
        }

    }

    // Using sorting array
    public  static void approach3(int[] a, int[] b)
    {

        int n = a.length;
        int m = b.length;
        int i=n-1,j=0;
        while (i>=0 && j<m) {

            if(a[i]>b[j])
            {
                a[i]^=b[j];
                b[j]^=a[i];
                a[i]^=b[j];
                i--;
                j++;
            }
            else
            {
                break;
            }
        }
        Arrays.sort(a);
        Arrays.sort(b);
    }

    public static void main(String[] args) {
        int[] a = new int[]{2,3};
        int[] b = new int[]{2, 4, 7, 10};

        approach3(a,b);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }
}
