/* 08-07-2015
 * 方法1是整个数组每次移动一个单元，移动k轮。注意：从后向前移动，arr[n-1]=temp
 * 方法2是将数组的前一半倒置；后一半倒置；整个倒置
 * 方法2注意：如果先整个倒置的话，前一半和后一半的分界点就发生变化了，要数清楚；
 * 
 * 经典算法：倒置算法
 * */

import java.util.Arrays;

public class easy189 {
	public static void main(String args[]){
		int arr[] = {1, 2, 3};
		rotate2(arr, 1);
		// *how to print an int array
		String arrString = Arrays.toString(arr);
		System.out.println(arrString);
	}
	
    public static void rotate1(int[] nums, int k) {
		int n = nums.length;
        for(int step=0; step<k; step++){ // k-round
        	int temp = nums[n-1];
        	for(int i=n-1; i>0; i--){ // move one step backward in each round
        		nums[i] = nums[i-1];
        	}
        	nums[0] = temp;
        }
    }
    
    public static void rotate2(int[] nums, int k) {
    	int n = nums.length;
    	k %= n; //*remember to do this step: k may be too long and >n
    	
    	if(k==0)  //*consider special case
    		return;
    	
    	for(int i=0; i<n/2; i++){ //* careful about the rotate order: whole rotate->rotate 0~k-1->rotate k~n-1
    		int temp = nums[i];
    		nums[i] = nums[n-i-1];
    		nums[n-i-1] = temp;
    	}
    	
    	for(int i=0; i<k/2; i++){
    		int temp = nums[i];
    		nums[i] = nums[k-i-1];
    		nums[k-i-1] = temp;
    	}
    	
    	for(int i=k; i<k+(n-k)/2; i++){ //*CAUTION: the calculation!!
    		int temp = nums[i];
    		nums[i] = nums[n-1+k-i];
    		nums[n-1+k-i] = temp;
    	}	
    }
}


/*
 * 数组倒置算法：
 * 要点：i<start+(tail-start)/2
 * */
//	for(int i = start; i<start+(tail-start)/2; i++){     //*
//	    int temp = nums[i];
//	    nums[i] = nums[tail+start-i-1];
//	    nums[tail+start-i-1] = temp;
//	}