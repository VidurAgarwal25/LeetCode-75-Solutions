class Solution {
public:
    unordered_map<string, unordered_map<string, double>>
    formGraph(vector<vector<string>>& equations, vector<double>& values) {
        unordered_map<string, unordered_map<string, double>> graph;
        for (int i = 0; i < equations.size(); i++) {
            string dividend = equations[i][0];
            string divisor = equations[i][1];
            graph[dividend][divisor] = values[i];
            graph[divisor][dividend] = 1.0 / values[i];
        }
        return graph;
    }
    void dfs(string dividend, string divisor,
             unordered_map<string, unordered_map<string, double>>& graph,
             unordered_set<string>& vis, double &ans, double temp) {
        if (vis.find(dividend) != vis.end())
            return;
        vis.insert(dividend);
        if (dividend == divisor) {
            ans = temp;
            return;
        }
        for (auto i :graph[dividend]){
            dfs(i.first,divisor,graph,vis,ans,i.second*temp);
        }
    }
    vector<double> calcEquation(vector<vector<string>>& equations,
                                vector<double>& values,
                                vector<vector<string>>& queries) {
        unordered_map<string, unordered_map<string, double>> graph =
            formGraph(equations, values);
        vector<double> res;
        for (int i = 0; i < queries.size(); i++) {
            string dividend = queries[i][0];
            string divisor = queries[i][1];
            if (graph.find(dividend) == graph.end() || graph.find(divisor) == graph.end())
                res.push_back(-1.0);
            else {
                unordered_set<string> vis;
                double ans = -1.0;
                double temp = 1.0;
                dfs(dividend, divisor, graph, vis, ans, temp);
                res.push_back(ans);
            }
        }
        return res;
    }
};

