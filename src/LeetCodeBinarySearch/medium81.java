package LeetCodeBinarySearch;

/**
 * Created by luoshalin on 12/26/15.
 */
public class medium81 {
    public boolean search(int[] nums, int target) {
        if(nums==null)
            return false;

        int len = nums.length;
        int left = 0;
        int right = len-1;
        while(left <= right){
            // exclude corner cases
            int mid = (left+right)/2;
            if(nums[left]==target || nums[right]==target || nums[mid]==target)
                return true;

            // if value is not at ridges/mid
            // DIFFERENCE WITH VERSION I: exclude the situation that left & right ridges are the same -> move pointers inward
            if(nums[left]==nums[right]){
                left++;
                right--;
                continue;
            }
            // search left
            if((target>nums[left] && nums[right]>=nums[mid] && nums[left]>nums[right])
                    || (nums[right]>=nums[mid] && nums[mid]>target && nums[left]>nums[right])
                    || (nums[mid]>target && target>nums[left] && nums[left]>nums[right])
                    || (nums[left]<target && target<nums[mid] && nums[mid]<=nums[right])){
                right = mid-1;
            }
            // search right
            else if((nums[right]>target && target>nums[mid] && nums[left]>nums[right])
                    || (target>nums[mid] && nums[mid]>=nums[left] && nums[left]>nums[right])
                    || (nums[mid]>=nums[left] && nums[right]>target && nums[left]>nums[right])
                    || (nums[left]<=nums[mid] && nums[mid]<target && target<nums[right])){
                left = mid+1;
            }
            // out of the upper/lower bound of the array
            else
                return false;
        }
        // if not found
        return false;
    }
}
