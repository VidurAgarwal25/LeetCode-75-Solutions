class Solution(object):
    def numTilings(self, n):
        """
        :type n: int
        :rtype: int
        """
        m = 1000000007
        if n == 1 or n == 2:
            return n % m
        
        dp = [0] * (n + 1)
        dp[1] = 1
        dp[2] = 2
        if n >= 3:
            dp[3] = 5
        
        for i in range(4, n + 1):
            dp[i] = ((2 * dp[i - 1]) % m + dp[i - 3] % m) % m
        
        return dp[n]
