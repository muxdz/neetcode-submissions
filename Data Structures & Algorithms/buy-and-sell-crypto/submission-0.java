class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int lowestBuy = 99999999;

        for (int i=0; i<prices.length; i++) {
            lowestBuy = Math.min(lowestBuy, prices[i]);

            profit = Math.max(profit, prices[i]-lowestBuy);
        }

        return profit;
    }
}
