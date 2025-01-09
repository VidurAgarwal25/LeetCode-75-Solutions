class Solution {
    public int maxProfit(int[] prices, int fee) {
        int[] temp = new int[2];
        int[] curr = new int[2];

        for (int i = prices.length - 1; i >= 0; i--) {
            for (int j = 0; j <= 1; j++) {
                if (j == 1) {
                    curr[1] = Math.max(-prices[i] + temp[0], temp[1]);
                } else {
                    curr[0] = Math.max(prices[i] - fee + temp[1], temp[0]);
                }
            }
            temp = curr.clone();
        }
        return curr[1];
    }
}
