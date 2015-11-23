import java.util.Arrays;

/*
 * 题意：给一个数组和int s，find the minimal length of a subarray of which the sum ≥ s
 * 思路：sort之后从后往前加呗(错！是subarray而不是subset)
 * 子串是指数组中［连续］的若干个元素，子序列只要求各元素的顺序与其在数组中一致，而没有连续的要求
 * 思路：快慢指针。快指针往后走，边走边加一直加到sum大于中枪值；一旦大于了就计算快慢指针之间subarray的长度并求最小，并移动慢指针直到sum小于中枪值；一直遍历完整个数组，最小长度存储在min中
 * 		注意外层循环！外层一个循环遍历所有元素；内层两个while一个找头一个找尾（while具有找数组头尾的功能！）
 * 要点：如何定义一个无限大的值
 * 		
 * */
public class aug09_medium209 {
	public static void main(String args[]){
		int[] arr = {2,3,1,2,4,3};
		System.out.println(minSubArrayLen(7, arr));
	}
	
    public static int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        int start=0, end=0;
        int sum=0;
        int min=Integer.MAX_VALUE; //*how to define a max variable
 
        while(start<n && end<n){
        	while(sum<s && end<n){
            	sum += nums[end];
            	end++;
            }
            while(sum>=s && start<=end){
            	sum -= nums[start];
            	start++;
            	min = Math.min(min, end-start+1); //*use min() function
            }	
        }
        if(min==Integer.MAX_VALUE)
        	min=0;
        return min;
    }
}
