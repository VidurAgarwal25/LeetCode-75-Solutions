class Solution {
    public int longestSubarray(int[] nums) {
        int curr = 0, prev = 0, maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                curr++;
            } else {
                maxLen = Math.max(maxLen, prev + curr);
                prev = curr;
                curr = 0;
            }
        }

        maxLen = Math.max(maxLen, prev + curr);

        if (maxLen == nums.length) {
            return maxLen - 1;
        }

        return maxLen;
    }
}
