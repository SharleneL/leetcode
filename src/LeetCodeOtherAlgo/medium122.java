package LeetCodeOtherAlgo;

/**
 * Created by luoshalin on 12/30/15.
 */
// 参考:http://blog.csdn.net/linhuanmars/article/details/23164149
// 只要后一天的价格比前一天的高,就交易
public class medium122 {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length==0)
            return 0;
        int profit = 0;
        for(int i=0; i<prices.length-1; i++){
            int diff = prices[i+1] - prices[i];
            if(diff > 0){   // make a deal
                profit += diff;
            }
        }
        return profit;
    }
}
