class Solution {
public:
    long long totalCost(vector<int>& costs, int k, int candidates) {
        priority_queue<int, vector<int>, greater<int>> l, r;
        int i = 0, j = costs.size()-1;
        long long ans = 0;
        while (k > 0) {
            while (l.size() < candidates && i <= j) {
                l.push(costs[i]);
                i++;
            }
            while (r.size() < candidates && j >= i) {
                r.push(costs[j]);
                j--;
            }
            int left = l.size() > 0 ? l.top() : INT_MAX;
            int right = r.size() > 0 ? r.top() : INT_MAX;
            if (left <= right) {
                ans += left;
                l.pop();
            } else {
                ans += right;
                r.pop();
            }
            k--;
        }
        return ans;
    }
};