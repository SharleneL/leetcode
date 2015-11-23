///*
// * 题意：给一个三角形的二维数组，求从顶到底的路径之和最短
// * 思路：参见medium64和medium62，都是动态规划求路径的问题。这道也一样，从下向上用递推公式
// * 参考：http://www.cnblogs.com/springfor/p/3887908.html
// * 要点：1. 特殊形状的二维链表怎么取值？取第i行第j个：matrix.get(i).get(j)
// * 		   最后一行的大小：triangle.get(triangle.size()-1).size()
// * */
//public class aug29_medium120 {
//	public static void main(String[] args){
//	}
//
//    public static int minimumTotal(List<List<Integer>> triangle) {
//        // save the result, set the size the same as the last row
//        int[] result = new int[triangle.get(triangle.size()-1).size()];
//        // initialize
//        for(int i=0; i<triangle.get(triangle.size()-1).size(); i++){
//        	result[i] = triangle.get(triangle.size()-1).get(i);
//        }
//
//        for(int i=triangle.size()-2; i>=0; i--){ // 减二不是减一是因为size()-2才是倒数第二行
//        	for(int j=0; j<triangle.get(i).size(); j++){
//            	result[j] = triangle.get(i).get(j) + Math.min(result[j], result[j+1]); // 取上一行相邻两元素的result中较小的
//        	}
//        }
//        return result[0];
//    }
//}
