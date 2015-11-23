/* 08-07-2015
 * 使用Map，将数组的值作为key，数组下标作为value存入map［反过来存］
 * 每遍历到一个数组元素就判断是否已经存在于map中
 * 存在则比较下标之差
 * 反过来存是因为我们想得到下标的值，因此下标要被存为value
 * */

import java.util.HashMap;
import java.util.Map;

public class easy219 {
	public static void main(String args[]){ //*how to write main func
		int[] arr = {1, 0, 1, 1}; //*how to initialize an array
		System.out.println(containsNearbyDuplicate(arr, 1));
	}
	
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if((nums==null) || (nums.length<2)) // *remember the null cases *length not length()
        	return false;
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // *how to new a hashmap
        for(int i=0; i<nums.length; i++){
        	if(map.containsKey(nums[i])){ // duplicate
        		int j = map.get(nums[i]); // *how to get value from key
        		map.put(nums[i], i); // ***update value to the last
        		if(i-j<=k)
        			return true;
        	}
    		else
    			map.put(nums[i], i); // ***put nums[i] as key, so that we can get i based on nums[i]
        }
		return false; //*remember to return if no match 
    }
}
