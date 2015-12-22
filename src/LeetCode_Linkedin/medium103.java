package LeetCode_Linkedin;

import java.util.*;

/**
 * Created by luoshalin on 12/14/15.
 */
public class medium103 {
    public static void main(String[] args) {
        // test goes here
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root==null)
            return res;

        List<Integer> curList = new ArrayList<Integer>();      // save current level node values

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode cur = root;
        queue.add(cur);
        int curLevelCount = 1;
        int nextLevelCount = 0;
        while(!queue.isEmpty()){
            cur = queue.poll();
            curLevelCount--;
            curList.add(cur.val);

            if(cur.left!=null) {
                queue.add(cur.left);
                nextLevelCount++;
            }
            if(cur.right!=null){
                queue.add(cur.right);
                nextLevelCount++;
            }

            if(curLevelCount==0){
                curLevelCount = nextLevelCount;
                nextLevelCount = 0;
                res.add(curList);
                curList = new ArrayList<Integer>();
            }
        }

        for(int i=0; i<res.size(); i++){
            if(i%2==0)
                continue;
            ArrayList<Integer> list = (ArrayList)res.get(i);
            // reverse list
            // int len = list.size();
            // for(i=0; i<=(len-1)/2; i++){
            //     int tmp = list.get(i);
            //     list.set(i, list.get(len-1-i));
            //     list.set(len-1-i, tmp);
            // }
            Collections.reverse(list);
        }
        return res;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
}

//
//# conditions & corner cases:
//root = null => return null
//
//# thought1
//levelOrderTraversal => reverse even number level lists
//
//
