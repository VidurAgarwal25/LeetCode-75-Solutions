class Solution(object):
    def mergeAlternately(self, word1, word2):
        """
        :type word1: str
        :type word2: str
        :rtype: str
        """
        l1 = len(word1)
        l2 = len(word2)
        res = []
        
        min_len = min(l1, l2)
        
        for i in range(min_len):
            res.append(word1[i])
            res.append(word2[i])
        
        if l1 > l2:
            res.append(word1[min_len:])
        else:
            res.append(word2[min_len:])
        
        return ''.join(res)
