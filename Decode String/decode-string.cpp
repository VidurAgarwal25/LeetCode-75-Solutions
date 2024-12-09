class Solution {
public:
    string decodeString(string s) {

        int i = 0;
        stack<char> st;
        while (i < s.length()) {
            if (s[i] == ']') {
                string temp = "";
                string rep = "";
                int count = 0;
                while (!st.empty() && st.top() != '[') {
                    temp = st.top() + temp;
                    st.pop();
                }
                st.pop();
                while (!st.empty() && st.top() >= '0' &&
                       st.top() <= '9') {
                    rep = st.top() + rep;
                    st.pop();
                }
                count = stoi(rep);
                string repeat = "";
                for (int j = 1; j <= count; j++) {
                    repeat += temp;
                }
                for (char ch : repeat)
                    st.push(ch);
            } else
                st.push(s[i]);
            i++;
        }
        string res="";
        while(!st.empty()){
            res=st.top()+res;
            st.pop();
        }
        return res;
    }
};