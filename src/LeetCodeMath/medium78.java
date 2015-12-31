package LeetCodeMath;

import com.sun.tools.javac.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by luoshalin on 12/27/15.
 */
public class medium78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums==null || nums.length==0)
            return res;
        int subsetCount = (int)Math.pow(2, nums.length);
        Arrays.sort(nums);
        for(int i=0; i<subsetCount; i++){
            List<Integer> list = new ArrayList<Integer>();
            // get the num which is '1' in i & add to list
            for(int j=0; j<nums.length; j++){
                if((i&(1<<j))!=0){
                    list.add(nums[j]);
                }
            }
            res.add(list);
        }
        return res;
    }
}
