package LeetCode_Linkedin;

import java.util.ArrayList;

/**
 * Created by luoshalin on 12/14/15.
 */
public class medium173 {

    public static void main(String[] args){
        // test goes here
    }

    public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
    }

    public class BSTIterator {
        int index;
        ArrayList<TreeNode> list;

        public BSTIterator(TreeNode root) {
            list = new ArrayList<>();
            index = 0;
            inOrderDFS(root, list); // save BST as a list with inorder traversal
        }
        private void inOrderDFS(TreeNode root, ArrayList<TreeNode> list){
            if(root==null)
                return;
            inOrderDFS(root.left, list);
            list.add(root);
            inOrderDFS(root.right, list);
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            if(index < list.size())     // index is pointing to the next number to be iterated
                return true;
            return false;
        }

        /** @return the next smallest number */
        public int next() {
            int val = list.get(index).val;
            index++;                    // index will be moved to the next position
            return val;
        }
    }
}
