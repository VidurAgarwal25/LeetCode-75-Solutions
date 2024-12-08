class Solution {
public:
    int equalPairs(vector<vector<int>>& grid) {
        unordered_map<string, int> m;
        for (int i = 0; i < grid.size(); i++) {
            string s = "";
            for (int j = 0; j < grid[0].size(); j++) {
                s += to_string(grid[i][j])+'-';
            }
            m[s]++;
        }
        int ans = 0;
        for (int i = 0; i < grid[0].size(); i++) {
            string s = "";
            for (int j = 0; j < grid.size(); j++) {
                s += to_string(grid[j][i])+'-';
            }
            ans += m[s];
        }
        return ans;
    }
};