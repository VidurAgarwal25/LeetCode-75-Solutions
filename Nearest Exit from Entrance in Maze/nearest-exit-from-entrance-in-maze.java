class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length;
        int m = maze[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{entrance[0], entrance[1]});
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int row = current[0], col = current[1];
                
                maze[row][col] = '+';

                if (!(row == entrance[0] && col == entrance[1]) &&
                    (row == 0 || row == n - 1 || col == 0 || col == m - 1)) {
                    return steps;
                }

                if (row - 1 >= 0 && maze[row - 1][col] != '+') {
                    queue.offer(new int[]{row - 1, col});
                    maze[row - 1][col] = '+';
                }
                if (row + 1 < n && maze[row + 1][col] != '+') {
                    queue.offer(new int[]{row + 1, col});
                    maze[row + 1][col] = '+';
                }
                if (col - 1 >= 0 && maze[row][col - 1] != '+') {
                    queue.offer(new int[]{row, col - 1});
                    maze[row][col - 1] = '+';
                }
                if (col + 1 < m && maze[row][col + 1] != '+') {
                    queue.offer(new int[]{row, col + 1});
                    maze[row][col + 1] = '+';
                }
            }
            steps++;
        }

        return -1;
    }
}
