class Solution(object):
    def uniqueOccurrences(self, arr):
        m = {}
        s = set()
        
        
        for num in arr:
            m[num] = m.get(num, 0) + 1
        
        
        for count in m.values():
            if count in s:
                return False
            s.add(count)
        
        return True
