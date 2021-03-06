/*
 * 自身左右比较的话，拆成左右两边子树 另开一个函数比较！！！
 * */
public class oct07_101 {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		private TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static void main(String[] args) {
		// test goes here
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(2);
		TreeNode n4 = new TreeNode(3);
		TreeNode n5 = new TreeNode(3);
		
		n1.left = n2;
		n1.right = n3;
		n2.right = n4;
		n3.left = n5;
		
		System.out.println(isSymmetric(n1));
	}
	
    public static boolean isSymmetric(TreeNode root) {
    	// when to stop
    	if(root == null)
    		return true;
    	return(isSymmetric(root.left, root.right));
    	
    }
    
    public static boolean isSymmetric(TreeNode p, TreeNode q){
    	// exit
    	if(p==null && q==null)
    		return true;
    	if(p==null || q==null)
    		return false;
    	// process current node
    	// true only when current node and sons all satisfy
    	return(p.val==q.val && isSymmetric(p.right, q.left) && isSymmetric(p.left, q.right));
    }
}
