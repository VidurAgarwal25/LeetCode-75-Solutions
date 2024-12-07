class Solution {
public:
    int longestOnes(vector<int>& nums, int k) {
        int l = 0, r = 0, zero = 0, maxzero = 0;
        while (r < nums.size()) {
            if (nums[r] == 0) {
                zero++;
            }

            if (zero <= k)
                maxzero = max(maxzero, r - l + 1);
            else {
                if (nums[l] == 0)
                    zero--;
                l++;
            }
            r++;
        }
        return maxzero;
    }
};