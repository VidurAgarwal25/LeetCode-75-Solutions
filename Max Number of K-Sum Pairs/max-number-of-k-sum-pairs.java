import java.util.HashMap;

class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int num : nums) {
            int diff = k - num;

            if (map.getOrDefault(diff, 0) > 0) {
                map.put(diff, map.get(diff) - 1);
                count++;
            } else {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        return count;
    }
}
