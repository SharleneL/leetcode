package LeetCodeTree_Medium;

import java.util.LinkedList;

/**
 * Created by luoshalin on 12/26/15.
 */

// 参考:http://blog.csdn.net/ljiabin/article/details/49474445

public class medium297 {
    public static void main(String[] args){
        // test goes here
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public class Codec {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            String nodeStr="";
            StringBuilder resStr = new StringBuilder();
            // level order traversal
            if(root==null){
                return nodeStr;
            }
            LinkedList<TreeNode> q = new LinkedList<TreeNode>();
            q.add(root);
            while (!q.isEmpty()){
                TreeNode cur = q.poll();
                // process & save to str
                if(cur==null){
                    resStr.append("#,");
                }else{
                    resStr.append(cur.val).append(',');
                    q.add(cur.left);
                    q.add(cur.right);
                }
            }
            nodeStr = resStr.substring(0, resStr.length()-1).toString();   // remove the last char ','
            return nodeStr;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if(data==null || data.length()==0)
                return null;

            String[] strArr = data.split(",");
            TreeNode nodeArr[] = new TreeNode[strArr.length];
            int nulls[] = new int[strArr.length];                // number of null nodes before this node
            for(int i=0; i<strArr.length; i++){
                if(i>0)
                    nulls[i] = nulls[i-1];
                if(strArr[i].equals("#")){
                    nodeArr[i]=null;
                    nulls[i]++;
                }else {
                    nodeArr[i] = new TreeNode(Integer.parseInt(strArr[i]));
                }
            }

            for(int i=0; i<nodeArr.length; i++){
                if(nodeArr[i]==null){
                    continue;
                }
                nodeArr[i].left = nodeArr[2*(i-nulls[i])+1];
                nodeArr[i].right = nodeArr[2*(i-nulls[i])+2];
            }
            return nodeArr[0];
        }
    }

}
