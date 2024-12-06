class Solution(object):
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        l, r = 0, len(height) - 1
        max_area = 0

        while l < r:
            diff = r - l
            h = min(height[l], height[r])
            curr = diff * h
            max_area = max(max_area, curr)

            if height[l] < height[r]:
                l += 1
            else:
                r -= 1

        return max_area
