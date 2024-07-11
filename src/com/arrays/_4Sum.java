package com.arrays;

import java.util.*;

public class _4Sum {

    public static List<List<Integer>> Approach1(int[] nums,int target)
    {
        HashSet<List<Integer>> set = new HashSet<>();
        int n =  nums.length;
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                for(int k=j+1;k<n;k++)
                {
                  for(int l=k+1;l<n;l++)
                  {
                      if(nums[i] + nums[j] + nums[k] + nums[l] == target)
                      {
                          List<Integer> quad =  new ArrayList<>();
                          quad.add(nums[i]);
                          quad.add(nums[j]);
                          quad.add(nums[k]);
                          quad.add(nums[l]);
                          Collections.sort(quad);
                          set.add(quad);
                      }
                  }
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(set);

        return ans;

    }

    public static List<List<Integer>> Approach2(int[] nums,int target)
    {
        HashSet<List<Integer>> set = new HashSet<>();
        int n =  nums.length;
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                HashSet<Integer> temp = new HashSet<>();
                for(int k=j+1;k<n;k++)
                {
                    int sum = nums[i] + nums[j] + nums[k];
                    if(temp.contains(target-sum))
                    {
                        List<Integer> quad =  new ArrayList<>();
                        quad.add(nums[i]);
                        quad.add(nums[j]);
                        quad.add(nums[k]);
                        quad.add(target-sum);
                        Collections.sort(quad);
                        set.add(quad);
                    }
                    temp.add(nums[k]);
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(set);

        return ans;
    }

    public static List<List<Integer>> Approach3(int[] nums,int target)
    {

        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n =  nums.length;
        for(int i=0;i<n;i++)
        {
            if(i>0 && nums[i] == nums[i-1]) continue;
            for(int j=i+1;j<n;j++)
            {

                if(j>i+1 && nums[j] == nums[j-1]) continue;

                int k = j+1;
                int l = n-1;

                while (k<l)
                {
                    if(target == nums[i] + nums[j] + nums[k] + nums[l])
                    {
                        List<Integer> quad =  new ArrayList<>();
                        quad.add(nums[i]);
                        quad.add(nums[j]);
                        quad.add(nums[k]);
                        quad.add(nums[l]);
                        ans.add(quad);
                        k++;
                        l--;

                        while (k<l && nums[k]==nums[k-1]) k++;
                        while (k<l && nums[l]==nums[l+1]) l--;
                    }
                    else if(target < nums[i] + nums[j] + nums[k] + nums[l]){
                        l--;
                    }else {
                        k++;
                    }
                }

            }
        }




        return ans;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{
                4,3,3,4,4,2,1,2,1,1
        };

        List<List<Integer>> ans = Approach3(arr,9);

        for(int i=0;i<ans.size();i++)
        {
            System.out.println(ans.get(i));
        }
    }

}
