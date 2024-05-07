package com.graph;

import java.util.*;

public class AccountMerge {
    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n =  accounts.size();
        DisjointSet ds = new DisjointSet(n);

        HashMap<String,Integer> map = new HashMap<>();

        for(int i=0;i<accounts.size();i++)
        {
            List<String> account =  accounts.get(i);
            for(int j=1;j<account.size();j++)
            {
                String email =  account.get(j);

                if(!map.containsKey(email))
                {
                    map.put(email,i);
                }else {
                    ds.unionByRank(i, map.get(email));
                }

            }
        }

        ArrayList<String>[] mergedMail = new ArrayList[n];
        for(int i=0;i<n;i++)
        {
            mergedMail[i] = new ArrayList<>();
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            int node = ds.findParent(value);
            mergedMail[node].add(key);
        }

        for(int i=0;i<n;i++)
        {
            Collections.sort(mergedMail[i]);
        }

        List<List<String>> ans = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(mergedMail[i].size()==0) continue;
            List<String> list = new ArrayList<>();
            list.add(accounts.get(i).get(0));
            for(String st:mergedMail[i])
            {
                list.add(st);
            }
            ans.add(list);
        }

        return ans;
    }
    public static void main(String[] args) {
        String[][] accountsArr =  new String[][]{
                {"John","johnsmith@mail.com","john_newyork@mail.com"},
                {"John","johnsmith@mail.com","john00@mail.com"},
                {"Mary","mary@mail.com"},
                {"John","johnnybravo@mail.com"}
        };

        List<List<String>> accounts = new ArrayList<>();

        for(int i=0;i<accountsArr.length;i++)
        {
            List<String> list = Arrays.asList(accountsArr[i]);
            accounts.add(list);
        }
        List<List<String>> ans = accountsMerge(accounts);

        for(int i=0;i<ans.size();i++)
        {
            System.out.println(ans.get(i).toString());
        }
    }
}
