import java.util.Arrays;

class Solution {
    public int findMinArrowShots(int[][] points) {
        
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        
        int count = 1; 
        int n = points.length;
        int ps = points[0][0]; 
        int pe = points[0][1]; 
        
        for (int j = 1; j < n; j++) {
            int s = points[j][0]; 
            int e = points[j][1]; 
            
            if (pe < s) {
                
                count++;
                ps = s;
                pe = e;
            } else {
                
                ps = Math.max(ps, s);
                pe = Math.min(pe, e);
            }
        }
        
        return count;
    }
}
