import java.util.HashSet;
import java.util.Set;

class Solution {
    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>();
        
        vowels.add('a'); vowels.add('e'); vowels.add('i'); vowels.add('o'); vowels.add('u');
        vowels.add('A'); vowels.add('E'); vowels.add('I'); vowels.add('O'); vowels.add('U');

        int left = 0, right = s.length() - 1;
        char[] chars = s.toCharArray();  

        while (left < right) {
            while (left < right && !vowels.contains(chars[left])) left++;
            while (left < right && !vowels.contains(chars[right])) right--;

            if (left < right) {
                
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
        return new String(chars);
    }
}
