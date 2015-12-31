package LeetCodeBinarySearch;

/**
 * Created by luoshalin on 12/26/15.
 */

// 还有错误 没通过
// 直接用之前的方法(注释处)可以通过 但世间不是O(nlogn)

public class medium275 {
    public static void main(String[] args){
        // test goes here
    }

    public int hIndex(int[] citations) {
        if(citations==null || citations.length==0)
            return 0;
        int result = 0;
        // Arrays.sort(citations);
        int len = citations.length;
        int start = 0;
        int end = len-1;
        while (start<=end){
            int mid = start+(end-start)/2;
            if(len-1-mid>=citations[mid]){
                start = mid+1;
                result = len-1-mid;
            } else {
                end = mid-1;
            }
        }
        return result;
//        for(int i=len-1; i>=0; i--){
//            // i+1 papers are smaller than citations[i]
//            // len-1-i papers >= citations[i]
//            if(result>=citations[i]){
//                return result;
//            }
//            result++;
//        }
//        return result;
    }
}
