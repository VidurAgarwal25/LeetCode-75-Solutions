class Solution(object):
    def dfs(self, node, away, tow, visited):
        visited[node] = True
        count = 0
        
        for neighbor in away[node]:
            if not visited[neighbor]:
                count += 1
                count += self.dfs(neighbor, away, tow, visited)
        
        for neighbor in tow[node]:
            if not visited[neighbor]:
                count += self.dfs(neighbor, away, tow, visited)
        
        return count

    def minReorder(self, n, connections):
        """
        :type n: int
        :type connections: List[List[int]]
        :rtype: int
        """
        away = [[] for _ in range(n)]
        tow = [[] for _ in range(n)]
        
        for a, b in connections:
            away[a].append(b)
            tow[b].append(a)
        
        visited = [False] * n
        
        return self.dfs(0, away, tow, visited)
