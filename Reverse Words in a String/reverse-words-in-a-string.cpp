class Solution {
public:
    string reverseWords(string s) {
        int left = 0, right = s.length() - 1;
        while (s[left] == ' ') {
            left++;
        }
        while (s[right] == ' ') {
            right--;
        }
        string res = "", word = "";
        for (int i = left; i <= right; i++) {
            if (s[i] == ' ') {
                while (s[i+1] == ' ') {
                    i++;
                }
                if (res == "")
                    res = word;
                else
                    res = word + " " + res;
                word = "";
            } else {
                word += s[i];
            }
        }
        if(res=="")
        return word;

        return word+" "+res;
    }
};