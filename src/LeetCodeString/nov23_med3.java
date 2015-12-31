package LeetCodeString;

import java.util.HashMap;

// ===== TIME LIMIT EXCEEDED
// ===== use int arr[26] instead of map

/**
 * Created by luoshalin on 11/23/15.
 */
public class nov23_med3 {

    public static void main(String[] args){
        // test goes here
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int res = 0;
        // special case
        if(s==null || s.length()==0)
            return 0;

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.toCharArray()[i];
            if(!map.containsKey(ch)){
                map.put(ch, i);
            }
            else{
                res = Math.max(res, map.size());
//                int index = map.get(ch);
//                for(Iterator<Map.Entry<Character, Integer>> it = map.entrySet().iterator(); it.hasNext();){
//                    Map.Entry<Character, Integer> entry = it.next();
//                    if(entry.getValue() <= index) {
//                        it.remove();
//                    }
//                }
//                map.put(ch, i);
                i = map.get(ch);
                map.clear();
            }
        }
        res = Math.max(res, map.size());
        return res;
    }
}
