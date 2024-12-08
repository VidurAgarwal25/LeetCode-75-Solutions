import java.util.HashMap;
import java.util.Map;

class Solution {
    public int equalPairs(int[][] grid) {
        Map<String, Integer> rowMap = new HashMap<>();
        
        for (int i = 0; i < grid.length; i++) {
            String s = "";
            for (int j = 0; j < grid[0].length; j++) {
                s += grid[i][j] + "-";
            }
            rowMap.put(s, rowMap.getOrDefault(s, 0) + 1);
        }
        
        int count = 0;

        for (int j = 0; j < grid[0].length; j++) {
            String s = "";
            for (int i = 0; i < grid.length; i++) {
                s += grid[i][j] + "-";
            }
            count += rowMap.getOrDefault(s, 0);
        }
        
        return count;
    }
}
