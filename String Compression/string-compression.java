class Solution {
    public int compress(char[] chars) {
        int j = 0;  
        int i = 0;  
        
        while (i < chars.length) {
            char currentChar = chars[i];
            int count = 0;
            
            
            while (i < chars.length && chars[i] == currentChar) {
                i++;
                count++;
            }
            
            
            chars[j++] = currentChar;
            
            
            if (count > 1) {
                String countStr = String.valueOf(count);
                for (char c : countStr.toCharArray()) {
                    chars[j++] = c;
                }
            }
        }
        
        return j;  
    }
}
