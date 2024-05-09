package com.arrays;

public class SecondLargestElement {

    /**
     * Using pointer
     */
    public static  void optimal(int[] arr)
    {
        int fs = Integer.MAX_VALUE;
        int ss = Integer.MAX_VALUE;

        int fh = Integer.MIN_VALUE;
        int sh = Integer.MIN_VALUE;


        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]<fs)
            {
                ss = fs;
                fs = arr[i];
            }else if(arr[i]<ss && fs != arr[i]) {
                ss = arr[i];
            }


            if(arr[i]>fh)
            {
                sh = fh;
                fh = arr[i];
            }else if(arr[i]>sh && fh != arr[i]) {
                sh = arr[i];
            }

        }


        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]<fs)
            {
                ss = fs;
                fs = arr[i];
            }else if(arr[i]<ss && fs != arr[i]) {
                ss = arr[i];
            }
        }

        System.out.println(ss);
        System.out.println(sh);

    }
    public static void main(String[] args) {

        int[] arr = new int[]{1,2,3,5,7,7};

        optimal(arr);
    }
}
