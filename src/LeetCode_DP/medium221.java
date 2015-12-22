package LeetCode_DP;

/**
 * Created by luoshalin on 12/19/15.
 */
public class medium221 {
    public static void main(String[] args){
        // test goes here
    }
    public int maximalSquare(char[][] matrix) {
        if(matrix==null || matrix.length==0)
            return 0;

        // initialize
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        int max = 0;
        // first row
        for(int i=0; i<col; i++){
            dp[0][i] = matrix[0][i] - '0';
            max = Math.max(max, dp[0][i]);
        }
        // first col
        for(int i=0; i<row; i++){
            dp[i][0] = matrix[i][0] - '0';
            max = Math.max(max, dp[i][0]);
        }

        for(int i=1; i<row; i++){
            for(int j=1; j<col; j++){
                if(matrix[i][j] == '0')
                    dp[i][j] = 0;
                else{
                    if(dp[i-1][j-1]!=0 && dp[i-1][j]!=0 && dp[i][j-1]!=0) {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                        max = Math.max(max, dp[i][j]);
                    }
                    else{
                        dp[i][j] = 1;
                        max = Math.max(max, dp[i][j]);
                    }
                }
            }
        }
        return max * max;
    }
}
