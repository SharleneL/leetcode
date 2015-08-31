/*
 * 题意：给一个数组，求乘积最大的subarr
 * 思路：medium53是求和最大的subarr，一定要对比着看
 * 		product和求和不同的一点在于，product可能负负得正，因此既要纪录最大值又要纪录最小值。递推公式发生了一些改变
 * 参考：http://www.danielbit.com/blog/puzzle/leetcode/leetcode-maximum-product-subarray
 * */
public class aug30_medium152 {
	public static void main(String[] args){
		int[] nums = {2,3,-2,4};
		System.out.println(maxProduct(nums));
	}
	
    public static int maxProduct(int[] nums) {
    	if(nums==null)
    		return Integer.MIN_VALUE;
    	if(nums.length==0)
    		return 0;
    	
        int maxPdt = nums[0];
        int maxTemp = nums[0];
        int minTemp = nums[0];
        for(int i=1; i<nums.length; i++){
        	int maxTempCopy = maxTemp; // to calculate the minTemp
        	maxTemp = Math.max(nums[i], Math.max(maxTemp*nums[i], minTemp*nums[i])); //  递推公式－注意是和nums[i]比较，不是和本身比较
        	minTemp = Math.min(nums[i], Math.min(maxTempCopy*nums[i], minTemp*nums[i]));
        	maxPdt = Math.max(maxPdt, maxTemp);
        }
        return maxPdt;
    }
}
