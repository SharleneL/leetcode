package LeetCode_Linkedin;

/**
 * Created by luoshalin on 12/15/15.
 */
public class medium236 {
    public static void main(String[] args){
        // test goes here
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || p==null || q==null)
            return null;

        if(nodeInTree(p, root.left) && nodeInTree(q, root.left)){
            return lowestCommonAncestor(root.left, p, q);
        }
        else if(nodeInTree(p, root.right) && nodeInTree(q, root.right)){
            return lowestCommonAncestor(root.right, p, q);
        }
        else if((nodeInTree(p, root.left) && nodeInTree(q, root.right)) || (nodeInTree(p, root.right) && nodeInTree(q, root.left))){
            return root;
        }
        else
            return null;
    }

    public static boolean nodeInTree(TreeNode n, TreeNode root){
        if(n==null || root==null)
            return false;

        if(n==root)
            return true;
        return nodeInTree(n, root.left) || nodeInTree(n, root.right);
    }

    // helpers
    public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
    }
}

//# corners
//root==null || p==null || q==null => return null
//p||q not in tree => return null
//
//# thought
//rec: top -> down
//    return root if (pinleft && qinright)||(pinright && qinleft) => helper func : nodeInTree
//    if all in same side
//        find in that side