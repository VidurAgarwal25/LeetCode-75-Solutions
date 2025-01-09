class Solution {
public:
    int findMinArrowShots(vector<vector<int>>& points) {
        sort(points.begin(), points.end());
        int count = 1, i = 0, j = 1, n = points.size();
        int ps = points[0][0];
        int pe = points[0][1];
        while (j < n) {
            int s = points[j][0];
            int e = points[j][1];
            if (pe < s) {
                count++;
                ps = s;
                pe = e;
                j++;
            } else {
                if (s > ps)
                    ps = s;
                if (e < pe)
                    pe = e;
                j++;
            }
        }
        return count;
    }
};