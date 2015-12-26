package LeetCodeDP;

/**
 * Created by luoshalin on 12/19/15.
 */
public class medium264 {
    public static void main(String[] args){
        // test goes here
        System.out.print(nthUglyNumber(11));
    }

    public static int nthUglyNumber(int n) {
        if(n==0)
            return 0;
        if(n==1)
            return 1;

        // n>=2
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        int[] res = new int[n];
        res[0] = 1;
        for(int i=1; i<n; i++){       // when i==n, got the target res
            int m2 = res[i2] * 2;
            int m3 = res[i3] * 3;
            int m5 = res[i5] * 5;
            res[i] = Math.min(m2, Math.min(m3, m5));
            if(res[i]==m2)
                i2++;
            if(res[i]==m3)
                i3++;
            if(res[i]==m5)
                i5++;
        }
        return res[n-1];
    }
}
