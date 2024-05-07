package com.graph;

import java.util.*;

public class WordLadderI {

   static class Pair{
        String s;
        int d;
        Pair(String s, int d)
        {
            this.s = s;
            this.d = d;
        }
    }
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> set = new HashSet<>();
        for(int i=0;i<wordList.size();i++)
        {
            String word = wordList.get(i);
            if(!set.contains(word))
            {
                set.add(word);
            }
        }

        if(!set.contains(endWord)) return 0;

        Queue<Pair> q= new LinkedList<>();

        q.add(new Pair(beginWord,1));

        while(!q.isEmpty())
        {
            Pair p = q.poll();

            String word = p.s;
            int d = p.d;
            if(word.equals(endWord)) return p.d;
            // N * String lengh * 26 * logN for set
            for(int i=0;i<word.length();i++)
            {
                StringBuilder sb = new StringBuilder(word);
                for(int j=0;j<26;j++)
                {
                    char c = (char) (j+'a');
                    sb.setCharAt(i, c);
                    String newWord = sb.toString();
                    if(newWord.equals(word)) continue;

                    if(set.contains(newWord))
                    {
                        q.add(new Pair(newWord,d+1));
                        set.remove(newWord);
                    }
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        String[] array = {"hot","dot","dog","lot","log","cog"};
        List<String> list = Arrays.asList(array);

        int ans =  ladderLength("hit","cog",list);
        System.out.println(ans);
    }
}
