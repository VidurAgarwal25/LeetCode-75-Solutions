class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = 1;
        }

        int prefix = 1;
        for (int i = 1; i < nums.length; i++) {
            prefix *= nums[i - 1];
            res[i] = prefix;
        }

        int suffix = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            suffix *= nums[i + 1];
            res[i] = suffix * res[i];
        }

        return res;
    }
}
