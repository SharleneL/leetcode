///*
// * 注意！！这个解里面的双层List可以通过leetcode编译！！！！！
// *
// * arrayList.remove(int index)是移除index处元素并返回移除元素
// * arrayList.add(elem)和arrayList.push(elem)好像是同样效果
// *
// * 删除ll中所有元素的方法：
// * ArrayList list=new ArrayList();	// 新开辟一片空间！！
// * list.clear(); 					// 把空间里的东西全删掉了！别的地方也引用不到这个list了！
// * list=null;
// * */
//
//import java.awt.List;
//import java.util.ArrayList;
//import java.util.LinkedList;
//
//
//public class oct07_102 {
//
//	public static class TreeNode {
//		int val;
//		TreeNode left;
//		TreeNode right;
//
//		private TreeNode(int val){
//			this.val = val;
//		}
//	}
//
//	public static void main(String[] args) {
//		// test goes here
//		TreeNode root = new TreeNode(1);
//		ArrayList<ArrayList<Integer>> res = levelOrder(root);
//		System.out.println(res.get(0));
//	}
//
//	public List<List<Integer>> levelOrder(TreeNode root) {
//		public List<List<Integer>> levelOrder(TreeNode root) {
//		      List<List<Integer>> result = new ArrayList<List<Integer>>();
//		      LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
//		      List<Integer> levelResult = new ArrayList<Integer>();
//
//		      if(root==null)
//		      	return result;
//		      queue.add(root);
//		      int curLevelCount = 1;
//		      int nextLevelCount = 0;
//
//		      while(!queue.isEmpty()){
//		      	TreeNode cur = queue.poll();
//		      	curLevelCount--;
//		      	levelResult.add(cur.val);
//
//		      	if(cur.left != null){
//		      		queue.add(cur.left);
//		      		nextLevelCount++;
//		      	}
//		      	if(cur.right != null){
//		      		queue.add(cur.right);
//		      		nextLevelCount++;
//		      	}
//
//		      	if(curLevelCount == 0){
//		      		result.add(levelResult);
//		      		levelResult = new ArrayList<Integer>();
//		      		curLevelCount = nextLevelCount;
//		      		nextLevelCount = 0;
//		      	}
//		      }
//		      return result;
//		     }
//	}
//}
