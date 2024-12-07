class Solution {
public:
    bool uniqueOccurrences(vector<int>& arr) {
        unordered_map<int, int> m;
        unordered_set<int> s;
        for (int i = 0; i < arr.size(); i++) {
            m[arr[i]]++;
        }
        for (auto i : m) {
            if (s.find(i.second) != s.end())
                return false;
            s.insert(i.second);
        }
        return true;
    }
};