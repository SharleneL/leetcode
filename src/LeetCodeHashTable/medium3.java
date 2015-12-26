package LeetCodeHashTable;

import java.util.HashMap;

/**
 * Created by luoshalin on 12/25/15.
 */
public class medium3 {
    public static void main(String[] args){
        // test goes here
        System.out.print(lengthOfLongestSubstring("au"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s==null)
            return 0;
        int len = s.length();
        if(len==0 || len==1)
            return len;

        int res = 0;
        int substrLen = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();    // ch in s; index of ch
        for(int i=0; i<len; i++){
            char ch = s.charAt(i);
            if(!map.containsKey(ch)){
                map.put(ch, i);
                substrLen++;
            }else{
                i = map.get(ch);
                res = Math.max(res, substrLen);
                substrLen = 0;
                map.clear();
            }
        }
        res = Math.max(res, substrLen);
        return res;
    }
}
