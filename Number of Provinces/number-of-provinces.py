class Solution(object):
    def findCircleNum(self, isConnected):
        """
        :type isConnected: List[List[int]]
        :rtype: int
        """
        def dfs(isConnected, visited, node):
            visited[node] = True
            for i in range(len(isConnected)):
                if isConnected[node][i] == 1 and not visited[i]:
                    dfs(isConnected, visited, i)

        n = len(isConnected)
        visited = [False] * n
        count = 0

        for i in range(n):
            if not visited[i]:
                count += 1
                dfs(isConnected, visited, i)

        return count
