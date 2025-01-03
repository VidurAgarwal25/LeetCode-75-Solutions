class Solution {
public:
    void helper(int index, vector<string> &ans, unordered_map<char,string> &m,string digits, string &temp){
        if(index==digits.length()){
            ans.push_back(temp);
            return;
        }
        char digit = digits[index];
        for(char ch:m[digit]){
            temp+=ch;
            helper(index+1,ans,m,digits,temp);
            temp.pop_back();
        }
    }
    vector<string> letterCombinations(string digits) {
        vector<string>ans;
        if(digits.length()==0)
        return ans;
        unordered_map<char,string>m; string temp="";
        m['2']="abc";
        m['3']="def";
        m['4']="ghi";
        m['5']="jkl";
        m['6']="mno";
        m['7']="pqrs";
        m['8']="tuv";
        m['9']="wxyz";
        helper(0,ans,m,digits,temp);
        return ans;
    }
};