package LeetCodeDFS;

/**
 * Created by luoshalin on 12/22/15.
 */

// 和257一样,都是DFS找路
// 好吧为了练习我再写一遍不偷懒
// 发现一个坑: int有局部值,所以sum要返回,不能像path一样直接传,不然调用函数里的sum还是原来的sum不会因为在调用函数中被改变

public class medium129 {
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

    public int sumNumbers(TreeNode root) {
        int sum = 0;
        if(root==null)
            return sum;

        // if root not null
        int num = 0;    // the num for current path
        sum = DFS(root, num, sum);
        return sum;
    }
    public int DFS(TreeNode root, int num, int sum){
        // process current
        num = num*10 + root.val;
        // return condition - leaf node
        if(root.left==null && root.right==null){
            sum += num;
            return sum;
        }

        // process next
        if(root.left!=null)
            sum = DFS(root.left, num, sum);
        if(root.right!=null)
            sum = DFS(root.right, num, sum);
        return sum;
    }

}
