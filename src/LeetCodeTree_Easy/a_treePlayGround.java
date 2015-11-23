import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
 * For practice!!
 * 104/111
 * minDepth和maxDepth的区别存在于 ***左右儿子都有&&左右儿子depth不同*** 的情况
 * min的时候挑小的返回；max的时候挑大的返回
 * 如果只有一个儿子的话都是返回单边depth
 * */

public class a_treePlayGround {
/***************************************/	
	public class TreeNode {
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
/***************************************/
	
	
	// 1. get the node count in a tree
	public int getNodeCountRec(TreeNode root){
		int count = 0;
		// 1-special occation & exit
		if(root == null)
			return count;
		
		TreeNode cur = root;
		if(cur==null)
			return count;
		// 2-process current node
		return getNodeCountRec(cur.left) + getNodeCountRec(cur.right) + 1;
	}
	
	// 1. get the node count in a tree
	public int getNodeCount(TreeNode root){
		int count = 0;
		if(root == null)
			return count;
		
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		count++;
		while(!queue.isEmpty()){
			TreeNode cur = queue.poll();
			if(cur.left != null){
				queue.add(cur.left);
				count++;
			}
			if(cur.right != null){
				queue.add(cur.right);
				count++;
			}
		}
		return count;
	}
	
	// 2. get depth
	public int getDepthRec(TreeNode root){
		int depth = 0;
		if(root == null)
			return depth;
		
		return Math.max(getDepthRec(root.left), getDepthRec(root.right))+1;
	}
	
	// 2. get depth
	public int getDepth(TreeNode root){
		if(root == null)
			return 0;
		int depth = 0;
		
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		int curLevelCount = 1;
		int nextLevelCount = 0;
		
		while(!queue.isEmpty()){
			TreeNode cur = queue.poll();
			curLevelCount--;
			if(cur.left != null){
				queue.add(cur.left);
				nextLevelCount++;
			}
			if(cur.right != null){
				queue.add(cur.right);
				nextLevelCount++;
			}
			if(curLevelCount == 0){
				curLevelCount = nextLevelCount;
				nextLevelCount = 0;
				depth++;
			}
		}
		return depth;
	}
	
	// 4. level traversal (BFS)
	public List levelTraversal(TreeNode root){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(root==null)
			return res;
		
		List<Integer> levelRes = new ArrayList<Integer>();
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.push(root);
		int curLevelCount = 1;	// root != null
		int nextLevelCount = 0;
		
		while(!queue.isEmpty()){
			TreeNode cur = queue.poll();
			curLevelCount--;
			levelRes.add(cur.val);
			if(cur.left != null){
				queue.push(cur.left);
				nextLevelCount++;
			}
			if(cur.right != null){
				queue.push(cur.right);
				nextLevelCount++;
			}
			if(curLevelCount == 0){
				curLevelCount = nextLevelCount;
				nextLevelCount = 0;
				res.add(levelRes);
			}
		}
		return res;
	}
	
	// 5. convert BST to double LL - 递归，将根的左边指向左树处理完后的最右一个元素；右边指向右树处理完后的最左一个元素
	public TreeNode convertBST2DLLRec(TreeNode root){
		root = convertBST2DLLSubRec(root);
		while(root.left != null)
			root = root.left;
		return root;
	}
	public static TreeNode convertBST2DLLSubRec(TreeNode root){
		// exit
		if(root==null || (root.left==null && root.right==null))
			return root;
		
		// current node
		if(root.left != null){
			TreeNode leftNode = convertBST2DLLSubRec(root.left);
			while(leftNode.right!=null)
				leftNode = leftNode.right;
			leftNode.right = root;
			root.left = leftNode;
		}
		if(root.right != null){
			TreeNode rightNode = convertBST2DLLSubRec(root.right);
			while(rightNode.left!=null)
				rightNode = rightNode.left;
			rightNode.left = root;
			root.right = rightNode;
		}
		return root;
	}
	
	// 5. convert BST to double LL - 迭代
	public TreeNode convertBST2DLL(TreeNode root){
//		if(root==null)
//			return null;
//		Stack<TreeNode> stack = new Stack<TreeNode>();
//		TreeNode curNode = root;
//		TreeNode lastNode = null;
//		
//		while(true){
//			while(curNode!=null){
//				stack.push(curNode);
//				curNode = curNode.left;
//			}
//			if(stack.isEmpty())
//				break;
//			curNode = stack.pop();
//			if(lastNode != null){
//				lastNode.right = curNode;
//				curNode.left = lastNode;
//				lastNode = curNode;
//			}
//			curNode = curNode.right;
//		}
		
	}

	// 6. get the node count for the Kth level
	public int getNodeNumKthLevel(TreeNode root, int k){
		int res = 0;
		if(root == null)
			return res;
		
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		int level = 0;
		int curLevelCount = 0;
		int nextLevelCount = 0;
		
		queue.add(root);
		curLevelCount++;
		level++;
		
		while(level != k){
			while(!queue.isEmpty()){
				TreeNode cur = queue.poll();
				curLevelCount--;
				if(cur.left != null){
					queue.add(cur.left);
					nextLevelCount++;
				}
				if(cur.right != null){
					queue.add(cur.right);
					nextLevelCount++;
				}
				if(curLevelCount==0){
					curLevelCount = nextLevelCount;
					nextLevelCount = 0;
					level++;
				}
			}
		}
		return curLevelCount;
	}

