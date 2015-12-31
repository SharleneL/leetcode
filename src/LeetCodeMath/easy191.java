package LeetCodeMath;

/**
 * Created by luoshalin on 12/26/15.
 */
public class easy191 {
    public static void main(String[] args){
        // test goes here
    }

    public int hammingWeight(int n) {
        int res = 0;
        while(n!=0){
            n = n&(n-1);
            res++;
        }
        return res;
    }
}
