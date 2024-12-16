class Solution(object):
    def maxScore(self, nums1, nums2, k):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :type k: int
        :rtype: int
        """
        nums = sorted(zip(nums2, nums1), reverse=True)
        ans, s = 0, 0
        q = []
        
        for i in range(k - 1):
            s += nums[i][1]
            heapq.heappush(q, nums[i][1])
        
        for i in range(k - 1, len(nums)):
            s += nums[i][1]
            ans = max(ans, s * nums[i][0])
            if q and q[0] < nums[i][1]:
                s -= heapq.heappop(q)
                heapq.heappush(q, nums[i][1])
            else:
                s -= nums[i][1]
        
        return ans
