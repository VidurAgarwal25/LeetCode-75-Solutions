class Solution:
    def totalCost(self, costs, k, candidates):
        l, r = [], []
        i, j = 0, len(costs) - 1
        ans = 0
        
        while k > 0:
            while len(l) < candidates and i <= j:
                heapq.heappush(l, costs[i])
                i += 1
            while len(r) < candidates and j >= i:
                heapq.heappush(r, costs[j])
                j -= 1
            
            left = l[0] if l else float('inf')
            right = r[0] if r else float('inf')
            
            if left <= right:
                ans += left
                heapq.heappop(l)
            else:
                ans += right
                heapq.heappop(r)
                
            k -= 1
        
        return ans
