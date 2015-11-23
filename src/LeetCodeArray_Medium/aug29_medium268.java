/*
 * 题意：找出少了的数
 * 要点：先排序！如何对数组进行排序？Arrays.sort(arr)
 * */
import java.util.Arrays;


public class aug29_medium268 {
	public static void main(String[] args){
		int[] nums = {1, 0};
		System.out.println(missingNumber(nums));
	}
    public static int missingNumber(int[] nums) {
    	Arrays.sort(nums);
    	int len = nums.length;
    	int i=0;
    	while(i<len && nums[i]==i){
    		i++;
    	}
        return i;
    }
}
