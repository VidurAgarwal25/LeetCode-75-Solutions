class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0, r = 0, zero = 0, maxZero = 0;

        while (r < nums.length) {
            if (nums[r] == 0) {
                zero++;
            }

            if (zero <= k) {
                maxZero = Math.max(maxZero, r - l + 1);
            } else {
                if (nums[l] == 0) {
                    zero--;
                }
                l++;
            }
            r++;
        }

        return maxZero;
    }
}
