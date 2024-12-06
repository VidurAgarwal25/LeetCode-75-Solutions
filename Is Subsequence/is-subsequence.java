class Solution {
    public boolean isSubsequence(String s, String t) {
        int l1 = s.length();
        int l2 = t.length();
        int j = 0;

        if (l1 > l2) 
            return false;

        for (int i = 0; i < l2 && j < l1; i++) {
            if (s.charAt(j) == t.charAt(i)) {
                j++; 
            }
        }

        return j == l1;
    }
}
