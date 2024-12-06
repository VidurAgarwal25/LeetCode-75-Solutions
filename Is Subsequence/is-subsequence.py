class Solution(object):
    def isSubsequence(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        l1 = len(s)
        l2 = len(t)
        j = 0  

        if l1 > l2:
            return False

        for i in range(l2):
            if j < l1 and s[j] == t[i]:
                j += 1

        return j == l1
