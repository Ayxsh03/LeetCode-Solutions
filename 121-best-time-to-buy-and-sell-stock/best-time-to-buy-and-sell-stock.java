class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int max = 0;
        int minPrice = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            int profit = prices[i] - minPrice;
            if(profit > 0){
                max = Math.max(profit, max);
            }
            else{
                minPrice = Math.min(prices[i], minPrice);
            }
        }
        return max;
    }
}