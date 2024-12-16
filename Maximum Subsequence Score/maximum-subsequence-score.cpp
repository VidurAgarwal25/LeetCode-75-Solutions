class Solution {
public:
    long long maxScore(vector<int>& nums1, vector<int>& nums2, int k) {
        vector<pair<int, int>> nums;
        int n = nums1.size();
        for (int i = 0; i < n; i++) {
            nums.push_back({nums2[i], nums1[i]});
        }
        sort(nums.rbegin(), nums.rend());
        long long ans = 0, s = 0;
        priority_queue<int, vector<int>, greater<int>> q;
        for (int i = 0; i < k - 1; i++) {
            s += nums[i].second;
            q.push(nums[i].second);
        }
        for (int i = k - 1; i < n; i++) {
            s += nums[i].second;
            ans = max(ans, s * nums[i].first);
            if (q.size() > 0 && q.top() < nums[i].second) {
                s -= q.top();
                q.pop();
                q.push(nums[i].second);
            } else {
                s -= nums[i].second;
            }
        }
        return ans;
    }
};