class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int n = intervals.length;
        int i = 0, j = 1;
        int count = 0;
        
        while (j < n) {
            int s = intervals[i][0];
            int e = intervals[i][1];
            int ns = intervals[j][0];
            int ne = intervals[j][1];
            
            if (e <= ns) {
                i = j;
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
}
