/* 参考：http://www.cnblogs.com/springfor/p/3886603.html
 * 题意：m*n的棋盘，左上走到右下有几种走法
 * 要点：
 * 1. 注意二维数组！m*n = m行n列 = matrix[m][n]
 * 2. 如何定义一个m*n的数组？
 * 3. 递归！递归！递归！想到棋盘上的任意一点(i,j)，要么从左边来，要么从上边来。因此到达(i,j)应该是到达左边点和上边点的路径数之和。
 * */
public class aug28_medium62 {
	public static void main(String args[]){
		System.out.println(uniquePaths(4, 5));
	}
    public static int uniquePaths(int m, int n) {
        int[][]matrix = new int[m][n];  // 如何定义一个m*n的数组？
        
        // special occasions
        if(m==0 || n==0)
        	return 0;
        if(m==1 || n==1)
        	return 1;
        
        // find the result recursively
        // initialize
        for(int i=0; i<matrix.length; i++)
        	matrix[i][0] = 1;
        for(int j=0; j<matrix[0].length; j++)
        	matrix[0][j] = 1;
        // calculate the result
        for(int i=1; i<matrix.length; i++){
        	for(int j=1; j<matrix[0].length; j++){
        		matrix[i][j] = matrix[i-1][j] + matrix[i][j-1];
        	}
        }
        return matrix[m-1][n-1];
    }
}
