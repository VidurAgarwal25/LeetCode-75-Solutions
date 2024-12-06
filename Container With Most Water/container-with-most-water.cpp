class Solution {
public:
    int maxArea(vector<int>& height) {
        int l = 0, r = height.size()-1;
        int maxarea = 0;
        while (l < r) {
            int diff = r - l;
            int h = min(height[l], height[r]);
            int curr = diff * h;
            maxarea = max(maxarea, curr);
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }
};