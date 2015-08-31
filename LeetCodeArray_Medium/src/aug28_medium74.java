/*
 * 题意：一个二维数组，每行都是sorted，下一行最小也比上一行最大的大，写一个高效的算法知道某个值在不在这个数组中
 * 思路：既然说“高效”那么就二分！参见medium34里的基本二分
 * 		是二维数组，那么就把它拉直来二分。
 * 要点：1. pos=row*col-1; row=pos/col; col=pos%row
 * 		2. 二维数组的special case: 行为0或列为0或null
 * 		3. 刚开始的时候跑的总不是这个class，原来是因为main函数没有加static！这个不会自动报错的！
 * */
public class aug28_medium74 {
	public static void main(String[] args){
		int[][]matrix = {{1, 1}};
		System.out.println(searchMatrix(matrix, 2));
	}
	
    public static boolean searchMatrix(int[][] matrix, int target) {
    	// special case
    	if(matrix.length==0||matrix[0].length==0||matrix==null)             
    		 return false;
    	
    	int row = matrix.length, col = matrix[0].length;
    	int low = 0, high = row*col-1; 
    	int mid, newrow, newcol;
    	boolean result = false;
    	
    	while(low<=high){
    		mid = (low+high)/2;
    		newrow = mid/col;
    		newcol = mid%col;
    		if(matrix[newrow][newcol] == target){
    			result = true;
    			break;
    		}
    		if(matrix[newrow][newcol] > target){
    			high = mid-1;
    		}
    		if(matrix[newrow][newcol] < target){
    			low = mid+1;
    		}
    	}
    	return result;
    }
}
