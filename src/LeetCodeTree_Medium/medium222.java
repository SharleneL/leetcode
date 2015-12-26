package LeetCodeTree_Medium;

/**
 * Created by luoshalin on 12/26/15.
 */
public class medium222 {
    public static void main(String[] args){
        // test goes here
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int countNodes(TreeNode root) {
        if(root==null)
            return 0;

        int leftHeight = 0;
        int rightHeight = 0;
        TreeNode leftNode = root;
        TreeNode rightNode = root;
        while(leftNode.left!=null){
            leftNode = leftNode.left;
            leftHeight++;
        }
        while(rightNode.right!=null){
            rightNode = rightNode.right;
            rightHeight++;
        }

        if(leftHeight==rightHeight){
            return (2 << (leftHeight)) - 1;
        }
        else{
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }
}
