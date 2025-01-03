class Solution {
public:
    void handle(int index, int n, int& k, int& sum, vector<int>& temp,
                vector<vector<int>>& res) {
        if (sum == n && k == 0) {
            res.push_back(temp);
            return;
        }
        if (sum > n || k == 0)
            return;
        for (int i = index; i <= 9; i++) {
            sum += i;
            k--;
            temp.push_back(i);
            handle(i + 1, n, k, sum, temp, res);
            temp.pop_back();
            sum-=i;
            k++;
        }
    }
    vector<vector<int>> combinationSum3(int k, int n) {
        vector<int> temp;
        vector<vector<int>> res;
        int sum = 0;
        handle(1, n, k, sum, temp, res);
        return res;
    }
};