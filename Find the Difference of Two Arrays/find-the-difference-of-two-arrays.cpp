class Solution {
public:
    vector<vector<int>> findDifference(vector<int>& nums1, vector<int>& nums2) {
        unordered_set<int> l1;
        unordered_set<int> l2;
        for (int i = 0; i < nums1.size(); i++) {
            l1.insert(nums1[i]);
        }
        for (int i = 0; i < nums2.size(); i++) {
            l2.insert(nums2[i]);
        }
        vector<vector<int>> res;
        vector<int> ans;
        for (auto i : l1) {
            if (l2.find(i) == l2.end()) {
                ans.push_back(i);
            }
        }
        res.push_back(ans);
        ans = {};
        for (auto i : l2) {
            if (l1.find(i) == l1.end()) {
                ans.push_back(i);
            }
        }
        res.push_back(ans);
        return res;
    }
};