package LeetCodeString;

/**
 * Created by luoshalin on 11/23/15.
 */
public class nov23_easy28 {

    public static void main(String[] args){
        // test goes here
        System.out.println(strStr("aaa", "a"));
    }

    public static int strStr(String haystack, String needle) {
        int index = -1;

        // special cases
        if(haystack==null || needle==null || needle.length()>haystack.length()){
            return -1;
        }
        if(needle.length()==0){
                return 0;
        }

        for(int i=0; i<haystack.length(); i++){
            if(needle.length()+i > haystack.length())
                return index;       // index = -1
            if(haystack.charAt(i)==needle.charAt(0)){
                int j = 0;
                while(j<needle.length() && haystack.charAt(i+j)==needle.charAt(j)){
                    j++;
                }
                if(j==needle.length()){
                    index = i;
                    return index;
                }
            }
        }
        return index;
    }
}
