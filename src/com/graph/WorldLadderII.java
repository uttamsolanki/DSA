package com.graph;

import java.util.*;

public class WorldLadderII {
    public static List<List<String>> findLadders1(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> set = new HashSet<>();
        List<List<String>> ans = new ArrayList<>();
        for(String s:wordList)
        {
            if(!set.contains(s))
            {
                set.add(s);
            }
        }

        if(!set.contains(endWord)) return ans;

        Queue<List<String>> q = new LinkedList<>();
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        q.add(list);

        while (!q.isEmpty())
        {
            int n = q.size();
            List<String> tempList = new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                List<String> innerList = q.poll();
                String word = innerList.get(innerList.size()-1);

                if(word.equals(endWord)) {
                    ans.add(innerList);
                    continue;
                }
                for(int j=0;j<word.length();j++)
                {
                    StringBuilder sb = new StringBuilder(word);
                    for(int k=0;k<26;k++)
                    {
                        char c = (char) (k+'a');
                        sb.setCharAt(j, c);
                        String newWord = sb.toString();
                        if(newWord.equals(word)) continue;

                        if(set.contains(newWord))
                        {
                            List<String> newList = new ArrayList<>();
                          //  Collections.copy(innerList, newList);
                            newList.addAll(innerList);
                            newList.add(newWord);
                            q.add(newList);
                            tempList.add(newWord);
                        }
                    }
                }
            }

            for(int i=0;i<tempList.size();i++)
            {
                if(set.contains(tempList.get(i)))
                {
                    set.remove(tempList.get(i));
                }
            }
        }
        return ans;
    }

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> set = new HashSet<>();
        List<List<String>> ans = new ArrayList<>();
        for(String s:wordList)
        {
            if(!set.contains(s))
            {
                set.add(s);
            }
        }

        if(!set.contains(endWord)) return ans;

        Queue<List<String>> q = new LinkedList<>();
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        q.add(list);

        ArrayList < String > usedOnLevel = new ArrayList < > ();
        usedOnLevel.add(beginWord);
        int level = 0;

        while (!q.isEmpty())
        {

                List<String> innerList = q.poll();
                String word = innerList.get(innerList.size()-1);


                if(innerList.size()>level)
                {
                    level++;
                    for(String it:usedOnLevel)
                    {
                        set.remove(it);
                    }
                }

                if(word.equals(endWord)) {
                    if(ans.size()==0 || innerList.size()== ans.get(0).size())
                    {
                        ans.add(innerList);
                    }

                }
                for(int j=0;j<word.length();j++)
                {
                    StringBuilder sb = new StringBuilder(word);
                    for(int k=0;k<26;k++)
                    {
                        char c = (char) (k+'a');
                        sb.setCharAt(j, c);
                        String newWord = sb.toString();
                        if(newWord.equals(word)) continue;

                        if(set.contains(newWord))
                        {
                            innerList.add(newWord);
                            List<String> newList = new ArrayList<>(innerList);
                            //  Collections.copy(innerList, newList);
                           // newList.addAll(innerList);
                          //  newList.add(newWord);
                            q.add(newList);
                            innerList.remove(innerList.size()-1);
                            usedOnLevel.add(newWord);
                        }
                    }
                }
            }

        return ans;
    }
    public static void main(String[] args) {
        String[] array = {"hot","dot","dog","lot","log","cog"};
        List<String> list = Arrays.asList(array);

        List<List<String>> ans=  findLadders("hit","cog",list);

        for(int i=0;i<ans.size();i++)
        {
            System.out.println(ans.get(i).toString());
        }

    }
}
