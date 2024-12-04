class Solution(object):
    def kidsWithCandies(self, candies, extraCandies):
        """
        :type candies: List[int]
        :type extraCandies: int
        :rtype: List[bool]
        """
        max_candies = max(candies)  # Find the maximum candies any kid currently has
        result = []

        for candy in candies:
            # Check if the current candy count plus extraCandies is at least max_candies
            result.append(candy + extraCandies >= max_candies)

        return result
