class Solution {
public:
    int largestAltitude(vector<int>& gain) {
        int s=0;
        int maxs=0;
        for(int i=0;i<gain.size();i++){
            s+=gain[i];
            maxs=max(maxs,s);
        }
        return maxs;
    }
};