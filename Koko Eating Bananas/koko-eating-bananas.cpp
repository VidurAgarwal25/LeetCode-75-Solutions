class Solution {
public:
    long calctime(vector<int>& piles, int k) {
        long time = 0;
        for (int i = 0; i < piles.size(); i++) {
            time += (piles[i] + k - 1) / k;
        }
        return time;
    }
    int minEatingSpeed(vector<int>& piles, int h) {
        int lar = INT_MIN;
        for (int i = 0; i < piles.size(); i++) {
            if (piles[i] > lar)
                lar = piles[i];
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
};