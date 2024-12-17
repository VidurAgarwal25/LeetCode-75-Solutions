class Solution {
public:
    vector<int> countBits(int n) {
        vector<int>res(n);
        res.push_back(0);
        for(int i=1;i<=n;i++){
            res[i]=res[i>>1] + (i&1);
        }
        return res;
    }
};