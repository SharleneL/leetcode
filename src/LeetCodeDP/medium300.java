package LeetCodeDP;

import java.util.Arrays;

/**
 * Created by luoshalin on 12/19/15.
 */
public class medium300 {
    public static void main(String[] args){
        // test goes here
        int nums[] = {10,9,2,5,3,7,101,18};
        System.out.print(lengthOfLIS(nums));
    }

    public static int lengthOfLIS(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        if(nums.length==1)
            return 1;

        int dp[] = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;
        for(int i=1; i<nums.length; i++){
            for(int j=0; j<i; j++){
                if(nums[j]<nums[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    max = Math.max(dp[i], max);
                }
            }
        }
        return max;
    }
}

//if nums.len<2:
//        return 0
//max = MIN
//tmp = 0
//iterate i: from 1 to len-1:
//    if([i]>[i-1])           ->if ==?
//       tmp++
//    else                // decrease
//       max = MAX(max, tmp)
//        tmp = 0
