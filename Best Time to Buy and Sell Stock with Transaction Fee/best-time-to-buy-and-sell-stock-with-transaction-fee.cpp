class Solution {
public:
    int maxProfit(vector<int>& prices, int fee) {

        vector<int> temp(2, 0);vector<int> curr(2, 0);

        for (int i = prices.size() - 1; i >= 0; i--) {
            for (int j = 0; j <= 1; j++) {
                if (j) {
                    curr[1] = max(-prices[i] + temp[0], temp[1]);
                } else {
                    curr[0] =
                        max(prices[i] - fee + temp[1], temp[0]);
                }
            }
            temp=curr;
        }
        return curr[1];
    }
};