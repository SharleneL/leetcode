/*
 * 注意：n<=0的情况都要排除！
 * */
public class Jul28_231 {
    public boolean isPowerOfTwo(int n) {
        if (((n & (n-1)) == 0) && (n>0))
        	return true;
        else
        	return false;
    }
}
