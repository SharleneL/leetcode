package LeetCodeDFS;

/**
 * Created by luoshalin on 12/22/15.
 */
public class medium116 {
    public static void main(String[] args){
        // test goes here
    }
    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }

    public void connect(TreeLinkNode root) {
        // process current
        if(root==null)
            return;

        if(root.left!=null){
            root.left.next = root.right;
        }
        if(root.right!=null && root.next!=null){
            root.right.next = root.next.left;
        }
        // process left
        connect(root.left);
        // process right
        connect(root.right);
    }
}
