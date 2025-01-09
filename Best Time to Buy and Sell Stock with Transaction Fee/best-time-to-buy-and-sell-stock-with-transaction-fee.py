class Solution(object):
    def maxProfit(self, prices, fee):
        """
        :type prices: List[int]
        :type fee: int
        :rtype: int
        """
        temp = [0, 0] 
        curr = [0, 0] 
        for i in range(len(prices) - 1, -1, -1): 
            for j in range(2):
                if j == 1:
                    curr[1] = max(-prices[i] + temp[0], temp[1])
                else:
                    curr[0] = max(prices[i] - fee + temp[1], temp[0])
            temp = curr[:] 

        return curr[1]  