class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) {
            return ans;
        }

        Map<Character, String> digitToLetters = new HashMap<>();
        digitToLetters.put('2', "abc");
        digitToLetters.put('3', "def");
        digitToLetters.put('4', "ghi");
        digitToLetters.put('5', "jkl");
        digitToLetters.put('6', "mno");
        digitToLetters.put('7', "pqrs");
        digitToLetters.put('8', "tuv");
        digitToLetters.put('9', "wxyz");

        helper(0, digits, digitToLetters, new StringBuilder(), ans);
        return ans;
    }

    private void helper(int index, String digits, Map<Character, String> digitToLetters, StringBuilder current, List<String> ans) {
        if (index == digits.length()) {
            ans.add(current.toString());
            return;
        }

        char digit = digits.charAt(index);
        String letters = digitToLetters.get(digit);
        for (char ch : letters.toCharArray()) {
            current.append(ch);
            helper(index + 1, digits, digitToLetters, current, ans);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
