class Solution {
public:
    int eraseOverlapIntervals(vector<vector<int>>& intervals) {
        sort(intervals.begin(), intervals.end());
        int n = intervals.size();
        int i = 0, j = 1;
        int count = 0;
        while (j < n) {
            int s = intervals[i][0];
            int e = intervals[i][1];
            int ns = intervals[j][0];
            int ne = intervals[j][1];
            if (e <= ns) {
                i=j;
                j++;
            } else {
                if (e >= ne) {
                    i = j;
                }
                j++;
                count++;
            }
        }
        return count;
    }
};