

package track.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Problem: Given an array arr. The task is to count all the triplets such that the sum of two elements equals the third element
 * Link: https://www.geeksforgeeks.org/problems/count-the-triplets4615/1
 */

public class CountTriplet {

    //Approach 1
    // Brute force algo using 3 for loop
    public static int countTriplet1(int arr[]) {
        // code here
        int cnt  = 0;
        int n = arr.length;
        //To avoid duplicate target, i have used set to track previous taken
        HashMap<Integer,HashSet<Integer>> map =  new HashMap<>();
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                int sum = arr[i] + arr[j];

                for(int k=0;k<n;k++)
                {
                    if(sum == arr[k])
                    {
                        HashSet<Integer> set = new HashSet<>();
                        if(map.containsKey(k))
                        {
                            set = map.get(k);
                        }

                        if(!set.contains(i) && !set.contains(j))
                        {
                            cnt++;
                            set.add(i);
                            set.add(j);
                        }
                        map.put(k,set);
                    }
                }
            }
        }
        return cnt;
    }

    //Approach 2: using HashMap
    // First store all array elements in HashMap
    // Interate 2 for loop and check if sum exist or not
    // if exist then remove that pair

    public static int countTriplet2(int arr[]) {
        // code here
        int cnt  = 0;
        int n = arr.length;
        HashMap<Integer,Integer> countMap =  new HashMap<>();
        HashMap<Integer,HashSet<Integer>> map =  new HashMap<>();
        for(int i=0;i<n;i++)
        {
            countMap.put(arr[i],countMap.getOrDefault(arr[i],0)+1);
        }

        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                int sum = arr[i] + arr[j];

                if(countMap.containsKey(sum))
                {
                    HashSet<Integer> set = new HashSet<>();
                    if(map.containsKey(sum))
                    {
                        set = map.get(sum);
                    }

                    if(!set.contains(i) && !set.contains(j))
                    {
                        cnt+=countMap.get(sum);

                        set.add(i);
                        set.add(j);
                    }
                    map.put(sum,set);
                }


            }
        }
        return cnt;
    }
    public static int countTriplet(int[] arr)
    {
        int n = arr.length;
        Arrays.sort(arr);

        HashMap<Integer,Integer> map =  new HashMap<>();

        for(int i=0;i<n;i++)
        {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }


        int mapSize = map.size();
        int[] temp = new int[mapSize];
        int index = 0;
        for(Map.Entry<Integer,Integer> entry:map.entrySet())
        {
            temp[index++] = entry.getKey();
        }
        int cnt = 0;
        for(int i=0;i<mapSize;i++)
        {
            for(int j=i;j<mapSize;j++)
            {
                    int a = temp[i];
                    int b = temp[j];
                    int c =a + b;

                    if(i==j && map.get(a)<=1)
                    {
                        continue;
                    }

                    if(map.containsKey(c))
                    {
                        int min = Math.min(map.get(a),map.get(b));
                        if(i==j)
                        {
                            min/=2;
                        }
                        cnt+= min*map.get(c);
                    }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] arr = new  int[]{1, 5, 3, 2};

        int ans = countTriplet(arr);
        System.out.println(ans);
    }
}
