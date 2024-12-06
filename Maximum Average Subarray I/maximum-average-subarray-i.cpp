class Solution {
public:
    double findMaxAverage(vector<int>& nums, int k) {
        int l=0, r=k-1;
        double s=0;
        double avg=0;
        double maxavg;
        for(int i=0;i<=r;i++){
            s+=nums[i];
        }
        avg=s/(k*1.0);
        maxavg=avg;
        while(r<nums.size()-1){
            s+=nums[++r]-nums[l++];
            avg=s/(k*1.0);
            maxavg=max(avg,maxavg);
        }
        return maxavg;
    }
};