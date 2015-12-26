package LeetCodeDP;

/**
 * Created by luoshalin on 12/19/15.
 */
public class easy70 {

    public static void main(String[] args){
        // test goes here
    }

    public int climbStairs(int n) {
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        if(n==2)
            return 2;

        int[] res = new int[n];
        res[0] = 1;  // first step
        res[1] = 2;  // second step
        for(int i=2; i<n; i++){
            res[i] = res[i-2] + res[i-1];
        }
        return res[n-1];
    }
}
