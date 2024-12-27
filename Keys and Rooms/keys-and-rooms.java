class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        dfs(rooms, visited, 0);
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }

    private void dfs(List<List<Integer>> rooms, boolean[] visited, int room) {
        visited[room] = true;
        
        for (int key : rooms.get(room)) {
            if (!visited[key]) {
                dfs(rooms, visited, key);
            }
        }
    }
}
