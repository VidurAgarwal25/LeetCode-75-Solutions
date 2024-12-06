import java.util.HashSet;

class Solution {
    public int maxVowels(String s, int k) {
        int l = 0, r = k - 1;
        HashSet<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        
        int count = 0, maxCount = 0;

        for (int i = 0; i < k; i++) {
            if (vowels.contains(s.charAt(i))) {
                count++;
            }
        }

        maxCount = count;

        while (r < s.length() - 1) {
            if (vowels.contains(s.charAt(l))) {
                count--;
            }
            l++;
            
            r++;
            if (vowels.contains(s.charAt(r))) {
                count++;
            }
            
            maxCount = Math.max(count, maxCount);
        }

        return maxCount;
    }
}
