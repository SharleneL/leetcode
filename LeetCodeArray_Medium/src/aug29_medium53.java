/*
 * 题意：给一个arr，求和最大的subarr
 * 		medium39是求subset和的问题，可以参考
 * 思路：好好想一下，某个元素要么加到之前的子集里，要么从自己这里重新开始一个子集。选比较大的那个，和现有的最大和作比较。然后继续往后走。
 * */
public class aug29_medium53 {
	public static void main(String[] args){
		int[] nums = {-1, 2, -1, 3};
		System.out.println(maxSubArray(nums));
	}
    public static int maxSubArray(int[] nums) {
    	if(nums==null)
    		return Integer.MIN_VALUE;
    	if(nums.length==0)
    		return 0;
    	
    	int maxSum = nums[0];
    	int maxTemp = nums[0];
    	for(int i=1; i<nums.length; i++){
    		maxTemp = Math.max(maxTemp+nums[i], nums[i]); 	// 加到之前的子集比较大还是重开一个子集比较大
    		maxSum = Math.max(maxTemp, maxSum); 			// 求最大
    	}
    	return maxSum;
    }
}
