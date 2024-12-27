class Solution {
public:
    bool canVisitAllRooms(vector<vector<int>>& rooms) {
        int n = rooms.size();
        vector<int> vis(n, 0);
        dfs(rooms, vis, 0);

        
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0)
                return false;
        }
        return true;
    }

    void dfs(vector<vector<int>>& rooms, vector<int>& vis, int room) {
        vis[room] = 1;

        for (int key : rooms[room]) {
            if (vis[key] == 0) {     
                dfs(rooms, vis, key);
            }
        }
    }
};
