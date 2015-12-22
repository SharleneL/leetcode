package LeetCodeString_Easy;

/**
 * Created by luoshalin on 11/23/15.
 */

// Write a function to find the longest common prefix string amongst an array of strings.


public class nov23_easy14 {

    public static void main(String[] args){
        // test goes here
        String[] strs = {"llo", "helllo", "he"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0)
            return "";

        String preStr = strs[0];

        if(strs.length > 1){
            for(int i=1; i<strs.length; i++){
                int len = Math.min(preStr.length(), strs[i].length());
                int j=0;
                while(j<len && preStr.charAt(j)==strs[i].charAt(j)){
                    j++;
                }
                preStr = preStr.substring(0, j);
            }
        }
        return preStr;
    }
}
