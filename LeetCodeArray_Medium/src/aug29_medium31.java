import java.util.Arrays;

/*
 * 求某一数字排列的下一个排列
 * 思路：比如排列是(2,3,6,5,4,1)
 * 		1. 从后往前找，找到第一个不再递增的位置p（这里是3）。如果p是第一个（654321），则下个排列为当前排列的倒转（123456）
 * 		2. 如果p不是第一个：从后往前找，找到第一个比p大的数（这里是4）；将3和4对换（236541 -> 246531）；将p后面的数全倒转（246531 -> 241356）
 * 要点：1. 如何定义一个函数的参数：swap(int nums[], int start, int end)
 * 		2. 倒置算法：参见数组easy189。但是要随机应变，不是所有的都是start+end-i-1里面要减一的。看你传入的参数是下标还是第几个。
 * 		3. 从后往前／前往后找某个位置的时候，记得用while循环！别用for了！
 * */
public class aug29_medium31 {
	public static void main(String[] args){
		int[] nums = {5, 1, 1};
		nextPermutation(nums);
		System.out.println(Arrays.toString(nums));
	}
    public static void nextPermutation(int[] nums) {
//    	special cases
    	if(nums==null || nums.length<2)
    		return;
    	
    	int n = nums.length;
    	int p;
    	
//    	find position p
    	int i=n-2;
    	while(i>=0 && nums[i]>=nums[i+1])
    		i--;
    	p=i;
    	
//      this is the last permutation, swap the whole array
        if(p==-1){
        	swap(nums, 0, n-1);
        	return;
        }
        else{
//        	from the tail, find the first number > nums[p] and swap
        	for(int j=n-1; j>p; j--){
        		if(nums[j]>nums[p]){
        			int temp = nums[j];
        			nums[j] = nums[p];
        			nums[p] = temp;
        			break;
        		}
        	}
//        	swap the whole array after nums[p]
        	swap(nums, p+1, n-1);
        	return;
        }
    }
    public static void swap(int nums[], int start, int end){
    	int n = end-start+1; // length of the sub-array to be swapped
    	int temp;
    	for(int i=start; i< start+n/2; i++){
    		temp = nums[i];
    		nums[i] = nums[start+end-i];
    		nums[start+end-i] = temp;
    	}
    	return;
    }
}
