package LeetCodeBinarySearch;

/**
 * Created by luoshalin on 12/26/15.
 */
public class medium69 {
    public static void main(String[] args){
        // test goes here
        System.out.print(mySqrt(17));
    }

    public static int mySqrt(int x) {
        long start=0, end=x/2+1;
        while(start<=end){
            long mid = start + (end-start)/2;
            if(mid*mid < x)
                start = mid+1;
            else if(mid*mid > x)
                end = mid-1;
            else
                return (int)mid;
        }
        return (int)start-1;
    }
}
