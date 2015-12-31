package LeetCodeMath;

/**
 * Created by luoshalin on 12/27/15.
 */
public class medium137 {
    public static void main(String[] args){
        int[] nums = {1, 2, 2, 2, 5, 5, 5};
        System.out.print(singleNumber(nums));
    }
    public static int singleNumber(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;

        int bit[] = new int[32];

        int res = 0;

        for(int i=0; i<32; i++){        // process the i-th bit
            for(int j=0; j<nums.length; j++){
                if((nums[j] & (1<<i))!=0)
                    bit[i] += 1;
            }
            if(bit[i]%3 != 0){
                res |= (1<<i);
            }
        }
        return res;
    }
}
