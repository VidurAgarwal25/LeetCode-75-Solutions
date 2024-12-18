class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs(isConnected, visited, i);
            }
        }

        return count;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int node) {
        visited[node] = true;
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[node][i] == 1 && !visited[i]) {
                dfs(isConnected, visited, i);
            }
        }
    }
}
