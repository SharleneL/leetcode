package LeetCode_Linkedin;

/**
 * Created by luoshalin on 12/15/15.
 */
public class easy198 {
    public static void main(String[] args){
        // test goes here
        int nums[] = {1, 1, 1};
        System.out.print(rob(nums));
    }

    public static int rob(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        if(nums.length==1)
            return nums[0];

        int sum[] = new int[nums.length];
        sum[0] = nums[0];
        sum[1] = Math.max(nums[0], nums[1]);
        for(int i=2; i<=sum.length-1; i++){
            sum[i] = Math.max(sum[i-1], sum[i-2]+nums[i]);
        }
        return sum[sum.length-1];
    }
}

//# corner
//nums=null || nums.size=0 => return 0
//nums.size=1 => return nums[0]
//
//# thought1 : DP => find formula
//reach at ith house:
//        1. rob ith => nums(i) + moneysum(i-2)
//        2. not rob ith => moneysum(i-1)
//benifit: moneysum(i) = MAX(moneysum(i-1), moneysum(i-2)+nums(i))
//
//maintain a new arr moneysum => size=nums.size
//i : 2->nums.size-1
//    i=0: nums[0]
//    i=1: max(nums[0], nums[1])