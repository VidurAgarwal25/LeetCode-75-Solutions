class Solution {
    private long calctime(int[] piles, int k) {
        long time = 0;
        for (int pile : piles) {
            time += (pile + k - 1) / k;
        }
        return time;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int lar = Integer.MIN_VALUE;
        for (int pile : piles) {
            if (pile > lar) {
                lar = pile;
            }
        }

        int l = 1, r = lar, ans = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            long time = calctime(piles, mid);
            if (time <= h) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }
}
