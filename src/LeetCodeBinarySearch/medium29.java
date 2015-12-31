package LeetCodeBinarySearch;

/**
 * Created by luoshalin on 12/26/15.
 */
public class medium29 {
    public static void main(String[] args){
        // test goes here
        System.out.print(divide(-2147483648, -1));
    }

    public static int divide(int dividend, int divisor) {
        long divd = (long)dividend;
        long divs = (long)divisor;

        if(divs==0)
            return Integer.MAX_VALUE;
        if(divd==0 || divs==1)
            return (int)divd;
        if(divs==-1){
            divd = -divd;
            return (int)divd;
        }
        boolean negative = (divd>0 && divs<0) || (divd<0 && divs>0);

        divd = Math.abs(divd);
        divs = Math.abs(divs);

        long sum = 0;
        long quodient = 0;
        while (sum<=divd){
            sum += divs;
            quodient++;
        }
        if(negative)
            return -(int)(quodient-1);
        else
            return (int)quodient-1;
    }
}
