class Solution(object):
    def minFlips(self, a, b, c):
        """
        :type a: int
        :type b: int
        :type c: int
        :rtype: int
        """
        count = 0
        while a or b or c:
            bita = a & 1
            bitb = b & 1
            bitc = c & 1
            if bitc == 1:
                if bita == 0 and bitb == 0:
                    count += 1
            else:
                if bita == 1 and bitb == 1:
                    count += 2
                elif bita == 1 or bitb == 1:
                    count += 1
            a >>= 1
            b >>= 1
            c >>= 1
        return count
