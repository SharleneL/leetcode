/*
 * 题意：把一个二维矩阵转90度
 * 方法：四个点转一圈，多加一个temp值
 * 要点：1. 循环边界的计算: i-[0, col/2]; j-[0, Math.ceil(((double) row) / 2)]
 * 		2. 如何让奇数除以2之后取顶？（就是，现在5/2=2, 如何5/2=3） - Math.ceil(((double) 5) / 2)
 * */
public class aug28_medium48 {
	public static void main(String[] args){
		System.out.println(Math.ceil(((double) 7) / 2.));
		System.out.println(Math.ceil(((double) 7) / 2));
	}
	
    public static void rotate(int[][] matrix) {
    	int n = matrix.length;
    	for (int i = 0; i < n / 2; i++) {
    		for (int j = 0; j < Math.ceil(((double) n) / 2); j++) {
    			int temp = matrix[i][j];
    			matrix[i][j] = matrix[n-1-j][i];
    			matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
    			matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
    			matrix[j][n-1-i] = temp;
    		}
    	}
    }
}
