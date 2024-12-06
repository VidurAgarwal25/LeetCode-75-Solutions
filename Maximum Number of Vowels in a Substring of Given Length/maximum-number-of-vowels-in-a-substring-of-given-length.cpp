class Solution {
public:
    int maxVowels(string s, int k) {
        int l=0, r=k-1;
        unordered_set<char>list={'a','e','i','o','u'};
        int count=0,maxcount=0;
        for(int i=0;i<=r;i++){
            if(list.find(s[i])!=list.end()){
                count++;
            }
        }
        maxcount=count;
        while(r<s.length()-1){
            if(list.find(s[l++])!=list.end()){
                count--;
            }
            if(list.find(s[++r])!=list.end()){
                count++;
            }
            maxcount=max(count,maxcount);
        }
        return maxcount;
    }
};