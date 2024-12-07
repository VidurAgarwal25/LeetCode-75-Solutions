class Solution {
    public int largestAltitude(int[] gain) {
        int s = 0;
        int maxs = 0;
        for (int i = 0; i < gain.length; i++) {
            s += gain[i];
            maxs = Math.max(maxs, s);
        }
        return maxs;
    }
}
