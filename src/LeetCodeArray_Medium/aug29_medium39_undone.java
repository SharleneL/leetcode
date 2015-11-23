//import java.awt.List;
//import java.util.ArrayList;
//import java.util.Arrays;
//
///*
// * 题意：给一个arr和一个target int，求所有加起来结果为target的subarr。arr中的某个数可以重复使用n多次
// * 啊啊啊啊好难啊！没思路！
// * 参考：http://www.cnblogs.com/springfor/p/3884294.html
// * 思路：要用递归。但还是没太搞懂，先照葫芦画瓢了。
// * 		大概意思是，对arr从小到大排序，遍历时每次从target里减去当前遍历数作为newtarget，然后再送进去递归；递归直到newtarget为0则将现有的item链表存入结果中作为一组解
// * 要点：1. 如何定义一维／多维ArrayList
// * 		2. 如何向多维ArrayList中add一维ArrayList
// * 问题：Leetcode上要求返回的是List<List<Integer>>但我们返回的是ArrayList<ArrayList<Integer>>，应该怎么convert？？？
// * */
//public class aug29_medium39_undone {
//
//
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>(); // how to define a multi-dimension arraylist
//        ArrayList<Integer> item = new ArrayList<Integer>(); // one of the possible results
////        special cases
//        if(candidates==null || candidates.length==0)
//        	return res;
//
////        sort the input arr
//        Arrays.sort(candidates);
////        input arr, target sum, start position in the candidates[] arr, one possible result, whole result
//        findSums(candidates, target, 0, item, res);
//        return res;
//    }
//
//    private void findSums(int[] candidates, int target, int start, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> res){
////    	recursion result
//    	if(target<0)
//    		return;
//    	if(target==0){
//    		res.add(item); // how to add ArrayList to a multi-dimension ArrayList
//    		return;
//    	}
//
////    	recursion process
//    	for(int i=start; i<candidates.length; i++){
//    		if(i>0 && candidates[i]==candidates[i-1]) // deal with duplicates
//    			continue;
//    		item.add(candidates[i]);
//    		int newtarget = target - candidates[i];
//    		findSums(candidates, newtarget, i, item, res); // 传i不传i-1是因为candidates中同个元素可以被用好多次
//    		item.remove(item.size()-1); // 如果上一步递归始终没跳出来，说明加这个元素是走不通的，因此将item中的倒数第一个元素踢出去，下一轮循环的时候再加下一个元素进来
//    	}
//    }
//}
