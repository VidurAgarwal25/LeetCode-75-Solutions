class Solution(object):
    def orangesRotting(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        n = len(grid)
        m = len(grid[0])
        
        q = deque()
        vis = [[0] * m for _ in range(n)]
        
        for i in range(n):
            for j in range(m):
                if grid[i][j] == 2:
                    q.append((i, j, 0))
                    vis[i][j] = 1
        
        time = 0
        dir_row = [-1, 0, 1, 0]
        dir_col = [0, 1, 0, -1]
        
        while q:
            row, col, t = q.popleft()
            time = max(t, time)
            
            for i in range(4):
                new_row = row + dir_row[i]
                new_col = col + dir_col[i]
                
                if 0 <= new_row < n and 0 <= new_col < m and vis[new_row][new_col] == 0 and grid[new_row][new_col] == 1:
                    vis[new_row][new_col] = 1
                    q.append((new_row, new_col, t + 1))
        
        for i in range(n):
            for j in range(m):
                if grid[i][j] == 1 and vis[i][j] == 0:
                    return -1
        
        return time
