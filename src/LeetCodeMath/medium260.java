package LeetCodeMath;

/**
 * Created by luoshalin on 12/27/15.
 */
public class medium260 {
    public int[] singleNumber(int[] nums) {
        int res[] = new int[2];
        if(nums==null || nums.length==0)
            return res;

        int xor = 0;
        for(int num : nums){
            xor ^= num;
        }
        // get the xor result of all nums in the array
        // find the rightmost 1
        int k = 0;
        while (xor!=0){
            k++;
            if((xor&1)!=0)
                break;
            else
                xor = xor>>1;
        }

        int a = 0;
        int b = 0;
        for(int num : nums){
            if((num&(1<<(k-1)))!=0)
                a ^= num;
            else
                b ^= num;
        }
        res[0] = a;
        res[1] = b;

        return res;
    }
}
