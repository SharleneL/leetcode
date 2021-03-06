import java.util.LinkedList;

/*
 * 深度为k的完全二叉树，至少有2^{k-1}个节点，至多有2^k-1个节点
 * 深度为1则只有一个结点
 * 递归求解：注意！！！
 * 			1.return递归函数要+1!!!!! 
 * 			2.如果只有一个结点（比如没有左结点），要另外讨论：因为如果直接返回两边较小的结点深度+1，则会返回null node的深度+1，也就是0+1
 * 			但是深度应该是右子树+1（也就是深度较大子树的深度+1）
 * 			3. a?b:c 三元表达式
 * */

public class oct05_easy111 {
	
//	class for tree node
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static void main(String[] args) {
//		test goes here
//		construct the tree
		TreeNode r1 = new TreeNode(1);
		TreeNode r2 = new TreeNode(2);
		TreeNode r3 = new TreeNode(3);
		TreeNode r4 = new TreeNode(4);
		TreeNode r5 = new TreeNode(5);
		TreeNode r6 = new TreeNode(6);
		
		r1.left = r2;
		r1.right = r3;
		r2.left = r4;
		r2.right = r5;
//		r3.right = r6;
		
		System.out.println(minDepth1(r1));
	}
	
	
//	SOLUTION STARTS HERE
	
    public static int minDepth1(TreeNode root) {
        if(root == null)
        	return 0;
    	int depLeft = minDepth1(root.left);
    	int depRight = minDepth1(root.right);
    	if(depLeft==0 || depRight==0) {								// !!!
    		return depLeft >= depRight ? depLeft+1 : depRight+1;  	// !!! +1 !!!
    	}
    	else
    		return Math.min(depLeft, depRight)+1;  					// !!! +1
    }
    
    public static int minDepth2(TreeNode root) {
    	if(root == null)
    		return 0;
    	
    	int depth = 1;
    	int curLevelCount = 1;
    	int nextLevelCount = 0;
    	LinkedList<TreeNode> queue = new LinkedList<TreeNode>();	// how to initialize a LL
    	queue.add(root);
    	
    	while(!queue.isEmpty()) {				// use isEmpty!!!! Not ==null!!!!
    		TreeNode curNode = queue.poll();	// retrieve & remove the head node
    		curLevelCount--;					// pop one & minus the number
    		if(curNode.left==null && curNode.right==null)	// !!! 不能用或！要用且！因为单边空的话不能返回depth！必须要两边空才能返回depth！
    			return depth;
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
    	return depth;							// remember to return outside of the judgement...
    }
}
