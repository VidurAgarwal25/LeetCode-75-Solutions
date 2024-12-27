class Solution {
    public void dfs(int node, List<List<Integer>> away, List<List<Integer>> tow, 
                    int[] ans, boolean[] vis) {
        vis[node] = true;
        for (int i : away.get(node)) {
            if (!vis[i]) {
                ans[0]++;
                dfs(i, away, tow, ans, vis);
            }
        }
        for (int i : tow.get(node)) {
            if (!vis[i]) {
                dfs(i, away, tow, ans, vis);
            }
        }
    }

    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> away = new ArrayList<>();
        List<List<Integer>> tow = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            away.add(new ArrayList<>());
            tow.add(new ArrayList<>());
        }

        for (int[] connection : connections) {
            int a = connection[0];
            int b = connection[1];
            away.get(a).add(b);
            tow.get(b).add(a);
        }

        boolean[] vis = new boolean[n];
        int[] ans = {0};

        
        dfs(0, away, tow, ans, vis);

        return ans[0];
    }
}
