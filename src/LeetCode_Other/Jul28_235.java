/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*
 * BST的定义：左<中<右
 * 按照数值大小来判断在哪边子树上，递归得到结果
 * 
 * ？递归结果的返回：为什么递归是root.left/root.right，但最后return的是root？
 * */

public class Jul28_235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	TreeNode m = root; //将初始的root保留下来，最后也许要用
    	
        if(((m.val-p.val)*(m.val-q.val) <= 0)) // p/q分别在root两边子树上，或其中之一就是root
        	return m;
        else if((m.val>p.val)&&(m.val>q.val)) // 都在左子树
        	return lowestCommonAncestor(m.left, p, q);
        else if((m.val<p.val)&&(m.val<q.val))
        	return lowestCommonAncestor(m.right, p, q);
        else
        	return root;//白忙活
    }
}
