class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> l = new PriorityQueue<>();
        PriorityQueue<Integer> r = new PriorityQueue<>();
        int i = 0, j = costs.length - 1;
        long ans = 0;
        
        while (k > 0) {
            while (l.size() < candidates && i <= j) {
                l.add(costs[i]);
                i++;
            }
            while (r.size() < candidates && j >= i) {
                r.add(costs[j]);
                j--;
            }
            
            int left = l.size() > 0 ? l.peek() : Integer.MAX_VALUE;
            int right = r.size() > 0 ? r.peek() : Integer.MAX_VALUE;
            
            if (left <= right) {
                ans += left;
                l.poll();
            } else {
                ans += right;
                r.poll();
            }
            k--;
        }
        
        return ans;
    }
}
