class Solution {
public:
    vector<int> asteroidCollision(vector<int>& a) {
        stack<int> s;
        for (int i = 0; i < a.size(); i++) {
            if (a[i] > 0)
                s.push(a[i]);
            else {
                bool destroyed = false;
                while (!s.empty() && s.top() > 0) {
                    if (abs(a[i]) > s.top()) {
                        s.pop();
                    }
                   else if (abs(a[i]) == s.top()) {
                        s.pop();
                        destroyed = true;
                        break;
                    }
                    else{
                        destroyed = true;
                        break;
                    }
                }
                if (!destroyed)
                    s.push(a[i]);
            }
        }
        vector<int> res;
        while (!s.empty()) {
            res.push_back(s.top());
            s.pop();
        }
        reverse(res.begin(), res.end());
        return res;
    }
};