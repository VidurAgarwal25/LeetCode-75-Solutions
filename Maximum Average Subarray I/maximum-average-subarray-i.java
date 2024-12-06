class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int l = 0, r = k - 1;
        double s = 0;
        double avg = 0;
        double maxavg;

    
        for (int i = 0; i < k; i++) {
            s += nums[i];
        }

        avg = s / k; 
        maxavg = avg; 

        while (r < nums.length - 1) {  
            s += nums[++r] - nums[l++];  
            avg = s / k;  
            maxavg = Math.max(avg, maxavg);  
        }
        
        return maxavg;
    }
}
