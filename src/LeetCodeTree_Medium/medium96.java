package LeetCodeTree_Medium;

/**
 * Created by luoshalin on 12/26/15.
 */
public class medium96 {
    public static void main(String[] args){
        // test goes here
        System.out.print(numTrees(3));
    }

//    METHOD1 - RECURSIVE - TIME EXCEED
//    public static int numTrees(int n) {
//        int res = 0;
//        if(n==0)
//            return res;
//
//        return count(n);
//    }
//
//    public static int count(int n){
//        if(n==0)
//            return 1;
//        if(n==1)
//            return 1;
//        if(n==2)
//            return 2;
//
//        // n>2
//        int res = 0;
//        for(int i=0; i<n; i++){
//            res += count(i) * count(n-1-i);
//        }
//        return res;
//    }


//    METHOD2 - NONRECURSIVE
    public static int numTrees(int n){
        if(n==0)
            return 0;

        int[] res = new int[n+1];
        res[0] = 1;
        res[1] = 1;
        for(int i=2; i<=n; i++){        // calculate how many BST created from [1, 2, 3, ..., i]
            for(int j=0; j<i; j++){
                res[i] += res[j]*res[i-1-j];
            }
        }
        return res[n];
    }
}
