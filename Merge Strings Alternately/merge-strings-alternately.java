class Solution {
    public String mergeAlternately(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        StringBuilder res = new StringBuilder();
        
        int minLength = Math.min(l1, l2);
        
        for (int i = 0; i < minLength; i++) {
            res.append(word1.charAt(i));
            res.append(word2.charAt(i));
        }
        
        if (l1 > l2) {
            res.append(word1.substring(minLength));
        } else {
            res.append(word2.substring(minLength));
        }
        
        return res.toString();
    }
}
