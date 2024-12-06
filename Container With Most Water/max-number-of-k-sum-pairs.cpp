class Solution {
public:
    int maxOperations(vector<int>& nums, int k) {
        unordered_map<int, int> m;
        int count = 0;
        for (int i = 0; i < nums.size(); i++) {
            int diff = k - nums[i];
            if(m[diff]>0){
                m[diff]--;
                count++;
            }
            else
            m[nums[i]]++;
        }
        return count;
    }
};