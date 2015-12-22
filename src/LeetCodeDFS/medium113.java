package LeetCodeDFS;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luoshalin on 12/22/15.
 */
public class medium113 {
    public static void main(String[] args){
        // test goes here
    }
    // helper class
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root==null)
            return res;

        ArrayList<Integer> path = new ArrayList<Integer>();
        helper(root, path, sum, res);
        return res;
    }
    public void helper(TreeNode root, ArrayList<Integer> path, int sum, List<List<Integer>> res){
        if(root==null)
            return;
        // process cur
        path.add(root.val);
        sum -= root.val;
        if(root.left==null && root.right==null){
            if(sum==0)
                res.add(new ArrayList<Integer>(path));      // CAUTION: DO NOT ADD DIRECTLY; NEED TO INITIALIZE ANOTHER NEW LIST
        }
        // process left
        if(root.left!=null)
            helper(root.left, path, sum, res);
        // process right
        if(root.right!=null)
            helper(root.right, path, sum, res);
        path.remove(path.size()-1);
    }
}

//DFS
//helper(root, path, sum, res):
//    // process cur
//    path.add(root)
//    sum -= root
//    if root=leaf:
//        if sum=0:
//            add path to res
//        end if
//        return
//    end if
//    // process left
//    helper(left, path, sum, res)
//    // process right
//    helper(right, path, res)
//end func
