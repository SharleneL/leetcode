package LeetCode_DP;

/**
 * Created by luoshalin on 12/19/15.
 */
public class medium309 {
    public static void main(String[] args){
        // test goes here
    }

    public int maxProfit(int[] prices) {
        int buy = Integer.MIN_VALUE, preBuy = 0, sell = 0, preSell = 0;
        for(int price : prices){
            preBuy = buy;
            buy = Math.max(preSell-price, preBuy);
            preSell = sell;
            sell = Math.max(preBuy+price, preSell);
        }
        return sell;
    }
}
