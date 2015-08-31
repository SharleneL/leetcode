import java.util.HashMap;

/*
 * 题意：给一个int[] array和一个int target，求这个数组中和为target的两个元素的位置
 * 思路：法1:使用Pair这个数据结构，将原始数组和下标存入新建的Pair数组中；Arrays.sort(pairs)对数组排序；头指针＋尾指针，如果和偏大了就尾指针前移一个，和偏小就头指针后移一个
 * 		参考：http://blog.csdn.net/sunjilong/article/details/17165995
 * 		法2:使用HashMap。将target-array[i]和i作为k-v存入hashmap中；遍历array中元素，如果map中含有某个元素则中枪
 * 		要点：存入hashmap的v是目标和数组元素的*差*
 * 			存hashmap的时候注意谁是k谁是v：因为我们需要的是下标i，因此将i作为value而不是key
 * 要点：java数组的静态初始化和动态初始化 区别
 * */

public class aug09_medium1 {
	public static void main(String args[]){
		int[] arr = {1, 2, 3, 4, 5};
		System.out.println(twoSum(arr,5)[0]);
		System.out.println(twoSum(arr,5)[1]);
	}
	
    public static int[] twoSum(int[] nums, int target) {
    	int n = nums.length;
    	int[] result = new int[2]; //* have to specify the length of the array. java数组的静态初始化和动态初始化
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i=0; i<n; i++){
        	if(map.containsKey(nums[i])){ // find the match
        		result[0] = map.get(nums[i])+1;
        		result[1] = i+1;
        		break;
        	}
        	else{ // save the difference
        		map.put(target-nums[i], i);
        	}
        }
        return result;
    }
}
