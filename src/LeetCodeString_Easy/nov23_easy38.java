package LeetCodeString_Easy;

// took too much time. need more clear thoughts.


/**
 * Created by luoshalin on 11/23/15.
 */
public class nov23_easy38 {

    public static void main(String[] args){
        // test goes here
        System.out.println(countAndSay(5));
    }

    public static String countAndSay(int n) {
        if(n==0)
            return "";
        if(n==1)
            return "1";

        StringBuilder preRes = new StringBuilder("1");
        StringBuilder curRes = new StringBuilder("");   // the (i+1)th
        for(int i=1; i<n; i++){
            // get curRes based on preRes
            char ch = preRes.charAt(0);
            int count = 0;
            for(int j=0; j<preRes.length(); j++){
                if(preRes.charAt(j)==ch){
                    count++;
                    continue;
                }
                curRes.append(count).append(ch);
                count = 1;
                ch = preRes.charAt(j);
            }
            curRes.append(count).append(ch);    // the last chars
            preRes.setLength(0);
            preRes.append(curRes.toString());
            curRes.setLength(0);
        }
        return preRes.toString();
    }
}
