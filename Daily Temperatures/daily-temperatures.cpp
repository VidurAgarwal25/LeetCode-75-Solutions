class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& t) {
        vector<int> res;
        stack<int> st;
        for (int i = t.size() - 1; i >= 0; i--) {
            while(!st.empty()&&t[i]>=t[st.top()]){
                st.pop();
            }
            if(st.empty()){
                res.push_back(0);
            }
            else{
                res.push_back(st.top()-i);
            }
            st.push(i);
        }
        for(int i=0;i<res.size()/2;i++){
            int temp=res[i];
            res[i]=res[res.size()-1-i];
            res[res.size()-1-i] = temp;
        }
        return res;
    }
};