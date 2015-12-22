package LeetCodeStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by luoshalin on 12/20/15.
 */
public class medium144 {
    public static void main(String[] args) {
        // test goes here
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();

        helper(root, res);
        return res;
    }
    public static void helper(TreeNode root, List<Integer> res){
        if(root==null)
            return;

        res.add(root.val);
        helper(root.left, res);
        helper(root.right, res);
    }

    // helper
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
}
