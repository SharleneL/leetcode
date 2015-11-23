/*
 * 这个题虽然代码很短但还是挺难的。。真的不太想得清楚，而且return条件要想明白，挺容易想不清楚的。
 * 题意：找一个数组中峰值的index。峰值就是说比左右邻居都要大的数。找到一个就行，不用找全部的。
 * 思路：因为要求OlogN，想到二分法。那么可以讨论：如果mid比下一个数大会怎么样？如果mid比下一个数小会怎么样？
 * 		如果中间元素大于其相邻后续元素，则中间元素左侧(包含该中间元素）必包含一个局部最大值。
 * 		如果中间元素小于其相邻后续元素，则中间元素右侧必包含一个局部最大值。
 * 		（因为nums[0]和nums[n-1]为无穷小，因此肯定有一个peak值）
 * 步骤：使用左右指针指定比较范围。如果mid大于mid+1则在[0, mid]里找；如果mid小于mid+1则在[mid+1, n-1]里找(如果mid等于mid+1的话在左边或右边找都行)
 * */
public class aug31_medium162 {
	public static void main(String[] args){
		int[] nums = {1, 2, 3, 5, 4};
		System.out.println(findPeakElement(nums));
	}
    public static int findPeakElement(int[] nums) {
        int n = nums.length;
        int left = 0, right = n-1;
        while(left<right){
        	int mid = (left+right)/2;
        	if(nums[mid]>nums[mid+1]){
        		right = mid;
        	}
        	if(nums[mid]<=nums[mid+1]){
        		left = mid+1;
        	}
        }
    	return left; // 此时left<right
    }
}
