import java.util.Arrays;

/*
 * 思路：利用第一行和第一列做标记。
 * 		1.检查R1和C1中是否有0并进行标记；
 * 		2.遍历除了R1和C1之外所有的数组元素，如果有0则在R1和C1的对应头做标记
 * 		3.遍历R1和C1，该置0的置0
 * 		4.若1.中，R1和C1中有0，则将R1/C1置0
 * 
 * 要点：
 * 多维数组的定义
 * print数组的方法
 * */
public class aug10_medium73 {
	public static void main(String args[]){
		int[][] matrix = {{0, 0, 0, 5},
		                  {4, 3, 1, 4},
		                  {0, 1, 1, 4}, 
		                  {1, 2, 1, 3},
		                  {0, 0, 1, 1}};
		setZeroes(matrix);
		for(int i=0; i<3; i++){  // 如何输出多维数组
			System.out.println(Arrays.toString(matrix[i]));
		}
	}
	
    public static void setZeroes(int[][] matrix) {
    	boolean columnZero=false, rowZero=false; // to judge C1 and R1 contains 0 or not
    	
        //step1-check C1
    	for(int i=0; i<matrix.length; i++){
        	if(matrix[i][0]==0){
        		columnZero = true;
        		break;
        	}
        }
    	//step1-check R1
    	for(int j=0; j<matrix[0].length; j++){
    		if(matrix[0][j]==0){
    			rowZero = true;
    			break;
    		}
    	}
    	
    	//step2
    	for(int i=1; i<matrix.length; i++){
    		for(int j=1; j<matrix[0].length; j++){
    			if(matrix[i][j]==0){
    				matrix[0][j] = 0;
    				matrix[i][0] = 0;
    			}
    		}
    	}
    	
    	//step3
    	for(int i=1; i<matrix.length; i++){
        	if(matrix[i][0]==0)
        		for(int j=1; j<matrix[0].length; j++)
        			matrix[i][j] = 0;
        }
    	for(int j=0; j<matrix[0].length; j++){
    		if(matrix[0][j]==0)
    			for(int i=1; i<matrix.length; i++)
    				matrix[i][j] = 0;
    	}
    	
    	//step4
    	if(columnZero==true){
    		for(int i=0; i<matrix.length; i++)
    			matrix[i][0] = 0;
    	}
    	if(rowZero==true){
    		for(int j=0; j<matrix[0].length; j++)
    			matrix[0][j] = 0;
    	}
    }
}
