import java.util.Arrays;

/*
 * 题意：给一个数组，求除了当前元素外所有元素之积所构成的数组。不能用除法，时间为O(n)
 * 参考：https://leetcode.com/discuss/46104/simple-java-solution-in-o-n-without-extra-space
 * 思路：是O(n)所以不能双层循环。方法是遍历两次数组：
 * 		1. 从左到右遍历，把乘积放在相应的数组位置上
 * 		2. 从右到左遍历，将右边的累积乘积乘以相应位置上的左边乘积
 * 要点：n元素数组的定义：int[] arr = new int[n];
 * */
public class aug29_medium238 {
	public static void main(String[] args){
		int[] nums = {1, 2, 3, 4};
		System.out.println(Arrays.toString(productExceptSelf(nums)));
	}
	
    public static int[] productExceptSelf(int[] nums) {
    	int n = nums.length;
    	int left=nums[0], right=nums[n-1];
    	int[] res = new int[n];
    	res[0] = 1;
    	// calculate the product on the left
        for(int i=1; i<n; i++){
        	res[i] = left;
        	left *= nums[i];
        }
        // calculate the produce on the right
        for(int i=n-2; i>=0; i--){
        	res[i] *= right;
        	right *= nums[i];
        }
        return res;
    }
}
