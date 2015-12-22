package LeetCode_DP;

/**
 * Created by luoshalin on 12/19/15.
 */
public class medium63 {
    public static void main(String[] args){
        // test goes here
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid==null)
            return 0;

        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        if(row==0 || col==0)
            return 0;
        if(obstacleGrid[0][0]==1 || obstacleGrid[row-1][col-1]==1)
            return 0;

        int[][] dp = new int[row][col];
        // initialization
        dp[0][0] = 1;
        // first row
        for(int i=1; i<col; i++){
            if(obstacleGrid[0][i] == 1)
                dp[0][i] = 0;
            else
                dp[0][i] = dp[0][i-1];
        }
        // first col
        for(int i=1; i<row; i++){
            if(obstacleGrid[i][0] == 1)
                dp[i][0] = 0;
            else
                dp[i][0] = dp[i-1][0];
        }

        for(int i=1; i<row; i++){
            for(int j=1;j<col; j++){
                if(obstacleGrid[i][j]==1)
                    dp[i][j] = 0;
                else
                    dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        return dp[row-1][col-1];
    }
}


