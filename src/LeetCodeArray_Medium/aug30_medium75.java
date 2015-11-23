import java.util.Arrays;

/*
 * 题意：给一个数组，里面混合了红白蓝三种obj。将这个数组sort一下，使得所有红色的在一起，白色的在一起，蓝色的在一起。不能用库里的sort方法。
 * 思路：三指针。说白了还是挺简单的。。
 * 步骤：1. 从左往右，指针notred指向第一个不是red的位置
 * 		2. 从右往左，指针notblue指向第一个不是blue的位置
 * 		3. 指针white从notred开始往右走，遇到红色就和notred互换且notred++，遇到蓝色就和notblue互换且notblue--
 * 
 * 要点：1.数组元素swap的话，传入函数的时候传下标和数组，而不能传数组元素！不然对原数组根本没有影响
 * 		2.蓝色的时候white不后移
 * 		3.line28 line30 while循环里对数组越界的判断要放在最前面！如果norred<nums.length放在nums[notred]后面的话数组还是会越界！因为nums[notred]放在前面会被执行！
 * */
public class aug30_medium75 {
	public static void main(String[] args){
//		int[] nums = {0, 2, 0, 1, 0, 1, 2, 2};
		int[] nums = {0, 0};
		sortColors(nums);
		System.out.println(Arrays.toString(nums));
	}
	
    public static void sortColors(int[] nums) {
    	// special cases
    	if(nums==null || nums.length<2)
    		return;
        int notred = 0;
        int notblue = nums.length-1;
        while(notred<nums.length && nums[notred]==0)
        	notred++;
        while(notblue>=0 && nums[notblue]==2)
        	notblue--;
        
        int white=notred;
        while(white<=notblue){
        	if(nums[white]==0){					// 如果是红色，则white和notred互换，notred后移，white也后移
        		swap(white, notred, nums);
        		notred++;
        		white++;
        	}
        	else if(nums[white]==2){
        		swap(white, notblue, nums);
        		notblue--;						// 注意：如果蓝色，则white和notblue互换，notblue前移，white不后移而是保持不变。因为把notblue的元素换到前面之后，还要再检测一边这个元素是不是红的
        	}
        	else
        		white++;
        }
        return;
    }
    public static void swap(int a, int b, int[] nums){
    	int temp = nums[a];
    	nums[a] = nums[b];
    	nums[b] = temp;
    }
}
