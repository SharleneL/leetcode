/*
 * 题意：给一个数组，里面是当日股价，求一次买卖交易的最大利益。
 * 思路：分析题目，必须是先买入一笔再卖出一笔。因此从前往后遍历一遍，用当前元素减去左侧的最小值，得到的值的max则为最大利益
 * 要点：1. 当求最小值时如何初始化minValue？ Integer.MAX_VALUE
 * 		2. 如何使用数学函数库？ Math.XXX
 * */
public class aug29_medium121 {
	public static void main(String[] args){
		int[] prices = {1, 2, 3, 4};
		System.out.println(maxProfit(prices));
	}
    public static int maxProfit(int[] prices) {
    	int minBuy = Integer.MAX_VALUE, maxProfit=0;
        for(int i=1; i<prices.length; i++){
        	minBuy = Math.min(minBuy, prices[i-1]);
        	maxProfit = Math.max(maxProfit, prices[i]-minBuy);
        }
        return maxProfit;
    }
}
