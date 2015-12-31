package LeetCodeMath;

/**
 * Created by luoshalin on 12/27/15.
 */
public class medium201 {
    public int rangeBitwiseAnd(int m, int n) {
        int count = 0;
        while (m!=n){
            m = m>>1;
            n = n>>1;
            count++;
        }
        return m<<count;
    }
}
