import java.awt.List;
import java.util.ArrayList;

/*
 * 题意：给一个矩阵，螺旋输出
 * 思路：特殊情况是当只有一行的时候不用螺旋，直接输出；否则顺时针来
 * 要点：1. List中加数字：result.add()
 * 		2. res.add 的时候 matrix[x][y++] 数组下标自增是y++还是++y：y++表示matrix[x][y];y++。++y则反过来
 * 		3. sprial的时候循环下标的范围？比如，第一行从左到右的时候是0->n-1还是0->n-2？（第一行全遍历完还是留下最后一个）
 * 			到n-2好一些，如果到n-1的话y++会变成n，这样数组会越界。每循环一边都剩下最后一个位置不要输出，而是留给下一行来输出
 * 		4. 怎么总是忘记special case的判断！！！注意：special case有两种：null和空集
 * 		5. Leetcode里面要返回List，然而Eclipse里面我们要用ArrayList，通不过编译怎么办？List<Integer> res = new ArrayList<>(Integer); 因为List是virtual class
 * */
public class aug31_medium54 {
	public static void main(String[] args){
		int[][] matrix = {{ 1, 2, 3 },
					      { 4, 5, 6 },
					      { 7, 8, 9 }};
		
		ArrayList<Integer> res = spiralOrder(matrix);
		for(int i=0; i<res.size(); i++){
			System.out.print(res.get(i));
		}
	}
	
    public static ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        // special cases
        if(matrix==null || matrix.length==0) // 不能光写matrix==null，因为如果matrix={{}}的话是［空集而不是null］，应该加上长度为0的判断
        	return res;
        
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0;
        int y = 0;
        
        while(m>0 && n>0){
        	if(m==1){
        		for(int i=0; i<n; i++)
        			res.add(matrix[x][y++]);
        		break;
        	}
        	else if(n==1){
        		for(int j=0; j<m; j++)
        			res.add(matrix[x++][y]);
        		break;
        	}
        	// spiral
        	else {
        		// right to left
        		for(int i=0; i<n-1; i++)
        			res.add(matrix[x][y++]);
        		// up to down
        		for(int j=0; j<m-1; j++)
        			res.add(matrix[x++][y]);
        		// left to right
        		for(int i=n-1; i>0; i--)
        			res.add(matrix[x][y--]);
        		// down to up
        		for(int j=m-1; j>0; j--){
        			res.add(matrix[x--][y]);
        		}
        	}
        	m -= 2;
        	n -= 2;
        	x++;
        	y++;
        }
        return res;
    }
}
