class Solution(object):
    def nearestExit(self, maze, entrance):
        """
        :type maze: List[List[str]]
        :type entrance: List[int]
        :rtype: int
        """
        rows, cols = len(maze), len(maze[0])
        queue = deque([(entrance[0], entrance[1])])
        steps = 0
        
        while queue:
            size = len(queue)
            for _ in range(size):
                row, col = queue.popleft()
                
                maze[row][col] = '+'
                
                if (row != entrance[0] or col != entrance[1]) and \
                   (row == 0 or row == rows - 1 or col == 0 or col == cols - 1):
                    return steps
                
                for dr, dc in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
                    nr, nc = row + dr, col + dc
                    if 0 <= nr < rows and 0 <= nc < cols and maze[nr][nc] == '.':
                        queue.append((nr, nc))
                        maze[nr][nc] = '+'
                        
            steps += 1
        
        return -1
