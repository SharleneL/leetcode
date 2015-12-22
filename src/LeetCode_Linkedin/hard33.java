package LeetCode_Linkedin;

/**
 * Created by luoshalin on 12/14/15.
 */
public class hard33 {
    public static void main(String[] args){
        int nums[] = {1, 2, 3, 4, 5, 6};
        int target = 4;
        System.out.print(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        if(nums==null)
            return -1;

        int len = nums.length;
        int left = 0;
        int right = len-1;
        while(left <= right){
            // exclude corner cases
            if(nums[left]==target)
                return left;
            if(nums[right]==target)
                return right;
            int mid = (left+right)/2;
            if(nums[mid]==target)
                return mid;

            // if value is not at ridges/mid
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
                return -1;
        }
        // if not found
        return -1;
    }
}
