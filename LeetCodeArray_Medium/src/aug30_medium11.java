/*
 * 题意：想象一下一个二维坐标系，对应每个x=1,2,3...画一条垂直于x轴的线段，端点为(x, y)和(x, 0)，其中y>=1。这些线段中任意两条和x轴可以构成一个盛水的容器，求容器的最大容积。
 * 		哎这个脑洞也真是大啊....
 * 思路：我现在想到的是最大容积为max( |i-j|*min(ai, aj) ) 来一发动态规划。但是怎么规划我没想出来
 * 参考：http://www.cnblogs.com/lautsie/p/3219461.html
 * 步骤：1.分别取最左和最右的L1和R1。此时容器宽度最大。
 * 	    2.将L1和R1往中间移动。只有当L1或者R1的高度增加才有可能让容积变大。因此移动的思路是这样的：
 * 			a. 比较L1和R1，移动L1和R1中较短的那个（始终牢记容积是由短板决定）
 * 			b. 往中间移动到第一个比自己高的那条，计算当前容积，计算max
 * 			c. 返回a，再次比较新的L1和R1
 * 
 * */
public class aug30_medium11 {
	public static void main(String[] args){
		int[] height = {10,9,8,7,6,5,4,3,2,1};
		System.out.println(maxArea(height));
	}
    public static int maxArea(int[] height) {
    	// special case
    	if(height==null || height.length<2)
    		return Integer.MIN_VALUE;
 
    	// step1
        int indexL=0, indexR=height.length-1;
        int area = (indexR-indexL) * Math.min(height[indexL], height[indexR]);
        while(indexL<indexR){
        	// step2.a - 左边短
        	if(height[indexL]<=height[indexR]){
        		// step2.b 找到比自己高的那条
        		while((indexL+1<indexR)&&(height[indexL+1]<height[indexL])){
        			indexL++;
        		}
        		++indexL;
        		// step 2.b 计算面积
        		area = Math.max(area, (indexR-indexL) * Math.min(height[indexL], height[indexR]));
        	}
        	// 右边短
        	if(height[indexL]>height[indexR]){
        		while((indexR-1>indexL)&&(height[indexR-1]<height[indexR])){
        			indexR--;
        		}
        		--indexR;
        		// step 2.b 计算面积
        		area = Math.max(area, (indexR-indexL) * Math.min(height[indexL], height[indexR]));
        	}
        }
        return area;
    }
}
