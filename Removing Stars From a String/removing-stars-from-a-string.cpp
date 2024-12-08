class Solution {
public:
    string removeStars(string s) {
        int index=0;
        for(int i=0;i<s.length();i++){
            if(s[i]=='*'){
                index--;
            }
            else{
                s[index++]=s[i];
            }
        }
        s.resize(index);
        return s;
    }
};