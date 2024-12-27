class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int[][] vis = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j, 0});
                    vis[i][j] = 1;
                }
            }
        }

        int time = 0;
        int[] dirRow = {-1, 0, 1, 0};
        int[] dirCol = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int row = current[0];
            int col = current[1];
            int t = current[2];
            time = Math.max(t, time);

            for (int i = 0; i < 4; i++) {
                int newRow = row + dirRow[i];
                int newCol = col + dirCol[i];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m
                        && vis[newRow][newCol] == 0 && grid[newRow][newCol] == 1) {
                    vis[newRow][newCol] = 1;
                    q.add(new int[]{newRow, newCol, t + 1});
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && vis[i][j] == 0) {
                    return -1;
                }
            }
        }

        return time;
    }
}
