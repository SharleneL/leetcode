import java.util.Arrays;

/*
 * 参考：http://www.cnblogs.com/springfor/p/3857704.html
 * 题意：给一个数组和一个target数，找出数组从从第几个到第几个等于target。跑下来时间得是O(logn)
 * 思路：考虑到时间限制，想到二分法。用三轮二分：
 * 		第一轮，只要mid==target就停下
 * 		第二轮，在[0, mid]里面二分找左边边界。若中间数不是target则边界在右边
 * 		第二轮，在[mid, len-1]里面二分找右边边界。若中间数不是target则边界在左边
 * 要点：
 * 1. 如何对数组排除特殊情况？（null或长度为0）
 * 2. 二分的写法？！？！？！参见line34-line45
 * 3. 将数组作为string打印出来 line18-line19
 * */
public class aug28_medium34 {
	public static void main(String[] agrs){
		int nums[] = {1};
		String stringResult = Arrays.toString(searchRange(nums, 1));
		System.out.println(stringResult);
	}
	
    public static int[] searchRange(int[] nums, int target) {
    	int result[] = {-1, -1};
    	// special occasions － 要点1
    	if(nums==null || nums.length==0)
    		return null;
    	
        int low = 0;
        int high = nums.length-1;
        int mid = (low+high)/2;
        
        // dichotomy #1 - find the target number
//         要点2 － 二分的写法 － start
        while(low<=high){  			// 是 <= 不是 <
        	mid = (low+high)/2;		// 每次循环都要重新计算mid
        	if(nums[mid]==target) 	// break的情况写在最前面
        		break;
        	if(nums[mid]<target)	// 变换边界
        		low = mid+1;
        	if(nums[mid]>target)
        		high = mid-1;
        }
        if(nums[mid]!=target){
        	return result;
        }
//        要点2 － 二分的写法 － end
        
        // dichotomy #2 - find the left range
        int newlow = 0;
        int newhigh = mid-1;
        int newmid = (newlow+newhigh)/2;
        while(newlow<=newhigh){
        	newmid = (newlow+newhigh)/2;
        	if(nums[newmid]<target)
        		newlow = newmid+1;
        	if(nums[newmid]==target)
        		newhigh = newmid-1;
        }
       result[0] = newlow;
       
       // dichotomy #3 - find the left range
       newlow = mid+1;
       newhigh = nums.length-1;
       while(newlow<=newhigh){
    	   newmid = (newlow+newhigh)/2;
    	   if(nums[newmid]>target)
    		   newhigh = newmid-1;
    	   if(nums[newmid]==target)
    		   newlow = newmid+1;
       }
       result[1] = newhigh; 
       
       return result;
    }
}
