import java.util.Arrays;

/* 08-08-15
 * 思路：将中枪的元素和尾部元素互换。一个头指针一个尾部指针
 * while循环使尾指针从后向前找到未中枪元素；移动头指针找到中枪元素；swap；后移头指针
 * 经典算法：交换数组中的两个元素
 * */
public class easy27 {
	public static void main(String args[]){
		int[] arr = {1, 1, 2, 3, 1, 4, 5};
		int n = removeElement(arr, 1);
		System.out.println(n);
		System.out.println(Arrays.toString(arr));
	}
	
    public static int removeElement(int[] nums, int val) {
        int n = nums.length;
        if(nums==null || n==0){ // special case
        	return 0;
        }
        
        int i=0, j=n-1;

        while(j>=0 && nums[j]==val) // find the tail: when using while, consider limit **j>=0**, and put this sentence before nums[j]! or this sentence will have to judge nums[-1] and return error
    		j--;
        if(j<0)
        	return 0;
        
        while(i<=j){
        	if(nums[i] == val){
        		int temp = nums[i];
        		nums[i] = nums[j];
        		nums[j] = temp;
        	}
        	i++;
            while(nums[j]==val)
        		j--; 
        }
        return j+1;
    }
}




/*
 * 交换数组中的两个元素：要把数组作为参数传入
 * */
//	 void swap(int arr[], int i, int j)  
//	 {  
//	     int tmp = arr[i];  
//	     arr[i] = arr[j];  
//	     arr[j] = tmp;  
//	 }  