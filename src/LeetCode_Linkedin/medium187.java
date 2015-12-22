package LeetCode_Linkedin;

import java.util.*;

/**
 * Created by luoshalin on 12/14/15.
 */
public class medium187 {
    public static void main(String[] args){
        // test goes here
        String s = "AAAAAAAAAAAAA";
        List<String> res = findRepeatedDnaSequences(s);
        for(String str : res){
            System.out.println(str);
        }
    }

    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<String>();
        if(s==null)
            return res;
        int len = s.length();
        if(len<10)
            return res;

        Map<String, Integer> map = new HashMap<String, Integer>();
        for(int i=0; i<=len-10; i++){
            String tenGram = s.substring(i, i+10);
            // in the set, means appear more than once
            if(map.containsKey(tenGram)){
                if(map.get(tenGram)==1){
                    res.add(tenGram);
                    map.put(tenGram, 2);
                }
            }
            // not in the set, save to set
            else {
                map.put(tenGram, 1);
            }
        }
        return res;
    }
}

//straightforward:
//init hashmap
//init res
//for each 10-gram of s:
//    judge whether in a hashset
//    if yes:
//        save to res
//    if no:
//        save to hashmap
//end iteration
//return res