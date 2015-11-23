//
//public class oct06_100 {
//
//	public static class TreeNode{
//		int val;
//		TreeNode left;
//		TreeNode right;
//
//		private TreeNode(int val) {
//			this.val = val;
//		}
//	}
//
//	public static void main(String[] args){
//		// test here
//	}
//
//    public boolean isSameTree1(TreeNode p, TreeNode q) {
//        if(p==null && q==null)
//        	return true;
//        else if((p==null && q!=null) || (p!=null && q==null))
//        	return false;
//        else {
//        	if(isSameTree1(p.left, q.left) && isSameTree1(p.right, q.right) && p.val==q.val)
//        		return true;
//        }
//        return false;
//    }
//
//    public boolean isSameTree2(TreeNode p, TreeNode q) {
//    	if(p==null && q==null)
//    		return true;
//    	else if((p==null && q!=null) || (p!=null && q==null))
//        	return false;
//
//    	// 遍历
//
//    }
//}
