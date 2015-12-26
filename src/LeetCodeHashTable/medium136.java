package LeetCodeHashTable;

/**
 * Created by luoshalin on 12/25/15.
 */
public class medium136 {
    public static void main(String[] args){
        // test goes here
    }
    public int singleNumber(int[] nums) {
        int res = 0;
        if(nums==null || nums.length==0)
            return res;
        for(int num : nums){
            res = res ^ num;
        }
        return res;
    }
}
