class Solution(object):
    def combinationSum3(self, k, n):
        """
        :type k: int
        :type n: int
        :rtype: List[List[int]]
        """
        def handle(index, n, k, current_sum, temp, res):
            if current_sum == n and k == 0:
                res.append(temp[:])
                return
            if current_sum > n or k == 0:
                return
            
            for i in range(index, 10):
                temp.append(i)
                handle(i + 1, n, k - 1, current_sum + i, temp, res)
                temp.pop()
        
        res = []
        handle(1, n, k, 0, [], res)
        return res
