package LeetCode_DP;

import java.util.Arrays;

/**
 * Created by luoshalin on 12/19/15.
 */

//start - 11:12
//finish a recursive algo - time exeed - 11:48
//[36min]
//end -


public class medium279 {
    public static void main(String[] args){
        // test goes here
        System.out.print(numSquares(41));
    }

    public static int numSquares(int n) {
//        algo1 - time exceed
//        if(n==0)
//            return 0;
//        if(n==1)
//            return 1;
//
//        int k = (int)Math.sqrt(n);
//        if(k*k==n)
//            return 1;
//        int min = Integer.MAX_VALUE;
//        for(int i=1; i<=k; i++){
//            int m = i*i;
//            min = Math.min(min, numSquares(m)+numSquares(n-m));
//        }
//        return min;

//        algo2
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for(int i=0; i*i<=n; i++){
            dp[i*i] = 1;
        }
        for(int a=0; a<=n; a++){
            for(int b=0; a+b*b<=n; b++){
                dp[a+b*b] = Math.min(dp[a]+1, dp[a+b*b]);
            }
        }
        return dp[n];
    }
}
