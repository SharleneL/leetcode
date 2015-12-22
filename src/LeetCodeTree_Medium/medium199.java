package LeetCodeTree_Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by luoshalin on 12/21/15.
 */
public class medium199 {
    public static void main(String[] args){
        // test goes here
    }

    // levelOrderTraversal & put last elem to res
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();

        if(root==null)
            return res;

        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int curLevel = 1;
        int nextLevel = 0;
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            curLevel--;
            if(cur.left!=null){
                q.offer(cur.left);
                nextLevel++;
            }
            if(cur.right!=null){
                q.offer(cur.right);
                nextLevel++;
            }
            if(curLevel==0){    // this is the last node in this level
                res.add(cur.val);
                curLevel = nextLevel;
                nextLevel = 0;
            }
        }
        return res;
    }

    // helper
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
