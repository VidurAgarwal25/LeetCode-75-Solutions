class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int maxArea = 0;

        while (l < r) {
            int diff = r - l;
            int h = Math.min(height[l], height[r]);
            int curr = diff * h;
            maxArea = Math.max(maxArea, curr);

            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return maxArea;
    }
}
