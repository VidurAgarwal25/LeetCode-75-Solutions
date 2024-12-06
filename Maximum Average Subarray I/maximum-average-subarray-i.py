class Solution(object):
    def findMaxAverage(self, nums, k):
        l, r = 0, k - 1
        s = sum(nums[:k])
        max_avg = float(s) / k

        while r < len(nums) - 1:
            r += 1
            s += nums[r] - nums[l]
            l += 1
            max_avg = max(max_avg, float(s) / k)

        return max_avg
