/*
 * 1.将字符串存入数组时，存入ArrayList中：arrayList.add(str)
 * 2.注意判断条件！！！
 * */

import java.util.ArrayList;

public class Jul28_228 {
    public List<String> summaryRanges(int[] nums) {
    	List<String> res = new ArrayList();
    	
    	if((nums == null) || (nums.length<1)) //判断条件！！！
    		return res;
    	
        int s=0, e=0; // start; end
        while(e<nums.length){ //判断条件！！！
        	if(((e+1)<nums.length) && (nums[e+1] == (nums[e]+1)))
        		e++;// end pointer move back by 1
        	// save to result arraylist
        	else{ 
        		if(s==e)
        			res.add(Integer.toString(nums[e]));
        		else{
            		String str = nums[s] + "->" + nums[e];
            		res.add(str);
        		}
        		s = e+1;
        		e = e+1;
        	}
        }
        return res;
    }
}
