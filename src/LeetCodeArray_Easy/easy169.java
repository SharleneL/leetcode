import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

/* 08-08-2015
 * 题意：给一个数组，返回出现次数大于n/2的元素。词频问题用HashMap
 * 哈哈一次过！
 * 思路：遍历数组存入hashmap中，元素作为key，出现次数作为value；再用keyset遍历hashmap，大于n/2的元素则返回
 * 要点：hashmap的使用：如何初始化hashmap？如何存取hashmap中的k-v? 如何用keyset遍历hashmap？
 * */
public class easy169 {
	public static void main(String args[]){
		int[] arr = {1, 3, 3, 3, 2, 3, 2};
		System.out.println(majorityElement(arr));
	}
	
    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); //*initialize hashmap
        int n = nums.length;
        
        // save nums into map
        for(int i=0; i<n; i++){
        	if(!map.containsKey(nums[i])){ //*get/put k-v in hashmap
        		map.put(nums[i], 1);
        	}
        	else{ // map contains key
        		int count = (Integer) map.get(nums[i]); // *cast map's get result to Integer type
        		map.put(nums[i], count+1);
        	}
        }
        
        // bianli all the keys
        Set set = map.keySet(); // *get the keySet of the map to bianli it
        for(Iterator iterator = set.iterator();iterator.hasNext();){
        	int key = (Integer)iterator.next();
        	int value = (Integer)map.get(key);
        	if(value > n/2){
        		return key;
        	}
        }
        return -9999;
    }
}
