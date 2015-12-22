package LeetCodeDFS;

/**
 * Created by luoshalin on 12/22/15.
 */
public class medium114 {
    public static void main(String[] args){
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        n1.left = n2;
        n2.left = n3;
        n2.right = n4;
        n1.right = n5;
        n5.left = n6;

        flatten(n1);
        TreeNode n = n1;
        while (n!=null){
            System.out.println(n.val);
            n = n.right;
        }
    }
    // helper
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void flatten(TreeNode root) {
        if(root==null)
            return;
        TreeNode right = root.right;
        // process current
        root.right = root.left;
        root.left = null;
        // process left
        flatten(root.left);
        // left processed to a list; find the right most node of this list; put the original right tree root to the rightmost node's right
        TreeNode rightMostNode = root;
        while(rightMostNode.right!=null)
            rightMostNode = rightMostNode.right;
        rightMostNode.right = right;
        // process right
        flatten(root.right);
    }
}

//func rec():
//if root==null => return
//处理当前:
//tmp = root.right
//root.right = root.left
//处理左:
//rec(root.left)
//左边处理完了,此时得到一个list,因为之后要处理的右子树的list要接在左递归得到的list后面,所以要找到左递归list最右边的node,把右子树的root放到它右边
//while...
//    rightMostNode = root.right.right...
//end while
//rightMostNode.right = tmp
//处理右:
//rec(tmp)