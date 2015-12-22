package LeetCodeHeap;

import java.util.Arrays;

/**
 * Created by luoshalin on 12/20/15.
 */
public class medium313 {
    public static void main(String[] args){
        // test goes here
        int primes[] = {2, 7, 13, 19};
        System.out.print(nthSuperUglyNumber(3, primes));
    }
    public static int nthSuperUglyNumber(int n, int[] primes) {
        if(n==0)
            return 0;
        if(n==1)
            return 1;

        // n>=2
        int size = primes.length;
        int[] times = new int[size];
        Arrays.fill(times, 0);
        int[] res = new int[n];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[0] = 1;
        for(int i=1; i<n; i++){       // when i==n, got the target res
            for(int j=0; j<size; j++){
                res[i] = Math.min(res[i], res[times[j]]*primes[j]);
            }
            for(int j=0; j<size; j++){
                if(res[times[j]]*primes[j] == res[i])
                    times[j]++;
            }
        }
        return res[n-1];
    }
}
