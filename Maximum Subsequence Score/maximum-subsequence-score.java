class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        List<int[]> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums.add(new int[]{nums2[i], nums1[i]});
        }
        nums.sort((a, b) -> b[0] - a[0]);
        
        long ans = 0, s = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < k - 1; i++) {
            s += nums.get(i)[1];
            q.add(nums.get(i)[1]);
        }
        for (int i = k - 1; i < n; i++) {
            s += nums.get(i)[1];
            ans = Math.max(ans, s * nums.get(i)[0]);
            if (!q.isEmpty() && q.peek() < nums.get(i)[1]) {
                s -= q.poll();
                q.add(nums.get(i)[1]);
            } else {
                s -= nums.get(i)[1];
            }
        }
        return ans;
    }
}
