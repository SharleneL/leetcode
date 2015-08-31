import java.util.HashMap;

import aug30_medium105.TreeNode;

/*
 * 题意：给出一个Btree的inorder和postorder遍历的结果，还原回这棵树
 * 参考：http://blog.csdn.net/linhuanmars/article/details/24390157
 * 要点：和medium105的原理一样！唯一要注意的是现在根要从后往前找而不是从前往后！就三个地方代码有区别！
 * */

public class aug30_medium106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    	if(postorder==null || inorder==null || postorder.length==0 || inorder.length==0)
    		return null;
    	
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<inorder.length; i++){
        	map.put(inorder[i], i);
        }
        return findRoot(postorder, 0, postorder.length-1, inorder, 0, inorder.length-1, map);
    }
    
    public static TreeNode findRoot(int[] postorder, int postL, int postR, int[] inorder, int inL, int inR, HashMap<Integer, Integer> map){
    	if(postL>postR || inL>inR)  
            return null; 
    	// 区别在这个地方：取root是取postR而不是preL
    	TreeNode root = new TreeNode(postorder[postR]);
    	int index = map.get(postorder[postR]);

    	// 这里post的参数也有区别
    	root.left = findRoot(postorder, postL, postL+(index-inL)-1, 
    						 inorder,  inL,	   index-1,
    						 map);
    	// 这里post的参数也有区别
    	root.right = findRoot(postorder, postR-(inR-index), postR-1,
    						  inorder,  index+1, 			inR,
    						  map);
    	return root;
    }
    
    public class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x) { val = x; }
    }
}
