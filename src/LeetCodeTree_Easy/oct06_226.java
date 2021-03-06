
public class oct06_226 {

	public static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		
		private TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static void main(String[] args){
		// test here
	}
	
    public TreeNode invertTree(TreeNode root) {
        // 1. exit; end rec
    	if(root == null)
        	return null;
        
    	// 2. if not null, process current node
    	TreeNode left = root.left;
    	TreeNode right = root.right;
    	root.left = right;
    	root.right = left;
    	
    	// 3. coz we need to process the whole tree: process left node & right node
    	invertTree(root.left);
    	invertTree(root.right);
    	
    	return root;
    }
}
