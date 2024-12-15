class Solution(object):
    def minEatingSpeed(self, piles, h):
        """
        :type piles: List[int]
        :type h: int
        :rtype: int
        """
        def calctime(piles, k):
            time = 0
            for pile in piles:
                time += (pile + k - 1) // k
            return time

        lar = max(piles)
        l, r = 1, lar
        ans = 0

        while l <= r:
            mid = l + (r - l) // 2
            time = calctime(piles, mid)
            if time <= h:
                ans = mid
                r = mid - 1
            else:
                l = mid + 1

        return ans
