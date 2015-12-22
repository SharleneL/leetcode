package LeetCode_Linkedin;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luoshalin on 12/14/15.
 * http://blog.csdn.net/u010500263/article/details/18178243
 */
public class medium46 {
    public static void main(String[] args) {
        // test goes here
        int[] nums = {1, 2, 3, 3};
        ArrayList<ArrayList<Integer>> res = permute(nums);
        System.out.println(res);
    }

    public static ArrayList<ArrayList<Integer>> permute(int[] nums) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> item = new ArrayList<Integer>();

        if (nums.length == 0 || nums == null)
            return res;
        boolean[] visited = new boolean[nums.length];

        permutation_helper(nums, res, item, visited);
        return res;
    }

    public static void permutation_helper(int[] num, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> item, boolean[] visited) {
        if (item.size() == num.length) {
            res.add(new ArrayList<Integer>(item));
            return;
        }

        for (int i = 0; i < num.length; i++) {
            if (!visited[i]) {
                item.add(num[i]);
                visited[i] = true;
                permutation_helper(num, res, item, visited);
                item.remove(item.size() - 1);
                visited[i] = false;
            }
        }
    }
}

//clarification&extreme cases:
//        nums=null
//        contain same numbers=>part same/all the same
//
//        how we calculate P:
//        for each duplicated term in a len set:
//        calculate duplicate count c
//        select c positions&put duplicates=>len-c positions left
//        end=>all duplicated terms placed
//
//        for each non-duplicate term in the remaining set:
//        select 1 position&put term
//        end=>all terms placed