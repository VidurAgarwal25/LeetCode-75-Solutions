class Solution(object):
    def eraseOverlapIntervals(self, intervals):
        """
        :type intervals: List[List[int]]
        :rtype: int
        """
        intervals.sort(key=lambda x: x[0])
        n = len(intervals)
        i, j = 0, 1
        count = 0
        
        while j < n:
            s, e = intervals[i]
            ns, ne = intervals[j]
            
            if e <= ns:
                i = j
                j += 1
            else:
                if e >= ne:
                    i = j
                j += 1
                count += 1
        
        return count
