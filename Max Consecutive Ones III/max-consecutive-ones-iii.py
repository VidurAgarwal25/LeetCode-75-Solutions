class Solution(object):
    def longestOnes(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        l = 0
        zero = 0
        max_zero = 0

        for r in range(len(nums)):
            if nums[r] == 0:
                zero += 1

            if zero <= k:
                max_zero = max(max_zero, r - l + 1)
            else:
                if nums[l] == 0:
                    zero -= 1
                l += 1

        return max_zero
