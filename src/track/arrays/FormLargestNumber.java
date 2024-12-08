package track.arrays;

import java.util.*;

/**
 * Problem : Given an array of integers arr[] representing non-negative integers, arrange them so that after concatenating all of them in order,
 * it results in the largest possible number. Since the result may be very large, return it as a string.
 * Link: https://www.geeksforgeeks.org/problems/largest-number-formed-from-an-array1117/1
 */
public class FormLargestNumber {




    public static void reverse(int[] arr,int i, int j)
    {
        while (i<j)
        {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
    // reversing first single digit then 2 digit ...

    public static String approach1(int[] arr) {

        int n = arr.length;
        Arrays.sort(arr);
        String[] list =  new String[10];

        int i=0;
        int maxN = 10;
        int lastIndex = 0;
        while (i<n)
        {
            if(arr[i]>maxN)
            {
                reverse(arr,lastIndex, i-1);
                lastIndex = i;
                maxN*=10;
            }
            else
            {
                i++;
            }
        }
        reverse(arr,lastIndex, n-1);
        System.out.println(Arrays.toString(arr));
        return "";
    }

    public static List<String> sortByDigit(List<String> arr,int index, int maxDigit)
    {
        if(maxDigit<=index)
        {
            return arr;
        }
        if(arr.size()==0) return arr;
        List[] digitArray = new List[10];
        int n =arr.size();

        for(int i=0;i<10;i++)
        {
            digitArray[i] = new ArrayList<>();
        }

        for(int i=0;i<n;i++)
        {
            int key;
            String s = arr.get(i);
            if(arr.get(i).length()<=index)
            {
                key = Integer.parseInt(String.valueOf(s.charAt(0)));
            }
            else
            {
                key = Integer.parseInt(String.valueOf(s.charAt(index)));
            }
            digitArray[key].add(s);
        }

        for(int i=0;i<10;i++)
        {
            if(digitArray[i].size()!=0)
                digitArray[i] = sortByDigit(digitArray[i],index+1,maxDigit);
        }

        arr.clear();
        for(int i=9;i>=0;i--)
        {
            List<String> temp = digitArray[i];
          for(int j=0;j<temp.size();j++)
          {
              arr.add(temp.get(j));
          }
        }
        return arr;

    }
    //  Sorting with msb
    public static String approach2(int[] arr) {
        int n = arr.length;
        List<String> list = new ArrayList<>();
        int max = 0;

        for(int i=0;i<n;i++)
        {
            list.add(String.valueOf(arr[i]));
            max = Math.max(max,arr[i]);
        }
        if(max==0) return "0";
        List<String> ans = sortByDigit(list,0,String.valueOf(max).length());
        System.out.println(ans);
        return String.join("",ans);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,0,0,0,0,0};
        String ans = approach2(arr);
        System.out.println(ans);
    }
}
