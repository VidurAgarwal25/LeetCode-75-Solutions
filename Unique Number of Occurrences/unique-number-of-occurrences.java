class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> m = new HashMap<>();
        HashSet<Integer> s = new HashSet<>();

        for (int num : arr) {
            m.put(num, m.getOrDefault(num, 0) + 1);
        }

        for (int count : m.values()) {
            if (s.contains(count)) {
                return false;
            }
            s.add(count);
        }

        return true;
    }
}
