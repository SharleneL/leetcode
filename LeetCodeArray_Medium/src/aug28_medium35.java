/*
 * 题意：给一个sorted arr和一个int，问这个int应当被放在arr中的哪个index
 * 做的时间有点长，主要是没考虑清楚分类：
 * 先排除特殊情况：一头一尾；再遍历中间部分进行比较，确定index
 * 
 * 或者使用low-high指针也可
 * 
 * 要点：如果结果是if中得到的，return的时候注意了！在ifelse中将值赋给另开的一个变量result->break->在if语句之外return
 * 		不能在if语句中直接return！
 * */

public class aug28_medium35 {
	public static void main(String args[]){
		int[] nums = {1,3,5,6};
		System.out.println(searchInsert(nums, -1));
	}
    
	public static int searchInsert(int[] nums, int target) {
        int index = -1;
        int result = 0;
        if(nums[0]>=target)
        	result = 0;
        else if(nums[nums.length-1]<target)
        	result = nums.length;
        else {
        	for (int i=1; i<nums.length; i++){
            	if(nums[i]==target){
            		result = i;
            		break;
            	}
            	else if(nums[i-1]<target && nums[i]>target){
            		result = i;
            		break;
            	}
            }
        }
		return result;
    }
}
