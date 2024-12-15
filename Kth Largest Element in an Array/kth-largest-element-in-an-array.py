class Solution(object):
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        min_heap = nums[:k]
        heapq.heapify(min_heap)  
        for i in range(k, len(nums)):
            if nums[i] > min_heap[0]:  
                heapq.heappop(min_heap)  
                heapq.heappush(min_heap, nums[i])  

        
        return min_heap[0]