	// 7. get the number of leaf nodes
	public int getNodeNumLeafRec(TreeNode root){
		if(root == null)
			return 0;
		
		if(root.left==null && root.right==null)
			return 1;
		return getNodeNumLeafRec(root.left) + getNodeNumLeafRec(root.right);
	}
	
	// 7.get the number of leaf nodes
	public int getNodeNumLeaf(TreeNode root){
		if(root==null)
			return 0;
		
		int res = 0;
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		
		queue.push(root);
		
		while(!queue.isEmpty()){
			TreeNode cur = queue.poll();
			if(cur.left==null && cur.right==null)
				res++;
			else{
				if(cur.left!=null)
					queue.push(cur.left);
				if(cur.right!=null)
					queue.push(cur.right);
			}
		}
		return res;
	}

	// 8. whether 2 trees are the same
	public boolean isSameRec(TreeNode p, TreeNode q){
		if(p==null || q==null){
			if(p==null && q==null)
				return true;
			return false;
		}
		return p.val==q.val && isSameRec(p.left, q.left) && isSameRec(p.right, q.right);
	}

	// 8. whether 2 trees are the same
	public boolean isSame(TreeNode p, TreeNode q){
		if(p==null || q==null){
			if(p==null && q==null)
				return true;
			return false;
		}
		
		// preorder traversal
		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		Stack<TreeNode> stack2 = new Stack<TreeNode>();
		stack1.push(p);
		stack2.push(q);
		while(!stack1.isEmpty() && !stack2.isEmpty()){
			TreeNode cur1 = stack1.pop();
			TreeNode cur2 = stack2.pop();
			if(cur1==null && cur2==null)
				continue;
			else{
				if(cur1.val != cur2.val)
					return false;
				if(cur1.right!=null && cur2.right!=null){
					stack1.push(cur1.right);
					stack2.push(cur2.right);
				}
				if(cur1.left!=null && cur2.left!=null){
					stack1.push(cur1.left);
					stack2.push(cur2.left);
				}
				else
					return false;
			}
		}
		return true;
	}
	
	// 9. judge whether a B tree is an AVL tree
	public boolean isAVLRec(TreeNode root){
		if(root==null)
			return false;
		return isAVLRec(root.left) && isAVLRec(root.right) && Math.abs(getDepth(root.left) - getDepth(root.right))<=1;
	}
	
	// 10. get the mirror of a B tree - destroy
	public TreeNode mirrorRec(TreeNode root){
		if(root==null)
			return null;
		
		TreeNode left = mirrorRec(root.left);
		TreeNode right = mirrorRec(root.right);
		root.left = right;
		root.right = left;
		return root;
	}
	
	// 10.get the mirror of a B tree - non destroy
	public TreeNode mirrorCopyRec(TreeNode root){
		if(root==null)
			return null;
		
		TreeNode newRoot = new TreeNode(root.val);
		newRoot.left = mirrorCopyRec(root.right);
		newRoot.right = mirrorCopyRec(root.left);
		return newRoot;
	}

	// 10.1 judge 2 trees whether they are mirrors
	public boolean isMirrorRec(TreeNode p, TreeNode q){
		if(p==null || q==null){
			if(p==null && q==null)
				return true;
			return false;
		}
		return p.val==q.val && isMirrorRec(p.left, q.right) && isMirrorRec(p.right, q.left);
	}

	// 11. find the deepest common ancestor of 2 nodes
	public TreeNode getLastCommonParentRec(TreeNode p, TreeNode q, TreeNode root){
		if((nodeInTree(p, root.left)&&nodeInTree(q, root.right)) || (nodeInTree(p, root.right)&&nodeInTree(q, root.left)))
			return root;
		if(nodeInTree(p, root.left)&&nodeInTree(q, root.left))
			return getLastCommonParentRec(p, q, root.left);
		if(nodeInTree(p, root.right)&&nodeInTree(q, root.right))
			return getLastCommonParentRec(p, q, root.right);
		else
			return null;
	}
	public boolean nodeInTree(TreeNode p, TreeNode root){
		if(p==null || root==null)
			return false;
		if(p==root)
			return true;
		return nodeInTree(p, root.left) || nodeInTree(p, root.right);
	}
	
	
	
	
	
	// inorder traversal - nonRec
	public List inorder(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if(root==null)
			return res;
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode cur = root;
		while(true){
			// 1
			while(cur != null){
				stack.push(cur);
				cur = cur.left;
			}
			// 2
			if(stack.isEmpty())
				break;
			// 3
			cur = stack.pop();
			res.add(cur.val);
			// 4
			cur = cur.right;
		}
		return res;
	}
	
	// preorder traversal - nonRec
	public List preorder(TreeNode root){
		List<Integer> res = new ArrayList<Integer>();
		if(root == null)
			return res;
		
		TreeNode cur = root;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		// 1
		stack.push(root);
		while(!stack.isEmpty()){
			cur = stack.pop();
			res.add(cur.val);
			
			if(cur.right != null)
				stack.push(cur.right);
			if(cur.left != null)
				stack.push(cur.left);
		}
		return res;
	}

	// postorder traversal - nonRec
	public List postorder(TreeNode root){
		List<Integer> res = new ArrayList<Integer>();
		if(root == null)
			return res;
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Stack<TreeNode> output = new Stack<TreeNode>();
		TreeNode cur = root;
		
		stack.push(root);
		while(!stack.isEmpty()){
			cur = stack.pop();
			output.push(cur);
			if(cur.left != null)
				stack.push(cur.left);
			if(cur.right != null)
				stack.push(cur.right);
		}
		while(!output.isEmpty()){
			res.add(output.pop().val);
		}
		return res;
	}
}