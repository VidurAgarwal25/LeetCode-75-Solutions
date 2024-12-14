class Solution(object):
    def successfulPairs(self, spells, potions, success):
        """
        :type spells: List[int]
        :type potions: List[int]
        :type success: int
        :rtype: List[int]
        """
        res = []
        potions.sort()
        for spell in spells:
            min_potion = (success + spell - 1) // spell
            l, r = 0, len(potions)
            while l < r:
                middle = l + (r - l) // 2
                if potions[middle] >= min_potion:
                    r = middle
                else:
                    l = middle + 1
            res.append(len(potions) - l)
        return res
