class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = formGraph(equations, values);
        double[] results = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String dividend = queries.get(i).get(0);
            String divisor = queries.get(i).get(1);

            if (!graph.containsKey(dividend) || !graph.containsKey(divisor)) {
                results[i] = -1.0;
            } else {
                Set<String> visited = new HashSet<>();
                double[] ans = new double[]{-1.0};
                dfs(dividend, divisor, graph, visited, ans, 1.0);
                results[i] = ans[0];
            }
        }
        return results;
    }

    private Map<String, Map<String, Double>> formGraph(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String dividend = equations.get(i).get(0);
            String divisor = equations.get(i).get(1);

            graph.putIfAbsent(dividend, new HashMap<>());
            graph.putIfAbsent(divisor, new HashMap<>());

            graph.get(dividend).put(divisor, values[i]);
            graph.get(divisor).put(dividend, 1.0 / values[i]);
        }
        return graph;
    }

    private void dfs(String dividend, String divisor, Map<String, Map<String, Double>> graph, 
                     Set<String> visited, double[] ans, double temp) {
        if (visited.contains(dividend)) return;
        visited.add(dividend);

        if (dividend.equals(divisor)) {
            ans[0] = temp;
            return;
        }

        for (Map.Entry<String, Double> neighbor : graph.get(dividend).entrySet()) {
            dfs(neighbor.getKey(), divisor, graph, visited, ans, temp * neighbor.getValue());
        }
    }
}
