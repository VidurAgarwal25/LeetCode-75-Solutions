class Solution(object):
    def longestSubarray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        curr = 0
        prev = 0
        max_len = 0

        for num in nums:
            if num == 1:
                curr += 1
            else:
                max_len = max(max_len, prev + curr)
                prev = curr
                curr = 0

        max_len = max(max_len, prev + curr)

        if max_len == len(nums):
            return max_len - 1

        return max_len
