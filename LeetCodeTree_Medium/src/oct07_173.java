import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class oct07_173 {

	/**********pre-requisition**********/
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		private TreeNode(int val){
			this.val = val;
		}
	}
	
	public static void main(String[] args){
		// test goes here
	}
	/**********pre-requisition**********/
	
	
	// solution starts from here
	List<Integer> list;		// list to store the node values
	int index = 0;
	
    public oct07_173(TreeNode root) {		// the iterator obj initialization
    	list = inorder(root);				// get the node list after tree's inorder traversal
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(index < list.size())
        	return true;
        return false;
    }

    /** @return the next smallest number */
    public int next() {
        return list.get(index++);
    }
    
    public List inorder(TreeNode root) {				// Btree's inorder traversal
    	List<Integer> list = new ArrayList<Integer>();
    	if(root==null)
    		return list;
    	TreeNode cur = root;
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	while(true){
    		while(cur != null){
    			stack.push(cur);
    			cur = cur.left;
    		}
    		if(stack.isEmpty())
    			break;
    		cur = stack.pop();
    		list.add(cur.val);
    		cur = cur.right;
    	}
    	return list;
    }
}