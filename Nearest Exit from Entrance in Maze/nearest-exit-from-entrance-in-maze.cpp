class Solution {
public:
    int nearestExit(vector<vector<char>>& maze, vector<int>& entrance) {
        queue<pair<int, int>> q;
        q.push({entrance[0], entrance[1]});
        int n = maze.size();
        int m = maze[0].size();
        int step = 0;
        while (!q.empty()) {
            int size = q.size();
            for (int i = 1; i <= size; i++) {
                pair<int, int> temp = q.front();
                int row = temp.first;
                int col = temp.second;
                maze[row][col] = '+';
                q.pop();
                if (temp != make_pair(entrance[0], entrance[1]) &&
                    (row == 0 || row == n - 1 || col == 0 || col == m - 1)) {
                    return step;
                }
                if (row - 1 >= 0 && maze[row - 1][col] != '+') {
                    q.push(make_pair(row - 1, col));
                    maze[row-1][col]='+';
                }
                if (row + 1 < n && maze[row + 1][col] != '+') {
                    q.push(make_pair(row + 1, col));
                    maze[row+1][col]='+';
                }
                if (col - 1 >= 0 && maze[row][col - 1] != '+') {
                    q.push(make_pair(row, col - 1));
                    maze[row][col-1]='+';
                }
                if (col + 1 < m && maze[row][col + 1] != '+') {
                    q.push(make_pair(row, col + 1));
                    maze[row][col+1]='+';
                }
            }
            step++;
        }
        return -1;
    }
};