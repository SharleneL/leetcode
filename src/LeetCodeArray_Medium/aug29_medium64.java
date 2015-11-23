/*
 * 题意：求矩阵路径上数字的最小和
 * 参见medium62最短路径。递归公式：sum[i][j] = Math.min(sum[i-1][j]+grid[i][j], sum[i][j-1]+grid[i][j])
 * 要点：主要是对边界的分类讨论不清晰
 * 		可以参考http://www.cnblogs.com/springfor/p/3887701.html
 * 		a. 行为0或列为0则return
 * 		b. sum[0][0] = grid[0][0]初始化
 * 		c. 对第一行和第一列进行求和初始化
 * 		d. 递归求中间位置的值
 * */
public class aug29_medium64 {
    public static void main(String[] args){
    	int[][] grid = {{1,2},{1,1}};
    	System.out.println(minPathSum(grid));
    }
	public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int sum1 = grid[0][0], sum2 = grid[0][0];
        int[][] sum = new int[m][n];
        
        if(grid==null || m==0 || n==0)
        	return Integer.MIN_VALUE;
        sum[0][0] = grid[0][0];
        if(m==1&&n==1)
        	return sum[0][0];
        
        if(m>1){        
        	for(int i=1; i<m; i++){
	        	sum1 += grid[i][0];
	        	sum[i][0] += sum1;
	        }
        }

        if(n>1){	
	        for(int j=1; j<n; j++){
	        	sum2 += grid[0][j];
	        	sum[0][j] += sum2;
	        }
        }
        
        for(int i=1; i<m; i++){
        	for(int j=1; j<n; j++){
        		sum[i][j] = Math.min(sum[i-1][j]+grid[i][j], sum[i][j-1]+grid[i][j]);
        	}
        }
        return sum[m-1][n-1];
    }
}
