package LeetCodeBinarySearch;

/**
 * Created by luoshalin on 12/26/15.
 */
public class easy278 {
    public static void main(String[] args){
        // test goes here
    }

//    METHOD1 - TIME EXCEEDED - CALL isBadVersion() TOO MANY TIMES
//    public int firstBadVersion(int n) {
//        if(n<1)
//            return 0;
//
//        // dichonomy
//        int left = 1, right = n;
//        while (left<=right){
//            int mid = (left+right)/2;
//            if(isBadVersion(left)){
//                return left;
//            }else{
//                if(isBadVersion(mid)){
//                    left -= 1;
//                    right = mid;
//                }else{
//                    if(isBadVersion(right)){
//                        left = mid+1;
//                    }else{
//                        return 0;
//                    }
//                }
//            }
//        }
//        return 0;
//    }

    public int firstBadVersion(int n) {
        if(n<1)
            return 0;
        int left = 1;
        int right = n;
        while (left<right){
            // int mid = (left+right)/2;        // reason for time exceeded
            int mid = left+(right-left)/2;
            if(!isBadVersion(mid)){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        if(!isBadVersion(left))
            return left;
        else
            return 0;
    }
    // fake helper function
    public static boolean isBadVersion(int n){
        return false;
    }
}

// --- PSUEDO FOR METHOD1 ---//
//bad bad bad => return left
//good bad bad => find in [left-1, mid]
//good good bad => find in [mid+1, right]
//good good good => return 0

// --- PSUEDO FOR METHOD2 ---//
//while left<right:
//    if mid=bad:
//        find in [left, mid]
//    else if mid=good:
//        find in [mid+1, right]
//    end if
//end while
////此时left=right
//if left=bad:
//    return left
//else:           // all are good
//    return 0
//end if

