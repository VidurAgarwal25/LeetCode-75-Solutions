class Solution(object):
    def predictPartyVictory(self, senate):
        """
        :type senate: str
        :rtype: str
        """
        r = deque()
        d = deque()
        n = len(senate)

        for i in range(n):
            if senate[i] == 'R':
                r.append(i)
            else:
                d.append(i)

        while r and d:
            r_id = r.popleft()
            d_id = d.popleft()
            if r_id < d_id:
                r.append(r_id + n)
            else:
                d.append(d_id + n)

        return "Radiant" if r else "Dire"
