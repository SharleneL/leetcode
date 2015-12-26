package LeetCodeHashTable;

import java.util.*;

/**
 * Created by luoshalin on 12/25/15.
 */
public class medium49 {
    public static void main(String[] args){
        // test goes here
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        if(strs==null || strs.length==0)
            return res;

        for (String str : strs){
            char arr[] = str.toCharArray();
            Arrays.sort(arr);
            String newStr = String.valueOf(arr);
            if(!map.containsKey(newStr)){
                ArrayList<String> list = new ArrayList<String>();
                list.add(str);
                map.put(newStr, list);
            }
            else{
                map.get(newStr).add(str);
            }
        }

        for(ArrayList<String> list : map.values()){
            Collections.sort(list);
            res.add(list);
        }
        return res;
    }
}
