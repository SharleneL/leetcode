package LeetCodeDFS;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luoshalin on 12/22/15.
 */

// 就是DFS找到每条path
// 经典题啊

public class easy257 {
    public static void main(String[] args) {
        // test goes here
    }
    // helper class
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root==null)
            return res;

        // root!=null
        String path = "";
        DFS(root, path, res);
        return res;
    }

    public void DFS(TreeNode node, String path, List<String> res){
        // process current
        String curPath = path + "->" + String.valueOf(node.val);
        // return condition - leaf node
        if(node.right==null && node.left==null) {
            res.add(curPath.substring(2));
            return;
        }
        // process next - every son
        if(node.left!=null)
            DFS(node.left, curPath, res);
        if(node.right!=null)
            DFS(node.right, curPath, res);
    }

}
