class Solution {
public:
    void dfs(int node, vector<vector<int>>& away, vector<vector<int>>& tow,
             int& ans, vector<int>& vis) {
        vis[node] = 1;
        for (int i : away[node]) {
            if (!vis[i]) {
                ans += 1;
                dfs(i, away, tow, ans, vis);
            }
        }
        for (int i : tow[node]) {
            if (!vis[i]) {
                dfs(i, away, tow, ans, vis);
            }
        }
    }
    int minReorder(int n, vector<vector<int>>& connections) {
        vector<vector<int>> away(n), tow(n);
        vector<int> vis(n, 0);
        for (int i = 0; i < connections.size(); i++) {
            int a = connections[i][0];
            int b = connections[i][1];
            away[a].push_back(b);
            tow[b].push_back(a);
        }
        int ans = 0;
        dfs(0, away, tow, ans, vis);
        return ans;
    }
};