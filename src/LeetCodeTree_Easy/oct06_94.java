/*
 * 要存ll里面的话要另外建一个函数
 * class 创建的时候不能加括号！！！ public static class TreeNode {...}
 * class 初始化函数没有返回值！！！是private的！！！
 * */
import java.awt.List;
import java.util.ArrayList;

public class oct06_94 {

	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		private TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static void main(String[] args) {
		
	}
	
    public void helper(TreeNode root, ArrayList list) {
    	// 1. exit
    	if(root == null)
    		return;
    	// 3. process left
    	helper(root.left, list);
    	// 2. process current
    	list.add(root.val);
    	// 3. process right
    	helper(root.right, list);
    }
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();   
        if(root == null)
        	return result;

        helper(root, result);
        return result;
    }
}
