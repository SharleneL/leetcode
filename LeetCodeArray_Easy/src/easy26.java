/* 08-08-2015
 * 题目：从一个有序数组中去除重复的元素，留一个使整个数组不重复，返回不重复数组的长度。不能额外分配空间
 * 思路：快慢指针。指针2快，遍历并找到新出现的不一样的数字，把它存入指针1所指的位置。最后返回指针1所指处的长度
 * 经典算法：数组下标自增：a[i++]和a[++i]是什么？
 * */

import java.util.Arrays;

public class easy26 {
	public static void main(String args[]){
		int[] arr = {1, 1, 1, 1, 1, 1};
		int n = removeDuplicates(arr);
		System.out.println(n);
		System.out.println(Arrays.toString(arr));
	}
	
    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(nums==null || n==0)
        	return 0;
        if(n==1)
        	return 1;
        
        int i=0; // slow pointer
        int key = nums[i];
        for(int j=1; j<n; j++){ 	// fast pointer, move backward
        	if(nums[j]!=key){ 		// find a new different elem
        		i++; 				// slow pointer move backward
        		nums[i] = nums[j]; 	// save to slow pointer
        		key = nums[i];
        	}
        }
        return i+1;
    }
}

/*
 * 数组自增：
 * a[i++]等于a[i]，同时i增加1
 * a[++i]等于a[i+1]
 * */
