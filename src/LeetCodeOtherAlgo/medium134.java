package LeetCodeOtherAlgo;

/**
 * Created by luoshalin on 12/30/15.
 */
public class medium134 {

    public static void main(String[] args){
        int gas[] = {1, 3, 4, 10};
        int cost[] = {4, 2, 3, 1};
        System.out.print(canCompleteCircuit(gas, cost));
    }

    // 暴力解法,超时
//    public int canCompleteCircuit(int[] gas, int[] cost) {
//        if(gas==null || cost==null || gas.length==0 || cost.length==0 || gas.length!=cost.length)
//            return -1;
//
//        int len = gas.length;
//        for(int i=0; i<len; i++){   // judge whether one circuit can be completed starting from [i]
//            // count sum[i->i+1](gas-cost) ~ sum[i->i-1](gas-cost), if any <0, cannot complete this circuit start from i
//            int sum = 0;
//            for(int j=0; j<len; j++){
//                sum = sum + gas[(i+j)%len] - cost[(i+j)%len];
//                if(sum<0)
//                    break;
//            }
//            // else return i
//            if(sum>=0)
//                return i;
//        }
//        // not return - non of the starting i can complete the circuit - return -1
//        return -1;
//    }

    // DP - 不懂
    // 参考:http://blog.csdn.net/fightforyourdream/article/details/16875259
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int curSum = 0;     // 用于记录当前gas剩余量
        int total = 0;      // 记录走完一圈的gas剩余量
        int startIndex = 0; // 记录能走完一圈的开始位置

        for(int i=0; i<gas.length; i++){
            int curRemain = gas[i] - cost[i];
            if(curSum >= 0) // 如果当前还有剩余量，继续
                curSum += curRemain;
            else{           // 否则，从这里重新开始
                curSum = curRemain;
                startIndex = i;
            }
            total += curRemain;
        }
        return total>=0 ? startIndex : -1;  // 为什么total>=0就可以返回index了?
    }
}
