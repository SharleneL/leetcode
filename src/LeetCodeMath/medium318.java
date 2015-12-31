package LeetCodeMath;

/**
 * Created by luoshalin on 12/27/15.
 */
public class medium318 {
    public int maxProduct(String[] words) {
        if(words==null || words.length==0)
            return 0;

        int len = words.length;
        int bit[] = new int[len];
        for(int i=0; i<len; i++){
            int wordLen = words[i].length();
            for(int j=0; j<wordLen; j++){
                char ch = words[i].charAt(j);
                bit[i] |= (1 << (ch-'a'-1));
            }
        }

        int res = 0;
        for(int i=0; i<len; i++){
            for(int j=0; j<i; j++){
                if((bit[i] & bit[j]) == 0){     // no chars in common
                    res = Math.max(res, words[i].length()*words[j].length());
                }
            }
        }
        return res;
    }
}
