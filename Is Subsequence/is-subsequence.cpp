class Solution {
public:
    bool isSubsequence(string s, string t) {
        int l1 = s.length();
        int l2 = t.length();
        int j = 0;
        if (l1 > l2)
            return false;
        for (int i = 0; i < l2; i++) {
            if (s[j] == t[i])
                j++;
        }
        if (j == s.length())
            return true;
        return false;
    }
};