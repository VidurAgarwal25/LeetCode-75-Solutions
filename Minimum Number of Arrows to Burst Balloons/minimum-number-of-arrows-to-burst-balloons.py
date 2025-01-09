class Solution(object):
    def findMinArrowShots(self, points):
        """
        :type points: List[List[int]]
        :rtype: int
        """
       
        points.sort()

        count = 1  
        n = len(points)
        ps, pe = points[0][0], points[0][1]  

        j = 1
        while j < n:
            s, e = points[j][0], points[j][1]  
            
            if pe < s:
                
                count += 1
                ps, pe = s, e
            else:
               
                ps = max(ps, s)
                pe = min(pe, e)
            
            j += 1

        return count
