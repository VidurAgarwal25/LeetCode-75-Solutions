class Solution(object):
    def equalPairs(self, grid):
        row_map = {}
        
        for i in range(len(grid)):
            s = ''
            for j in range(len(grid[0])):
                s += str(grid[i][j]) + '-'
            row_map[s] = row_map.get(s, 0) + 1
        
        count = 0

        for j in range(len(grid[0])):
            s = ''
            for i in range(len(grid)):
                s += str(grid[i][j]) + '-'
            count += row_map.get(s, 0)
        
        return count
