import java.util.HashMap;
import java.util.HashSet;



public class LinkedListPlayGround {
	
	private static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int val){
			this.val = val;
		}
	}
	
	public static void main(String[] args){
		// test goes here
	}
	
	public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        HashMap<Integer, Character> map = new HashMap<Integer, Character>();
        
        for(int i=0; i<nums.length; i++){
        	if(set.contains(nums[i]))
        		return false;
        	set.add(nums[i]);
        	
        }
        return true;
    }
	
	
}
