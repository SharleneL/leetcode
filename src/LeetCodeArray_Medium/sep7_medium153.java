/*
 * 竟然一次就ac了。。虽然耗费了不少时间。。
 * 题意：一个递增的数组往后平移几个位置，找到新数组中的最小值
 * 要点：二分寻找，和之前做的一道题一样。纸上画图分析好，一共有以下几种可能性：
 * 		1. mid>l && mid>r  最小值在右边
 * 		2. mid<l && mid<r  最小值在左边
 * 		3. l<mid<r		   最小值在左边
 * 		最后的情况是只有两个元素，因此while的停止条件是l<r-1而不是l<r。返回两个元素中较小的元素即可
 * */
public class sep7_medium153 {
	public static void main(String[] args){
		int nums[] = {4, 5, 6, 7, 0, 1, 2};
		System.out.println(findMin(nums));
	}
	
    public static int findMin(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n-1;
        int mid;
        while(l<r-1){
        	mid = (l+r)/2;
        	if(nums[mid] < nums[r]){ // mid<l&&mid<r, or l<mid<r, find the min on the left
        		r=mid;
        	}
        	if(nums[mid] > nums[r]){ // mid>l&&mid>r, find the min on the right 
        		l = mid;
        	}
        }
        return Math.min(nums[l], nums[r]);
    }
}
