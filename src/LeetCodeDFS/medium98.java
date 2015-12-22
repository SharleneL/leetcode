package LeetCodeDFS;

/**
 * Created by luoshalin on 12/22/15.
 */
public class medium98 {
    public static void main(String[] args){
        // test goes here
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isValidBST(TreeNode root) {
        if(root==null)
            return true;
        if(root.left!=null){
            if(root.right!=null){
                // L & R not null
                TreeNode leftRightNode = root.left;     // left subtree's right-most node
                TreeNode rightLeftNode = root.right;    // right subtree's left-most node
                while(leftRightNode.right!=null)
                    leftRightNode = leftRightNode.right;
                while(rightLeftNode.left!=null)
                    rightLeftNode = rightLeftNode.left;
                return leftRightNode.val<root.val && root.val<rightLeftNode.val && isValidBST(root.left) && isValidBST(root.right);
            }
            else{
                // L not null, R null
                TreeNode leftRightNode = root.left;     // left subtree's right-most node
                while(leftRightNode.right!=null)
                    leftRightNode = leftRightNode.right;
                return leftRightNode.val<root.val && isValidBST(root.left);
            }
        }
        else{
            if(root.right!=null){
                // L null, R not null
                TreeNode rightLeftNode = root.right;    // right subtree's left-most node
                while(rightLeftNode.left!=null)
                    rightLeftNode = rightLeftNode.left;
                return root.val<rightLeftNode.val && isValidBST(root.right);
            }
            // L null, R null
            return true;
        }
    }
}
