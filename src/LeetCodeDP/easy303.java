package LeetCodeDP;

/**
 * Created by luoshalin on 12/19/15.
 */

//start - 10:43
//end - 10:59
//16min

public class easy303 {

    public static void main(String[] args){
        // test goes here
    }

    public class NumArray{
        int[] sumNums;

        public NumArray(int[] nums) {
            this.sumNums = new int[nums.length+1];
            sumNums[0] = 0;
            for(int i=0; i<nums.length; i++){
                sumNums[i+1] = sumNums[i] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            return this.sumNums[j+1] - this.sumNums[i];
        }
    }

}


//# corner cases
//
//# algo
//- constructor:
//create a sumNum int[]
//save the sum of all the elems in former index(inclusive)
//[0, -1, -2, 1, -4, ...]
//
//- sumRange func:
//return sumNum[j+1] - sumNum[i]
//i = 0; j = 2 -> return sum[0, 1, 2] -> sumNum[3]-sum[0]