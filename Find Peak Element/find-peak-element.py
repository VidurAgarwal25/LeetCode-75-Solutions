class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        if n == 1 or nums[0] > nums[1]:
            return 0
        if nums[n - 1] > nums[n - 2]:
            return n - 1

        left, right = 1, n - 2
        while left <= right:
            mid = left + (right - left) // 2
            if nums[mid] > nums[mid - 1] and nums[mid] > nums[mid + 1]:
                return mid
            elif nums[mid - 1] > nums[mid]:
                right = mid - 1
            else:
                left = mid + 1

        return -1
