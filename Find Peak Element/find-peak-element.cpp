class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        int len = nums.size();
        if (len == 1 || nums[0] > nums[1])
            return 0;
        if (nums[len - 1] > nums[len - 2])
            return len - 1;
        int l = 1, r = len - 2;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
                return mid;
            else if (nums[mid - 1] > nums[mid])
                r = mid - 1;
            else if (nums[mid - 1] < nums[mid])
                l = mid + 1;
        }
        return -1;
    }
};