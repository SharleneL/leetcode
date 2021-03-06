import java.util.LinkedList;


public class oct05_104 {

	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		private TreeNode(int val){
			this.val = val;
		}
	}
	
	public static void main(String[] args) {
		// test goes here
	}
	
    public int maxDepth1(TreeNode root) {
        if(root == null )
        	return 0;
        return Math.max(maxDepth1(root.left), maxDepth1(root.right)) + 1;
    }
    
    public int maxDepth2(TreeNode root) {
    	if(root == null)
    		return 0;
    	
    	int depth = 0;							// depth = 1 然后下面那两行不要注释掉就是findmin！！！
    	int curLevelCount = 1;
    	int nextLevelCount = 0;
    	LinkedList<TreeNode> queue = new LinkedList<TreeNode>();	// how to initialize a LL
    	queue.add(root);
    	
    	while(!queue.isEmpty()) {				// use isEmpty!!!! Not ==null!!!!
    		TreeNode curNode = queue.poll();	// retrieve & remove the head node
    		curLevelCount--;					// pop one & minus the number
    // 		if(curNode.left==null && curNode.right==null)	// !!! 不注释掉这两行 然后depth初始值为1就是findmin！！！
    // 			return depth;
    		if(curNode.left != null){			// add left node to Q if not null
    			queue.add(curNode.left);
    			nextLevelCount++;
    		}
    		if(curNode.right != null) {			// add right node to Q if not null
    			queue.add(curNode.right);
    			nextLevelCount++;
    		}
    		if(curLevelCount == 0){				// finish adding current level nodes' sons
    			curLevelCount = nextLevelCount;
    			nextLevelCount = 0;
    			depth++;						// finish one level, add one to depth
    		}
    	}
    	return depth;
    }
	
}
