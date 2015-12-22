package LeetCode_DP;

import java.util.Arrays;

/**
 * Created by luoshalin on 12/19/15.
 */
public class medium304 {
    public static void main(String[] args){
        // test goes here
    }

    public class NumMatrix {
        private int dp[][];

        public NumMatrix(int[][] matrix) {
            if(matrix==null || matrix.length==0)
                return;
            int row = matrix.length;
            int col = matrix[0].length;
            dp = new int[row+1][col+1];

            Arrays.fill(dp, 0);
            for(int i=1; i<=row; i++){
                for(int j=1; j<=col; j++){
                    dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + matrix[i-1][j-1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return dp[row2+1][col2+1] - dp[row2+1][col1] - dp[row1][col2+1] + dp[row1][col1];
        }
    }

}
