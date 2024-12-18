class Solution {
public:
    int findCircleNum(vector<vector<int>>& a) {
        int n=a.size();
        vector<int>vis(n,0);
        int count=0;
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                count++;
                dfs(a,vis,i);
            }
        }
        return count;
    }
    void dfs(vector<vector<int>>& a, vector<int>& vis, int node){
        vis[node]=1;
        for(int i=0;i<a.size();i++){
            if(a[node][i]==1&&vis[i]==0){
                dfs(a,vis,i);
            }
        }
    }
};