class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        queue<pair<pair<int, int>, int>> q;
        int n = grid.size();
        int m = grid[0].size();
        vector<vector<int>> vis(n, vector<int>(m, 0));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.push(make_pair(make_pair(i, j), 0));
                    vis[i][j] = 1;
                }
            }
        }
        int time = 0;
        vector<int> dir_row = {-1, 0, 1, 0};
        vector<int> dir_col = {0, 1, 0, -1};
        while (!q.empty()) {
            int size = q.size();
            for (int i = 1; i <= size; i++) {
                int row = q.front().first.first;
                int col = q.front().first.second;
                int t = q.front().second;
                q.pop();
                time = max(t, time);
                for (int j = 0; j <= 3; j++) {
                    int new_row = row + dir_row[j];
                    int new_col = col + dir_col[j];
                    if (new_row >= 0 && new_row < n && new_col >= 0 &&
                        new_col < m && vis[new_row][new_col] == 0 &&
                        grid[new_row][new_col] == 1) {
                        vis[new_row][new_col] = 1;
                        q.push(make_pair(make_pair(new_row, new_col), t + 1));
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && vis[i][j] == 0)
                    return -1;
            }
        }
        return time;
    }
};