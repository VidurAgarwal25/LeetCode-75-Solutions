class Solution {
public:
    int compress(vector<char>& chars) {
        int i = 0, j = 0;
        while (i < chars.size()) {
            char currentChar = chars[i];
            int count = 0;
            
            while (i < chars.size() && chars[i] == currentChar) {
                i++;
                count++;
            }
            
            chars[j++] = currentChar;
            
            if (count > 1) {
                string countStr = to_string(count);
                for (char c : countStr) {
                    chars[j++] = c;
                }
            }
        }
        
        return j;
    }
};
