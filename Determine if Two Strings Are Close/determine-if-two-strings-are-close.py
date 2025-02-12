class Solution(object):
    def closeStrings(self, word1, word2):
        """
        :type word1: str
        :type word2: str
        :rtype: bool
        """
        if len(word1) != len(word2):
            return False

        w1 = [0] * 26
        w2 = [0] * 26

        for c in word1:
            w1[ord(c) - ord('a')] += 1
        for c in word2:
            w2[ord(c) - ord('a')] += 1

        for i in range(26):
            if w1[i] > 0 and w2[i] == 0:
                return False

        return sorted(w1) == sorted(w2)
