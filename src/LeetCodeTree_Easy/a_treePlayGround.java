//import java.util.*;
//
///*
// * For practice!!
// * 104/111
// * minDepth和maxDepth的区别存在于 ***左右儿子都有&&左右儿子depth不同*** 的情况
// * min的时候挑小的返回；max的时候挑大的返回
// * 如果只有一个儿子的话都是返回单边depth
// * */
//
//public class a_treePlayGround {
//    /******************************/
//    public class TreeNode {
//        private int val;
//        private TreeNode left;
//        private TreeNode right;
//
//        public TreeNode(int val){
//            this.val = val;
//        }
//    }
//    /******************************/
//
//    public int getNodeNumRec(TreeNode root){
//        if(root==null)
//            return 0;
//
//        return getNodeNumRec(root.left)+getNodeNumRec(root.right)+1;
//    }
//    public int getNodeNum(TreeNode root){
//        if(root==null)
//            return 0;
//        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
//        queue.add(root);
//        int res = 1;
//        while(!queue.isEmpty()){
//            TreeNode cur = new TreeNode();
//            cur = queue.poll();
//            if(cur.left!=null){
//                queue.add(cur.left);
//                res++;
//            }
//            if(cur.right!=null){
//                queue.add(cur.right);
//                res++;
//            }
//        }
//        return res;
//    }
//
//    public int getDepthRec(TreeNode root){
//        if(root==null)
//            return 0;
//
//        return Math.max(getDepthRec(root.left), getDepthRec(root.right)) + 1;
//    }
//    public int getDepth(TreeNode root){
//        if(root==null)
//            return 0;
//
//        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
//        queue.add(root);
//        int depth = 1;
//        int curLevel = 1;
//        int nextLevel = 0;
//        while(!queue.isEmpty()){
//            TreeNode cur = new TreeNode();
//            cur = queue.poll();
//            curLevel--;
//            if(cur.left!=null){
//                queue.add(cur.left);
//                nextLevel++;
//            }
//            if(cur.right!=null){
//                queue.add(cur.right);
//                nextLevel++;
//            }
//            if(curLevel==0){
//                depth++;
//                curLevel = nextLevel;
//                nextLevel = 0;
//            }
//        }
//        return depth;
//    }
//
//    public void preOrder(TreeNode root){
//        if(root==null)
//            return;
//
//        Stack<TreeNode> stack = new Stack<TreeNode>();
//        stack.push(root);
//        while(!stack.isEmpty()){
//            TreeNode cur = stack.pop();
//            if(cur.right!=null)
//                stack.push(cur.right);
//            if(cur.left!=null)
//                stack.push(cur.left);
//        }
//    }
//
//    public void inOrder(TreeNode root){
//        if(root==null)
//            return;
//
//        Stack<TreeNode> stack = new Stack<TreeNode>();
//        TreeNode cur = root;
//        while(true){
//            while(cur!=null){
//                stack.push(cur);
//                cur = cur.left;
//            }
//            if(stack.isEmpty())
//                break;
//            cur = stack.pop();
//            System.out.println(cur.val;)
//            cur = cur.right;
//        }
//
//    }
//
//    public void postOrder(TreeNode root){
//        if(root==null)
//            return;
//
//        Stack<TreeNode> stack = new Stack<TreeNode>();
//        Stack<TreeNode> output = new Stack<TreeNode>();
//        stack.push(root);
//        while(!stack.isEmpty()){
//            TreeNode cur = new TreeNode();
//            cur = stack.pop();
//            output.push(cur);
//            if(cur.left!=null)
//                stack.push(cur.left);
//            if(cur.right!=null)
//                stack.push(cur.right);
//        }
//        while(!output.isEmpty()){
//            System.out.print(output.pop().val);
//        }
//    }
//
//    public boolean isSameRec(TreeNode root1, TreeNode root2){
//        if(root1==null){
//            if(root2==null)
//                return true;
//            else
//                return false;
//        }
//
//        if(root1.val!=root2.val)
//            return false;
//        return isSameRec(root1.left, root2.left) && isSameRec(root1.right, root2.right);
//    }
//
//    public boolean isSame(TreeNode root1, TreeNode root2){
//        if(root1==null){
//            if(root2==null)
//                return true;
//            else
//                return false;
//        }
//
//        Stack<TreeNode> stack1 = new Stack<>();
//        Stack<TreeNode> stack2 = new Stack<>();
//        stack1.push(root1);
//        stack2.push(root2);
//        while (!stack1.isEmpty() && !stack2.isEmpty()){
//            TreeNode cur1 = stack1.pop();
//            TreeNode cur2 = stack2.pop();
//            if(cur1.val!=cur2.val)
//                return false;
//            if(cur1.right!=null && cur2.right!=null){
//                stack1.push(cur1.right);
//                stack2.push(cur2.right);
//            }
//            if(cur2.left!=null && cur2.left!=null){
//                stack1.push(cur1.left);
//                stack2.push(cur2.left);
//            }
//        }
//        return true;
//    }
//
//    // to isAVL
//
//}
