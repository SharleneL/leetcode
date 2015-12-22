package LeetCode_Linkedin;

import java.util.*;

/**
 * Created by luoshalin on 12/2/15.
 * Word Ladder
 * http://www.danielbit.com/blog/puzzle/leetcode/leetcode-word-ladder
 */
public class medium127 {

    public static void main(String[] args){
        // test goes here
    }

    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        int result = 0;

        // special cases
        if(beginWord==null || endWord==null || wordList==null || wordList.size()==0)
            return result;

        wordList.add(beginWord);
        wordList.add(endWord);

        result = BFS(beginWord, endWord, wordList);

        return result;

        // start from the begin word
        // add begin word to q
        // loop - poll one str from q
        // if == endword return level
        // else add str to set
        // get all words differ one char from the str & add to q
        // loop end - if q is empty
    }

    public int BFS(String start, String end, Set<String> dict){
        Queue<String> queue = new LinkedList<String>();
        Queue<Integer> length = new LinkedList<Integer>();
        queue.add(start);
        length.add(1);

        while(!queue.isEmpty()){
            String word = queue.poll();     // take a word from the list
            int len = length.poll();        // get the length to get to this word

            if(word.equals(end))            // return the length to get to end word
                return len;

            for(int i=0; i<word.length(); i++){     // each char in current word
                char[] arr = word.toCharArray();
                for(char c='a'; c<='z'; c++){
                    if(c==arr[i])
                        continue;

                    arr[i] = c;                     // substitute current char with a char from a-z
                    String str = String.valueOf(arr);
                    if(dict.contains(str)){         // if substituted string is in the set
                        queue.add(str);
                        length.add(len+1);
                        dict.remove(str);
                    }
                }
            }
        }
        return 0;
    }
}
