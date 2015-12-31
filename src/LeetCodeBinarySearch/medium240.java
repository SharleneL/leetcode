package LeetCodeBinarySearch;

/**
 * Created by luoshalin on 12/26/15.
 */

// 参考:http://blog.csdn.net/xudli/article/details/47015825

public class medium240 {
    public static void main(String[] args){
        // test goes here
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0)
            return false;

        int row = matrix.length;
        int col = matrix[0].length;
        int i = 0;
        int j = col-1;
        while (i>=0&&i<row && j>=0&&j<col){
            if(matrix[i][j] < target)
                i++;
            else if(matrix[i][j] > target)
                j--;
            else
                return true;
        }
        return false;
    }
}
