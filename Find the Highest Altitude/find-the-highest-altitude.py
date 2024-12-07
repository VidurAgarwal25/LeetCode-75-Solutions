class Solution(object):
    def largestAltitude(self, gain):
        """
        :type gain: List[int]
        :rtype: int
        """
        s = 0
        maxs = 0
        for g in gain:
            s += g
            maxs = max(maxs, s)
        return maxs
