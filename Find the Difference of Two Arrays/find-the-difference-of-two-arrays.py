class Solution(object):
    def findDifference(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[List[int]]
        """
        set1 = set(nums1)
        set2 = set(nums2)
        
        res1 = [num for num in set1 if num not in set2]
        res2 = [num for num in set2 if num not in set1]
        
        return [res1, res2]
