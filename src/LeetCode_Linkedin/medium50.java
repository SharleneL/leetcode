package LeetCode_Linkedin;

/**
 * Created by luoshalin on 12/14/15.
 */
public class medium50 {
    public static void main(String[] args){
        // test goes here
    }

    public double myPow(double x, int n) {
        if(n==0)
            return 1;
        else if(n==1)
            return x;
        else if(n==-1)
            return (double)1/x;
        else{
            double half = myPow(x, n/2);
            return half * half * myPow(x, n%2);
        }
    }
}

//clarification:
//n=0?
//n<0?
//n>0
//
//classes - use rec, find recursion formula:
//if n=0:
//    return 1
//if n>0:
//    x^1 = x
//    x^n = x^(n/2) * x^(n/2) * x^(n%2)
//if n<0:
//    x^-1 = 1/x
//    x^n = x^(n/2) * x^(n/2) * x^(n%2)