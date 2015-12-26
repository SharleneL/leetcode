package LeetCodeDFS;

/**
 * Created by luoshalin on 12/22/15.
 */
public class medium108 {
    public static void main(String[] args){
        // test goes here
    }
    // helper class
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null || nums.length==0)
            return null;

        int start = 0;
        int end = nums.length-1;
        return helper(nums, start, end);
    }
    public TreeNode helper(int[] nums, int start, int end){
        // return case
        if(start>end)           // CAUTION: THE END CASE
            return null;

        // process current
        int mid = (start+end)/2;
        TreeNode newRoot = new TreeNode(nums[mid]);
        // process left
        newRoot.left = helper(nums, start, mid-1);
        // process right
        newRoot.right = helper(nums, mid+1, end);
        return newRoot;         // CAUTION: RETURN THE PROCESSED NODE
    }
}
