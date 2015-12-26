package LeetCodeDP;

/**
 * Created by luoshalin on 12/19/15.
 */
public class medium213 {
    public static void main(String[] args){
        //test goes here
    }

    public int rob(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        if(nums.length==1)
            return nums[0];
        if(nums.length==2)
            return Math.max(nums[0], nums[1]);

        // nums.len >= 2
        return Math.max(helper(nums, 0, nums.length-2), helper(nums, 1, nums.length-1));
    }

    public static int helper(int[] nums, int start, int end){
        int pre = 0;                                    // [i-2]
        int cur = nums[start];                          // [i-1]
        for(int i=start+1; i<=end; i++){
            int tmp = Math.max(cur, pre+nums[i]);       // [i]
            pre = cur;
            cur = tmp;
        }
        return cur;
    }
}
