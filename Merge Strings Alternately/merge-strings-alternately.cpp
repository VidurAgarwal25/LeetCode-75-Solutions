class Solution {
public:
    string mergeAlternately(string word1, string word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        int sm = 0, lar=0;
        string larWord="";
        string res="";
        if(l1<l2){
            sm = l1;
            larWord = word2;
        }
        else{
            sm=l2;
            larWord = word1;
        }
        int i;
        for(i=0; i<sm;i++){
            res+=word1[i];
            res+=word2[i];
        }
        for(int j=i;j<larWord.length();j++){
            res+=larWord[j];
        }
        return res;
    }
};