/*
 * 题意：给一个数组，位置i的值num[i]代表从这个位置出发能走(0, num[i])步。问从0位置出发，能不能到达数组最后一个点
 * 参考：http://www.cnblogs.com/springfor/p/3872320.html
 * 思路：感觉我还是没有很明白其中精髓＝ ＝
 * 		计算可能到达的每个点的maxCover。比如i点的maxCover是i+num[i]，就是说最多能走到下标为i+num[i]的位置。然后求所有点的maxCover的最大值。
 * 步骤：1. 从0开始遍历，要点：循环的判断条件很重要i<nums.length-1 && i<=maxCover，就是说i在maxCover范围之内，达到的话就++
 * 		2. 如果maxCover的最大值超过了数组的最后一个下标，表示可以到达最后一个位置
 * */
public class aug30_medium55 {
	public static void main(String[] args){
		int[] nums = {0, 2, 3};
		System.out.println(canJump(nums));
	}
    public static boolean canJump(int[] nums) {
        int maxCover = 0;
        if(nums == null || nums.length==0)
    		return false;
    	if(nums.length==1)
    		return true;
    	for(int i=0; i<nums.length-1 && i<=maxCover; i++){
    		maxCover = Math.max(maxCover, nums[i]+i);
    		if(maxCover>=nums.length-1)
    			return true;
    	}
    	return false;
    }
}
