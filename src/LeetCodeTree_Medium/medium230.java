package LeetCodeTree_Medium;

import java.util.Stack;

/**
 * Created by luoshalin on 12/26/15.
 */

// inorder traversal

public class medium230 {
    public static void main(String[] args){
        // test goes here
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int kthSmallest(TreeNode root, int k) {
        if(root==null || k==0)
            return 0;

        int count=0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while(true){
            while(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            if(stack.isEmpty())
                break;
            cur = stack.pop();
            count++;
            if(count==k)
                return cur.val;
            cur = cur.right;
        }
        return 0;
    }
}
