package LeetCodeHashTable;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by luoshalin on 12/24/15.
 */
public class medium274 {
    public static void main(String[] args){
        // test goes here
    }

    public int hIndex(int[] citations) {
        if(citations==null || citations.length==0)
            return 0;
        int result = 0;
        Arrays.sort(citations);
        int len = citations.length;
        for(int i=len-1; i>=0; i--){
            // i+1 papers are smaller than citations[i]
            // len-1-i papers >= citations[i]
            if(result>=citations[i]){
                return result;
            }
            result++;
        }
        return result;
    }
}

//total: N
//h: >=h
//N-h: <h
//
//for each paper[i]:
//    calculate how many paper[j] < paper[i] <- sort paper[] & find the first one if N-1-j = paper[i]
