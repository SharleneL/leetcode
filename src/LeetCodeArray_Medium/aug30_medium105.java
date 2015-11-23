import java.util.HashMap;

import aug30_medium106.TreeNode;

/*
 * 参考：http://blog.csdn.net/linhuanmars/article/details/24389549
 * 题意：给出一个Btree的inorder和preorder遍历的结果，还原回这棵树
 * 理解：最后返回的结果是根节点，根节点有左右指针因此可以代表整棵树。结合medium106看，那个是postorder和inorder还原树的
 * 思路：假设树的先序遍历是12453687，中序遍历是42516837。
 * 		1. 从preorder得到pre[0]=1是root
 * 		2. 在inorder中找到root的位置在in[3]
 * 		3. root的leftTree为in[0]-in[2]; rightTree为in[4]-in[7]
 * 		4. 通过左右子数的元素个数得知在preorder中，leftTree为pre[0+1]-pre[0+1+2], rightTree为pre[0+1+2+1]-pre[0+1+2+1+3]
 * 		5. 分别对左右子树递归以上过程
 * 
 * 步骤：1. 我们使用一个map来存储inorder，来实现思路2的位置寻找（因为题目里说树里没有重复元素因此可以用map）
 * 		2. 进入递归函数：a.创建根 b.递归左子树 c.递归右子树 d.一层层跳出递归：return root
 * 
 * 要点：1. 注意TreeNode class的定义！
 * 		2. 最重要的地方为思路4中左右子树边界位置的确定
 * 		3. 注意findRoot函数最开始几行中对特殊情况的判断。还不是很理解。
 * */


public class aug30_medium105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	// special cases
    	if(preorder==null || inorder==null || preorder.length==0 || inorder.length==0)
    		return null;
    	
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<inorder.length; i++){
        	// step 1 － 因为我们要寻找的是元素位置，因此i作为value而不是key
        	map.put(inorder[i], i);
        }
        return findRoot(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, map);
    }
    
    // step 2
    // 本函数的目的是给你一个preorder和一个inorder数组，找到这里面的root
    // preorder数组，找root范围的左边起点，找root范围的右边终点；inorder数组，找root范围的左边起点，找root范围的右边终点；用于在inorder中定位的map
    public static TreeNode findRoot(int[] preorder, int preL, int preR, int[] inorder, int inL, int inR, HashMap<Integer, Integer> map){
    	// 只有一个元素的时候从这个地方跳出
    	if(preL>preR || inL>inR)  
            return null; 
    	// step2.a
    	TreeNode root = new TreeNode(preorder[preL]);
    	int index = map.get(preorder[preL]);
    	
    	// step2.b,c; 思路3,4
    	// leftTree为in[0]-in[2]; pre[0+1]-pre[0+(3-0)]。index指在3处
    	root.left = findRoot(preorder, preL+1, preL+(index-inL),  // index-inL是左子数元素个数
    						 inorder,  inL,	   index-1,
    						 map);
    	// rightTree为in[4]-in[7]; pre[0+(3-0)+1]-pre[7]
    	root.right = findRoot(preorder, preL+(index-inL)+1, preR,
    						  inorder,  index+1, 			inR,
    						  map);
    	
    	// step2.d
    	return root;
    }
    
    public class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x) { val = x; }
    }
}
