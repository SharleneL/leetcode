///*
// * 我想不出来啊。。。。。竟然是减掉比。。。
// * */
//
//import oct06_100.TreeNode;
//
//
//public class oct07_112 {
//    public boolean hasPathSum(TreeNode root, int sum) {
//        boolean result = false;
//        if(root==null)
//        	return result;
//
//        // process current node
//        sum -= root.val;
//        if(root.left==null && root.right==null)
//        	return sum==0;
//        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
//    }
//}
