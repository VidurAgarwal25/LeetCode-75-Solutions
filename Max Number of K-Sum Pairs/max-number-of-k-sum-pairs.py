class Solution(object):
    def maxOperations(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        freq_map = {}
        count = 0
        
        for num in nums:
            diff = k - num
            
            if freq_map.get(diff, 0) > 0:
                freq_map[diff] -= 1
                count += 1
            else:
                freq_map[num] = freq_map.get(num, 0) + 1
        
        return count
